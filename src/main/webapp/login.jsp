<%--
    Document   : login
    Created on : Mar 21, 2022, 8:22:46 PM
    Author     : Son
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xem điểm</title>

    <link rel="stylesheet" href="<c:url value='assets/bootstrap/css/bootstrap.min.css' />">
    <script src="<c:url value='assets/bootstrap/js/bootstrap.min.js' /> "></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="<c:url value='assets/jquery/jquery.min.js'/>"></script>
    <link rel="stylesheet"
          href='<c:url value="assets/login/login.css"></c:url>'>

</head>

<body>
<div class="container" style="box-shadow: 0 0 20px rgb(0 0 0 / 70%);">
    <div class="label"></div>
    <!--Start header-->
    <div class="header">
        <!--Start login-->
        <div class="header-login">
            <div class="header-context">
                <p>Chào bạn
                    <a href="#">Đăng nhập</a>
                    <select id="font">
                        <option value="tahoma">------Font------</option>
                        <option value="time news roman">Font Unicode</option>
                        <option value="sanf">Font ABC</option>
                        <option value="sanf">Font VNI</option>
                        <option value="sanf">Text không dấu</option>
                    </select>
                </p>
            </div>
        </div>
        <!--End login-->
        <div class="add"></div>
        <!--Start navigation-->
        <div class="nav">
            <ul id="nav-ul">
                <li><a href="#">TRANG CHỦ</a></li>
                <li><a href="#">HƯỚNG DẪN ĐKMH</a></li>
            </ul>
        </div>
        <!--End navigation-->
    </div>
    <!--End header-->
    <div class="container-login">
        <form id="form-login" action="<c:url value='/dang-nhap'/>" method="post">
            <div class="login">
                <table>
                    <tr>
                        <td>
                            <a href="#">Quên Mật Khẩu!</a>
                        </td>
                        <td class="login-user">
                            <span class="label">Tên Đăng Nhập</span>
                            <input type="text" name="username" id="textbox" placeholder="username" >
                        </td>
                        <td class="login-pass">
                            <span class="label">Mật khẩu</span>
                            <input type="password" name="password" id="textbox" placeholder="password">
                        </td>
                        <td>
                            <input type="submit" name="submit" id="submit" class="label" value="Đăng Nhập">
                        </td>
                        <input type="hidden" value="login" name="action"/>
                        <c:if test="${not empty message}">
                            <td class="text-${alert} label" id="textbox">    ${message}
                            </td>
                        </c:if>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <div class="footer">
        <table>
            <tr>
                <td align="left">
                            <span class="label style1" style="color: red;">©2009 Học Viện Công Nghệ Bưu Chính Viễn Thông-Cơ Sở Miền Bắc. Quản lý bởi
                            </span>
                </td>
                <td class="style2">
                    <i style="font: size 12px;" class="fa">&#xf015;</i>
                </td>
                <td>
                    <a href="#" style="line-height: 2px;">
                        <span class="label">Trang chủ</span>
                    </a>
                </td>
            </tr>
            <tr>
                <td align="left" class="style1">
                    <a href="#">
                        <span class="label">Thiết kế bởi nhóm 14</span>
                    </a>
                </td>
                <td class="style2">
                    <i style="font-size: 12px;" class="fa-solid fa-up"></i>
                </td>
                <td class="style3">
                    <a href="#">
                        <span class="label">Đầu trang</span>
                    </a>
                </td>
                <td class="style">
                    <a href="#">
                        <span class="label">About</span>
                    </a>
                </td>
            </tr>
        </table>
    </div>
</div>

<script>
    // $("#submit").click(function () {
    //     let data = {};
    //     let formData = $("#form-login").serializeArray();
    //     $.each(formData, (index, value) => {
    //         data[""+v.name+""] = v.value
    //     })
    //
    // })
</script>

</body>

</html>