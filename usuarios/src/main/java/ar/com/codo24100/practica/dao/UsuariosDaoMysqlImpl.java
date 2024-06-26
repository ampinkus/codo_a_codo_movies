package ar.com.codo24100.practica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import ar.com.codo24100.practica.dto.UsuariosRegistro;
// import ar.com.codo24100.practica.dao.AdministradorDeConexiones;

public class UsuariosDaoMysqlImpl implements UsuariosRegistroDAO {

    @Override
    public void create(UsuariosRegistro registro) {
        String sql = "INSERT INTO movies_usuarios_registro (nombre, apellido, email, contrasena, fecha, pais) VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, registro.getNombre());
            pst.setString(2, registro.getApellido());
            pst.setString(3, registro.getEmail());
            pst.setString(4, registro.getContrasena());
            pst.setDate(5, java.sql.Date.valueOf(registro.getFecha()));
            pst.setString(6, registro.getPais());

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al crear registro: " + e.getMessage());
        } finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }

    @Override
    public ArrayList<UsuariosRegistro> findAll() {
        String sql = "SELECT * FROM movies_usuarios_registro";

        Connection connection = AdministradorDeConexiones.conectar();
        ArrayList<UsuariosRegistro> registros = new ArrayList<>();

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                Long id = res.getLong("id");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String email = res.getString("email");
                String contrasena = res.getString("contrasena");
                java.sql.Date fechaSql = res.getDate("fecha");
                LocalDate fecha = fechaSql.toLocalDate();
                String pais = res.getString("pais");

                UsuariosRegistro registro = new UsuariosRegistro(nombre, apellido, email, contrasena, fecha, pais);
                registro.setId(id);
                registros.add(registro);
            }
        } catch (Exception e) {
            System.err.println("Error al recuperar registros: " + e.getMessage());
        } finally {
            AdministradorDeConexiones.desconectar(connection);
        }
        return registros;
    }

    @Override
    public UsuariosRegistro findById(Long id) {
        String sql = "SELECT * FROM movies_usuarios_registro WHERE id = ?";
        Connection connection = AdministradorDeConexiones.conectar();
        UsuariosRegistro registro = null;

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String email = res.getString("email");
                String contrasena = res.getString("contrasena");
                java.sql.Date fechaSql = res.getDate("fecha");
                LocalDate fecha = fechaSql.toLocalDate();
                String pais = res.getString("pais");

                registro = new UsuariosRegistro(nombre, apellido, email, contrasena, fecha, pais);
                registro.setId(id);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar registro por ID: " + e.getMessage());
        } finally {
            AdministradorDeConexiones.desconectar(connection);
        }
        return registro;
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM movies_usuarios_registro WHERE id = ?";
        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar registro: " + e.getMessage());
        } finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }

    @Override
    public void updateById(UsuariosRegistro registro) {
        String sql = "UPDATE movies_usuarios_registro SET nombre = ?, apellido = ?, email = ?, contrasena = ?, fecha = ?, pais = ? WHERE id = ?";
        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, registro.getNombre());
            pst.setString(2, registro.getApellido());
            pst.setString(3, registro.getEmail());
            pst.setString(4, registro.getContrasena());
            pst.setDate(5, java.sql.Date.valueOf(registro.getFecha()));
            pst.setString(6, registro.getPais());
            pst.setLong(7, registro.getId());

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al actualizar registro: " + e.getMessage());
        } finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }
}
