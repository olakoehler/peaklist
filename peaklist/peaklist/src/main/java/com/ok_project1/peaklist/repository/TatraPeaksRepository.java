package com.ok_project1.peaklist.repository;

import com.ok_project1.peaklist.model.TatraPeak;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TatraPeaksRepository
extends JpaRepository<TatraPeak, Long> {
}
