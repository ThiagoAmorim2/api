package com.pessoas.api.service;

import java.util.UUID;

import com.pessoas.api.model.dao.PessoaDAO;
import com.pessoas.api.model.dto.ListaGenericaResponseDTO;
import com.pessoas.api.model.dto.PaginacaoRequestDTO;
import com.pessoas.api.model.dto.PessoaDTORequest;
import com.pessoas.api.model.dto.PessoaFiltroDTO;
import com.pessoas.api.model.dto.PessoaResponseDTO;

public interface PessoaService {

    // public PessoaDAO getPessoaDAOById(Long id);

    public Long criaPessoaDAO(PessoaDTORequest pessoaDTO);

    public ListaGenericaResponseDTO<PessoaResponseDTO> listarTodasPessoas(PaginacaoRequestDTO paginacao, PessoaFiltroDTO filtroNome);
    
    // public ListaGenericaResponseDTO<PessoaResponseDTO> listarTodasPessoasOrdemAlfaDecrecente(PaginacaoRequestDTO paginacao, PessoaFiltroDTO filtroNome);

}
