package com.softwarefoundation.fooddeliverycadastroapi.repository;

import com.softwarefoundation.fooddeliverycadastroapi.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {
}
