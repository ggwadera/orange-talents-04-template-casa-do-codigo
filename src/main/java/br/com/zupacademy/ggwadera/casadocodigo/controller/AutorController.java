package br.com.zupacademy.ggwadera.casadocodigo.controller;

import br.com.zupacademy.ggwadera.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.ggwadera.casadocodigo.model.Autor;
import br.com.zupacademy.ggwadera.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid AutorForm form) {
        final Autor autor = repository.save(form.toModel());
        return ResponseEntity.ok().build();
    }
}
