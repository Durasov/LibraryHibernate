<%@ page contentType="text/html;charset=Windows-1251" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add Cyclist</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<header class="header">
    <h1 class="header_logo">
        <a href="#" class="header_logo_link">Library</a></h1>
    <nav class="nav_item">
        <ul class="nav_ul">
            <li class="nav_li">
                <a href="/allbooks" class="nav_link nav_link1"> Книги </a>
            </li>
            <li class="nav_li">
                <a href="/bookshelf" class="nav_link nav_link2"> Жанры </a>
            </li>
            <li class="nav_li">
                <a href="/cyclists" class="nav_link nav_link3"> Поиск </a>
            </li>
        </ul>
    </nav>
</header>

<div class="description">
    <form action="addBook" method="post" class="form">
        <h2>Добавить книгу</h2>
        <p class="add_description">Название книги</p>
        <input name="book_name" type="text" required placeholder="Название книги" class="textbox"> </br>
        <p class="add_description">Жанр</p>
        <select name="genreSelector" class="add_select">
            <c:forEach items="${bookshelf}" var="bookshelf">
                <option>${bookshelf.nameBs}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Добавить" class="button"/>
        <a href="/allbooks" class="cancel">Назад</a>
    </form>
</div>
</body>
</html>