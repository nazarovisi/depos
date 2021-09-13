package com.aris.depo.repository;

import com.aris.depo.entites.views.ViewBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoViewBase extends JpaRepository<ViewBase, Long> {

}
