package br.com.nava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nava.entities.TurmaEntity;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity, Integer> {

}
