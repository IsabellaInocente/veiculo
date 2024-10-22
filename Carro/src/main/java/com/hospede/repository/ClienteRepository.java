package com.hospede.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospede.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

	Optional<Cliente> findAll(long id);

}
