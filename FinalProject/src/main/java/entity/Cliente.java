package entity;

import javax.persistence.Id;

import com.sun.istack.Nullable;

public class Cliente {
	
	@Id
	private long idCliente;
	
	@Nullable
	private String empresa;
	
	private String nome;
	
	@Nullable
	private String cpf;
	
	public Cliente(){

	}

	public Cliente(String nome){
		this.nome = nome;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setI(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}

