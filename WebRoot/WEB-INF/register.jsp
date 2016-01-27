<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML>
<html>
  <head>
  </head>
  
  <body>
  	<s:form action="register" method="post" enctype="multipart/form-data">
  		<table>
  			<tr>
  				<td>user_id</td>
  				<td><input name="id" type="text" /></td>
  				<td>No more than 8 bits in length</td>
  			</tr>
  			<tr>
  				<td>password</td>
  				<td><input name="pw" type="password" /></td>
  				<td>No more than 8 bits in length</td>
  			</tr>
  			<tr>
  				<td>repassword</td>
  				<td><input name="repw" type="password" /></td>
  				<td>No more than 8 bits in length</td>
  			</tr>
  			<tr>
  				<td>first_name</td>
  				<td><input name="firstName" type="text" /></td>
  				<td>No more than 10 bits in length</td>
  			</tr>
  			<tr>
  				<td>last_name</td>
  				<td><input name="lastName" type="text" /></td>
  				<td>No more than 10 bits in length</td>
  			</tr>
  			<tr>
  				<td>gender</td>
  				<td>
  					<input name="gender" type="radio"  value="0" checked />male
  					<input name="gender" type="radio"  value="1"/>female
  				</td>
  				<td></td>
  			</tr>
  			<tr>
  				<td>date_of_birth</td>
  				<td><input name="dateOfBirth" type="date" /></td>
  				<td></td>
  			</tr>
  			<tr>
  				<td>street</td>
  				<td><input name="street" type="text" /></td>
  				<td>No more than 20 bits in length</td>
  			</tr>
  			<tr>
  				<td>city</td>
  				<td><input name="city" type="text" /></td>
  				<td>No more than 10 bits in length</td>
  			</tr>
  			<tr>
  				<td>zip_code</td>
  				<td><input name="zipCode" type="text" /></td>
  				<td>5 bits in length</td>
  			</tr>
  			<tr>
  				<td>mobile_number</td>
  				<td><input name="mobileNumber" type="text" /></td>
  				<td>No more than 10 bits in length</td>
  			</tr>
  			<tr>
  				<td>email</td>
  				<td><input name="email" type="text" /></td>
  				<td>No more than 15 bits in length</td>
  			</tr>
  			<tr>
  				<td><s:submit value="register"/></td>
  			</tr>
  			<tr>
  				<td><s:label name="error"></s:label></td>
  			</tr>
  		</table>
  	</s:form>
  </body>
</html>
