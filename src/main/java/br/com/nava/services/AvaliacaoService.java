package br.com.nava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.AlunoDisciplina;
import br.com.nava.entities.AvaliacaoEntity;
import br.com.nava.repositores.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repo;
	
	public AvaliacaoEntity save(AvaliacaoEntity avaliacao) {
		return repo.save(avaliacao);
	}
	
	public List<AvaliacaoEntity> getAll(){
		return repo.findAll();
	}
	
	public AvaliacaoEntity buscarNotaAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		return repo.findByAlunoDisciplina(alunoDisciplina);
	}
	
}
