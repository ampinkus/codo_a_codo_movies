package ar.com.codo24100.practica.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import ar.com.codo24100.practica.dto.UsuariosRegistro;
import ar.com.codo24100.practica.service.UsuariosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/crearUsuario")
public class CrearUsuarioController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener parámetros del formulario HTML
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String contrasena = req.getParameter("contrasena");
        String fechaStr = req.getParameter("fecha");
        String pais = req.getParameter("pais");

        // Validar que todos los parámetros estén presentes
        if (nombre == null || apellido == null || email == null || contrasena == null || fechaStr == null || pais == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Error: Todos los campos son obligatorios.");
            return;
        }

        // Validar y parsear la fecha
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaStr); // Asumiendo que la fecha viene en formato ISO
        } catch (DateTimeParseException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Error: Formato de fecha incorrecto.");
            return;
        }

        // Crear una instancia de UsuariosRegistro
        UsuariosRegistro nuevoRegistro = new UsuariosRegistro(nombre, apellido, email, contrasena, fecha, pais);

        // Crear una instancia del servicio de UsuariosService
        UsuariosService usuariosService = new UsuariosService();

        // Usar el servicio para crear el nuevo registro
        usuariosService.crearUsuario(nuevoRegistro);

        // Responder al cliente con un mensaje de éxito
        resp.getWriter().println("Registro creado exitosamente: " + nuevoRegistro);
    }
}
