package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

// classe per gestire la connessione e le query da utilizzare
public class ConnectionUtils {

	private final String URI = "jdbc:mysql://localhost:3306/";
	private Connection conn;

	private String username;
	private String password;
	private String database;

	public ConnectionUtils(String username, String password, String database) throws SQLException {
		setUsername(username);
		setPassword(password);
		setDatabase(database);

		this.conn = DriverManager.getConnection(getURI() + getDatabase(), getUsername(), getPassword());
		if (conn != null)
			System.out.println("*** Connessione al db `" + getDatabase() + "` stabilita. ***");
	}

	public Connection getConnection() {
		return this.conn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getURI() {
		return URI;
	}

	public void close() throws SQLException {
		conn.close();
		System.out.println("*** Connessione al db `" + getDatabase() + "` chiusa. ***");
	}

	public ResultSet getStaticResultSet(String query) throws SQLException {
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query);
		if (rs != null)
			System.out.println("*** Result Set ottenuto. ***\n");

		return rs;
	}

	public ResultSet getPreparedResultSet(String table) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + table, ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = pstmt.executeQuery();
		if (rs != null)
			System.out.println("*** Result Set ottenuto. ***\n");

		return rs;
	}

	public void printResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();

		Integer columnsCount = metaData.getColumnCount();

		String columnsName = "";
		for (int i = 1; i <= columnsCount; i++) {
			columnsName += "|_" + metaData.getColumnName(i) + "_" + (i == columnsCount ? "|\n" : "");
		}

		System.out.println("--------------- ***    Risultati tabella   *** ---------------\n");
		System.out.println(columnsName);

		int count = 1;
		while (rs.next()) {
			String row = "";
			for (int i = 1; i <= columnsCount; i++) {
				row += rs.getString(metaData.getColumnName(i)) + " " + "(" + metaData.getColumnTypeName(i) + ")"
						+ " | ";
			}

			System.out.println("(Riga: " + count + ") " + row);
			count++;
		}

		System.out.println("\n--------------- *** Fine Risultati tabella *** ---------------\n");
	}
}
