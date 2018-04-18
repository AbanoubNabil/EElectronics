<%-- 
    Document   : UserProfile
    Created on : Mar 16, 2018, 1:41:19 PM
    Author     : men3m
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!--        <style>
        
                    div.form {
                        position: fixed;
                        bottom: 0;
                        right: 10;
                        
                        
                        
                    }
        
        
                    #txtbox
                    {
                        font-size: 18pt;
                        height: 35px;
                        width: 362px;
                    }
                    #h2
                    {
                        /* margin-right: 42px; */
                        margin-top: 224px;
                        margin-left: 657px;
                        /* text-align: right; */
                        /* float: none; */
                        /* position: relative; */
                        display: inline-block;
                        font-family: "comic sans Ms";
                        color: #68990e;
        
        
        
        
                    }
        
        
        
                    .button_example{
                        border-color:#3A4C7D;border-width: 0px 0px 2px 0px;border-style: solid; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
                        background-color: #a5b8da; background-image: -webkit-gradient(linear, left top, left bottom, from(#a5b8da), to(#7089b3));
                        background-image: -webkit-linear-gradient(top, #a5b8da, #7089b3);
                        background-image: -moz-linear-gradient(top, #a5b8da, #7089b3);
                        background-image: -ms-linear-gradient(top, #a5b8da, #7089b3);
                        background-image: -o-linear-gradient(top, #a5b8da, #7089b3);
                        background-image: linear-gradient(to bottom, #a5b8da, #7089b3);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#a5b8da, endColorstr=#7089b3);
                        width: 367px;
                    }
        
                    .button_example:hover{
                        border-color:#3A4C7D;border-width: 0px 0px 2px 0px;border-style: solid;
                        background-color: #819bcb; background-image: -webkit-gradient(linear, left top, left bottom, from(#819bcb), to(#536f9d));
                        background-image: -webkit-linear-gradient(top, #819bcb, #536f9d);
                        background-image: -moz-linear-gradient(top, #819bcb, #536f9d);
                        background-image: -ms-linear-gradient(top, #819bcb, #536f9d);
                        background-image: -o-linear-gradient(top, #819bcb, #536f9d);
                        background-image: linear-gradient(to bottom, #819bcb, #536f9d);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#819bcb, endColorstr=#536f9d);
        
        
                    }
                    .label{
                        font-family: comic new sans Ms;
                    }
        
        
                </style>-->




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

    </head>
    <body>

        <jsp:include page="Header.jsp"/>
        
        
        
        <div class="single-product-area" >
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="product-content-right">
                            <div class="woocommerce" >
                                <h2 id="h2"  >Welcome ${sessionScope.user.userName}</h2>
                                <form  method="post" action="EditProfile" class="checkout" >   

                                    <div id="customer_details" class="col2-set">
                                        <div class="col-1">
                                            <div class="woocommerce-billing-fields">


                                                <label > User Name:<br></label><br>
                                                <input id="txtbox" type="text" name="userName" value="${sessionScope.user.userName}" required="" autofocus="" />
                                                <br>
                                                <br>

                                                <label  >Email:<br></label><br>
                                                <input id="txtbox" type="text" name="Email" value="${sessionScope.user.userEmail}" required="" autofocus="" />
                                                <br>
                                                <br>

                                                <label > Password:<br></label><br>
                                                <input id="txtbox" type="text" name="password" value="${sessionScope.user.userPassword}" required=""/>  
                                                <br> <br> 

                                                 <label  >Address:<br></label><br>
                                                <input id="txtbox" type="text" name="address" value="${sessionScope.user.userAddress}" required="" autofocus="" />
                                                <br>
                                                <br>
                                                
                                                <label > gender:<br></label><br>
                                                <input id="txtbox" type="text" name="gender" value="${sessionScope.user.userGender}" required=""/>  
                                                <br> <br>

                                                <label > phone:<br></label><br>
                                                <input id="txtbox" type="text" name="phone" value="${sessionScope.user.userPhone}" required=""/>  
                                                <br> <br>

                                                <label > Balance:<br></label><br>
                                                <input id="txtbox" type="text" name="Balance" value="${sessionScope.user.userBalance}" required=""/>  
                                                <br> <br>
                                                <input id="id" type="hidden" name="id" value="${sessionScope.user.userId}" required=""/>  
                                                <br> <br>
                                                <button type="submit" class="button_example">Save new data </button>  
                                                <br><br>
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
