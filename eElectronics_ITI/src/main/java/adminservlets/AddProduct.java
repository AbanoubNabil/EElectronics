/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminservlets;

import DAOS.ProductsDAO;
import com.mycompany.eelectronics_iti.Products;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author bombo
 */
@WebServlet(urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {

    private ServletContext servletContext;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        servletContext = request.getServletContext();
        ArrayList<Products> allProducts = (ArrayList<Products>) servletContext.getAttribute("AllProducts");

        try {
            System.out.println("before save \n");
            Products newProduct = SaveImage(request, response);
            if (request.getParameter("update") != null) {
                int id = Integer.parseInt(request.getParameter("productId"));
                newProduct.setProductId(id);
                updateProduct(newProduct);
                Products product = null;

                for (Products p : allProducts) {

                    if (p.getProductId() == id) {

                        product = p;

                    }

                }
                if (product != null) {

                    allProducts.remove(product);
                    allProducts.add(newProduct);
                }

            } else {
                saveProduct(newProduct);
                allProducts.add(newProduct);
            }

            System.out.println("after save \n");
        } catch (SQLException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saveProduct(Products probj) throws SQLException {
        new ProductsDAO().createProduct(probj);
    }

    public void updateProduct(Products probj) throws SQLException {
        new ProductsDAO().updateProduct(probj);
    }

    public Products SaveImage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String prodName = new String();
        String prodImage = new String();
        String prodPrice = new String();
        String prodDesc = new String();
        String prodCateg = new String();
        String prodquantity = new String();

        Products probj = new Products();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items = null;
        File file = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            System.out.println("errrrrrrrrrrrrrrrrrrrrrrror");
            ex.printStackTrace();
        }
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            if (item.isFormField()) {
                String name = item.getFieldName();
                System.out.println("name : " + name);
                String value = item.getString();
                System.out.println("v : " + value);
                switch (name) {
                    case "productName":
                        prodName = value;
                        break;
                    case "price":
                        prodPrice = value;
                        break;
                    case "description":
                        prodDesc = value;
                        break;
                    case "category":
                        prodCateg = value;
                        break;
                    case "quantity":
                        prodquantity = value;
                        break;
                }
            } else {
                if (!item.isFormField()) {
                    try {
                        prodImage = item.getName();
                        System.out.println("" + prodImage);
                        file = new File(request.getServletContext().getRealPath("") + "\\img\\" + item.getName());
                        System.out.println("image fgfgfgfgfgfg/////////////////////=====================" + getClass().getResource("").toString().substring(6));
                        item.write(file);
                        response.sendRedirect("AddProducts.jsp");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

        }
        probj.setProductName(prodName);
        probj.setProductPrice(Double.parseDouble(prodPrice));
        probj.setProductQuantity((int) Double.parseDouble(prodquantity));
        probj.setProductDescription(prodDesc);
        probj.setProductCategory(prodCateg);
        probj.setProductImage(prodImage);
        return probj;
    }

}
