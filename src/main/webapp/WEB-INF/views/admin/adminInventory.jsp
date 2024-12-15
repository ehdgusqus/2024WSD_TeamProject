<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/top.jsp" %>

<h1 class="text-center">Admin Inventory Management</h1>
<div class="table-responsive">
  <table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
      <th>Product ID</th>
      <th>Product Name</th>
      <th>Quantity</th>
      <th>Price</th>
      <th>Category</th>
      <th>Created At</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
      <tr>
        <td>${product.inventory_id}</td>
        <td>${product.product_name}</td>
        <td>${product.quantity}</td>
        <td>${product.price}</td>
        <td>${product.category}</td>
        <td>${product.created_at}</td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/edit/${product.inventory_id}" class="btn btn-primary btn-sm">Edit</a>
          <form action="${pageContext.request.contextPath}/admin/delete/${product.inventory_id}" method="post" class="d-inline">
            <button type="submit" class="btn btn-danger btn-sm">Delete</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<a href="${pageContext.request.contextPath}/admin/add" class="btn btn-success">Add New Product</a>

<%@ include file="../include/bottom.jsp" %>
