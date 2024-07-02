package ar.com.codo24100.practica.controllers;

import java.io.IOException;
import ar.com.codo24100.practica.dto.UsuariosRegistro;
import ar.com.codo24100.practica.service.UsuariosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/obtenerUsuario")
public class ObtenerUsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener parámetro 'id' de la solicitud
        String idParam = req.getParameter("id");
        Long id = Long.parseLong(idParam);

        // Crear una instancia del servicio de UsuariosService
        UsuariosService usuariosService = new UsuariosService();

        // Obtener el registro por ID
        UsuariosRegistro registro = usuariosService.obtenerUsuarioPorId(id);

        // Responder al cliente con el registro encontrado o un mensaje de error si no existe
        if (registro != null) {
            resp.getWriter().println(registro);
        } else {
            resp.getWriter().println("No existe un usuario con ese ID: " + id);
        }
    }
}
