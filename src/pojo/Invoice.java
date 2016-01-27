package pojo;

import java.util.Date;

/**
 * Invoice entity. @author MyEclipse Persistence Tools
 */

public class Invoice implements java.io.Serializable {

	// Fields

	private Integer invoiceNo;
	private Date invoicePaydate;
	private String paymentMethod;
	private Double totalPrice;
	private Integer orderId;

	// Constructors

	/** default constructor */
	public Invoice() {
	}

	/** full constructor */
	public Invoice(Date invoicePaydate, String paymentMethod,
			Double totalPrice, Integer orderId) {
		this.invoicePaydate = invoicePaydate;
		this.paymentMethod = paymentMethod;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
	}

	// Property accessors

	public Integer getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoicePaydate() {
		return this.invoicePaydate;
	}

	public void setInvoicePaydate(Date invoicePaydate) {
		this.invoicePaydate = invoicePaydate;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}