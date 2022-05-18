<%--
  Created by IntelliJ IDEA.
  User: yasuo
  Date: 2022/4/25
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="multipart/form-data; charset=utf-8" />
    <title>修改课程信息</title>
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
    <form class="form-horizontal" enctype="multipart/form-data" id="courInfoToUpdate" method="post">
<%--        <div class="form-group" >--%>
<%--            <label for="courseName" class="col-sm-2 control-label">课程ID</label>--%>
<%--            <div class="col-sm-10">--%>
<%--                <input type="text" class="form-control" id="courseID" readonly="readonly" name="id" value="${course.getId()}">--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="courseName" class="col-sm-2 control-label">课程名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="courseName" name="name" value="${course.getName()}">
            </div>
        </div>
        <div class="form-group">
            <label for="courseHours" class="col-sm-2 control-label">课时</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="courseHours" name="hours" value="${course.getHours()}">
            </div>
        </div>
        <div class="form-group">
            <label for="academyId" class="col-sm-2 control-label">开课学院</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="academyID" name="aid" placeholder="学院ID" value="${course.getAid()}">
            </div>
        </div>
         <div class="form-group">
             <label for="courPictoupdate" class="col-sm-2 control-label">课程图片</label>
             <div class="col-sm-offset-2 col-sm-10">
                    <img src="${course.imgpath}" id="imgPreview" style="width: 100px;height: 100px; ">
                    <input  type="file"  id="courPicToUpdate" name="courPic" >
              </div>
         </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-warning" onclick="updateCourInfo()">保存修改</button>
                <a href="${pageContext.request.contextPath}/course/list" class="btn btn-default">取消</a>
            </div>
        </div>
    </form>
</div>
<script>
    function updateCourInfo() {
        var formData=new FormData();
        formData.append("id",${course.id});
        formData.append("name",document.getElementById("courseName").value);
        formData.append("hours",document.getElementById("courseHours").value);
        formData.append("aid",document.getElementById("academyID").value);
        formData.append("oldImgPath","${course.imgpath}");
        if (document.getElementById("courPicToUpdate").files[0]!=null)
            formData.append("courPic",document.getElementById("courPicToUpdate").files[0]);
        $.ajax({
            url: "${pageContext.request.contextPath}/course/UpdateCourInfo",
            type: "POST",
            processData: false,
            contentType: false,
            data: formData,
            success: function (data) {
                if (data == "success")
                {
                    alert("修改成功！");
                    window.location.replace("${pageContext.request.contextPath}/course/list");
                }
                else if (data == "dataError")
                    alert("请输入正确课程信息！");
                else if (data == "exist")
                    alert("课程名重复！");
            },
            error: function () {
                alert("修改失败！");
            }
        });
    }
</script>
</body>
</html>
