package id.co.buara.varia.computama.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.buara.varia.computama.BaseCommon;
import id.co.buara.varia.computama.dto.ItemDataDto;
import id.co.buara.varia.computama.dto.SearchDto;
import id.co.buara.varia.computama.service.ItemService;

@RestController
@RequestMapping("/itemDataCtl")
public class ItemDataCtl{

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/HelloWorld")
	public String helloWorldToMe() {
		return "Hello - World - To - Me";
	}
	
	@PostMapping("/inquiryItems")
	public ResponseEntity<List<ItemDataDto>> getAllItemDatasBySearch(@RequestBody SearchDto search){
		List<ItemDataDto> getItemDatas = itemService.getItemData(search.getSearch());
		if(getItemDatas==null||getItemDatas.size()==0) {
			return new ResponseEntity<List<ItemDataDto>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<ItemDataDto>>(getItemDatas, HttpStatus.OK);
		}
	}
	
}
