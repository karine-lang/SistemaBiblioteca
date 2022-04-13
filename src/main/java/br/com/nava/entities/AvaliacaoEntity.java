package br.com.nava.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AVALIACAO")
public class AvaliacaoEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3069700013254140774L;


	@EmbeddedId
	private AlunoDisciplina alunoDisciplina;
	
	
	private String conceito;


	public AlunoDisciplina getAlunoDisciplina() {
		return alunoDisciplina;
	}


	public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}


	public String getConceito() {
		return conceito;
	}


	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
	

}
