package br.com.nava.resources;

import java.net.URI;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nava.entities.DisciplinaEntity;
import br.com.nava.services.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaResource {
	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping
	public ResponseEntity<List<DisciplinaEntity>> listarDisciplina(){
		List<DisciplinaEntity> disciplina = disciplinaService.getAll();
		return ResponseEntity.ok().body(disciplina);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<DisciplinaEntity> buscarPorID(@PathVariable Integer id) throws ObjectNotFoundException {
		DisciplinaEntity disc = disciplinaService.getOne(id);
		return ResponseEntity.ok().body(disc);
		
	}
	
	
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody DisciplinaEntity disciplina){
		DisciplinaEntity disc = disciplinaService.save(disciplina);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disc.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		disciplinaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody DisciplinaEntity objDisciplina, @PathVariable Integer id){
		objDisciplina.setId(id);
		disciplinaService.update(objDisciplina);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
}
