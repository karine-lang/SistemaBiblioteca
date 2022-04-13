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

import br.com.nava.entities.AlunoEntity;
import br.com.nava.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoResouce {
	
	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AlunoEntity>> listarAluno(){
		
	List<AlunoEntity> alunos = alunoService.getAll();
	 return ResponseEntity.ok().body(alunos);
		
	
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AlunoEntity> buscaPorID(@PathVariable Integer id) throws ObjectNotFoundException {
		AlunoEntity aluno = alunoService.getOne(id);
		return ResponseEntity.ok().body(aluno);
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody AlunoEntity objAluno ){
		AlunoEntity aluno = alunoService.save(objAluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		alunoService.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	
	@RequestMapping(value= "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody AlunoEntity objAluno, @PathVariable Integer id){
		objAluno.setId(id);
		alunoService.update(objAluno);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
	
	
	
	

}
