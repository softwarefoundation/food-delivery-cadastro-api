package com.softwarefoundation.fooddeliverycadastroapi.repository;

import com.softwarefoundation.fooddeliverycadastroapi.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
    
}
