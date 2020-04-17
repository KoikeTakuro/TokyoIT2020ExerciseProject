<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/stylesheet.css"
  rel="stylesheet" type="text/css" />
<title>ログイン画面</title>
</head>

<body>
<div id="contents">
  <div id="header">
    <%@include file="/jsp/common/header_login.jsp"%>
  </div>
  <div id="main">

    <div class="contents">
      <form method="post"
        action="<%=request.getContextPath()%>/LoginServlet">
        <table class="table_login" align="center">
          <td><p style="color: red">${errorMessage}</p></td>
          <tr class="index_loginId">

            <td style="border-style: none; text-align: center;">社員ID：<input
              type="text" name="empId" maxlength="5" />
            </td>
          </tr>
          <tr>
            <!-- <td><html:errors property="empId" /></td> -->
          </tr>
          <tr class="index_password">
            <td style="border-style: none">パスワード：<input type="password"
              name="empPass" maxlength="30" /></td>
          </tr>
          <tr>
            <!--  <td><html:errors property="empPass" /></td> -->
          </tr>
          <tr>
            <td style="border-style: none"><input type="submit"
              value="ログイン" /></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
  <div id="footer">
    <%@include file="/jsp/common/footer.jsp"%>
  </div>
  </div>
</body>
</html>