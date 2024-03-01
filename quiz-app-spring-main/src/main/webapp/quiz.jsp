<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quiz Questions</title>
</head>
<body>
    <h2>Quiz Questions</h2>
    
    <c:forEach var="question" items="${questions}">
        <div>
            <p>${question.questionTitle}</p>
            <label>
                <input type="radio" name="answer_${question.id}" value="${question.option1}">
                ${question.option1}
            </label>
            <label>
                <input type="radio" name="answer_${question.id}" value="${question.option2}">
                ${question.option2}
            </label>
            <label>
                <input type="radio" name="answer_${question.id}" value="${question.option3}">
                ${question.option3}
            </label>
            <label>
                <input type="radio" name="answer_${question.id}" value="${question.option4}">
                ${question.option4}
            </label>
        </div>
    </c:forEach>

    <!-- Add a submit button if needed -->
    <form action="/quiz/submit/${quizId}" method="post">
        <button type="submit">Submit Quiz</button>
    </form>
</body>
</html>
