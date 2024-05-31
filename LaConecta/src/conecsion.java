import java.sql.*;
public class conecsion {

        public static  String HOST = "jdbc:mysql://localhost/";
        public static String USER = "root";
        public static String PASSWORD = "zafiroelpillo";

        public static Connection connectToDatabase(String databaseName) {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(HOST + databaseName, USER, PASSWORD);
                System.out.println("Connected to database: " + databaseName);
            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Error connecting to database: " + e.getMessage());
                throw new RuntimeException(e);
            }
            return connection;
        }

        public static void disconnect(Connection connection) {
            try {
                connection.close();
                System.out.println("Disconnected from database");
            } catch (SQLException e) {
                System.err.println("Error disconnecting from database: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }

        public static void executeQuery(Connection connection, String query) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                printResultSet(resultSet);
            } catch (SQLException e) {
                System.err.println("Error executing query: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }

        private static void printResultSet(ResultSet resultSet) throws SQLException {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            Connection connection = connectToDatabase("caso2");
            executeQuery(connection, "SELECT * FROM Ciudad");
            disconnect(connection);
        }
    }

