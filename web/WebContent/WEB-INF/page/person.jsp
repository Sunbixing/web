<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><?xml version="1.0" encoding="UTF-8"?>
<persons> <c:forEach items="${persons}" var="person">
	<person id="${person.id}"> <name>${person.name}</name> <pwd>${person.pwd}</pwd>
	</person>
</c:forEach> </persons>