package com.patricia.pessoa.dto;

import com.patricia.pessoa.domain.Contato;
import com.patricia.pessoa.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private List<ContatoDto> contatos;

    public Pessoa converter() {
        Pessoa newPessoa = new Pessoa();

        newPessoa.setNome(this.nome);
        newPessoa.setCpf(this.cpf);
        newPessoa.setDataNascimento(this.dataNascimento);
        if (this.contatos != null) {
            List<Contato> contatosList = this.contatos.stream()
                    .map(dto -> dto.converter(newPessoa))
                    .collect(Collectors.toList());
            newPessoa.setContatos(contatosList);
        } else {
            newPessoa.setContatos(new ArrayList<>());
        }

        return newPessoa;
    }

    public Pessoa converterUpdate() {
        Pessoa newPessoa = new Pessoa();

        newPessoa.setId(this.id);
        newPessoa.setNome(this.nome);
        newPessoa.setCpf(this.cpf);
        newPessoa.setDataNascimento(this.dataNascimento);
        if (this.contatos != null) {
            List<Contato> contatosList = this.contatos.stream()
                    .map(dto -> dto.converter(newPessoa))
                    .collect(Collectors.toList());
            newPessoa.setContatos(contatosList);
        } else {
            newPessoa.setContatos(new ArrayList<>());
        }

        return newPessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<ContatoDto> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoDto> contatos) {
        this.contatos = contatos;
    }
}
