<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="header">社員情報管理システム</h2>

<c:if test="${user != null}">
  <h5 class="login_user" align="right">
    ようこそ<b>${user.empName}</b>さん
  </h5>
  <c:if test="${user.authority == 1}">

    <div align="right">
      <form method="get"
      action="<%=request.getContextPath()%>/InfoTopServlet">
      <input type="submit" value="社員情報一覧">
    </form>
    </div>
  </c:if>
  <c:if test="${user.authority == 2}">
    <div align="right">
       <form method="get"
      action="<%=request.getContextPath()%>/ManageTopServlet">
      <input type="submit" value="社員情報一覧">
    </form>
    </div>
    <div align="right">
      <form method="post"
      action="<%=request.getContextPath()%>/DeptManageServlet">
      <input type="submit" value="部署情報一覧">
    </form>
    </div>
  </c:if>
  <div align="right">
     <form method="get"
      action="<%=request.getContextPath()%>/LogoutServlet">
      <input type="submit" value="ログアウト">
    </form>
  </div>
</c:if>
