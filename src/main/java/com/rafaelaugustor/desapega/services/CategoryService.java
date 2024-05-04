package com.rafaelaugustor.desapega.services;

import com.rafaelaugustor.desapega.domain.entities.Category;
import com.rafaelaugustor.desapega.repositories.CategoryRepository;
import com.rafaelaugustor.desapega.rest.dtos.request.CategoryRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.CategoryResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository repository;

    public void createCategory(CategoryRequestDTO request){

        Category categoryToSave = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .image(request.getImage())
                .build();

        repository.save(categoryToSave);

        log.info("Category {} has been created", request.getName());
    }

    public void deleteCategory(UUID id){
        repository.deleteById(id);
    }

    public Page<CategoryResponseDTO> findAllCategories(Pageable page){

        Page<Category> response = repository.findAll(page);

        return response.map(CategoryResponseDTO::new);

    }

    public CategoryResponseDTO findCategoryById(UUID id){

        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));


        return CategoryResponseDTO.builder()
                .name(category.getName())
                .description(category.getDescription())
                .image(category.getImage())
                .build();

    }

    public void updateCategory(UUID id, CategoryRequestDTO request){

        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setImage(request.getImage());

        repository.save(category);

        log.info("Category {} has been updated", request.getName());
    }

}
