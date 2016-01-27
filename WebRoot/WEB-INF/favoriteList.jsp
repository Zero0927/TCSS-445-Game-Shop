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
  	<h1>Favorite List</h1>
  		<table border="0" cellspacing="0" cellpadding="0">
  			<tr>
  				<td>game id</td>
  				<td></td>
  			</tr>
		  	<s:iterator value="favoriteLists">
		  		<tr>
		  			<td><s:property value="gameId"/></td>
	  				<td><a href="./favoriteDelete?favoriteListId=${favoriteListId}">delete</a></td>
		  		</tr>
		  	</s:iterator>
  		</table>
  </body>
</html>
