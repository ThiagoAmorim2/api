package com.pessoas.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class PaginacaoRequestDTO {
 
    @NotBlank(message = "Não pode ser nulo")
    private Integer limit;

    @NotBlank(message = "Não pode ser nulo")
    private Integer offset;

    @NotBlank(message = "Não pode ser nulo")
    private String sort;


}
