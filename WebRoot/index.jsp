<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<s:form action="login" method="post" enctype="multipart/form-data">
	  	<s:textfield label="user_id" name="id"/>
	  	<s:password label="password" name="pw" />
	  	<s:label name="error"/>
	  	<s:submit value="login"/>
  	</s:form>
  	 	<a href="./register"> register</a>
  </body>
</html>