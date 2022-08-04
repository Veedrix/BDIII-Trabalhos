package org.salvandoobjetos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String dataNascimento;
	private String Sexo;
	private String cpf;
	@OneToOne
	private Endereco endereco;
	@OneToMany(mappedBy = "cliente", orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Cliente() {}
	public Cliente(String nome, String dataNascimento, String sexo, String cpf, Endereco endereco, List<Telefone> telefones) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		Sexo = sexo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefones = telefones;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String string) {
		this.cpf = string;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public Long getId() {
		return id;
	}
}
