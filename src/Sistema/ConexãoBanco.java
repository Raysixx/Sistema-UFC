package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConexãoBanco 
{
	public static Statement IniciarBanco(Statement s)
	{
		Connection c = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:BancodeDados.db");
			s = c.createStatement();
		} catch (Exception e)
		  {
			JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		  }
		return s;
	}
}
