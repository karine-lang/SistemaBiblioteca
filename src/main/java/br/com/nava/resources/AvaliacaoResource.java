package br.com.nava.resources;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.nava.entities.AlunoDisciplina;
import br.com.nava.entities.AlunoEntity;
import br.com.nava.entities.AvaliacaoEntity;
import br.com.nava.entities.DisciplinaEntity;
import br.com.nava.services.AvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoResource {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AvaliacaoEntity>>  listarAvaliacao(){
		List<AvaliacaoEntity> listaAvaliacao = avaliacaoService.getAll();
		return ResponseEntity.ok().body(listaAvaliacao);
		}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody AvaliacaoEntity objAvaliacao){
		Map<String, Object> params = new HashMap<String, Object>();
		
		objAvaliacao =   avaliacaoService.save(objAvaliacao);
		UriComponentsBuilder uriBuilder = ServletUriComponentsBuilder.fromCurrentRequest();
		uriBuilder.path("/{idAluno}/{idDisciplina}");
		params.put("idAluno", objAvaliacao.getAlunoDisciplina().getAluno().getId());
		params.put("idDisciplina", objAvaliacao.getAlunoDisciplina().getDisciplina().getId());
		
	
		URI uri = uriBuilder.buildAndExpand(params).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id_aluno}/{id_disciplina}", method = RequestMethod.GET)
	public ResponseEntity<AvaliacaoEntity> buscarAvaliacaoAlunoPorDisciplina(@PathVariable Integer id_aluno, Integer id_disciplina){
		AlunoEntity aluno = new AlunoEntity();
		aluno.setId(id_aluno);
		
		DisciplinaEntity disciplina = new DisciplinaEntity();
		disciplina.setId(id_disciplina);
		
		AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
		alunoDisciplina.setAluno(aluno);
		
		alunoDisciplina.setDisciplina(disciplina);
		
		 AvaliacaoEntity avaliacao  = avaliacaoService.buscarNotaAlunoDisciplina(alunoDisciplina);
		 
		System.out.println(avaliacao.getConceito());
		
		 return ResponseEntity.ok().body(avaliacao);
	}
	



}
