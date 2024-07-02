package ar.com.codo24100.practica.controllers;

import java.io.IOException;
import ar.com.codo24100.practica.service.UsuariosService; // Corregir el import aquí
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/eliminarUsuario")
public class EliminarUsuarioController extends HttpServlet {

    private final UsuariosService usuariosService = new UsuariosService(); // Crear instancia del servicio

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener parámetro 'id' de la solicitud
        String idParam = req.getParameter("id");
        Long id = Long.parseLong(idParam);

        // Usar el servicio para eliminar el usuario por ID y verificar si se eliminó
        boolean eliminado = usuariosService.eliminarUsuarioPorId(id);

        // Responder al cliente con un mensaje de éxito o error
        if (eliminado) {
            resp.getWriter().println("Usuario eliminado exitosamente con ID: " + id);
        } else {
            resp.getWriter().println("No existe un usuario con ese ID: " + id);
        }
    }
}
