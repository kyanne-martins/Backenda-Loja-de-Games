package com.generation.LojaGame.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.generation.LojaGame.model.CategoriaModel;
import com.generation.LojaGame.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoriagame")
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable Long id){
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/produto/{produto}")
	public ResponseEntity<List<CategoriaModel>> getByTipo(@PathVariable String tipo){
		return ResponseEntity.ok(repository.findAllByTipoContainingIgnoreCase(tipo));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria (@Valid @RequestBody CategoriaModel tipo){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tipo));			
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria (@RequestBody CategoriaModel tipo){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tipo));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		repository.deleteById(id);
	}	

}
