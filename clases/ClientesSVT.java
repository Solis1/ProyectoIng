
package clases;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ClientesSVT", urlPatterns = {"/ClientesSVT"})
public class ClientesSVT extends HttpServlet {
    
    private DatosClientes datosC;
    private Clientes cl;
    private Conexion cnn;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            cnn = new Conexion();
            cl = new Clientes();
            
            cl.setNombre(request.getParameter("txtNombre"));
            cl.setApeidoPaterno(request.getParameter("txtApeidoPaterno"));
            cl.setApeidoMaterno(request.getParameter("txtApeidoMaterno"));
            cl.setTelefono(request.getParameter("txtTelefono"));
            cl.setDireccion(request.getParameter("txtDireccion"));
            cl.setCodigoPostal(request.getParameter("txtCodigoPostal"));
            cl.setCiudad(request.getParameter("txtCiudad"));
            cl.setEstado(request.getParameter("txtEstado"));
            
            datosC = new DatosClientes(cnn);
            
            datosC.insertClientes(cl);
               
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientesSVT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesSVT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
