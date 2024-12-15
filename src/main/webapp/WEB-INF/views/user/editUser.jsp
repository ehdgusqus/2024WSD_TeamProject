<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/top.jsp" %>

<div class="container my-5">
    <h1 class="text-center mb-4">Edit Cart Item</h1>
    <form action="${pageContext.request.contextPath}/users/edit/${cartItem.userInventoryId}" method="post" class="border p-4 rounded bg-light shadow">
        <input type="hidden" name="userInventoryId" value="${cartItem.userInventoryId}">

        <div class="form-group">
            <label for="productName">Product Name:</label>
            <input type="text" id="productName" name="productName" class="form-control" value="${cartItem.productName}" readonly>
        </div>

        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" class="form-control" value="${cartItem.quantity}" min="1" max="${cartItem.availableQuantity}" required>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary">Update Item</button>
            <a href="${pageContext.request.contextPath}/users/cart" class="btn btn-secondary">Back to Cart</a>
        </div>
    </form>
</div>

<%@ include file="../include/bottom.jsp" %>
