package com.example.gestionbassins.repos;

import com.example.gestionbassins.entities.ImageBassin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageBassinRepository extends JpaRepository<ImageBassin, Long> {
}