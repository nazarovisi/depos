package com.aris.depo.repository;

import com.aris.depo.entites.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoBase extends JpaRepository<Base, Long> {

}
