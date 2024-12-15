<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/top.jsp" %>

<div class="container my-5">
    <h1 class="text-center mb-4">Product List</h1>

    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Available Quantity</th>
                <th>Price</th>
                <th>Category</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <!-- AdminVO의 필드 사용 -->
                    <td>${product.inventory_id}</td>  <!-- inventory_id -->
                    <td>${product.product_name}</td>  <!-- product_name -->
                    <td>${product.quantity}</td>  <!-- quantity -->
                    <td>${product.price}</td>  <!-- price -->
                    <td>${product.category}</td>  <!-- category -->
                    <td>
                        <!-- Add to Cart Form -->
                        <form action="${pageContext.request.contextPath}/users/add" method="post" class="d-flex align-items-center">
                            <input type="hidden" name="inventory_id" value="${product.inventory_id}">
                            <input type="number" name="quantity" class="form-control form-control-sm mr-2" min="1" max="${product.quantity}" required>
                            <button type="submit" class="btn btn-primary btn-sm">Add to Cart</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="text-center mt-4">
        <a href="${pageContext.request.contextPath}/users/cart" class="btn btn-secondary">View Cart</a>
        <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Back to Main</a>
    </div>
</div>

<%@ include file="../include/bottom.jsp" %>
