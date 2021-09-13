package com.aris.depo.repository;

import com.aris.depo.entites.ShippingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoShippingProduct extends JpaRepository<ShippingProduct, Long> {

}
