package br.com.zupacademy.ggwadera.casadocodigo.autor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AutorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private AutorRepository repository;

    @Test
    public void deveRetornarStatus200() throws Exception {
        NovoAutorDTO form = NovoAutorDTOBuilder.aNovoAutorDTO()
            .withEmail("autor@email.com")
            .withNome("Autor Autoria")
            .withDescricao("Descrição do livro")
            .build();
        mvc.perform(post("/autores")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(form)))
            .andExpect(status().isOk());
        verify(repository, times(1)).save(any(Autor.class));
    }

    @Test
    public void deveRetornarErro400ComValoresInvalido() throws Exception {
        NovoAutorDTO form = new NovoAutorDTO();
        mvc.perform(post("/autores")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(form)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$", hasSize(greaterThan(0))))
            .andExpect(jsonPath("$[*].campo").exists())
            .andExpect(jsonPath("$[*].erro").exists());
        verify(repository, never()).save(any(Autor.class));
    }

}