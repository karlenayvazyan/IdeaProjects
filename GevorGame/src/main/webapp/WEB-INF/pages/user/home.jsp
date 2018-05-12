<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: karlen
  Date: 5/16/15
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>::User home::</title>
</head>
<body>
<a href="addCategoryView.action">Add category</a><br/>
<table border="1">
    <tr>
        <td>Category name</td>
        <td>Actions</td>
    </tr>
    <s:iterator value="categories">
        <%--<a href="">--%>
        <tr>
            <td>
                <s:iterator value="languages">
                    <s:property value="text"/>
                </s:iterator>
            </td>
            <td>
                <a href="userHome.action?categoryId=<s:property value="id"/>">View sub categories</a>
                <a href="addCategoryView.action?categoryId=<s:property value="id"/>">Add sub category</a>
                <a href="editCategory-view.action?categoryId=<s:property value="id"/>">edit</a>
                <a href="deleteCategory.action?categoryId=<s:property value="id"/>">delete</a>
            </td>
        </tr>
        <%--</a>--%>
    </s:iterator>
</table>
</body>
</html>
