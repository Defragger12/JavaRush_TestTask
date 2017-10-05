<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="Update Book" />
    <c:param name="body">
        <div class="container" role="main">
            <h1>Updating Book</h1>
            <form:form method="POST" modelAttribute="book" action="${pageContext.request.contextPath}/edit/${book.id}">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <form:input path="title" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <form:input path="description" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="isbn">Isbn:</label>
                    <form:input path="isbn" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="printYear">Print Year:</label>
                    <form:input path="printYear" class="form-control" />
                </div>
                <button type="submit" class="btn btn-default">Update</button>
            </form:form>
        </div>
    </c:param>
</c:import>