package darioTest;

import java.sql.SQLException;

import Main.CarManager;
import Main.ManageFile;

//classe di testing
public class Test {
	public static void main(String[] args) throws SQLException {
		
		// test funzionamento managemnt delle auto
		CarManager cm = new CarManager();
		
		//test funzionamento del file manager
		ManageFile mf = new ManageFile();
		
		// test generale di tutte le parti
		cm.startCarManager();
	}
}
