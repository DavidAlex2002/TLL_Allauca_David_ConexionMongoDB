package Configuración;

public class DataBase {

	private String server, db, user, pass;
	private int port;
	
	public DataBase()
	{
		this.server = "localhost";
		this.port = 27017;
		this.user = "root";
		this.pass = null;
		this.db = "futbolistas";
	}
	
	public String getServer() {
		return server;
	}

	public int getPort() {
		return port;
	}
	
	public String getDb() {
		return db;
	}
	
	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}
}
