<%-- 
    Document   : Header
    Created on : Mar 8, 2018, 10:39:24 AM
    Author     : eslam java
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <div class="header-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="user-menu">
                            <ul>
                                <c:if test="${sessionScope.user!=null}">
                                    <li><a href="UserProfile.jsp"><i class="fa fa-user"></i> My Account</a></li>
                                    </c:if>


                                <li><a href="cart.jsp"><i class="fa fa-user"></i> My Cart</a></li>

                                <c:if test="${sessionScope.user==null}">
                                    <li><a href="login.jsp"><i class="fa fa-user"></i> Login</a></li>
                                    </c:if>


                            </ul>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="header-right">
                            <ul class="list-unstyled list-inline">
                                <li class="dropdown dropdown-small">
                                    <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">USD</a></li>
                                        <li><a href="#">INR</a></li>
                                        <li><a href="#">GBP</a></li>
                                    </ul>
                                </li>

                                <li class="dropdown dropdown-small">
                                    <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">English</a></li>
                                        <li><a href="#">French</a></li>
                                        <li><a href="#">German</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="site-branding-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="logo">
                            <h1><a href="index.jsp">e<span>Electronics</span></a></h1>
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <div class="shopping-item">


                            <a href="cart.jsp">Cart - <span class="cart-amunt">$

                                    <c:if test="${sessionScope.totalOrderPrice!=null}">

                                        <c:out value="${sessionScope.totalOrderPrice}"/>
                                    </c:if>
                                    <i class="fa fa-shopping-cart"></i>
                            </a>


                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End site branding area -->

        <div class="mainmenu-area">
            <div class="container">
                <div class="row">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div> 
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="shop.jsp">Shop page</a></li>                 
                            <li><a href="cart.jsp">Cart</a></li>
                            <li class="dropdown dropdown-small"><a data-toggle="dropdown"
                                                                   data-hover="dropdown" class="dropdown-toggle" ><span
                                        class="key">Category</span></a>
                                <ul class="dropdown-menu">

                                    <c:if test="${applicationScope.categories!=null}">
                                        <c:forEach items="${applicationScope.categories}" var="category">

                                            <li><a href="shop.jsp?productCategory=<c:out value="${category}"/>"><c:out value="${category}"/></a></li>

                                        </c:forEach>
                                    </c:if>


                                </ul></li>
                                <c:if test="${sessionScope.admin!=null}">
                                <li class="dropdown dropdown-small"><a data-toggle="dropdown"
                                                                       data-hover="dropdown" class="dropdown-toggle" ><span
                                            class="key">Manage Products</span></a>
                                    <ul class="dropdown-menu">



                                        <li><a href="AddProducts.jsp">Add Product</a></li>
                                        <li><a href="AllProducts.jsp">View Products</a></li>
                                        <li><a href="AllUsers.jsp">View Users</a></li>



                                    </ul></li>
                                </c:if>

                            <c:if test="${sessionScope.isadmin==true}">
                                <li style="margin-left: 250px "><a href="#">${sessionScope.admin.adminName}</a></li>
                                <li style="margin-left: 10px "><a href="LogoutServlet">Log Out</a></li>
                                </c:if>
                                <c:if test="${sessionScope.user !=null}">

                                <li style="margin-left: 400px "><a href="UserProfile.jsp">${sessionScope.user.userName}</a></li>
                                <li style="margin-left: 10px "><a href="LogoutServlet">Log Out</a></li>

                            </c:if>
                            <c:if test="${sessionScope.user ==null&& sessionScope.admin==null}">

                                <li style="margin-left: 400px "><a href="login.jsp">Login</a></li>
                                <li style="margin-left: 10px "><a href="register.jsp">Register</a></li>

                            </c:if>

                        </ul>
                    </div>  
                </div>
            </div>
        </div> <!-- End mainmenu area -->
    </body>
</html>
