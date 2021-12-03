<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("UTF-8"); %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Анкети!</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-header bg-primary">
                    Ваше імя при проходженні анкети:<h5 class="card-title text-white mt-2">${userName}</h5>
                </div>

                <form action="/questions" method="post">
                    <c:forEach items="${questionList}" var="question" varStatus="theList">
                    <div class="card">
                        <div class="card-header">
                                ${question.question}
                        </div>
                        <div class="card-body">
                            <c:forEach items="${question.answers}" var="answer" varStatus="theCount">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="${theList.index}"
                                           id="${theList.index}_${theCount.index}"
                                           value="${theCount.index}" checked>
                                    <label class="form-check-label" for="${theList.index}_${theCount.index}">
                                            ${answer}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    </c:forEach>

            </div>
            <button type="submit" class="btn btn-primary">Перейти до заповення Анкети</button>

            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

