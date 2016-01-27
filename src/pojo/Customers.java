package pojo;

import java.util.Date;

/**
 * Customers entity. @author MyEclipse Persistence Tools
 */

public class Customers implements java.io.Serializable {

	// Fields

	private String customerId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String street;
	private String city;
	private String zipCode;
	private String mobileNumber;
	private String email;

	// Constructors

	/** default constructor */
	public Customers() {
	}

	/** minimal constructor */
	public Customers(String customerId, String firstName, String lastName,
			String gender, Date dateOfBirth) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	/** full constructor */
	public Customers(String customerId, String firstName, String lastName,
			String gender, Date dateOfBirth, String street, String city,
			String zipCode, String mobileNumber, String email) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	// Property accessors

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}