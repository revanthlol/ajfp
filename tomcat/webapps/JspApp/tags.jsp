<%@ page language="java" %>
<html><body>
<%-- comment --%>
<%! int square(int n) { return n * n; } %>
<% int a = 10, b = 20; int sum = a + b; %>
<p>Sum: <%= sum %></p>
<p>Square of 5: <%= square(5) %></p>
</body></html>
