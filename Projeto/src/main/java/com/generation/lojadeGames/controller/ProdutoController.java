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
import com.generation.lojadeGames.model.Produto;
import com.generation.lojadeGames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository prodRepository;
	
	// GET - Retorna todas Produtos cadastradas
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll(){
		
		return ResponseEntity.ok(prodRepository.findAll());
	}
	
	// GET - Retorna as Produtos pelo ID
	@GetMapping("/{id}")
    public ResponseEntity<Produto> GetById(@PathVariable long id){
        return prodRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
	
	// GET -  Retorna as Produtos pela descrição
	@GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Produto>> GetByTitulo(@PathVariable String descricao){
        return ResponseEntity.ok(prodRepository.findAllByDescricaoContainingIgnoreCase(descricao));
    }
	
	// POST - Método para inserir dados na tabela Produto
	@PostMapping
    public ResponseEntity<Produto> post (@RequestBody Produto produto){
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(prodRepository.save(produto));
    }
	
	// PUT - Atualiza os dados da tabela Produto
	@PutMapping
    public ResponseEntity<Produto> putProduto (@Valid @RequestBody Produto produto){

        return prodRepository.findById(produto.getId())
            .map(resposta -> ResponseEntity.ok().body(prodRepository.save(produto)))
            .orElse(ResponseEntity.notFound().build());
    }
	
	// DELETE - Deleta os dados da tabela Produto pelo ID
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRepository(@PathVariable long id) {

        return prodRepository.findById(id)
                .map(resposta -> {
                    prodRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
