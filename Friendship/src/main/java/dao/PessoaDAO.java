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

public class PessoaDAO {
	
	Connection connection;
	public PessoaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Pessoa pessoa) {
		String sql = "INSERT INTO Pessoa (nome,email,data_nascimento) VALUES (?,?,?)";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1,pessoa.getNome());
			statement.setString(2, pessoa.getEmail());
			statement.setDate(3, pessoa.getDataNascimento());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public Pessoa findbyId(int id) {

		String sql = "SELECT * FROM Pessoa WHERE id_pessoa = ?";
		Pessoa pessoa = new Pessoa();
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			pessoa = new Pessoa();
			pessoa.setIdPessoa(rs.getInt("id_pessoa"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setEmail(rs.getString("email"));
			pessoa.setDataNascimento(rs.getDate("data_nascimento"));
		} catch (SQLException e) {
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		
		return pessoa;
	}
			
	public void updateNameEmailById(Pessoa pessoa) {
		String sql = "UPDATE Pessoa SET nome = ?, email = ?, data_nascimento = ? WHERE id_pessoa = ?";
		 try(PreparedStatement statement = connection.prepareStatement(sql)){
			 statement.setString(1, pessoa.getNome());
			 statement.setString(2, pessoa.getEmail());
			 statement.setDate(3, pessoa.getDataNascimento());
			 statement.setInt(4, pessoa.getIdPessoa());
			 statement.execute();
		 }catch (SQLException e) {
			 Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		 }
	}
	
	public List<Pessoa> findAll(){
		String sql = "SELECT * FROM Pessoa";
		
		List<Pessoa> list = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Pessoa pessoa = null;
			
			while (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setIdPessoa(rs.getInt("id_pessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setDataNascimento(rs.getDate("data_nascimento"));
				
				list.add(pessoa);
			}
			
		}catch (SQLException e) {
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		return list;
	}
	
	public void deleteByname (Pessoa pessoa) {
		String sql = "DELETE FROM Pessoa WHERE id_pessoa = ?";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, pessoa.getIdPessoa());
			statement.execute();
		}catch (SQLException e ) {
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}

	
}
