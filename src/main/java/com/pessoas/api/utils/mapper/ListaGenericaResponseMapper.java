package com.pessoas.api.utils.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pessoas.api.model.dto.ListaGenericaResponseDTO;
import com.pessoas.api.model.dto.PaginacaoResponseDTO;

@Component
public class ListaGenericaResponseMapper {
    
    
    private final ObjectMapper mapper;

    public ListaGenericaResponseMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T, U> ListaGenericaResponseDTO <T> vindoDaPagina(Page<U> doObjeto, Class<T> paraOObjeto) {
        List<T> content = pegarConteudoResponse(doObjeto, paraOObjeto);
        PaginacaoResponseDTO pageable = pegarPaginaResponse(doObjeto);
        return new ListaGenericaResponseDTO<T>(pageable, content);
    }

    private <U> PaginacaoResponseDTO pegarPaginaResponse(Page<U> objectFrom) {
        return PaginacaoResponseDTO.builder()
                .limite(objectFrom.getPageable().getPageSize())
                .offset(objectFrom.getPageable().getOffset())
                .pageNumber(objectFrom.getNumber() + 1)
                .pageElements(objectFrom.getNumberOfElements())
                .totalPages(objectFrom.getTotalPages())
                .totalElements(objectFrom.getTotalElements())
                .build();
    }

    private <T, U> List<T> pegarConteudoResponse(Page<U> objectFrom, Class<T> objectTo) {
        return objectFrom.getContent()
                .stream()
                .map(i -> mapper.convertValue(i, objectTo))
                .collect(Collectors.toList());
    }
}
