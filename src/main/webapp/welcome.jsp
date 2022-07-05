<%-- 
    Document   : welcome
    Created on : 2022年7月1日, 下午5:05:35
    Author     : yku
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>你登入成功嚕!感動嘛....</h1>
        <p><c:out value="${title}"/></p>
    </body>
</html>
