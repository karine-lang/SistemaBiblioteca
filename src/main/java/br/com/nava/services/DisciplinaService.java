package br.com.nava.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.DisciplinaEntity;
import br.com.nava.repositores.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	
	public List<DisciplinaEntity>  getAll(){
		return disciplinaRepository.findAll();
	}
	
	public DisciplinaEntity getOne(Integer id) throws ObjectNotFoundException {
		Optional<DisciplinaEntity> disciplina = disciplinaRepository.findById(id);
		return disciplina.orElseThrow(() -> new ObjectNotFoundException(null, "disciplina não encontrada :("));
		
	}
	public DisciplinaEntity save(DisciplinaEntity disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	
	public void delete(Integer id) {
		disciplinaRepository.deleteById(id);
	}
	
	
	public DisciplinaEntity update(DisciplinaEntity objDisciplina) {
		DisciplinaEntity disc = getOne(objDisciplina.getId());
		disc.setNome(objDisciplina.getNome());
		return disciplinaRepository.save(disc);
		
	}

}
