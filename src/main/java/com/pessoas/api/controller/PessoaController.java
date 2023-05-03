package com.pessoas.api.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pessoas.api.model.dto.ListaGenericaResponseDTO;
import com.pessoas.api.model.dto.*;
import com.pessoas.api.service.PessoaService;
import com.pessoas.api.utils.UrlUtils;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    private final PessoaService pessoaService;
    private final UrlUtils urlUtils;

    public PessoaController(PessoaService pessoaService, UrlUtils urlUtils) {
        this.pessoaService = pessoaService;
        this.urlUtils = urlUtils;
    }

    @PostMapping
    public ResponseEntity<?> criarPessoa(@RequestBody PessoaDTORequest pessoaDTORequest){
        URI location = urlUtils.getCreatedLocation(pessoaService.criaPessoaDAO(pessoaDTORequest));
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<ListaGenericaResponseDTO<PessoaResponseDTO>> buscarTodasPessoas(
                            @RequestParam(value = "nome") String nome,
                            @RequestParam(value = "sort") String sort){
    	PessoaFiltroDTO filtroNome = new PessoaFiltroDTO(nome);
    	PaginacaoRequestDTO paginacao = new PaginacaoRequestDTO();
        paginacao.setSort(sort);
        return ResponseEntity.ok(pessoaService.listarTodasPessoas(paginacao, filtroNome));
    }    
    
}
