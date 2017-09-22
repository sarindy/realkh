package com.real.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepo contactRepo;

	@Override
	public Contact addContact(Contact contact) {
		contactRepo.save(contact);
		return null;
	}

}
