package ar.com.codo24100.practica.dao;

import java.util.ArrayList;
import ar.com.codo24100.practica.dto.UsuariosRegistro;

public interface UsuariosRegistroDAO {

    public void create(UsuariosRegistro registro); // crear un nuevo registro

    public ArrayList<UsuariosRegistro> findAll(); // mostrar todos los registros

    public UsuariosRegistro findById(Long id); // obtener un registro por su ID

    public void deleteById(Long id); // borrar un registro por su ID

    public void updateById(UsuariosRegistro registro); // actualizar un registro
}
