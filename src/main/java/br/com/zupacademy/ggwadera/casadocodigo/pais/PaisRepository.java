package br.com.zupacademy.ggwadera.casadocodigo.pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	@Query("select count(*) from Pais p right outer join Estado e on p = e.pais where p.id = :id")
	int countEstadosById(@Param("id") Long id);

}
