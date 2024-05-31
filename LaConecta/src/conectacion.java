import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class conectacion {

      public static Connection ConectorBD(String bd) {

        Connection conexion;
        String host= "jdbc:mysql://localhost/";
        String user = "root";
        String passwd= "zafiroelpillo";
        PreparedStatement ps= null;
        Resultset rs= null;

        System.out.println("Conectando...");

        try {
            conexion= DriverManager.getConnection(host+bd, user,passwd);
            System.out.println("Conexion exitosa");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void Desconexion(Connection cb) {
        try {
            cb.close();
            System.out.println("Desconecntando.....");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String []args) {
        Connection bd= ConectorBD("caso2");
    }
}
