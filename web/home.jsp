<%-- 
    Document   : home
    Created on : Feb 13, 2022, 3:10:50 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>VietSun Esports Monitor System</h1></center>
    <form action="TestServlet" method="POST">
        Nhập API Key của bạn:
        <input type="text" name="apikey"/><br>
        Chọn player muốn xem thông tin:
        <select name="player">
            <option value="summer" label="Summer"></option>
            <option value="sunny" label="Sunny"></option>
            <option value="jett" label="Jett" ></option>
            <option value="noatz" label="NoAtz" ></option>
            <option value="killer" label="Killer" ></option>
            <option value="bunzz" label="Bunzz" ></option>
        </select>
        <br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
