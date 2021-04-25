package br.com.zupacademy.ggwadera.casadocodigo.cliente;

import br.com.zupacademy.ggwadera.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.ggwadera.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ClienteValidator implements Validator {

	private final EstadoRepository estadoRepository;
	private final PaisRepository paisRepository;

	@Autowired
	public ClienteValidator(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteNovoDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) return;
		final ClienteNovoDTO dto = (ClienteNovoDTO) target;
		if (paisRepository.countEstadosById(dto.getPaisId()) == 0) return;
		if (dto.getEstadoId() == null) {
			errors.rejectValue("estadoId", null, "estado deve ser especificado");
		} else if (!estadoRepository.existsById(dto.getEstadoId())) {
			errors.rejectValue("estadoId", null, "não foi encontrado nenhum estado com esse id");
		} else if (!estadoRepository.existsByIdAndPaisId(dto.getEstadoId(), dto.getPaisId())) {
			errors.rejectValue("estadoId", null, "estado não pertence ao país selecionado");
		}
	}


}
