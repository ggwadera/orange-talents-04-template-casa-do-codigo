package br.com.zupacademy.ggwadera.casadocodigo.cliente;

import br.com.zupacademy.ggwadera.casadocodigo.estado.Estado;
import br.com.zupacademy.ggwadera.casadocodigo.pais.Pais;
import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.CPFOrCNPJ;
import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.ExistsId;
import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteNovoDTO {

	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@CPFOrCNPJ
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;

	@NotBlank
	private String telefone;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cep;

	@NotBlank
	private String cidade;

	private Long estadoId;

	@NotNull
	@ExistsId(domainClass = Pais.class)
	private Long paisId;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Cliente toModel(EntityManager manager) {
		final Pais pais = manager.find(Pais.class, paisId);
		final Estado estado = estadoId != null ? manager.find(Estado.class, estadoId) : null;
		return new Cliente.Builder()
			.email(email)
			.nome(nome)
			.sobrenome(sobrenome)
			.documento(documento)
			.telefone(telefone)
			.endereco(endereco)
			.complemento(complemento)
			.cep(cep)
			.cidade(cidade)
			.pais(pais)
			.estado(estado)
			.build();
	}

}
