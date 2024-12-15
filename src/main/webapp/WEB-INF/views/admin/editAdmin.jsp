<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/top.jsp" %>

<h1 class="text-center my-4">Edit Product</h1>
<div class="container">
    <form action="${pageContext.request.contextPath}/admin/edit/${product.inventoryId}" method="post" class="needs-validation" novalidate>
        <input type="hidden" name="inventoryId" value="${product.inventoryId}">

        <div class="mb-3">
            <label for="productName" class="form-label">Product Name:</label>
            <input type="text" class="form-control" id="productName" name="productName" value="${product.productName}" required>
            <div class="invalid-feedback">Please provide a valid product name.</div>
        </div>

        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" value="${product.quantity}" min="1" required>
            <div class="invalid-feedback">Quantity must be at least 1.</div>
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Price:</label>
            <input type="text" class="form-control" id="price" name="price" value="${product.price}" required>
            <div class="invalid-feedback">Please provide a valid price.</div>
        </div>

        <div class="mb-3">
            <label for="category" class="form-label">Category:</label>
            <input type="text" class="form-control" id="category" name="category" value="${product.category}">
        </div>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary">Update Product</button>
            <a href="${pageContext.request.contextPath}/admin" class="btn btn-secondary">Back to Inventory</a>
        </div>
    </form>
</div>

<%@ include file="../include/bottom.jsp" %>
