package com.pessoas.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pessoas.api.model.dao.PessoaDAO;
import com.pessoas.api.specification.PessoaSpecification;

public interface PessoaRepository extends JpaRepository<PessoaDAO, UUID>, PessoaSpecification{

}
