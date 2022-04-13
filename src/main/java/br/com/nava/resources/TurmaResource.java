package br.com.nava.resources;

import java.net.URI;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nava.entities.TurmaEntity;
import br.com.nava.services.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaResource {
	@Autowired
	private TurmaService turmaService;
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TurmaEntity>> listarTurmas(){
		List<TurmaEntity> turmas = turmaService.getAll();
		return ResponseEntity.ok().body(turmas);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TurmaEntity> buscaporID(@PathVariable Integer id) throws ObjectNotFoundException {
		TurmaEntity turma = turmaService.getOne(id);
		return ResponseEntity.ok().body(turma);
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody TurmaEntity turma){
		TurmaEntity objTurma = turmaService.save(turma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objTurma.getId_turma()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		turmaService.delete(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody TurmaEntity objTurma, @PathVariable Integer id){
		objTurma.setId_turma(id);
		turmaService.update(objTurma);
		return ResponseEntity.noContent().build();
	}
	
	

}
