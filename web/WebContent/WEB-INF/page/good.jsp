<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><?xml version="1.0" encoding="UTF-8"?>
<goods> <c:forEach items="${goods}" var="good">
	<good id="${good.id}"> <name>${good.name}</name> <univalent>${good.univalent}</univalent><quantity>${good.quantity}</quantity>
	</good>
</c:forEach> </goods>