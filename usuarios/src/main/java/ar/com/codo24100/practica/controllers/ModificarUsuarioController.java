package ar.com.codo24100.practica.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ar.com.codo24100.practica.dto.UsuariosRegistro;
import ar.com.codo24100.practica.service.UsuariosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/actualizarUsuario")
public class ModificarUsuarioController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener parámetros del formulario HTML
        Long id = Long.parseLong(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String contrasena = req.getParameter("contrasena");
        String fechaStr = req.getParameter("fecha"); // La fecha viene como cadena
        String pais = req.getParameter("pais");

         // Validar que todos los parámetros estén presentes
         if (nombre == null || apellido == null || email == null || contrasena == null || fechaStr == null || pais == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Error: Todos los campos son obligatorios.");
            return;
        }

        // Definir el formato de fecha que esperas recibir
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

        // Convertir la cadena de fecha al tipo LocalDate
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaStr, formatter);
        } catch (Exception e) {
            resp.getWriter().println("Formato de fecha incorrecto: " + fechaStr);
            return;
        }

        // Crear una instancia de UsuariosRegistro
        UsuariosRegistro registroActualizado = new UsuariosRegistro(nombre, apellido, email, contrasena, fecha, pais);
        registroActualizado.setId(id);

        // Crear una instancia del servicio de UsuariosService
        UsuariosService usuariosService = new UsuariosService();

        // Usar el servicio para actualizar el registro por ID y verificar si se actualizó
        boolean actualizado = usuariosService.actualizarUsuario(registroActualizado);

        // Responder al cliente con un mensaje de éxito o error
        if (actualizado) {
            resp.getWriter().println("Registro actualizado exitosamente: " + registroActualizado);
        } else {
            resp.getWriter().println("No existe un registro con ese ID: " + id);
        }
    }
}
