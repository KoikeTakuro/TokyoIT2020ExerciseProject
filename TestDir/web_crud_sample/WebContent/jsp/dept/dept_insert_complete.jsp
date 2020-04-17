<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
  rel="stylesheet" type="text/css" />
<title>部署情報登録画面</title>
</head>

<body>
  <div id="header">
    <%@include file="/jsp/common/header_login.jsp"%>
  </div>
  <div id="main">
    <h3>登録が完了しました。</h3>
    <form method="get"
      action="<%=request.getContextPath()%>/DeptManageServlet">
      <input type="submit" value="部署一覧に戻る">
    </form>
  </div>
  <div id="footer">
    <%@include file="/jsp/common/footer.jsp"%>
  </div>
</body>
</html>
