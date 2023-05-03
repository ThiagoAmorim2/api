package com.pessoas.api.model.dao;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Pessoa.listarTodasPessoas",
        query = "SELECT * FROM tb_Pessoa WHERE nome LIKE :nome"
    ),
    @NamedNativeQuery(
        name = "Pessoa.contagemTodasPessoas", 
        query = "SELECT COUNT(*) FROM tb_Pessoa WHERE nome LIKE :nome"
    ),
    @NamedNativeQuery(
        name = "Pessoa.listarPessoasOrdemAlfabeticaDecrescente",
        query = "SELECT * FROM tb_Pessoa WHERE nome LIKE :nome ORDER BY nome DESC"
    ),
    
    @NamedNativeQuery(
        name = "Pessoa.listarPessoasOrdemAlfabeticaCrescente",
        query = "SELECT * FROM tb_Pessoa WHERE nome LIKE :nome ORDER BY nome ASC"
    )
})

@Getter
@Setter
@Entity
@Table(name = "tb_Pessoa")
public class PessoaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "nome", nullable = false)
    public String nome;

    @Column(name = "idade", nullable = false)
    public Integer idade;
    
}
