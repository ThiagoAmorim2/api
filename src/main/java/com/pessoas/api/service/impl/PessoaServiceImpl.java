package com.pessoas.api.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pessoas.api.model.dao.PessoaDAO;
import com.pessoas.api.model.dto.ListaGenericaResponseDTO;
import com.pessoas.api.model.dto.PaginacaoRequestDTO;
import com.pessoas.api.model.dto.PessoaDTORequest;
import com.pessoas.api.model.dto.PessoaFiltroDTO;
import com.pessoas.api.model.dto.PessoaResponseDTO;
import com.pessoas.api.repository.PessoaRepository;
import com.pessoas.api.service.PessoaService;
import com.pessoas.api.utils.mapper.ListaGenericaResponseMapper;


@Service
public class PessoaServiceImpl implements PessoaService{

    private final ObjectMapper objectMapper;

    private final PessoaRepository pessoaRepository;

    private final ListaGenericaResponseMapper listaGenericaResponseMapper;

    public PessoaServiceImpl(
        PessoaRepository pessoaRepository, 
        ObjectMapper objectMapper, 
        ListaGenericaResponseMapper listaGenericaResponseMapper
        ){
        this.pessoaRepository = pessoaRepository;
        this.objectMapper = objectMapper;
        this.listaGenericaResponseMapper = listaGenericaResponseMapper;
    }

    @Override
    public Long criaPessoaDAO(PessoaDTORequest pessoaDTO) {
        PessoaDAO pessoaDAO = objectMapper.convertValue(pessoaDTO, PessoaDAO.class);
        pessoaRepository.save(pessoaDAO);
        return pessoaDAO.getId();
    }

    @Override
    public ListaGenericaResponseDTO<PessoaResponseDTO> listarTodasPessoas(PaginacaoRequestDTO paginacao, PessoaFiltroDTO filtroNome) {
        paginacao.setLimit(20);
        paginacao.setOffset(0);

        if(paginacao.getSort().equals("DESC")){
                Page<PessoaDAO> listagemPessoasOrdemAlfaDecrescente = pessoaRepository.especificacaoListarTodasPessoasOrdemAlfaDecrescente(paginacao, filtroNome);
                return listaGenericaResponseMapper.vindoDaPagina(listagemPessoasOrdemAlfaDecrescente, PessoaResponseDTO.class);
        }else if(paginacao.getSort().equals("ASC")){
                Page<PessoaDAO> listagemPessoasOrdemAlfaCrescente = pessoaRepository.especificacaoListarTodasPessoasOrdemAlfaCrescente(paginacao, filtroNome);
                return listaGenericaResponseMapper.vindoDaPagina(listagemPessoasOrdemAlfaCrescente, PessoaResponseDTO.class);
        }else{
                Page<PessoaDAO> listagemPessoas = pessoaRepository.especificacaoListarTodasPessoas(paginacao, filtroNome);
                return listaGenericaResponseMapper.vindoDaPagina(listagemPessoas, PessoaResponseDTO.class);
        }
    }
    
}
