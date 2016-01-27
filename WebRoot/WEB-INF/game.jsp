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
  			<td>game id</td>
  			<td>rating</td>
  			<td>comment</td>
  			<td></td>
  		</tr>
  		<s:iterator value="ratings">
  			<tr>
  				<form action="./rating" method="post">
  					<td><s:property value="gameId"/></td>
					<td><input type="text" name="rating"  value="${rating}"/></td>
	  				<td><textarea rows="3" cols="20" name="comment" >${comment}</textarea></td>
	  				<td>
	  					<input type="hidden" value="${ratingId}" name="ratingId"/>
	  					<input type="submit" value="submit" />
	  				</td>
  				</form>
			</tr>
		</s:iterator>
	</table>
  </body>
</html>
