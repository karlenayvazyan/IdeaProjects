<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>:: Login::</title>
</head>
<body>
<s:if test="%{#session.message neq null}">
    <s:property value="#session.message"/>
    <s:set scope="session" value="null" var="message"/>
</s:if>
<s:actionerror/>
<s:form action="do-login">
    <s:textfield name="email" label="Email"/>
    <s:password name="password" label="Password"/>
    <s:submit value="Login"/>
</s:form>
</body>
</html>
