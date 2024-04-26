package com.rafaelaugustor.desapega.services;

import com.rafaelaugustor.desapega.domain.entities.Category;
import com.rafaelaugustor.desapega.repositories.CategoryRepository;
import com.rafaelaugustor.desapega.rest.dtos.request.CategoryRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.CategoryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public void createCategory(CategoryRequestDTO request){

        Category categoryToSave = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .image(request.getImage())
                .build();

        repository.save(categoryToSave);

    }

    public void deleteCategory(UUID id){
        repository.deleteById(id);
    }

    public Page<CategoryResponseDTO> findAllCategories(Pageable page){

        Page<Category> response = repository.findAll(page);

        return response.map(CategoryResponseDTO::new);

    }
}
