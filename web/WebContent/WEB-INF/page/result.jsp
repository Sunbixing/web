<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><?xml version="1.0" encoding="UTF-8"?>
<results> <c:forEach items="${results}" var="result">
	<result id="${result.id}"> <title>${result.title}</title> <content>${result.content}</content><comments>${result.comments}</comments>
	</result>
</c:forEach> </results>