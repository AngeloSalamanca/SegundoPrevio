package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConexionMySQL {
	private Connection con = null;
	private static ConexionMySQL db;
	private PreparedStatement preparedStatement;
	
	private static final String url= "jdbc:mysql://localhost:3306/";
	private static final String dbName = "bbva";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "";
    
    public ConexionMySQL() {
		try {
			Class.forName(driver).newInstance();
			con = (Connection)DriverManager.getConnection(url+dbName,userName,password);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void cerrarConexion() {
    	try {
    		con.close();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static ConexionMySQL getConexion() {
    	if (db == null) {
    		db = new ConexionMySQL();
    	}
    	return db;
    }
    
    public ResultSet query() throws SQLException {
    	ResultSet res = preparedStatement.executeQuery();
    	return res;
    }
    
    public int execute() throws SQLException {
    	int result = preparedStatement.executeUpdate();
    	return result;
    }
    
    public Connection getCon() {
    	return this.con;
    }
    
    public PreparedStatement setPreparedStatement (String sql) throws SQLException {
    	//db = getConexion();
    	this.preparedStatement = con.prepareStatement(sql);
    	return this.preparedStatement;
    }
}