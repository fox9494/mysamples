
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="frame" uri="/WEB-INF/tlds/frame.tld" %>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>成勘院会议系统</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/resource/bootstrap/3.0/css/bootstrap.css'/>" rel="stylesheet" type="text/css" />

    <!-- Custom styles for this template -->
    <link href="<c:url value='/resource/css/signin.css'/>" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <form class="form-signin" role="form" action="<c:url value='/WEB-INF/jsp/index.jsp'/>">
        <h2 class="form-signin-heading">欢迎登录</h2>
        <!-- <input type="text" class="form-control" placeholder="用户名" required autofocus> -->
        <input type="text" class="form-control" placeholder="用户名" >
        <input type="password" class="form-control" placeholder="密码" >
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 记住我
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
