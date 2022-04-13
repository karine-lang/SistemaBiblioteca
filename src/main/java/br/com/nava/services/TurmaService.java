package br.com.nava.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.nava.entities.TurmaEntity;
import br.com.nava.repositores.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<TurmaEntity> getAll(){
		return turmaRepository.findAll();
		}
	
	public TurmaEntity getOne(Integer id) throws ObjectNotFoundException {
		Optional<TurmaEntity> turma = turmaRepository.findById(id);
	return  turma.orElseThrow(() -> new ObjectNotFoundException(null, "Turma não encontrada! :("));
	
	
	}
	
	public TurmaEntity save(TurmaEntity turma) {
		return turmaRepository.save(turma);
	}
	
	
	public void delete(Integer id) {
		turmaRepository.deleteById(id);
	}
	
	
	public TurmaEntity update(TurmaEntity objTurma) {
		TurmaEntity turma = getOne(objTurma.getId_turma());
		turma.setNome(objTurma.getNome());
		return turmaRepository.save(turma);
	}

}
