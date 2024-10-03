package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository disciplinaRep;
	
	public List<Disciplina> findAll(){
		return disciplinaRep.findAll();
	}
		
	public Disciplina findById(Integer id) {
		return disciplinaRep.findById(id).orElseThrow(
													() -> new ResponseStatusException(HttpStatus.NOT_FOUND)
												);
	}
	
	public Disciplina insert(Disciplina c) {
		return disciplinaRep.save(c);
	}
	
	public void delete(Integer id) {
		disciplinaRep.deleteById(id);
	}
	
	public Disciplina update(Integer id, Disciplina disciplinaAlt, Integer hr) {
		return disciplinaRep.findById(id).map(
				disciplinaDB ->{
					disciplinaDB.setNomedisciplina(disciplinaAlt.getNomedisciplina());
									 			return disciplinaRep.save(disciplinaDB);
									 		}
										)
									.orElseThrow(
											() -> new ResponseStatusException(HttpStatus.NOT_FOUND)
									);
	}
}
