package id.co.buara.varia.computama;
import org.springframework.core.io.Resource;

import com.opencsv.CSVReader;

import id.co.buara.varia.computama.repository.ItemData;
import id.co.buara.varia.computama.throwable.InternalServerErrorException;
import id.co.buara.varia.computama.throwable.NotFoundDataException;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseCommon {
	
	protected static final String TABLE_ITEM = "table/TABLE_ITEM.csv";
	protected static final String TABLE_CART = "table/TABLE_CART.csv";
	protected static final String TABLE_CART_DTL = "table/TABLE_CART_DTL.csv";
	protected static final String TABLE_USER = "table/TABLE_USER.csv";
	protected static MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

	
	private static InputStream getFileData(String tableName) {
		Resource resource = new ClassPathResource(tableName);
		InputStream input;
		try {
			input = resource.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new NotFoundDataException("Table Tidak Ditemukan");
		}
		return input;  
	}
	
	protected static List<ItemData> getItemDatas(String search){
		List<ItemData> getDatas = new ArrayList<>();
		getDatas = mapperFacade.mapAsList(getDatas(TABLE_ITEM), ItemData.class);
		return  getDatas==null?new ArrayList<ItemData>() : 
			getDatas.stream().filter(data->data.getNamaItem().toUpperCase().contains(search.toUpperCase())).collect(Collectors.toList());
	}
	
	protected static Boolean isItemsExist(String search){
		List<ItemData> getDatas = new ArrayList<>();
		getDatas = mapperFacade.mapAsList(getDatas(TABLE_ITEM), ItemData.class);
		return  getDatas==null? false : 
			getDatas.stream().anyMatch(data->data.getIdItem().equalsIgnoreCase(search));
	}
	
	private static List<Map<String, Object>> getDatas(String table){
		  InputStream file = getFileData(table);
		  System.out.println("testing : " + table);
		  CSVReader csvReader = new CSVReader(new InputStreamReader(file));
			String[] record;
			List<String> header = new ArrayList<>();
			List<Map<String, Object>> datas = new ArrayList<Map<String,Object>>();
		  try {

				int i = 0;
				while ((record = csvReader.readNext()) != null) {
					if (record.length > 0) {
						if(i==0) {
						  	for (String rec : record) {
						  		header.add(rec);
							}
						}
						if(i!=0) {
							 Map<String, Object> mapp = new HashMap<String, Object>();
						  for (int col = 0; col<record.length;col++) {
							   mapp.put(header.get(col), record[col]);
						  }
						  datas.add(mapp);

					    }
					i++;
				}
			 }
		    }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new InternalServerErrorException(e.getLocalizedMessage());
			}
			
			return datas;
	}
	
	public static void main(String[] args) {
		System.out.println("data keluaran : " +  isItemsExist("item11"));
	}
	
}
