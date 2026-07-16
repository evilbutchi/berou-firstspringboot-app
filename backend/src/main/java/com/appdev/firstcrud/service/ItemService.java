package com.appdev.firstcrud.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.appdev.firstcrud.entity.ItemEntity;
import com.appdev.firstcrud.repository.ItemRepository;
import com.appdev.firstcrud.response.NameErrorResponse;

@Service
public class ItemService {

	@Autowired
	ItemRepository irepo;

	public ItemService() {
		// TODO Auto-generated constructor stub
	}

	//C - Create
	//method will return the student being added
	public ItemEntity postItem(ItemEntity Item) {
		return irepo.save(Item);
	}

	//R - Read
	public List<ItemEntity> getAllItems(){
		return irepo.findAll();
	}

	//U - Update
	@SuppressWarnings("finally")
	public ItemEntity putItem(int id, ItemEntity newItemDetails) {
		ItemEntity Item = new ItemEntity();
		try {
			//findById is a pre-defined method of the repository
			Item = irepo.findById(id).get(); 
			Item.setName(newItemDetails.getName());
			Item.setUnit(newItemDetails.getUnit());
			Item.setPrice(newItemDetails.getPrice());
		}catch(NoSuchElementException ex) {
			throw new NameNotFoundException("Item " + id + " does not exist!");
		}finally {
			return irepo.save(Item);
		}
	}

	//D - Delete
	public String deleteItem(int id) {
		String msg = "";
		if (irepo.existsById(id)) {
			irepo.deleteById(id);
			msg = "Item " + id + " is successfully deleted!";
		}else {
			msg = id + " does not exist!";
		}
		return msg;
	}

	//specific exception
	@ExceptionHandler
	public ResponseEntity<NameErrorResponse> handleException(NameNotFoundException ex){
		//create a student error response obj
		NameErrorResponse error = new NameErrorResponse();
		//set values
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		//return response entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	//generic exception
	@ExceptionHandler
	public ResponseEntity<NameErrorResponse> handleException(Exception ex){
		//create a student error response obj
		NameErrorResponse error = new NameErrorResponse();
		//set values
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		//return response entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
