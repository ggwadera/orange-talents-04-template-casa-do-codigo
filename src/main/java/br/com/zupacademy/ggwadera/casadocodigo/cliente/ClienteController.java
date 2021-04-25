package br.com.zupacademy.ggwadera.casadocodigo.cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteValidator clienteValidator;
	@PersistenceContext
	private EntityManager manager;

	public ClienteController(ClienteValidator clienteValidator) {
		this.clienteValidator = clienteValidator;
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(clienteValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid ClienteNovoDTO dto) {
		final Cliente cliente = dto.toModel(manager);
		manager.persist(cliente);
		return ResponseEntity.ok().build();
	}

}
