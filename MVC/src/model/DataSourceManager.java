package model;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	private DataSource ds;

	private DataSourceManager() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydbcp");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DataSourceManager getInstance() {
		return instance;
	}

	public DataSource getDataSource() {
		return ds;
	}
}
