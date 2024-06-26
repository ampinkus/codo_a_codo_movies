package ar.com.codo24100.practica.service;

import java.util.ArrayList;
import ar.com.codo24100.practica.dto.UsuariosRegistro; // Corregir el import aquí
import ar.com.codo24100.practica.dao.UsuariosRegistroDAO;
import ar.com.codo24100.practica.dao.UsuariosDaoMysqlImpl;

public class UsuariosService {

    private UsuariosRegistroDAO dao;

    // Instanciar la interfaz para poder usar los métodos.
    public UsuariosService() {
        this.dao = new UsuariosDaoMysqlImpl();
    }

    public void crearUsuario(UsuariosRegistro registro) { // Corregir el tipo de parámetro aquí
        this.dao.create(registro);
    }

    public ArrayList<UsuariosRegistro> listarUsuarios() {
        return this.dao.findAll();
    }
    
    public UsuariosRegistro obtenerUsuarioPorId(Long id) { // Corregir el tipo de retorno aquí
        return this.dao.findById(id);
    }


    public boolean eliminarUsuarioPorId(Long id) {
        UsuariosRegistro registro = this.dao.findById(id); // Corregir el tipo de variable aquí
        if (registro != null) {
            this.dao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean actualizarUsuario(UsuariosRegistro registro) { // Corregir el tipo de parámetro aquí
        UsuariosRegistro registroExistente = this.dao.findById(registro.getId()); // Corregir el tipo de variable aquí
        if (registroExistente != null) {
            this.dao.updateById(registro);
            return true;
        } else {
            return false;
        }
    }
}
