package com.pessoas.api.specification.impl;

import java.util.Collections;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.pessoas.api.model.dao.PessoaDAO;
import com.pessoas.api.model.dto.PaginacaoRequestDTO;
import com.pessoas.api.model.dto.PessoaFiltroDTO;
import com.pessoas.api.specification.PessoaSpecification;
import com.pessoas.api.utils.QueryUtils;
import com.pessoas.api.utils.mapper.PessoaMapper;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

import java.math.BigInteger;

public class PessoaSpecificationImpl implements PessoaSpecification{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryUtils queryUtils;



    @Override
    @ReadOnlyProperty
    public Page<PessoaDAO> especificacaoListarTodasPessoas(PaginacaoRequestDTO paginacao, PessoaFiltroDTO filtroNome) {
        TypedQuery<Tuple> query = entityManager.createNamedQuery("Pessoa.listarTodasPessoas", Tuple.class);
        List<Tuple> result = query
            .setParameter("nome", queryUtils.valorContemNoParametro(filtroNome.getNome()))
            .setFirstResult(paginacao.getOffset())
            .setMaxResults(paginacao.getLimit())
            .getResultList();
        
        return new PageImpl<>(PessoaMapper.toPessoa(result), PageRequest.of(paginacao.getOffset() / paginacao.getLimit(), paginacao.getLimit()), contagemDeTodasPessoas(filtroNome));
    }

    @Override
    @ReadOnlyProperty
    public Page<PessoaDAO> especificacaoListarTodasPessoasOrdemAlfaDecrescente(PaginacaoRequestDTO paginacao, PessoaFiltroDTO filtroNome) {
        TypedQuery<Tuple> query = entityManager.createNamedQuery("Pessoa.listarPessoasOrdemAlfabeticaDecrescente", Tuple.class);
        List<Tuple> result = query
            .setParameter("nome", queryUtils.valorContemNoParametro(filtroNome.getNome()))
            .setFirstResult(paginacao.getOffset())
            .setMaxResults(paginacao.getLimit())
            .getResultList();
        
        return new PageImpl<>(PessoaMapper.toPessoa(result), PageRequest.of(paginacao.getOffset() / paginacao.getLimit(), paginacao.getLimit()), contagemDeTodasPessoas(filtroNome));
    }
    
    
    @Override
    @ReadOnlyProperty
    public Page<PessoaDAO> especificacaoListarTodasPessoasOrdemAlfaCrescente(PaginacaoRequestDTO paginacao, PessoaFiltroDTO filtroNome) {
        TypedQuery<Tuple> query = entityManager.createNamedQuery("Pessoa.listarPessoasOrdemAlfabeticaCrescente", Tuple.class);
        List<Tuple> result = query
            .setParameter("nome", queryUtils.valorContemNoParametro(filtroNome.getNome()))
            .setFirstResult(paginacao.getOffset())
            .setMaxResults(paginacao.getLimit())
            .getResultList();
        
        return new PageImpl<>(PessoaMapper.toPessoa(result), PageRequest.of(paginacao.getOffset() / paginacao.getLimit(), paginacao.getLimit()), contagemDeTodasPessoas(filtroNome));
    }

    @Override
    public Integer contagemDeTodasPessoas(PessoaFiltroDTO filtroParaContagem) {
        Query query = entityManager.createNamedQuery("Pessoa.contagemTodasPessoas");
        query.setParameter("nome", queryUtils.valorContemNoParametro(filtroParaContagem.getNome()));
        
        return ((BigInteger) query.getSingleResult()).intValue();  
    }

    
}
