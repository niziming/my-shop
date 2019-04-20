<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>MyShop | 登陆</title>
    <!-- Tell the browser to be responsive to screen width 响应式 -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../../assets/bower_components/bootstrap/dist/css/bootstrap.min.css"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../assets/bower_components/font-awesome/css/font-awesome.min.css"/>
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../assets/bower_components/Ionicons/css/ionicons.min.css"/>
    <!-- Theme style -->
    <link rel="stylesheet" href="../../assets/css/AdminLTE.min.css"/>
    <!-- iCheck -->
    <link rel="stylesheet" href="../../assets/plugins/iCheck/square/blue.css"/>

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <%--谷歌字体--%>
    <link href='https://fonts.font.im/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
</head>
<%--Header End--%>

<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>Admin</b>登陆</a>
    </div>
    <%--/.UserService.-logo--%>
    <div class="login-box-body">
        <p class="login-box-msg">欢迎管理员登陆</p>

        <%--Denger alert--%>
            <c:if test="${msg != null}">
            <div class="alert alert-danger alert-dismissible" >
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${msg}
            </div>
        </c:if>
        <%--/.alert--%>

        <form action="/login" method="post">
            <div class="form-group has-feedback">
                <input type="email" class="form-control" placeholder="邮箱" name="email" />
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>



            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="密码" name="pwd" />
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input name="isRemember" type="checkbox"> 记住我?
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登陆</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="#">忘记密码?</a><br>
    </div>
    <!-- /.UserService-box-body -->
</div>
<!-- /.UserService-box -->

<!-- jQuery 3 -->
<script src="../../assets/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../../assets/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    });
</script>

</body>
</html>
