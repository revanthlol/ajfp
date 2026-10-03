<%@ page language="java" %>
<html><body>
<form>
  Count: <input name="count" value="5">
  <input type="submit">
</form>
<%
  String c = request.getParameter("count");
  int n = (c != null) ? Integer.parseInt(c) : 5;
  for (int i = 1; i <= n; i++) {
%>
  <p><%= i %>. Hello World</p>
<% } %>
</body></html>
