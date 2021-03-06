package com.generation.lojadeGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo nome não pode ser vazio")
	@Size(min = 2, max = 100, message = "Permitido no mínimo 2 e máximo 100 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo nickname não pode ser vazio")
	@Size(min = 5, max = 100, message = "Permitido no mínimo 5 e máximo 100 caracteres")
	private String usuario;
	
	@NotBlank(message = "O atributo senha não pode ser vazio")
	@Size(min = 5, max = 100, message = "Permitido no mínimo 5 e máximo 100 caracteres")
	private String senha;
	
	@Size(max = 255, message = "Permitido no máximo 255 caracteres")
	private String foto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	

}
