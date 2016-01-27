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
    <h1>Pay</h1>
    <h2>Shopping Cart</h2>
  	<table border="0" cellspacing="0" cellpadding="0">
  		<tr>
  			<td>game id</td>
  			<td>quantity</td>
  		</tr>
  		<s:iterator value="shoppingCarts">
  			<tr>
  				<td><s:property value="gameId"/></td>
				<td><s:property value="quantity"/></td>
			</tr>
		</s:iterator>
	</table>
	<h2>Total : <s:property value="totalPrice"/></h2>
	<s:form action="pay" method="post" enctype="multipart/form-data">
		<input type="radio"  name="paymentMethod" value="online pay" checked />online pay
		<input type="radio"  name="paymentMethod" value="cash" />cash<br />
		<input type="submit" value="pay"/>
	</s:form>
  </body>
</html>
