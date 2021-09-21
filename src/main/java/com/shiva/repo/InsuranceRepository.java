package com.shiva.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

}
