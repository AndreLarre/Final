package entity;

import javax.persistence.Id;

import com.sun.istack.Nullable;

public class Projeto {

	@Id
	private long idProjeto;
		
	private String nome;
	
	@Nullable
	private String Senha;
	
	private String Empresa;
	
	public Projeto(){

	}

	public Projeto(String nome){
		this.nome = nome;
	}

	public long getIdCliente() {
		return idProjeto;
	}

	public void setI(long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String Senha) {
		this.Senha = Senha;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		this.Empresa = empresa;
	}
}
