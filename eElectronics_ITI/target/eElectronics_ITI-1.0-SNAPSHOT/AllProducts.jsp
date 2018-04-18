
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
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
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

                                <h3>Product List</h3><br><br>

                                <table class="timetable_sub">
                                    <tr>
                                        
                                        <th> Name </th>
                                        <th> Price </th>  
                                        <th> Category </th>
                                        <th> Quantity </th>
                                        <th> Description </th>
                                        <th > Image </th>
                                    </tr>
                                    <c:forEach items="${applicationScope.AllProducts}" var="product" >                   
                                        <tr>
                                            
                                         
                                            <td><c:out value="${product.productName}"/></td>
                                        <td>${product.productPrice}</td>
                                        <td>${product.productCategory}</td>
                                        <td>${product.productQuantity}</td>
                                        <td>${product.productDescription}</td>
                                        <td>
                                            <img style="width:75px;height:75px; max-height:75px;max-width:75px;" src="img/${product.productImage}" alt=" " class="img-responsive" >
                                        </td>
                                         <td class="invert">
                                            <div class="rem">
                                                <a href="GetProductById?id=${product.productId}">
                                                    Edit
                                                    <div class="close1">
                                                    </div>
                                                </a>
                                            </div>
                                        </td>
                                        <td class="invert">
                                            <div class="rem">
                                                <a href="DeleteProduct?id=${product.productId}">
                                                    Delete
                                                    <div class="close1">
                                                    </div>
                                                </a>
                                            </div>
                                        </td>
                                        </tr>
                                    </c:forEach>
                                </table> 
                                                <a href="AddProducts.jsp">
                                                    Add Product
                                                    <div class="close1">
                                                    </div>
                                                </a>
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
