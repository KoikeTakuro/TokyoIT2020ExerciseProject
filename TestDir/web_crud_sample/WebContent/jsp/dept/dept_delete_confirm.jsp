<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
  rel="stylesheet" type="text/css" />
<title>部署情報削除画面</title>
</head>
<body>
  <div id="header">
    <%@include file="/jsp/common/header_login.jsp"%>
  </div>
  <div id="main">

    <h3>この部署を削除しますか？</h3>
    <table align="center" width="300px">
      <tr>
        <th>部署ID</th>
        <td><c:out value="${dept.deptId}" /></td>
      </tr>
      <tr>
        <th>部署名</th>
        <td><c:out value="${dept.deptName}" /></td>
      </tr>
    </table>
    <form method="post"
      action="<%=request.getContextPath()%>/DeleteDeptCompleteServlet">
      <input type="hidden" name="deptId" value="${dept.deptId}" /> <input
        type="submit" value="実行" />
    </form>

    <form method="get"
      action="<%=request.getContextPath()%>/DeptManageServlet">
      <input type="submit" value="部署一覧表示に戻る" />
    </form>
  </div>

  <div id="footer">
    <%@include file="/jsp/common/footer.jsp"%>
  </div>

</body>
</html>