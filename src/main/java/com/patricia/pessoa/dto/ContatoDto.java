package com.patricia.pessoa.dto;

import com.patricia.pessoa.domain.Contato;
import com.patricia.pessoa.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ContatoDto {
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public Contato converter(Pessoa pessoa) {
        Contato newContato = new Contato();

        newContato.setId(this.id);
        newContato.setEmail(this.email);
        newContato.setNome(this.nome);
        newContato.setTelefone(this.telefone);

        newContato.setPessoa(pessoa);

        return newContato;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
