<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
	<div class="container" style="text-align: center;">
		<h1>Upload file</h1>
		<c:out value="${msg }"></c:out>
		<form method="post" action="/" enctype="multipart/form-data">
			<input type="file" name="file" /> <input type="submit"
				value="Upload File" />
		</form>
		<hr />
		<table border="1">
			<tr>
				<td>File Name</td>
				<td>Owner Name</td>
				<td>Last Modified</td>
				<td>Size</td>
				<td>Action</td>
			</tr>

			<c:forEach items="${objects}" var="object" varStatus="entry">
				<tr>
					<td>${object.key }</td>
					<td>${object.owner.displayName}</td>
					<td>${object.lastModified}</td>
					<td>${object.size}</td>
					<td><a href='deleteFile?key=<c:out value="${object.key}"/>'>Delete</a></td>
				</tr>
			</c:forEach>
	</div>
</body>
</html>