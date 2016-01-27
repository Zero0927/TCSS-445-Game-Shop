package pojo;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private String userId;
	private String password;
	private String customerId;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String userId, String password, String customerId) {
		this.userId = userId;
		this.password = password;
		this.customerId = customerId;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}