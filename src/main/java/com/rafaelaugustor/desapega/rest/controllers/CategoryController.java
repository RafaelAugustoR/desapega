package com.rafaelaugustor.desapega.rest.controllers;

import com.rafaelaugustor.desapega.rest.dtos.request.CategoryRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.CategoryResponseDTO;
import com.rafaelaugustor.desapega.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.rafaelaugustor.desapega.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryRequestDTO request){
        service.createCategory(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id){
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<Page<CategoryResponseDTO>> findAllCategories(Pageable pageable){
        var response = service.findAllCategories(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDTO> findCategoryById(@PathVariable UUID id){
        var response = service.findCategoryById(id);
        return ResponseEntity.ok().body(response);
    }

}
