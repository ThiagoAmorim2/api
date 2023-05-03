package com.pessoas.api.specification;

import org.springframework.data.domain.Page;

import com.pessoas.api.model.dao.PessoaDAO;
import com.pessoas.api.model.dto.PaginacaoRequestDTO;
import com.pessoas.api.model.dto.PessoaFiltroDTO;

public interface PessoaSpecification {
    public Page<PessoaDAO> especificacaoListarTodasPessoas(PaginacaoRequestDTO paginacao, PessoaFiltroDTO filtroNome);
    public Page<PessoaDAO> especificacaoListarTodasPessoasOrdemAlfaDecrescente(PaginacaoRequestDTO paginacao, PessoaFiltroDTO filtroNome);
    public Page<PessoaDAO> especificacaoListarTodasPessoasOrdemAlfaCrescente(PaginacaoRequestDTO paginacao, PessoaFiltroDTO filtroNome);
    public Integer contagemDeTodasPessoas(PessoaFiltroDTO filtroParaContagem);
}
