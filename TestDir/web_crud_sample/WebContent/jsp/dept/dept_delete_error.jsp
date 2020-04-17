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

    <div>
      <h3>部署に所属している人がいるため、削除することができません。</h3>
      <h3>所属人数を0名にしてください。</h3>
    </div>

    <div>
      <c:if test="${user.authority == 1}">
           <a href="/web_crud_sample/DeptManageServlet">部署一覧に戻る</a>
           </c:if>
    </div>

    <div>
      <c:if test="${user.authority == 2}">
         <a href="/web_crud_sample/DeptManageServlet">部署一覧に戻る</a>
      </c:if>
    </div>

  </div>
  <div id="footer">
    <%@include file="/jsp/common/footer.jsp"%>
  </div>
</body>