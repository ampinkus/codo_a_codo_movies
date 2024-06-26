package ar.com.codo24100.practica.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
    // Atributo

    // Obtener una conexión, hago el método estático porque no quiero crear una instancia para usarlo
    public static Connection conectar() {
        // Lógica para obtener la conexión
        String url = "jdbc:mysql://localhost:3306/cac-24100?serverTimezone=America/Argentina/Buenos_Aires&useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "Hammil01";
        // Como usamos JDBC tenemos que decirle que driver vamos a usar
        String driver = "com.mysql.cj.jdbc.Driver";
        // Tengo que crear una instancia de Connection para poder hacer la consulta
        Connection connection = null;

        // Como puede dar un error entonces try/catch
        try {
            // Si va todo bien
            // forName es un método estático: que no necesito una instancia para usar dicho
            // método
            Class.forName(driver);
            // Me conecto
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // Si falla
            System.err.println("No se ha podido conectar a la db:" + e.getMessage());
        }
        return connection;
    }

    public static void desconectar(Connection connection) {
        // Controlo el posible error del método close
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
