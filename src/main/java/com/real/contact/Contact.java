package com.real.contact;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recid")
	private int recid;
	@Column(name = "first_name")
	private String firstName;
	
	@OneToMany(mappedBy = "contact",  cascade = CascadeType.PERSIST,orphanRemoval = true)
	private List<Phone> phone;

	public Contact(String firstName, List<Phone> phone) {
		super();
		this.firstName = firstName;
		this.phone = phone;
	}

	public int getRecid() {
		return recid;
	}

	public void setRecid(int recid) {
		this.recid = recid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	public Contact() {
		
	}
	
	

}
