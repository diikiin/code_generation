package com.company.code_generation.repository;

import com.company.code_generation.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter, Long> {

    Counter findTopByOrderByIdDesc();
}
