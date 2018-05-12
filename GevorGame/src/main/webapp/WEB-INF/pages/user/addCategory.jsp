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
  <title>::Add category::</title>
</head>
<body>
<s:actionerror/>
<table>
<form action="addCategory" enctype="multipart/form-data" method="post">
  <tr>
    <td>
      <label for="size1">
        1 size
      </label>
    </td>
    <td>
      <input type="file" name="image_1" id="size1">
    </td>
  </tr>
  <tr>
    <td>
      <label for="size2">
        2 size
      </label>
    </td>
    <td>
      <input type="file" name="image_2" id="size2">
    </td>
  </tr>
  <tr>
    <td>
      <label for="size3">
        3 size
      </label>
    </td>
    <td>
      <input type="file" name="image_3" id="size3">
    </td>
  </tr>
  <tr>
    <td>
      <label for="size4">
        4 size
      </label>
    </td>
    <td>
      <input type="file" name="image_4" id="size4">
    </td>
  </tr>
  <tr>
    <td>
      <label for="size5">
        5 size
      </label>
    </td>
    <td>
      <input type="file" name="image_5" id="size5">
    </td>
  </tr>
  <tr>
    <td>
      <label for="languageAm">
        Category name am
      </label>
    </td>
    <td>
      <input type="text" name="language_am" id="languageAm"/>
    </td>
  </tr>
  <tr>
    <td>
      <label for="languageEn">
        Category name en
      </label>
    </td>
    <td>
      <input type="text" name="language_en" id="languageEn"/>
    </td>
  </tr>
  <tr>
    <td>
      <label for="languageRu">
        Category name ru
      </label>
    </td>
    <td>
      <input type="text" name="language_ru" id="languageRu"/>
    </td>
  </tr>
  <input type="hidden" name="categoryId" value="<s:property value="categoryId"/>"/>
  <s:submit/>
</form>
</table>
</body>
</html>
