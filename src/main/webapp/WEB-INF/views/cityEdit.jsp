<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Редактируем город</title>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <h4>Редактируем город: <c:out value="${city.cityName}"/></h4>
    </div>
    <form name='saveCityPlace' action="<c:url value='/addCityFromEditCity'/>" method='POST'>
        <div style="margin-left:30px;">
            <div class="col-md-6 mb-3">
                <label for="cityName">Название города:</label>
                <input type="text" class="form-control" id="cityName" name="cityName" value="<c:out value="${city.cityName}"/>" required>
            </div>
        <div class="col-md-6 mb-3">
            <label for="placeName">Название места:</label>
            <input type="text" class="form-control" id="placeName" name="placeName" value="<c:out value="${place.placeName}"/>" required>
        </div>

        <div class="col-md-6">
            <label for="placeDiscript">Описание места:</label>
            <textarea class="form-control" id="placeDiscript" name="placeDiscript" maxlength="250" required><c:out value="${place.placeDiscript}"/></textarea>
            <div class="feedback">
                Введите название места и его описание
            </div>
        </div>
</div>
<button class="btn btn-primary" type="submit">Сохранить место</button>
    </form>

    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Место</th>
                <th scope="col">Описание</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${city.place}" var="place">
                <tr>
                    <td><c:out value="${place.placeName}"/></td>
                    <td><c:out value="${place.placeDiscript}"/></td>
                    <td>
                        <a href="<c:url value='/editPlace?placeId=${place.id}&cityId=${city.id}'/>">Изменить место</a>
                    </td>
                    <td>
                        <form action="<c:url value='/deletePlace?placeId=${place.id}&cityId=${city.id}'/>"method='POST'>
                            <a href="#" onclick="parentNode.submit();">Удалить место</a>
                            <input type="hidden" name="img" value=""/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>