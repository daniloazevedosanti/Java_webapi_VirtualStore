package com.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
