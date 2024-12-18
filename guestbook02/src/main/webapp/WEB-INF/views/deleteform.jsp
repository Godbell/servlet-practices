<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String id = request.getParameter("id");
%>

<html>
<head>
    <title>방명록</title>
</head>
<body>
  <form method="post" action="/guestbook02/gb?a=delete">
    <input type="hidden" name="a" value="delete">
    <input type="hidden" name="id" value="<%=id %>">
    <table>
      <tr>
        <td>비밀번호</td>
        <td><input type="password" name="password"></td>
        <td><input type="submit" value="삭제"></td>
      </tr>
    </table>
  </form>
<a href="/guestbook02/gb?a=list">메인으로 돌아가기</a>
</body>
</html>
