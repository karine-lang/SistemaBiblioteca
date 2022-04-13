package br.com.nava.initializations;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.nava.entities.AlunoDisciplina;
import br.com.nava.entities.AlunoEntity;
import br.com.nava.entities.AvaliacaoEntity;
import br.com.nava.entities.DisciplinaEntity;
import br.com.nava.entities.TurmaEntity;
import br.com.nava.repositores.AlunoRepository;
import br.com.nava.services.AlunoService;
import br.com.nava.services.AvaliacaoService;
import br.com.nava.services.DisciplinaService;
import br.com.nava.services.TurmaService;

@Component
public class AlunoIniti implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	AlunoService alunoService;
	@Autowired
	TurmaService turmaService;
	@Autowired
	DisciplinaService disciplinaService;
	
	@Autowired
	AvaliacaoService avaliacaoService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		AlunoEntity aluno1 = new AlunoEntity();
		aluno1.setNome("Karine");	
		
		AlunoEntity aluno2 = new AlunoEntity();
		aluno2.setNome("Rafael");	
		
		AlunoEntity aluno3 = new AlunoEntity();
		aluno3.setNome("Gabriel");
		
		AlunoEntity aluno4 = new AlunoEntity();
		aluno4.setNome("Cleber");
	
		
		DisciplinaEntity java = new DisciplinaEntity();
		java.setNome("java");
		disciplinaService.save(java);
		
		DisciplinaEntity arquiterura = new DisciplinaEntity();
		arquiterura.setNome("arquiterura");
		disciplinaService.save(arquiterura);
		
		TurmaEntity ihc = new TurmaEntity();
		ihc.setNome("IHC");
		turmaService.save(ihc);
		
		
		TurmaEntity mat =new TurmaEntity();
		mat.setNome("MAT");
		
		turmaService.save(mat);
		
		TurmaEntity redes = new TurmaEntity();
		redes.setNome("redes");
		turmaService.save(redes);
	
		
		
		TurmaEntity ads = new TurmaEntity();
		ads.setNome("ads");
		
		turmaService.save(ads);
		
		

		
		
		aluno1.setTurma(ads);
		aluno2.setTurma(ads);
		aluno3.setTurma(redes);
		aluno4.setTurma(ihc);
		
		aluno1.setDisciplina(Arrays.asList(java,arquiterura));
		aluno2.setDisciplina(Arrays.asList(arquiterura));
		aluno3.setDisciplina(Arrays.asList(java,arquiterura));
		aluno4.setDisciplina(Arrays.asList(java));
		
	
		
		alunoService.save(aluno1);
		alunoService.save(aluno2);
		alunoService.save(aluno3);
		alunoService.save(aluno4);
		
		AvaliacaoEntity avaliacaoAluno1 = new AvaliacaoEntity();
		
		AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
		
		alunoDisciplina.setAluno(aluno1);
		alunoDisciplina.setDisciplina(arquiterura);
		avaliacaoAluno1.setAlunoDisciplina(alunoDisciplina);
		avaliacaoAluno1.setConceito("A");
		
		avaliacaoService.save(avaliacaoAluno1);
		
		AlunoDisciplina alunoDisciplina2 = new AlunoDisciplina();
		alunoDisciplina2.setAluno(aluno2);
		alunoDisciplina2.setDisciplina(java);
		
		AvaliacaoEntity avaliacaoaluno2 = new AvaliacaoEntity();
		avaliacaoaluno2.setAlunoDisciplina(alunoDisciplina2);
		avaliacaoaluno2.setConceito("B");
		
		avaliacaoService.save(avaliacaoaluno2);
		
		AvaliacaoEntity aval = avaliacaoService.buscarNotaAlunoDisciplina(alunoDisciplina);
		System.out.println("avaliação" + aval.getConceito());
		System.out.println("aluno" + aval.getAlunoDisciplina().getAluno().getNome());
		System.out.println("disciplina" + aval.getAlunoDisciplina().getDisciplina().getNome());
		
		
		
		
		
		
		
		//turmaService.delete(2);
	
		
		List<TurmaEntity> listaTurma = turmaService.getAll();
		for (TurmaEntity turmaEntity : listaTurma) {
			System.out.println("nome turma:"+ turmaEntity.getNome());
		}
		TurmaEntity turma1 = turmaService.getOne(1);
		System.out.println(turma1.getNome());
		
		
		

	
	
	
}
}
