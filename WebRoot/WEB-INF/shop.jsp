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
  	<h1>Game Shop</h1>
  		<table border="0" cellspacing="0" cellpadding="0">
  			<tr>
  				<td>id</td>
  				<td>name</td>
  				<td>description</td>
  				<td>company</td>
  				<td>category</td>
  				<td>price</td>
  				<td>units in stock</td>
  				<td></td>
  				<td></td>
  			</tr>
		  	<s:iterator value="games">
		  		<tr>
		  			<td><s:property value="gameId"/></td>
	  				<td><s:property value="gameName"/></td>
	  				<td><s:property value="gameDescription"/></td>
	  				<td><s:property value="gameCompany"/></td>
	  				<td><s:property value="gameCategory"/></td>
	  				<td><s:property value="gamePrice"/></td>
	  				<td><s:property value="gameUnitsInStock"/></td>
	  				<td><a href="./favoriteAdd?gameId=${gameId}">favorite</a></td>
	  				<td>
	  					<s:if test="gameUnitsInStock > 0">
	  						<a href="./buyCarAdd?gameId=${gameId}">buy</a>
	  					</s:if>
	  				</td>
		  		</tr>
		  	</s:iterator>
  		</table>
  </body>
</html>
