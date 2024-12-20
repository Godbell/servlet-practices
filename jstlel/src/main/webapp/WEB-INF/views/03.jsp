<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<title>Title</title>
<head>
</head>
<%
  pageContext.setAttribute("newLine", "\n");
%>
<body>
  <h4>JSTL Test: forEach, set</h4>

  <c:set var="count" value="${fn:length(list)}"/>
  <c:forEach items="${list}" var="vo" varStatus="status">
    <h4>[${count - status.index}](${status.count}:${status.index}) ${vo.id}: ${vo.name}</h4>
  </c:forEach>

  <p>
    ${fn:replace(contents, newLine, "<br>")}
  </p>
</body>
</html>
