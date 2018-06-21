<%@ page contentType="text/html;charset=UTF-8"%>
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

<table class="table" align="center">
    <thead>
    <th>Название книги</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${allbooks}" var="book">
    <tr>
        <td>${book.nameB}
        </td>
        <td><a href="/editBook?idB=${book.idB}">Изменить</a></td>
        <td><a href="/deleteBook?idB=${book.idB}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/addBook" class="add_button">Добавить книгу</a>
</div>
</form>
</body>
</html>