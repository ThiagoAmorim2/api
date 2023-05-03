package com.pessoas.api.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaResponseDTO {
    
    private Long id;
    private String nome;
    private Integer idade;
}
