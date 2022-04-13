package br.com.nava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nava.entities.DisciplinaEntity;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Integer> {

}
