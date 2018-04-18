
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

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <SCRIPT SRC= "js/addPrduct.js"></SCRIPT>
    </head>
    <body>

        <jsp:include page="Header.jsp"/>

        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="product-content-right">
                            <div class="woocommerce">


                                <form  <c:choose><c:when test="${requestScope.showproduct != null}">action="AddProduct?update=true&&productId=${requestScope.showproduct.productId}"</c:when>    
                                                                                                        <c:otherwise>action="AddProduct"</c:otherwise> </c:choose> class="checkout" method="post" name="addProductForm" onsubmit="return validate(event)" enctype="multipart/form-data">

                                                                                                            <div id="customer_details" class="col2-set">
                                                                                                                <div class="col-1">
                                                                                                                    <div class="woocommerce-billing-fields">

                                                                                                                <c:choose>
                                                                                                                    <c:when test="${requestScope.showproduct != null}">
                                                                                                                        <h3>${requestScope.showproduct.productName}</h3>
                                                                                                                    </c:when>    
                                                                                                                    <c:otherwise>
                                                                                                                        <h3>Add product</h3>
                                                                                                                    </c:otherwise>
                                                                                                                </c:choose>
                                                                                                                <p id="billing_first_name_field" class="form-row form-row-first validate-required">
                                                                                                                    <label class="" for="billing_first_name">Product Name <abbr title="required" class="required">*</abbr>
                                                                                                                    </label>
                                                                                                                    <input type="text" <c:choose><c:when test="${requestScope.showproduct != null}">value="${requestScope.showproduct.productName}"</c:when>    
                                                                                                                               <c:otherwise>value=""</c:otherwise> </c:choose> 
                                                                                                                                   placeholder="enter your product name" id="tProductName"  name="productName" class="input-text ">
                                                                                                                               <span id="productNameAlert"> </span><br> 
                                                                                                                           </p>

                                                                                                                           <div class="clear"></div>


                                                                                                                           <p id="billing_address_1_field" class="form-row form-row-wide address-field validate-required">
                                                                                                                               <label class="" for="billing_address_1">Description <abbr title="required" class="required">*</abbr>
                                                                                                                               </label>
                                                                                                                               <input type="text" <c:choose><c:when test="${requestScope.showproduct != null}">value="${requestScope.showproduct.productDescription}"</c:when>    
                                                                                                                               <c:otherwise>value=""</c:otherwise> </c:choose>  name="description" placeholder="Product description" id="tProductDescription" class="input-text ">
                                                                                                                               <span id="productDescriptionAlert"> </span>
                                                                                                                           </p>

                                                                                                                           <p id="billing_city_field" class="form-row form-row-wide address-field validate-required" data-o_class="form-row form-row-wide address-field validate-required">
                                                                                                                               <label class="" for="billing_city"> Price  <abbr title="required" class="required">*</abbr>
                                                                                                                               </label>
                                                                                                                               <input type="text" <c:choose><c:when test="${requestScope.showproduct != null}">value="${requestScope.showproduct.productPrice}"</c:when>    
                                                                                                                               <c:otherwise>value=""</c:otherwise> </c:choose> name="price" placeholder="price" id="tPrice" class="input-text ">
                                                                                                                               <span id="priceAlert"> </span><br>
                                                                                                                           </p>

                                                                                                                           <div class="clear"></div>

                                                                                                                           <p id="billing_email_field" class="form-row form-row-first validate-required validate-email">
                                                                                                                               <label>Quantity in stock<sup>*</sulabelp></label> <input type="number" name="quantity" placeholder="quantity" <c:choose><c:when test="${requestScope.showproduct != null}">value="${requestScope.showproduct.productQuantity}"</c:when>    
                                                                                                                                                                                 <c:otherwise>value=""</c:otherwise> </c:choose>id="tQuantity" class="required" min="1">*</abbr>
                                                                                                                                                                                 </label>
                                                                                                                                                                                 <span id="quantityAlert"> </span><br>
                                                                                                                                                                             </p>
                                                                                                                                                                             <p  class="form-row form-row-last validate-required validate-phone">
                                                                                                                                                                                 <label class="" for="billing_phone">Category <abbr title="required" class="required">*</abbr>
                                                                                                                                                                                 </label>
                                                                                                                                                                                 <select id="tCategory" name="category" >
                                                                                                                                                                                     <option value="mobiles">Mobiles</option>
                                                                                                                                                                                     <option value="laptops">Laptops</option>
                                                                                                                                                                                     <option value="gaming">Gaming</option>
                                                                                                                                                                                     <option value="headphones">Headphones</option>
                                                                                                                                                                                 </select>                                                 
                                                                                                                                                                                 <span id="categoryAlert"> </span><br>
                                                                                                                                                                             </p>


                                                                                                                                                                             <div class="clear"></div>

                                                                                                                                                                             <input <c:choose><c:when test="${requestScope.showproduct == null}">value=""</c:when>    
                                                                                                                                                                                        <c:otherwise>value="<c:out value="${requestScope.showproduct.productImage}"/>"</c:otherwise> </c:choose> type="file" id="fileF" name="file" accept="image/*" >

                                                                                                                                                                                        <p  class="form-row form-row-last validate-required validate-phone">
                                                                                                                                                                                            <input type="submit" <c:choose><c:when test="${requestScope.showproduct != null}">value="Edit product"</c:when>    
                                                                                                                                                                                               <c:otherwise>value="add product"</c:otherwise> </c:choose> class="input-text ">
                                                                                                                </p>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                </form>
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
