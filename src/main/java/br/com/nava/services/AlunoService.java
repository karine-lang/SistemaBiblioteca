package br.com.nava.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.AlunoEntity;
import br.com.nava.repositores.AlunoRepository;

@Service
public class AlunoService { 
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<AlunoEntity> getAll() {
		
		return alunoRepository.findAll();
		
	}
	
	public AlunoEntity getOne(Integer id) throws ObjectNotFoundException{
		Optional<AlunoEntity> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(null,"Objeto Não encontrado"));
	}
	 public AlunoEntity save(AlunoEntity aluno) {
		 return alunoRepository.save(aluno);
	 }
	 
	 public void delete(Integer id) {
		 alunoRepository.deleteById(id);
	 }
	 
	 public AlunoEntity update(AlunoEntity objAluno) {
		 
		 AlunoEntity aluno = getOne(objAluno.getId());
		 aluno.setNome(objAluno.getNome());
		 aluno.setTurma(objAluno.getTurma());
		 aluno.setDisciplina(objAluno.getDisciplina());
		 return save(aluno);
		 
	 }
	
	
	

}
