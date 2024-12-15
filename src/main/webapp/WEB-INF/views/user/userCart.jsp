<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/top.jsp" %>

<div class="container my-5">
    <h1 class="text-center mb-4">Your Cart</h1>

    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Category</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${cartItems}">
                <tr>
                    <td>${item.inventory_id}</td>
                    <td>${item.product_name}</td>
                    <td>${item.quantity}</td>
                    <td>${item.category}</td>
                    <td class="text-center">
                        <!-- Edit Quantity Form -->
                        <form action="${pageContext.request.contextPath}/users/edit/${item.userInventoryId}" method="get" class="d-inline">
                            <button type="submit" class="btn btn-sm btn-primary">Edit</button>
                        </form>
                        <!-- Remove Item Form -->
                        <form action="${pageContext.request.contextPath}/users/delete" method="post" class="d-inline">
                            <input type="hidden" name="userInventoryId" value="${item.userInventoryId}">
                            <button type="submit" class="btn btn-sm btn-danger">Remove</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Total Quantity and Price -->
    <c:if test="${not empty cartItems}">
        <div class="text-right">
            <p><strong>Total Quantity:</strong> ${totalQuantity}</p>
            <p><strong>Total Price:</strong> ${totalPrice}</p>
        </div>
    </c:if>

    <!-- Back to Products Button -->
    <div class="text-center mt-4">
        <a href="${pageContext.request.contextPath}/users" class="btn btn-secondary">Back to Products</a>
    </div>
</div>

<%@ include file="../include/bottom.jsp" %>
