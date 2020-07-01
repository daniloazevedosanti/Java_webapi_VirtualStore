package com.store.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.store.entities.Client;
import com.store.repositories.ClientRepository;
import com.store.services.exceptions.DatabaseException;
import com.store.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		
		Optional<Client> obj = repository.findById(id);
		//return obj.get();
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);	
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);	
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());		
		}
	}
	
	public Client update(Long id, Client obj) {
		try {
		Client entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
		}catch(EntityNotFoundException e) {
			//e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		
	}
}
