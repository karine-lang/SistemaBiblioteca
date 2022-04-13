package br.com.nava.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ALUNOS")
public class AlunoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private TurmaEntity turma;
	
	@ManyToMany
	@JoinTable(name = "matricula", joinColumns = {@JoinColumn(name ="id_aluno")},
	inverseJoinColumns = {@JoinColumn(name ="id_disciplina")})
	private List<DisciplinaEntity> disciplina;
	
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TurmaEntity getTurma() {
		return turma;
	}

	public void setTurma(TurmaEntity turma) {
		this.turma = turma;
	}

	public List<DisciplinaEntity> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<DisciplinaEntity> disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
	
}
