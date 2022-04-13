package br.com.nava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nava.entities.AlunoEntity;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {

}
 