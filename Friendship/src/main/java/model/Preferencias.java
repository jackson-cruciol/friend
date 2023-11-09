package model;

public class Preferencias {
	
	private int idPreferencias;
	private String descricao;
	private Pessoa pessoa;
	
	public int getIdPreferencias() {
		return idPreferencias;
	}
	public void setIdPreferencias(int idPreferencias) {
		this.idPreferencias = idPreferencias;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
