<%-- 
    Document   : single-product
    Created on : Feb 24, 2018, 5:16:44 AM
    Author     : eslam java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
           <script>

            var req = null;
            var req2 = null;
            var addToCartButtonElement = null;
            var addToCartButtonElementParent = null;
          
            function addToCartAJAX( productId){

                if (window.XMLHttpRequest) {

                    req = new XMLHttpRequest();
                } else if (window.ActiveXObject) {

                    req = new ActiveXObject(Microsoft.XMLHTTP);
                }

                req.onreadystatechange = handleReq;
                req.open("GET", "AddToCard?productId=" + productId , true);
                req.send(null);
            }
            function handleReq() {
                if (req.readyState == 4&&req.status == 200) {
                    if (req.responseText==="addedToCart") {
                        
                        alert("You have been already added  to your cart")

                    }
                }
            }
            
             function addToCartAJAX2(productId2) {

                addToCartButtonElement = document.getElementById("addToCartButton" + productId2);
                addToCartButtonElementParent = document.getElementById("addToCartButtonParent" + productId2);

                if (window.XMLHttpRequest) {

                    req2 = new XMLHttpRequest();

                } else if (window.ActiveXObject) {

                    req2 = new ActiveXObject(Microsoft.XMLHTTP);

                }

                req2.onreadystatechange = handleReq2;
                req2.open("GET", "AddToCard?productId=" + productId2, true);
                req2.send(null);

            }
            function handleReq2() {


                if (req2.readyState === 4 && req2.status === 200) {

                    addToCartButtonElementParent.removeChild(addToCartButtonElement);

                    if (req2.responseText === "addedToCart") {

                        alert("You have been already added this product  to your cart");

                    }
                }

            }

        </script>
    </head>
    <body>

        <jsp:include page="Header.jsp"></jsp:include> 

            <div class="product-big-title-area">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="product-bit-title text-center">
                                <h2>Shop</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="single-product-area">
                <div class="zigzag-bottom"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                           

                            <div class="single-sidebar">

                            </div>

                            <div class="single-sidebar">

                            </div>
                        </div>

                        <div class="col-md-8">



                            <div class="product-content-right">

                            <c:if test="${param.productId!=null}">

                                <c:forEach items="${applicationScope.AllProducts}" var="product">

                                    <c:if test="${product.productId==param.productId }">


                                        <div class="product-breadcroumb">
                                            <a href="">Home</a>
                                            <a href="">${product.productCategory}</a>
                                            <a href="">${product.productName}</a>
                                        </div>

                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="product-images">
                                                    <div class="product-main-img">
                                                        <img src="img/${product.productImage}" alt="">
                                                    </div>

                                                    <div class="product-gallery">
                                                        <img src="img/product-thumb-1.jpg" alt="">
                                                        <img src="img/product-thumb-2.jpg" alt="">
                                                        <img src="img/product-thumb-3.jpg" alt="">
                                                        <img src="img/product-thumb-4.jpg" alt="">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-6">
                                                <div class="product-inner">
                                                    <h2 class="product-name">${product.productName}</h2>
                                                    <div class="product-inner-price">
                                                        <ins>$${product.productPrice}</ins> 
                                                    </div>    
                                                    <form action="" class="cart">
                                                       
                                                        <button class="add_to_cart_button" type="button" onclick="addToCartAJAX( <c:out value="${product.productId}"/>)" >Add to cart</button>
                                                    </form>   



                                                    <div role="tabpanel">

                                                        <div class="tab-content">
                                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                                <h2>Product Description</h2>  
                                                                <p>${product.productDescription}</p>
                                                            </div>

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>



                                    </c:if>

                                </c:forEach>

                            </c:if>

                            <div class="related-products-wrapper">
                                <h2 class="related-products-title">Related Products</h2>
                                <div class="related-products-carousel">
                                    <c:if test="${applicationScope.AllProducts!=null}">

                                        <c:forEach items="${applicationScope.AllProducts}" var="product">


                                            <div class="single-product">
                                                <div class="product-f-image">
                                                    <img src="img/<c:out value="${product.productImage}"/>" alt="">
                                                   <div class="product-hover" id="addToCartButtonParent<c:out value="${product.productId}"/>">
                                            
                                            <a  class="add-to-cart-link"  id="addToCartButton<c:out value="${product.productId}"/>" onclick="addToCartAJAX2( <c:out value="${product.productId}"/>)"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                                            <a href="single-product.jsp?productId=<c:out value="${product.productId}"/>" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                        </div>
                                                </div>

                                                <h2><a href="single-product.jsp?productId=<c:out value="${product.productId}"/>"><c:out value="${product.productName}"/></a></h2>

                                                <div class="product-carousel-price">
                                                    <ins><c:out value="${product.productPrice}"/></ins> 
                                                </div> 
                                            </div>


                                        </c:forEach>
                                    </c:if>

                                </div>
                            </div>
                        </div>                    
                    </div>
                </div>
            </div>
        </div>


        <jsp:include page="footer.jsp"/>

    </body>
</html>
