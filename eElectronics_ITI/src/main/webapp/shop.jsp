<%-- 
    Document   : shop
    Created on : Feb 24, 2018, 5:15:54 AM
    Author     : eslam java
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
            var addToCartButtonElement = null;
            var addToCartButtonElementParent = null;

            function addToCartAJAX(productId) {

                addToCartButtonElement = document.getElementById("addToCartButton" + productId);
                addToCartButtonElementParent = document.getElementById("addToCartButtonParent" + productId);

                if (window.XMLHttpRequest) {

                    req = new XMLHttpRequest();

                } else if (window.ActiveXObject) {

                    req = new ActiveXObject(Microsoft.XMLHTTP);

                }

                req.onreadystatechange = handleReq;
                req.open("GET", "AddToCard?productId=" + productId, true);
                req.send(null);

            }
            function handleReq() {


                if (req.readyState === 4 && req.status === 200) {

                    addToCartButtonElementParent.removeChild(addToCartButtonElement);

                    if (req.responseText === "addedToCart") {

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

            <div class="row">

                <div class="col-md-4">

                </div>

                <div class="col-md-4" style="margin-top: 100px">
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Search Products</h2>
                        <form action="shop.jsp">
                            <input type="text" placeholder="Search products..." name="searchValue">
                            <input type="submit" value="Search">
                        </form>
                    </div>

                </div>

            </div>


            <div class="single-product-area">
                <div class="zigzag-bottom"></div>
                <div class="container">
                    <div class="row">

                    <c:if test="${param.productCategory!=null}">

                        <c:forEach items="${applicationScope.AllProducts}" var="product">

                            <c:if test="${fn:containsIgnoreCase(product.productCategory, param.productCategory) }">



                                <div class="col-md-3 col-sm-6">
                                    <div class="single-shop-product">
                                        <div class="product-upper">
                                            <img src="img/<c:out value="${product.productImage}"/>" alt="">
                                        </div>
                                        <h2><a href="single-product.jsp?productId=<c:out value="${product.productId}"/>"><c:out value="${product.productName}"/></a></h2>
                                        <div class="product-carousel-price">
                                            <ins>$<c:out value="${product.productPrice}"/></ins> 
                                        </div>  

                                        <div class="product-option-shop" id="addToCartButtonParent<c:out value="${product.productId}"/>">
                                            <a class="add_to_cart_button"  id="addToCartButton<c:out value="${product.productId}"/>" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" onclick="addToCartAJAX(<c:out value="${product.productId}"/>)">Add to cart</a>
                                        </div>                       
                                    </div>
                                </div>


                            </c:if>

                        </c:forEach>





                    </c:if>


                    <c:if test="${param.productCategory==null&& param.searchValue==null}">

                        <c:forEach items="${applicationScope.AllProducts}" var="product">





                            <div class="col-md-3 col-sm-6">
                                <div class="single-shop-product">
                                    <div class="product-upper">
                                        <img src="img/<c:out value="${product.productImage}"/>" alt="">
                                    </div>
                                    <h2><a href="single-product.jsp?productId=<c:out value="${product.productId}"/>"><c:out value="${product.productName}"/></a></h2>
                                    <div class="product-carousel-price">
                                        <ins>$<c:out value="${product.productPrice}"/></ins> 
                                    </div>  

                                    <div class="product-option-shop" id="addToCartButtonParent<c:out value="${product.productId}"/>">
                                        <a class="add_to_cart_button"  id="addToCartButton<c:out value="${product.productId}"/>" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" onclick="addToCartAJAX(<c:out value="${product.productId}"/>)">Add to cart</a>
                                    </div>                       
                                </div>
                            </div>




                        </c:forEach>





                    </c:if>

                    <c:if test="${param.searchValue!=null}">

                        <c:forEach items="${applicationScope.AllProducts}" var="product">




                            <c:if test="${fn:containsIgnoreCase(product.productName, param.searchValue) }">



                                <div class="col-md-3 col-sm-6">
                                    <div class="single-shop-product">
                                        <div class="product-upper">
                                            <img src="img/<c:out value="${product.productImage}"/>" alt="">
                                        </div>
                                        <h2><a href="single-product.jsp?productId=<c:out value="${product.productId}"/>"><c:out value="${product.productName}"/></a></h2>
                                        <div class="product-carousel-price">
                                            <ins>$<c:out value="${product.productPrice}"/></ins> 
                                        </div>  

                                        <div class="product-option-shop" id="addToCartButtonParent<c:out value="${product.productId}"/>">
                                            <a class="add_to_cart_button"  id="addToCartButton<c:out value="${product.productId}"/>" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" onclick="addToCartAJAX(<c:out value="${product.productId}"/>)">Add to cart</a>
                                        </div>                       
                                    </div>
                                </div>


                            </c:if>





                        </c:forEach>





                    </c:if>




                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="product-pagination text-center">
                            <nav>
                                <ul class="pagination">
                                    <li>
                                        <a href="#" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li>
                                        <a href="#" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>                        
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <jsp:include page="footer.jsp"/>
    </body>
</html>
