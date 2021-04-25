package br.com.zupacademy.ggwadera.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	boolean existsById(Long id);

	boolean existsByIdAndPaisId(Long id, Long paisId);

}
