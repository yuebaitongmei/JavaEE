<%--
  Created by IntelliJ IDEA.
  User: yasuo
  Date: 2022/4/24
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- jQuery-->
    <script src="https://fastly.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"
            integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
            crossorigin="anonymous"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
    <div>
        <input id="CourIDorName" name="CourIDorName" type="text" placeholder="输入课程名称或ID" style="width: 710px">
        <a href="javascript:;"
           onclick="if(document.getElementById('CourIDorName').value!='') location ='${pageContext.request.contextPath}/course/findCourAndAmyNameByID?courseID='+document.getElementById('CourIDorName').value;
                   else alert('课程ID不能为空');" class="btn btn-success">ID查询</a>
        <a href="javascript:;"
           onclick="if(document.getElementById('CourIDorName').value!='') location ='${pageContext.request.contextPath}/course/findCourAndAmyNameByName?courseName='+document.getElementById('CourIDorName').value;
                   else location ='${pageContext.request.contextPath}/course/list'; " class="btn btn-success">名称查询</a>
        <a href="${pageContext.request.contextPath}/course/toAdd" class="btn btn-info">添加课程</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th></th>
            <th>课程名称</th>
            <th>课时</th>
            <th>开课学院</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${requestScope.get('courseList')}">
            <tr>
                <td><img src="${course.imgpath}" style="width: 100px;height: 100px; "></td>

                <td style=" vertical-align: middle">${course.name}</td>
                <td style="vertical-align: middle">${course.hours}</td>
                <td style="vertical-align: middle">${course.academyname}</td>
                <td style="vertical-align: middle ">
                    <a href="${pageContext.request.contextPath}/course/toUpdate?courseID=${course.id}" class="btn btn-warning">编辑</a>
                    <a href="javascript:if(confirm('确定删除吗?'))location='${pageContext.request.contextPath}/course/deleteCourByID?courseID=${course.id}'"
                       class="btn btn-danger">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
