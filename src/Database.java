import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Database {
    private static final String URL = "jdbc:sqlite:expenses.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(URL);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return conn;
    }

    public static void createNewDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS expenses (\n"
           + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
           + " amount REAL NOT NULL,\n"
           + " category TEXT NOT NULL,\n"
           + " date TEXT NOT NULL\n"
           + ");";

        try (Connection conn = Database.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.execute(); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
