<%-- 
    Document   : Info
    Created on : Feb 14, 2022, 5:13:46 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                margin: auto;
                width: 50%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <%String name = (String)request.getAttribute("summonerName"); 
        String rank = (String)request.getAttribute("rank");
        String wins = (String)request.getAttribute("wins");
        String losses = (String)request.getAttribute("losses");
        String points = (String)request.getAttribute("points");
        %>
        <center><h1>VietSun Esports Monitor System</h1></center>
        <table>
            <tr>
                <td>Tên Ingame</td>
                <td><%=name %></td>
            </tr>
            <tr>
                <td>Rank</td>
                <td><%=rank %></td>
            </tr>
            <tr>
                <td>Số trận thắng</td>
                <td><%=wins %></td>
            </tr>
            <tr>
                <td>Số trận thua</td>
                <td><%=losses %></td>
            </tr>
            <tr>
                <td>Điểm hạng</td>
                <td><%=points %></td>
            </tr>
        </table>
    </body>
</html>
