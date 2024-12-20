<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h4>값</h4>
  ${iVal }<br>
  ${lVal }<br>
  ${fVal }<br>
  ${bVal }<br>
  ${sVal }<br>
  <h4>객체</h4>
  --${obj.id}--<br>
  ${user.id }<br>
  ${user.name}<br>
  <h4>Map</h4>
  ${m.iVal }<br>
  ${m.bVal }<br>
  ${m.sVal }<br>
  <h4>Literal</h4>
  ${1 }
  ${'Hello World'}
  ${true}
  <h4>산수연산</h4>
  ${1+2}
  <h4>관계연산</h4>
  ${iVal == 10 && lVal < 10}<br>
  ${lVal < 5}<br>
  ${obj == null}<br>
  ${empty obj}<br>
  ${obj != null}<br>
  ${not empty obj}<br>
  <h4>논리연산</h4>
  ${iVal != 10 && lVal >= 10}<br>
  ${iVal != 10 || lVal >= 10}<br>
  <h4>요청 파라미터</h4>
  ${param.no}
  ${param.name}

  <h4>Context Path</h4>
  ${pageContext.request.contextPath}
</body>
</html>
