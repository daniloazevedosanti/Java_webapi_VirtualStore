package com.store.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.store.entities.Product;
import com.store.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "*")
@Api(value="Módulo requisições dos Produtos")
public class ProductResource {

	@Autowired 
	private ProductService service;

	@ApiOperation(value="Retorna uma lista de produtos")
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value="Retorna um produto pelo id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Insere produto na base")
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value="Deleta produto na base pelo id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
