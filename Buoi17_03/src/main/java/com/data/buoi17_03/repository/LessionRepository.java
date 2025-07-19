package com.data.buoi17_03.repository;

import com.data.buoi17_03.entity.Lession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessionRepository extends JpaRepository<Lession, Integer> {
}
