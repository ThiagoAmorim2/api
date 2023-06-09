package com.pessoas.api.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ListaGenericaResponseDTO<T> {
    
    @JsonProperty("_pageable")
    private PaginacaoResponseDTO paginacao;

    @JsonProperty("_conteudo")
    private List<T> conteudo;

}
