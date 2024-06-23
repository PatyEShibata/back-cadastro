package com.patricia.pessoa.controllers;

import com.patricia.pessoa.domain.Pessoa;
import com.patricia.pessoa.repositories.ContatoRepository;
import com.patricia.pessoa.repositories.PessoaRepository;
import com.patricia.pessoa.dto.PessoaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin
public class PessoaController {
    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> allPessoas = repository.findAll();
        return ResponseEntity.ok(allPessoas);
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody @Validated PessoaDto data) {
        Pessoa pessoa = data.converter();

        Pessoa pessoaCriada = repository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@RequestBody @Validated PessoaDto data, @PathVariable Long id) {
        boolean pessoaExisteBanco = repository.existsById(id);

        if (!id.equals(data.getId()) || !pessoaExisteBanco) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Pessoa pessoa = data.converterUpdate();

        Pessoa pessoaAlterada = repository.save(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaAlterada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Optional<Pessoa> pessoaOptional = repository.findById(id);
        return pessoaOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
