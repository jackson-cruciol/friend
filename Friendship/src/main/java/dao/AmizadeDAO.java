package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Amizade;
import model.Pessoa;
import model.Preferencias;

public class AmizadeDAO {
	
	Connection connection;
	public AmizadeDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Amizade amizade) {
		String sql = "INSERT INTO Amizade (id_pessoa, id_amizade) VALUES (?,?)";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, amizade.getIdPessoa().getIdPessoa());
			statement.setInt(2, amizade.getIdAmizade().getIdPessoa());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(PreferenciaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public Amizade findbyIdAmizade(int id) {

		String sql = "SELECT * FROM Amizade WHERE id = ?";
		Amizade amizade = new Amizade();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			amizade = new Amizade();
			
			amizade.setId(rs.getInt("id"));
			
			int id_pessoa = rs.getInt("id_pessoa");
			Pessoa pessoa = pessoaDAO.findbyId(id_pessoa);
			amizade.setIdPessoa(pessoa);
			
			int id_pessoa2 = rs.getInt("id_amizade");
			Pessoa pessoa2 = pessoaDAO.findbyId(id_pessoa2);
			amizade.setIdAmizade(pessoa2);
			
		} catch (SQLException e) {
			Logger.getLogger(AmizadeDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		
		return amizade;
	}
	
	public List<Amizade> findAll() {
		String sql = "SELECT * FROM Amizade";
		
		List<Amizade> list = new ArrayList<>();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Amizade amizade = null;
			
			while (rs.next()) {
				amizade = new Amizade();
				amizade.setId(rs.getInt("id"));
				
				int id_pessoa = rs.getInt("id_pessoa");
				Pessoa pessoa = pessoaDAO.findbyId(id_pessoa);
				amizade.setIdPessoa(pessoa);
				
				int id_pessoa2 = rs.getInt("id_amizade");
				Pessoa pessoa2 = pessoaDAO.findbyId(id_pessoa2);
				amizade.setIdAmizade(pessoa2);
				
				list.add(amizade);
			}
			
		} catch (Exception e) {
			Logger.getLogger(AmizadeDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		return list;
		
	}
	
	public void deleteById(Amizade amizade)  {
		String sql = "DELETE FROM Amizade WHERE id = ? ";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, amizade.getId());
			statement.execute();
		}
	 catch (SQLException e) {
		Logger.getLogger(AmizadeDAO.class.getName()).log(Level.SEVERE,null,e);
	}
	}
	
	
}
