<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
  rel="stylesheet" type="text/css" />
<title>部署情報一覧画面</title>
</head>
<body>
  <div id="contents">

    <div id="header">
      <%@include file="/jsp/common/header.jsp"%>
    </div>

    <div class="select_func">
      <form method="post"
        action="<%=request.getContextPath()%>/DeptSelectServlet">
        <div class="select_empId">
          <input type="radio" name="radio" value="1" checked="checked" />
          部署ID: <input type="text" name="deptId" />
        </div>
        <div class="select_empName">
          <input type="radio" name="radio" value="2" /> 部署名: <input
            type="text" name="deptName" maxlength="30" />
        </div>


        <div class="select_submit">
          <input type="submit" value="検索実行" />
        </div>
      </form>

      <form method="post"
        action="<%=request.getContextPath()%>/InsertDeptInputServlet">
        <div class="update_submit">
          <input type="submit" value="部署新規登録" />
        </div>
      </form>


    </div>
    <form method="post"
      action="<%=request.getContextPath()%>/InfoSelectServlet"></form>

    <div class="table_manage">
      <table border="1" width="750px">
        <tr>
          <th>部署ID</th>
          <th>部署名</th>
          <th>部署所属人数</th>
          <th>部署情報更新</th>
          <th>部署情報削除</th>
        </tr>
        <c:forEach var="dept" items="${empList}">
          <tr>
            <td><c:out value="${dept.deptId}" /></td>
            <td><c:out value="${dept.deptName}" /></td>
            <td><c:out value="${dept.affiliation}" />名</td>
            <td><form method="get"
                action="<%=request.getContextPath()%>/UpdateDeptInputServlet">
                <input type="hidden" name="deptId" value="${dept.deptId}" /> <input
                  type="submit" value="更新" />
              </form></td>
            <td><form method="post"
                action="<%=request.getContextPath()%>/DeleteDeptConfirmServlet">
                <input type="hidden" name="deptId" value="${dept.deptId}" /> <input
                  type="hidden" name="affiliation" value="${dept.affiliation}" /> <input
                  type="submit" value="削除" />
              </form></td>
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
