<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
  rel="stylesheet" type="text/css" />
<title>社員情報一覧画面</title>
</head>
<body>
  <div id="contents">

    <div id="header">
      <%@include file="/jsp/common/header.jsp"%>
    </div>

    <div class="select_func">
      <form method="post"
        action="<%=request.getContextPath()%>/InfoSelectServlet">
        <div class="select_empId">
          <input type="radio" name="radio" value="1" checked="checked" />
          社員ID: <input type="text" name="empId" />
        </div>
        <div class="select_empName">
          <input type="radio" name="radio" value="2" /> 社員名: <input
            type="text" name="empName" maxlength="30" />
        </div>
        <div class="select_deptId">
          <input type="radio" name="radio" value="3" /> 部署名: <select
            name="deptId">
            <c:forEach var="dept" items="${deptList}" varStatus="status">
              <option value="${dept.deptId}">${dept.deptName}</option>
            </c:forEach>
          </select>
        </div>

        <div class="select_submit">
          <input type="submit" value="検索実行" />
        </div>
      </form>

      <form method="get"
        action="<%=request.getContextPath()%>/SelfUpdateInputServlet">
        <input type="hidden" name="empId" value="${user.empId}" />
        <div class="update_submit">
          <input type="submit" value="社員情報更新" />
        </div>
      </form>

      &nbsp;
      <div align="right">
      <form method="post"
        action="<%=request.getContextPath()%>/SelfPasswordInputServlet">
        <input type="hidden" name="empId" value="${user.empId}" />
        <div class="update_submit">
          <input type="submit" value="パスワード変更" />
        </div>
      </form>
      </div>

    </div>
    <form method="post"
      action="<%=request.getContextPath()%>/InfoSelectServlet"></form>

    <div class="table_manage">
      <table border="1" width="750px">
        <tr>
          <th>社員ID</th>
          <th>氏名</th>
          <th>部署名</th>
        </tr>
        <c:forEach var="empInfo" items="${empList}">
          <tr>
            <td><c:out value="${empInfo.empId}" /></td>
            <td><c:out value="${empInfo.empName}" /></td>
            <td><c:out value="${empInfo.deptName}" /></td>
          </tr>
        </c:forEach>
      </table>
    </div>
    &nbsp;
    <div id="footer">
      <%@include file="/jsp/common/footer.jsp"%>
    </div>

  </div>
</body>
</html>
