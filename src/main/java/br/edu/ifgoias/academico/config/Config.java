package br.edu.ifgoias.academico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.CursoRepository;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

@Configuration
public class Config implements CommandLineRunner{
	
	@Autowired
	private CursoRepository cursoRep;
	
	@Autowired
	private DisciplinaRepository disciplinaRep;
	
	@Override
	public void run(String... args) throws Exception {
		
		Curso c1 = new Curso(null,"Spring");
		Curso c2 = new Curso(null,"RestFull");
		
		cursoRep.save(c1);
		cursoRep.save(c2);
		System.out.println("Qtde Cursos: " +  cursoRep.count());
		
		
		Disciplina d1 = new Disciplina (null, "POO I", 40);
		Disciplina d2 = new Disciplina(null, "POO II", 60);
		
		disciplinaRep.save(d1);
		disciplinaRep.save(d2);
		
		System.out.println("Qtde Disciplinas: " +  disciplinaRep.count());
		
	}
}

//https://www.postman.com/