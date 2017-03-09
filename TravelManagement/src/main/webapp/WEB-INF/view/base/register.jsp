<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <%@include file="../includes/header.jspf" %>
        <title>Travel Management Portal</title>

        <style>
            .loader-modal {
                display: none;
                position: fixed;
                z-index: 1000;
                top: 0;
                left: 0;
                height: 100%;
                width: 100%;
                background-position: center;
                background: rgba(255, 255, 255, .8) url('${baseURL}/assets/images/ajax-loader.gif') 50%
                    50% no-repeat;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Register</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" autocomplete="off" id="registeration_form" method="POST" action="#">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Email" name="email" id="email" type="email" autofocus required="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" id="password" type="password" value="" required="">
                                    </div>
                                    <div class="form-group">
                                        <select id="role" class="form-control">
                                            <option value="ROLE_ADMIN">Admin</option>
                                            <option value="ROLE_USER">User</option>
                                        </select>
                                    </div>
                                    <input type="submit" class="btn btn-lg btn-success btn-block" value="Register" id="register">

                                    <div class="form-group" >
                                        <label for="msisdn" class="col-sm-3 control-label"> </label>
                                        <div class="col-sm-7">
                                            <span> 
                                                <label class="label label-danger" id="error_label">${ERR_MSG}</label></span>
                                        </div>
                                    </div>
                                    <div style="float:left;">
                                        <a href="${baseURL}/base/login.htm"><strong><- Login</strong></a>
                                    </div>
                                    <div class="loader-modal" id="loading"></div>

                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="../includes/footer.jspf" %>
    </body>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#registeration_form").submit(function (e) {
                e.preventDefault();

                var email = $("#email").val();
                var password = $("#password").val();
                var role = $("#role").val();
                var obj = {"email": email, "password": password, "role": role};
                var data = JSON.stringify(obj);
                $("#loading").css("display", "block");
                $.ajax({
                    contentType: 'application/json; charset=utf-8',
                    type: 'POST',
                    url: 'register.htm?',
                    dataType: 'json',
                    async: true,
                    data: data,
                    success: function (response) {
                        $("#loading").css("display", "none");
                        //swal("Response!", response.message, response.status);
                        swal({
                            title: response.status,
                            text: response.message,
                            confirmButtonColor: "#DD6B55",
                            confirmButtonText: "OK",
                            closeOnConfirm: false
                        },
                        function () {
                            window.location.href = '${baseURL}/base/login.htm';
                        });

                    },
                    error: function () {
                        $("#loading").css("display", "none");
                        swal("Oops!", "Sometime went wrong. please try again ", "error");

                    }
                });
            });
        });

    </script>
</html>
