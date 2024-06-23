package com.patricia.pessoa.repositories;

import com.patricia.pessoa.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
