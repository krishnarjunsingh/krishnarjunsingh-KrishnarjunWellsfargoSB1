package com.iiht.evaluation.coronokit.model;

public class KitDetail {

	private int id;
	private String name;
	private String description;
	private int productId;
	private int quantity;
	private int amount;
	private int coronaKitId;
	
	private String email;
	private int contact;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public KitDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public KitDetail(int id, int coronaKitId, int productId, int amount) {
		this.id = id;
		this.coronaKitId = coronaKitId;
		this.productId = productId;
		this.amount = amount;
	}
	
	public KitDetail(int coronaKitId, int amount) {

		this.coronaKitId = coronaKitId;
		this.amount = amount;
	}
	
	public KitDetail(int coronaKitId, String name, String description, int amount) {
		// TODO Auto-generated constructor stub
		this.coronaKitId = coronaKitId;
		this.name = name;
		this.description = description;
		this.amount = amount;
	}

	public KitDetail(String name, String email, int contact, String address) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}

	public int getCoronaKitId() {
		return coronaKitId;
	}

	public void setCoronaKitId(int coronaKitId) {
		this.coronaKitId = coronaKitId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
