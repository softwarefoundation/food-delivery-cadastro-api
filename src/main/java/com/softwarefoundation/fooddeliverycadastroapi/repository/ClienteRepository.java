package com.softwarefoundation.fooddeliverycadastroapi.repository;

import com.softwarefoundation.fooddeliverycadastroapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
