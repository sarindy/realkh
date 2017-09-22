package com.real.contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.real.response.ResponseModel;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/api/contact/addContact", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseModel> addContact(@RequestBody Contact contact){
		
		contactService.addContact(contact);
		
		return new ResponseEntity<ResponseModel>(
				new ResponseModel("001", "User not create due to already exist or null", contact), HttpStatus.OK);
	}

}
