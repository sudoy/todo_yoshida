package todo.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {

	public static Connection getConnection()throws SQLException, NamingException {
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("todolist_yoshida");
		return ds.getConnection();
	}

	public static void close(Connection con,ResultSet rs,PreparedStatement ps)
			throws SQLException {
		if(rs != null){rs.close();}
		if(ps != null){ps.close();}
		if(con != null){con.close();}
	}

	public static void close(Connection con,PreparedStatement ps)
			throws SQLException {
		if(ps != null){ps.close();}
		if(con != null){con.close();}
	}

}