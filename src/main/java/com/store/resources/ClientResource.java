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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.store.entities.Client;
import com.store.services.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/clients")
@CrossOrigin(origins = "*")
@Api(value="Módulo requisições para Clientes")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@ApiOperation(value = "Lista todos os clientes da base", notes = "Lista todos os clientes da base", response = Client.class, responseContainer = "List" )
	@ApiResponses(value = { 
	@ApiResponse(code = 200, message = "Listadas com sucesso")})
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = service.findAll();  
		
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value="Retorna cliente pelo id da base")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		Client obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Salva cliente na base")
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value="Delete cliente na base através do id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Atualiza cliente na base pelo id")
	@PutMapping
	(value = "/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client obj){
		service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
