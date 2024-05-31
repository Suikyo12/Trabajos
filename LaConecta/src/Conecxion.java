import java.sql.*;

public class Conecxion {
    public void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de MySQL: " + ex);
        }
        Connection conexion = null;
        System.out.println("Conectando....");
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/caso2", "root", "zafiroelpillo");
            System.out.println("Conexion Exitosa");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public static void main(String[] args) {
        Conecxion conecxion= new Conecxion();
        conecxion.connectDatabase();
            System.out.println();
    }
}
