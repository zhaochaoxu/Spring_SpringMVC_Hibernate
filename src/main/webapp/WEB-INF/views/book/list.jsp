<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>

    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container">

    <div class="page-header">
        <h3>SpringMVC+Spring+Hibernate</h3>
    </div>

    <div class="well well-sm">

        <form  class="form-inline" method="get">


            <div class="form-group">
                <input type="text" class="form-control" placeholder="请输入书籍名称" name="q_like_bookname"> <input type="text" name="q_ge_bookprice" class="form-control" placeholder="请输入最低价格">~<input
                    type="text" name="q_le_bookprice" class="form-control" placeholder="请输入最高价格">
            </div>
            <%--<div class="form-group">
                <select  name="type">
                    <option value="">请选择类型</option>
                    <c:forEach items="${types}" var="type">
                        <option value="${type.id}" ${typeid==type.id ? 'selected':''}>${type.booktype}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <select name="pub">
                    <option value="">请选出版社</option>
                    <c:forEach items="${pubs}" var="pub">
                        <option value="${pub.id}" ${pub.id==pubid ?'selected':''}>${pub.pubname}</option>
                    </c:forEach>
                </select>
            </div>--%>
            <button class="btn btn-default">搜索</button>

        </form>
    </div>
    <a href="/book/new" class="btn btn-success">添加新书籍</a>

    <table class="table">

        <thead>
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>数量</th>
            <th>分类</th>
            <th>出版社</th>
            <th>编辑</th>
        </tr>
        </thead>

        <tbody>

            <c:forEach items="${page.items}" var="book">
                <tr>
                    <td>${book.bookname}</td>
                    <td>${book.bookauthor}</td>
                    <td>${book.bookprice}</td>
                    <td>${book.booknum}</td>
                    <td>${book.bookType.booktype}</td>
                    <td>${book.publisher.pubname}</td>
                    <td>
                        <a href="/book/${book.id}/edit">修改</a>
                        <a href="/book/${book.id}/del">删除</a>
                    </td>
                </tr>
            </c:forEach>

        </tbody>

    </table>
    <ul class="pagination pull-right" id="page"></ul>

</div>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script>

    $(function(){


        $("#page").twbsPagination({
            totalPages:${page.totalPages},
            visiblePages:10,
            first:'首页',
            prev:'上一页',
            next:'下一页',
            last:'末页',
            href:'?bookname='+encodeURIComponent('${bookname}')+'&type=${typeid}&pub=${pubid}&p={{number}}'
        });


    });

</script>


</body>
</html>
