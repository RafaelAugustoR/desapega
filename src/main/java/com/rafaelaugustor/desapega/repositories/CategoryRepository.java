package com.rafaelaugustor.desapega.repositories;

import com.rafaelaugustor.desapega.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
