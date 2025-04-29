<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Ocurrió un error</h1>
<s:actionerror/>
<p>Detalle: <s:property value="%{exception.message}"/></p>
</body>
</html>