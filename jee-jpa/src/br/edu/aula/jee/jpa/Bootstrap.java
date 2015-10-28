package br.edu.aula.jee.jpa;

import java.sql.Connection;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Session Bean implementation class Bootstrap
 */
@Startup
@Stateless
public class Bootstrap {

	/**
	 * 
	 */
	@Resource(name = "ExampleDS")
	private DataSource dataSource;

	/**
	 * 
	 */
	@PostConstruct
	public void postConstruct() {
		try {
			final Connection connection = this.dataSource.getConnection();
			final String sql = "CREATE TABLE IF NOT EXISTS pessoa ( nome VARCHAR(255) )";
			connection.createStatement().executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
	public void insereACada10Segundos() {
		try {
			final Connection connection = this.dataSource.getConnection();

			String sql = "INSERT INTO pessoa VALUES ('nome " + System.currentTimeMillis() + "')";
			connection.createStatement().executeUpdate(sql);
			
			sql = "SELECT * FROM pessoa";
			final Statement ps = connection.createStatement();
			ps.execute(sql);
			System.out.println("--------------------------");
			while (ps.getResultSet().next()) {
				System.out.println( ps.getResultSet().getString("nome") );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
