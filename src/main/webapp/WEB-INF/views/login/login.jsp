<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/top.jsp" %>

<div class="container my-5">
    <h1 class="text-center mb-4">Login</h1>
    <form action="${pageContext.request.contextPath}/users/login" method="post" class="border p-4 rounded bg-light shadow">

        <div class="form-group">
            <label for="username">Username (or Email):</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Enter username or email" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Enter password" required>
        </div>

        <div class="form-group">
            <label for="role">Role:</label>
            <select id="role" name="role" class="form-control" required>
                <option value="user">User</option>
                <option value="admin">Admin</option>
            </select>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>
    </form>

    <div class="text-center mt-4">
        <a href="${pageContext.request.contextPath}/users/register" class="btn btn-secondary">Register</a>
    </div>
</div>

<%@ include file="../include/bottom.jsp" %>
