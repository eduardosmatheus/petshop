package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ConnectionApi {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/petshop?useTimezone=true&amp;serverTimezone=UTC";
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet result;

    public ConnectionApi() {
        this.conn = openDatabase();
    }
    
    public ConnectionApi(String sql, Object... params) {
        this();
        try {
            stmt = conn.prepareStatement(sql);
            List<Object> p = Arrays.asList(params);
            for (Object param : p) {
                stmt.setObject(p.indexOf(param), param);
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
            return stmt.executeUpdate();
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
        try {
            result.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao fechar esta conexão. Causa: "+ex);
        }
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
