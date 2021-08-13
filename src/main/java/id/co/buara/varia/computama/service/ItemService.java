package id.co.buara.varia.computama.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import id.co.buara.varia.computama.BaseCommon;
import id.co.buara.varia.computama.dto.ItemDataDto;
import id.co.buara.varia.computama.repository.ItemData;
@Service
public class ItemService extends BaseCommon{

	public List<ItemDataDto> getItemData(String search){
		List<ItemData> getDatas = getItemDatas(search);
		List<ItemDataDto> itemDataDtos = new ArrayList<ItemDataDto>();
		for (ItemData itemData : getDatas) {
			ItemDataDto dataDto = mapperFacade.map(itemData, ItemDataDto.class);
			dataDto.setHargaItemNum(new BigDecimal(itemData.getHargaItem()));
			itemDataDtos.add(dataDto);
		}
		return itemDataDtos;
	}
	
	public ItemDataDto getItemFromItems(String itemId) {
		List<ItemDataDto> itemDataDtos = getItemData("");
		ItemDataDto dto = new ItemDataDto();
		for (ItemDataDto itemDataDto : itemDataDtos) {
			if(itemDataDto.getIdItem().equalsIgnoreCase(itemId)) {
				dto = itemDataDto;
				break;
			}
		}
		return dto;
	}
	
	public Boolean isItemExist(String items) {
		return isItemsExist(items);
	}
	
}
