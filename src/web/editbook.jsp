<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Library</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<header class="header">
    <h1 class="header_logo">
        <a href="#" class="header_logo_link">Library</a></h1>
    <nav class="nav_item">
        <ul class="nav_ul">
            <li class="nav_li">
                <a href="/allbooks" class="nav_link nav_link1"> ����� </a>
            </li>
            <li class="nav_li">
                <a href="/bookshelf" class="nav_link nav_link2"> ����� </a>
            </li>
            <li class="nav_li">
                <a href="/cyclists" class="nav_link nav_link3"> ����� </a>
            </li>
        </ul>
    </nav>
</header>

<div class="description">
    <form action="editBook" method="post" class="form">
        <h2>${bookToEdit.nameB}</h2>
        <p class="add_description">��������</p>
        <input id="changeName" name="book_name" required type="text" value="${bookToEdit.nameB}" class="textbox"> </br>
        <p class="add_description">����</p>
        <select name="genreSelector" class="add_select">
            <option>${bookToEditbookshelf.nameBs}</option>
            <c:forEach items="${bookshelf}" var="bookshelf">
                <option>${bookshelf.nameBs}</option>
            </c:forEach>
        </select>
        <input id="submitButton" type="submit" value="��������" class="button"/>
        <a href="/allbooks" class="cancel">�����</a>
    </form>
</div>
</body>
</html>