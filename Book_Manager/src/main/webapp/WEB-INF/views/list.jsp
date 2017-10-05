<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="Book List" />
    <c:param name="body">
        <div class="container" role="main">
            <h1>Book List</h1>
            <p><em>${message}</em></p>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>PrintYear</th>
                    <th>Isbn</th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <div id="pagination">

                    <c:url value="list" var="prev">
                        <c:param name="page" value="${page-1}"/>
                    </c:url>
                    <c:if test="${page > 1}">
                        <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
                    </c:if>

                    <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
                        <c:choose>
                            <c:when test="${page == i.index}">
                                <span>${i.index}</span>
                            </c:when>
                            <c:otherwise>
                                <c:url value="list" var="url">
                                    <c:param name="page" value="${i.index}"/>
                                </c:url>
                                <a href='<c:out value="${url}" />'>${i.index}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:url value="list" var="next">
                        <c:param name="page" value="${page + 1}"/>
                    </c:url>
                    <c:if test="${page + 1 <= maxPages}">
                        <a href='<c:out value="${next}" />' class="pn next">Next</a>
                    </c:if>
                </div>
                <tbody>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}
                            <c:if test="${book.readAlready == 'No'}">
                            (new)
                            </c:if>
                        </td>
                        <td>${book.author}</td>
                        <td>${book.printYear}</td>
                        <td>${book.isbn}</td>
                        <c:if test="${book.readAlready == 'Yes'}">
                            <td>already read</td>
                        </c:if>
                        <c:if test="${book.readAlready == 'No'}">
                                <td>
                                    <a href="${pageContext.request.contextPath}/edit/${book.id}/read">click to read</a>
                                </td>
                        </c:if>
                        <td>
                            <a href="${pageContext.request.contextPath}/edit/${book.id}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/delete/${book.id}">Delete</a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div> <!-- /container -->
    </c:param>
</c:import>