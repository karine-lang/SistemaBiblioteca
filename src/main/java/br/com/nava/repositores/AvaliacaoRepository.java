package br.com.nava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nava.entities.AlunoDisciplina;
import br.com.nava.entities.AvaliacaoEntity;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, AlunoDisciplina> {
	
	AvaliacaoEntity findByAlunoDisciplina(AlunoDisciplina alunoDisciplina);

}
