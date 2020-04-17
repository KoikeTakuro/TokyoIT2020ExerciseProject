<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
  rel="stylesheet" type="text/css" />
<title>社員情報検索画面</title>
</head>

<body>
  <div id="header">
    <%@include file="/jsp/common/header_login.jsp"%>
  </div>
  <div id="main">

    <div>
      <h3>該当する社員が存在しません。</h3>
    </div>

    <div>
      <c:if test="${user.authority == 1}">
          <a href="/web_crud_sample/InfoTopServlet">社員一覧に戻る</a>
           </c:if>
    </div>

    <div>
      <c:if test="${user.authority == 2}">
        <a href="/web_crud_sample/ManageTopServlet">社員一覧に戻る</a>
      </c:if>
    </div>

  </div>
  <div id="footer">
    <%@include file="/jsp/common/footer.jsp"%>
  </div>
</body>