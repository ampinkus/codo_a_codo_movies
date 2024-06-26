package ar.com.codo24100.practica.controllers;

import java.io.IOException;
import java.util.ArrayList;

import ar.com.codo24100.practica.dto.UsuariosRegistro;
import ar.com.codo24100.practica.service.UsuariosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listarUsuarios")
public class ListarUsuariosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Crear una instancia del servicio de UsuariosRegistro
        UsuariosService usuariosService = new UsuariosService();

        // Obtener todos los registros de usuarios
        ArrayList<UsuariosRegistro> registros = usuariosService.listarUsuarios();

        // Responder al cliente con los registros en formato JSON (ejemplo)
        resp.setContentType("application/json");
        resp.getWriter().println(registros);
    }
}
