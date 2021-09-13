package com.aris.depo.repository;

import com.aris.depo.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProduct extends JpaRepository<Product, Long> {

}
