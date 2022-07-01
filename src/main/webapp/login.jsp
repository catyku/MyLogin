<%-- 
    Document   : login
    Created on : 2022年7月1日, 下午4:59:12
    Author     : yku
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    com.creations.login login = new com.creations.login();
    String usr = login.match(request.getParameter("account"), request.getParameter("password"));
    if(usr!=null){
        session.setAttribute("user",usr);
        response.sendRedirect("welcome.jsp");
    }
    else
    {
        out.println("帳號或密碼錯誤");
    }
%>