<%-- 
    Document   : cart
    Created on : Feb 24, 2018, 5:15:39 AM
    Author     : eslam java
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">


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

            var req2 = null;
            var theproductId = null;
            var req1 = null;
            var theRowProductId = null;





            function checkQuantity(productId) {

                theproductId = productId;

                if (window.XMLHttpRequest) {

                    req2 = new XMLHttpRequest();
                } else if (window.ActiveXObject) {

                    req2 = new ActiveXObject(Microsoft.XMLHTTP);
                }

                req2.onreadystatechange = handleReq2;
                req2.open("GET", "CheckProductQuantity?addedProductQuantity=" + document.getElementById("qty" + productId).value + "&addedProductId=" + productId, true);
                if (document.getElementById("qty" + productId).value > 0) {
                    req2.send(null);
                }

            }
            function handleReq2() {
                if (req2.readyState === 4) {
                    if (req2.status === 200) {
                        document.getElementById("result" + theproductId).innerHTML = "$" + req2.responseText;

                    } else {
                        document.getElementById("result" + theproductId).innerHTML = "$" + req2.responseText;

                    }
                }
            }

            function deleteProductRow(rowProductId) {

                theRowProductId = rowProductId;

                if (window.XMLHttpRequest) {

                    req1 = new XMLHttpRequest();
                } else if (window.ActiveXObject) {

                    req1 = new ActiveXObject(Microsoft.XMLHTTP);
                }

                req1.onreadystatechange = handleReq1;
                req1.open("GET", "DeleteProductFromCart?productId=" + rowProductId, true);
                req1.send(null);
            }
            function handleReq1() {
                if (req1.readyState === 4 && req1.status === 200) {
                    var productsTableBody = document.getElementById("productsTableBody");
                    var row = document.getElementById("productRow" + theRowProductId);

                    productsTableBody.removeChild(row);





                }
            }






        </script>
    </head>
    <body>

        <jsp:include page="Header.jsp"></jsp:include> 
        
        <c:if test="${param.userBalanceStatus!=null}">
            <script>
                alert("Your balance is less than your total order price \n Please charge first ");
            </script>
        </c:if>
             <c:if test="${param.loginStatus!=null}">
            <script>
                alert("Please! \n You Should login first ");
            </script>
        </c:if>

            <div class="product-big-title-area">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="product-bit-title text-center">
                                <h2>Shopping Cart</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- End Page title area -->


            <div class="single-product-area">
                <div class="zigzag-bottom"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-2">


                            <div class="single-sidebar">

                            </div>

                            <div class="single-sidebar">

                            </div>
                        </div>

                        <div class="col-md-8">
                            <div class="product-content-right">
                                <div class="woocommerce">
                                    <form method="post" action="ProceedWithCheckOut">
                                        <table cellspacing="0" class="shop_table cart">
                                            <thead>
                                                <tr>
                                                    <th class="product-remove">&nbsp;</th>
                                                    <th class="product-thumbnail">&nbsp;</th>
                                                    <th class="product-name">Product</th>
                                                    <th class="product-price">Price</th>
                                                    <th class="product-quantity">Quantity</th>
                                                    <th class="product-subtotal">Total</th>
                                                </tr>
                                            </thead>
                                            <tbody id="productsTableBody">

                                            <c:forEach items="${sessionScope.userCart}" var="product">


                                                <tr class="cart_item" id="productRow<c:out value="${product.productId}"/>" >
                                                    <td class="product-remove">
                                                        <a title="Remove this item" class="remove" onclick="deleteProductRow(<c:out value="${product.productId}"/>)"><img  width="50px" height="50px" src="img/deleteicon.jpg" /></a> 
                                                    </td>

                                                    <td class="product-thumbnail">
                                                        <a href="single-product.jsp?productId=<c:out value="${product.productId}"/>"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="img/<c:out value="${product.productImage}"/>"></a>
                                                    </td>

                                                    <td class="product-name">
                                                        <a href="single-product.jsp?productId=<c:out value="${product.productId}"/>"><c:out value="${product.productName}"/></a> 
                                                    </td>

                                                    <td class="product-price">
                                                        <span class="amount">$<c:out value="${product.productPrice}"/></span> 
                                                    </td>

                                                    <c:if test="${sessionScope.cartMap!=null}">

                                                        <td class="product-quantity">
                                                            <div class="quantity buttons_added">

                                                                <input type="button" class="minus" value="-">
                                                                <input type="number" size="4" class="input-text qty text" title="Qty" value="<c:out value="${sessionScope.cartMap.get(product.productId)}"/>" min="0" step="1" onblur="checkQuantity(<c:out value="${product.productId}"/>)" id="qty<c:out value="${product.productId}"/>">
                                                                <input type="button" class="plus" value="+">
                                                            </div>
                                                        </td>

                                                        <td class="product-subtotal">
                                                            <span class="amount" id="result<c:out value="${product.productId}"/>"><c:out value="$${sessionScope.cartMap.get(product.productId) * product.productPrice }"/></span> 
                                                        </td>

                                                    </c:if>

                                                    <c:if test="${sessionScope.cartMap==null}">

                                                        <td class="product-quantity">
                                                            <div class="quantity buttons_added">
                                                                <input type="button" class="minus" value="-">
                                                                <input type="number" size="4" class="input-text qty text" title="Qty" value="0" min="0" step="1" onblur="checkQuantity(<c:out value="${product.productId}"/>)" id="qty<c:out value="${product.productId}"/>">
                                                                <input type="button" class="plus" value="+">
                                                            </div>
                                                        </td>

                                                        <td class="product-subtotal">
                                                            <span class="amount" id="result<c:out value="${product.productId}"/>">$</span> 
                                                        </td>

                                                    </c:if>


                                                </tr>

                                            </c:forEach>


                                            <tr>

                                                <td class="actions" colspan="6">


                                                    <input  type="submit" value="Proceed to Checkout" name="proceed" class="checkout-button button alt wc-forward">

                                                </td>
                                            </tr>

                                        </tbody>

                                    </table>
                                </form>


                                <div class="cart-collaterals">


                                    <div class="cross-sells">

                                    </div>


                                    <div class="cart_totals ">

                                    </div>





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
