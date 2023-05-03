package com.pessoas.api.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFiltroDTO {
    
    @NotNull
    private String nome;

	public PessoaFiltroDTO(@NotNull String nome) {
		super();
		this.nome = nome;
	}
    
    
}
