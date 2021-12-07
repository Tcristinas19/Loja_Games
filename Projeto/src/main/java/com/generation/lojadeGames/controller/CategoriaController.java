package com.generation.lojadeGames.controller;

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

import com.generation.lojadeGames.model.Categoria;
import com.generation.lojadeGames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository catRepository;
	
	// GET - Retorna todas categorias cadastradas
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		
		return ResponseEntity.ok(catRepository.findAll());
	}
	
	// GET - Retorna as categorias pelo ID
	@GetMapping("/{id}")
    public ResponseEntity<Categoria> GetById(@PathVariable long id){
        return catRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
	
	// GET -  Retorna as categorias pela descrição
	@GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Categoria>> GetByTitulo(@PathVariable String descricao){
        return ResponseEntity.ok(catRepository.findAllByDescricaoContainingIgnoreCase(descricao));
    }
	
	// POST - Método para inserir dados na tabela categoria
	@PostMapping
    public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(catRepository.save(categoria));
    }
	
	// PUT - Atualiza os dados da tabela categoria
	@PutMapping
    public ResponseEntity<Categoria> putCategoria (@Valid @RequestBody Categoria categoria){

        return catRepository.findById(categoria.getId())
            .map(resposta -> ResponseEntity.ok().body(catRepository.save(categoria)))
            .orElse(ResponseEntity.notFound().build());
    }
	
	// DELETE - Deleta os dados da tabela categoria pelo ID
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRepository(@PathVariable long id) {

        return catRepository.findById(id)
                .map(resposta -> {
                    catRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
		
}
