package com.patricia.pessoa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patricia.pessoa.controllers.PessoaController;
import com.patricia.pessoa.domain.Pessoa;
import com.patricia.pessoa.dto.PessoaDto;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private PessoaDto pessoaDto;
    private Pessoa pessoa;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        pessoaDto = new PessoaDto();
        pessoaDto.setNome("Diogo César Dias");
        pessoaDto.setCpf("462.033.977-68");
        pessoaDto.setDataNascimento(LocalDate.of(1947,10,10));

        pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Diogo César Dias");
        pessoa.setCpf("462.033.977-68");
        pessoa.setDataNascimento(LocalDate.of(1947,10,10));
    }
}
