package it.eos.springuser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	private String mail;
	
	@Column(name = "password")
	private String psw;
	
	@Column(name ="nome")
	private String nome;
	
	


	@Override
	public String toString() {
		return "User [mail=" + mail + ", psw=" + psw + ", nome=" + nome + ", getMail()=" + getMail() + ", getPsw()="
				+ getPsw() + ", getNome()=" + getNome() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}




	public String getMail() {
		return mail;
	}




	public void setMail(String mail) {
		this.mail = mail;
	}




	public String getPsw() {
		return psw;
	}




	public void setPsw(String psw) {
		this.psw = psw;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}
		
	}

