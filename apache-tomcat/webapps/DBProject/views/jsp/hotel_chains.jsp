<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hotel Chains</title>
</head>
<body>
    <h2>Hotel Chains</h2>
    <table border="1">
        <tr>
            <th>Chain ID</th>
            <th>Number of Hotels</th>
            <th>Headquarters Address</th>
            <th>Contact Emails</th>
            <th>Phone Number</th>
        </tr>
        <% 
        List<HotelChain> hotelChains = (List<HotelChain>) request.getAttribute("hotelChains");
        for (HotelChain chain : hotelChains) {
        %>
            <tr>
                <td><%= chain.getChainId() %></td>
                <td><%= chain.getNHotels() %></td>
                <td><%= chain.getHQAddress() %></td>
                <td><%= chain.getContactEmails() %></td>
                <td><%= chain.getPhoneNumber() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
