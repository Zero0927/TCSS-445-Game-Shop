<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML>
<html>
  <head>
  	<style type="text/css">
  		td {
  			border:solid black;
  			border-width:1px 1px 0px 0px;
  			padding: 5px;
  		}
		table {
			border:solid black;
			border-width:0px 0px 1px 1px;
		}
  	</style>
  </head>
  
  <body>
    <a href="./shop">Shop</a>
  	<a href="./game">My Game</a>
  	<a href="./favoriteList">My Favorite List</a>
  	<a href="./shoppingCart">My Shopping Cart</a>
  	<a href="./invoice">My Invoice</a>
    <h1>Invoice</h1>
    <h2><s:property value="result"/></h2>
  	<table border="0" cellspacing="0" cellpadding="0">
  		<tr>
  			<td>invoice no</td>
  			<td>invoice paydate</td>
  			<td>payment method</td>
  			<td>total price</td>
  			<td>order id</td>
  		</tr>
  		<s:iterator value="invoices">
  			<tr>
  				<td><s:property value="invoiceNo"/></td>
				<td><s:property value="invoicePaydate"/></td>
				<td><s:property value="paymentMethod"/></td>
				<td><s:property value="totalPrice"/></td>
				<td><s:property value="orderId"/></td>
			</tr>
		</s:iterator>
	</table>
  </body>
</html>
