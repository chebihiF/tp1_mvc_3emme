<%--
  Created by IntelliJ IDEA.
  User: fcheb
  Date: 3/3/2022
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product list</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
</head>
<body>
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>

    <div class="container-sm">
        <br>
        <form method="post" action="products">
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Reference</label>
                <input type="text" class="form-control" id="formGroupExampleInput"
                       placeholder="add reference" name="reference">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInputLabel" class="form-label">Label</label>
                <input type="text" class="form-control" id="formGroupExampleInputLabel"
                       placeholder="add Label" name="label">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInputPrice" class="form-label">Price</label>
                <input type="text" class="form-control" id="formGroupExampleInputPrice"
                       placeholder="add Price" name="price">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInputQte" class="form-label">Quantity</label>
                <input type="text" class="form-control" id="formGroupExampleInputQte"
                       placeholder="add reference input placeholder" name="quantity">
            </div>
            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-outline-success">Save Product</button>
            </div>
        </form>

        <table class="table">
            <tr>
                <th>Reference</th>
                <th>Label</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.ref}</td>
                    <td>${p.label}</td>
                    <td>${p.price}</td>
                    <td>${p.quantity}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>
