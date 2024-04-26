package com.rafaelaugustor.desapega.rest.dtos.response;

import com.rafaelaugustor.desapega.domain.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponseDTO {

    private String name;

    private String description;

    private String image;

    public CategoryResponseDTO(Category entity){
        BeanUtils.copyProperties(entity, this);
    }
}
