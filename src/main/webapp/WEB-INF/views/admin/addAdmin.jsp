<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/top.jsp" %>

<div class="container my-5">
    <h1 class="text-center mb-4">Add New Product</h1>
    <form action="${pageContext.request.contextPath}/admin/add" method="post" class="needs-validation" novalidate>
        <!-- Product Name -->
        <div class="mb-3">
            <label for="product_name" class="form-label">Product Name:</label>
            <input type="text" class="form-control" id="product_name" name="product_name" required>
            <div class="invalid-feedback">Please enter a product name.</div>
        </div>

        <!-- Quantity -->
        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" min="1" required>
            <div class="invalid-feedback">Quantity must be greater than 0.</div>
        </div>

        <!-- Price -->
        <div class="mb-3">
            <label for="price" class="form-label">Price:</label>
            <input type="text" class="form-control" id="price" name="price" required>
            <div class="invalid-feedback">Please enter a valid price.</div>
        </div>

        <!-- Category -->
        <div class="mb-3">
            <label for="category" class="form-label">Category:</label>
            <input type="text" class="form-control" id="category" name="category">
        </div>

        <!-- Buttons -->
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success">Add Product</button>
            <a href="${pageContext.request.contextPath}/admin" class="btn btn-secondary">Back to Inventory</a>
        </div>
    </form>
</div>

<%@ include file="../include/bottom.jsp" %>
