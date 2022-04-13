package br.com.nava.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable 
public class AlunoDisciplina implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8140768452409880108L;

	@ManyToOne(cascade = CascadeType.ALL)
	private AlunoEntity aluno;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private DisciplinaEntity disciplina;

	public AlunoEntity getAluno() {
		return aluno;
	}

	public void setAluno(AlunoEntity aluno) {
		this.aluno = aluno;
	}

	public DisciplinaEntity getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaEntity disciplina) {
		this.disciplina = disciplina;
	}
	

}
