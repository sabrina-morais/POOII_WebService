package br.edu.ifgoias.academico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.services.DisciplinaService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping (value= "/disciplinas")
public class DisciplinaResource {
	
	@Autowired
	private DisciplinaService service;
	
	@GetMapping
	public ResponseEntity <List<Disciplina>> findAll(){
		List <Disciplina> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Disciplina> findById(@PathVariable Integer id){
		
		Disciplina disciplina = service.findById(id);
		
		return ResponseEntity.ok().body(disciplina);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Disciplina> insert(@RequestBody Disciplina d){
		
		 d = service.insert(d);
		
		return ResponseEntity.ok().body(d);
		
	} 
	
	@DeleteMapping (value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id){
		
		service.delete(id);
	
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Disciplina> update(@PathVariable Integer id, @RequestBody Disciplina d  ){
		
		d = service.update(id, d, id);
		
		return ResponseEntity.ok().body(d);
	}
	
	

}
