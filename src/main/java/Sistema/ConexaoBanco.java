package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConexaoBanco
{
	public static Statement IniciarBanco(Statement s)
	{
		Connection c;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./BancodeDados.db");
			populateDataBaseIfEmpty(c);
			s = c.createStatement();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}

		return s;
	}

	private static void populateDataBaseIfEmpty(Connection c) throws SQLException {
		Statement s = c.createStatement();

		try {
			s.executeQuery("select * from Lutadores");
		} catch (Exception e) {
			s.executeUpdate("create table Lutadores (" +
					"ID INTEGER PRIMARY KEY," +
					"Nome TEXT not null," +
					"Idade INTEGER not null," +
					"Sexo TEXT not null," +
					"Peso DOUBLE not null," +
					"País TEXT not null," +
					"Categoria TEXT not null" +
					");");

			s.executeUpdate("create table Codigos (" +
					"num PRIMARY KEY" +
					");");

			s.executeUpdate("insert into Lutadores(ID, Nome, Idade, Sexo, Peso, País, Categoria) values ('0', 'Rafael', '20', 'Masculino', '74.5', 'Brasil', 'Meio-Médio');");
			s.executeUpdate("insert into Lutadores(ID, Nome, Idade, Sexo, Peso, País, Categoria) values ('1', 'Matheus', '23', 'Masculino', '65.0', 'Brasil', 'Pena');");
			s.executeUpdate("insert into Lutadores(ID, Nome, Idade, Sexo, Peso, País, Categoria) values ('2', 'Adriano', '24', 'Masculino', '78.0', 'Brasil', 'Médio');");
			s.executeUpdate("insert into Lutadores(ID, Nome, Idade, Sexo, Peso, País, Categoria) values ('3', 'Anderson', '25', 'Masculino', '72.0', 'Brasil', 'Meio-Médio');");

			s.executeUpdate("insert into Codigos (num) values (3);");
		}

		s.close();
	}
}
