package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class ConnectionApi {
    
    private static final String DB_URL = "jdbc:mysql://localhost/petshop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet result;

    public ConnectionApi() {
        this.conn = openDatabase();
    }
    
    public ConnectionApi(String sql, Object... params) {
        this();
        try {
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            List<Object> p = Arrays.asList(params);
            for (Object param : p) {
                stmt.setObject(p.indexOf(param) + 1, param);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void executeQuery() {
        try {
            result = stmt.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public int executeUpdate() {
        try {  
            int result = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next())
                return rs.getInt(1);
            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public int executeUpdate(String sql, Object... params) {
        try { 
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            List<Object> p = Arrays.asList(params);
            for (Object param : p) {
                stmt.setObject(p.indexOf(param) + 1, param);
            }
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next())
                return rs.getInt(1);
            return 0;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean next() {
        try {
            return result.next();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public <T> T get(String column, Class<T> clazz) {
        try {
            return result.getObject(column, clazz);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar retornar a coluna " + column +".\n Causa: "+ ex);
        }
    }
    
    public void close() { 
    }
    
    private static Connection openDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
