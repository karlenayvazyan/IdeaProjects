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
    <title>::Edit category::</title>
</head>
<body>
<s:actionerror/>
<s:form action="editCategory">
    <table>
        <tr>
            <td>
                <label for="languageAmText">
                    Category name am
                </label>
            </td>
            <td>
                <input type="text" name="category.languages[0].text" id="languageAmText"
                       value="<s:property value="category.languages[0].text"/>"/>
                <input type="hidden" name="category.languages[0].id" value="<s:property value="category.languages[0].id"/>">
                <input type="hidden" name="category.languages[0].language"
                       value="<s:property value="@am.ak.mybatis.data.model.lcp.LanguageLCP@AM.name()"/>">
            </td>
        </tr>
        <tr>
            <td>
                <label for="languageEnText">
                    Category name en
                </label>
            </td>
            <td>
                <input type="text" name="category.languages[1].text" id="languageEnText"
                       value="<s:property value="category.languages[1].text"/>">
                <input type="hidden" name="category.languages[1].id" value="<s:property value="category.languages[1].id"/>">
                <input type="hidden" name="category.languages[1].language"
                       value="<s:property value="@am.ak.mybatis.data.model.lcp.LanguageLCP@EN.name()"/>">
            </td>
        </tr>
        <tr>
            <td>
                <label for="languageRuText">
                    Category name ru
                </label>
            </td>
            <td>
                <input type="text" name="category.languages[2].text" id="languageRuText"
                       value="<s:property value="category.languages[2].text"/>">
                <input type="hidden" name="category.languages[2].id" value="<s:property value="category.languages[2].id"/>">
                <input type="hidden" name="category.languages[2].language"
                       value="<s:property value="@am.ak.mybatis.data.model.lcp.LanguageLCP@RU.name()"/>">
            </td>
        </tr>
    </table>
    <s:submit/>
</s:form>
</body>
</html>
