package imageservlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.eelectronics_iti.Products;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bombo
 */
@WebServlet(urlPatterns = {"/GetImage"})
public class GetImage extends HttpServlet {

    private ServletContext servletContext;
    private String noProductImg = "\\img\\NoProduct.png";

    private String noProfileImg = "\\img\\NoProfilePic.png";

   

    @Override
    public void init(ServletConfig config) throws ServletException {
        servletContext = config.getServletContext();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          ArrayList<Products> productsList = null;
        response.setContentType("image/jpg");
        if (request.getParameter("id") != null) {
            Integer productID = Integer.parseInt(request.getParameter("id"));
            if (servletContext.getAttribute("allProducts") != null) {
                productsList = (ArrayList<Products>) servletContext.getAttribute("allProducts");
            }
                for (Products p : productsList) {
                    if (p.getProductId() == productID) {

                        if (p.getProductImage() != null) {
                            File f = new File(request.getServletContext().getRealPath("")+"\\img\\"+ p.getProductImage());
                            BufferedImage bi = ImageIO.read(f);
                            OutputStream out = response.getOutputStream();
                            ImageIO.write(bi, "jpg", out);
                            out.close();
                        } else {
                            File f = new File(request.getServletContext().getRealPath("") + noProductImg);
                            BufferedImage bi = ImageIO.read(f);
                            OutputStream out = response.getOutputStream();
                            ImageIO.write(bi, "jpg", out);
                            out.close();
                        }
                    } else {
//                        File f = new File(request.getServletContext().getRealPath("") + noProductImg);
//                        BufferedImage bi = ImageIO.read(f);
//                        try (OutputStream out = response.getOutputStream()) {
//                            ImageIO.write(bi, "jpg", out);
//                        }
                        
                        System.out.println("no product found ");
                    }

                }
            
        } 
    }

}
