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
import model.Pessoa;
import model.Preferencias;

public class PreferenciaDAO {
	
	Connection connection;
	public PreferenciaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Preferencias preferencias) {
		String sql = "INSERT INTO Preferencias (descricao,id_pessoa) VALUES (?,?)";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, preferencias.getDescricao());
			statement.setInt(2, preferencias.getPessoa().getIdPessoa());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(PreferenciaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public Preferencias findbyIdPreferencia(int id) {

		String sql = "SELECT * FROM Preferencias WHERE id_preferencia = ?";
		Preferencias preferencias = new Preferencias();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			preferencias = new Preferencias();
			preferencias.setIdPreferencias(rs.getInt("id_preferencia"));
			preferencias.setDescricao(rs.getString("descricao"));
			
			int id_pessoa = rs.getInt("id_pessoa");
			Pessoa pessoa = pessoaDAO.findbyId(id_pessoa);
			preferencias.setPessoa(pessoa);
			
		} catch (SQLException e) {
			Logger.getLogger(PreferenciaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		
		return preferencias;
	}
	
	public void updateDescriptionById(Preferencias preferencias) {
		String sql = "UPDATE Preferencias SET descricao = ? WHERE id_preferencia = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, preferencias.getDescricao());
			statement.setInt(2, preferencias.getIdPreferencias());
			statement.execute();
		} catch (SQLException e) {
			Logger.getLogger(PreferenciaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public List<Preferencias> findByAll() {
		String sql = "SELECT * FROM Preferencias";
		
		List<Preferencias> list = new ArrayList<>();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Preferencias preferencias = null;
			
			while (rs.next()) {
				preferencias = new Preferencias();
				preferencias.setIdPreferencias(rs.getInt("id_preferencia"));
				preferencias.setDescricao(rs.getString("descricao"));
				int id_pessoa = rs.getInt("id_pessoa");
				
				Pessoa pessoa = pessoaDAO.findbyId(id_pessoa);
				
				preferencias.setPessoa(pessoa);
				list.add(preferencias);
			}
			
		} catch (Exception e) {
			Logger.getLogger(PreferenciaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		return list;
		
	}
	
	public void deleteById(Preferencias preferencias)  {
		String sql = "DELETE FROM Preferencias WHERE id_preferencia = ? ";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, preferencias.getIdPreferencias());
			statement.execute();
		}
	 catch (SQLException e) {
		Logger.getLogger(PreferenciaDAO.class.getName()).log(Level.SEVERE,null,e);
	}
	}


}
