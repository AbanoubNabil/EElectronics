
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>eElectronics - HTML eCommerce Template</title>

        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="css/file.css">



        <c:if test="${empty sessionScope.allusers}">
          
            <jsp:include page="/GetAllUsers" ></jsp:include>
        </c:if>
    </head>
    <body>
       
         <jsp:include page="Header.jsp"></jsp:include> 

        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="product-content-right">
                            <div class="woocommerce">

                                <h3>Users List</h3><br><br>

                                <table class="timetable_sub">
                                    <tr>
                                       
                                        <th> Name </th>
                                        <th> Full Address </th>  
                                       
                                        <th> Email </th>
                                        <th> Password </th>
                                        <th> Balance </th>
                                        <th> Phone </th>
                                        <th> Gender </th>
                                    </tr>
                                    <c:if test="${allusers} == null">

                                    </c:if>
                                    <c:forEach var="userr" items="${allusers}">                   
                                        <tr>
                                            
                                            <td>${userr.userName}</td>
                                            <td>${userr.userAddress}</td>
                                            <td>${userr.userEmail}</td>
                                            <td>${userr.userPassword}</td>
                                            <td>${userr.userBalance}</td>
                                            <td>${userr.userPhone}</td>
                                            <td>${userr.userGender}</td>
                                            <td class="invert">
                                                <div class="rem">
                                                    <a href="GetCartHistory?xyz=${userr.userId}">
                                                        History
                                                        <div class="close1">
                                                        </div>
                                                    </a>
                                                </div>
                                            </td>
                                            <td class="invert">
                                                <div class="rem">
                                                    <a href="UpgradeUser?id=${userr.userId}">
                                                        Make Admin
                                                        <div class="close1">
                                                        </div>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table> 

                            </div>

                        </div>                       
                    </div>                    
                </div>
            </div>
        </div>
    </div>



    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>

    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    <!-- jQuery sticky menu -->
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.sticky.js"></script>

    <!-- jQuery easing -->
    <script src="js/jquery.easing.1.3.min.js"></script>

    <!-- Main Script -->
    <script src="js/main.js"></script>
</body>
</html>
