package com.rafaelaugustor.desapega.rest.controllers;

import com.rafaelaugustor.desapega.rest.dtos.request.CategoryRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.CategoryResponseDTO;
import com.rafaelaugustor.desapega.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.rafaelaugustor.desapega.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService service;

    @PostMapping("")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryRequestDTO request) {
        log.info("Creating category: {}", request);
        service.createCategory(request);
        log.info("Category created successfully");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        log.info("Deleting category with ID: {}", id);
        service.deleteCategory(id);
        log.info("Category deleted successfully");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<Page<CategoryResponseDTO>> findAllCategories(Pageable pageable) {
        log.info("Fetching all categories");
        var response = service.findAllCategories(pageable);
        log.info("Categories fetched successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findCategoryById(@PathVariable UUID id) {
        log.info("Fetching category by ID: {}", id);
        var response = service.findCategoryById(id);
        log.info("Category fetched successfully");
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryRequestDTO request, @PathVariable UUID id) {
        log.info("Updating category with ID: {}", id);
        service.updateCategory(id, request);
        log.info("Category updated successfully");
        return ResponseEntity.noContent().build();
    }
}
