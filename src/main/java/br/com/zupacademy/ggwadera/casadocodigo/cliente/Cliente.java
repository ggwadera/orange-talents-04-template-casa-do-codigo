package br.com.zupacademy.ggwadera.casadocodigo.cliente;

import br.com.zupacademy.ggwadera.casadocodigo.estado.Estado;
import br.com.zupacademy.ggwadera.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	private String nome;
	private String sobrenome;
	private String documento;
	private String telefone;
	private String endereco;
	private String complemento;
	private String cep;
	private String cidade;

	@ManyToOne
	private Estado estado;

	@ManyToOne
	private Pais pais;

	@Deprecated
	public Cliente() {
	}

	public Cliente(Builder builder) {
		this.email = builder.email;
		this.nome = builder.nome;
		this.sobrenome = builder.sobrenome;
		this.documento = builder.documento;
		this.telefone = builder.telefone;
		this.endereco = builder.endereco;
		this.complemento = builder.complemento;
		this.cep = builder.cep;
		this.cidade = builder.cidade;
		this.estado = builder.estado;
		this.pais = builder.pais;
	}

	public Long getId() {
		return id;
	}

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

	public Estado getEstado() {
		return estado;
	}

	public Pais getPais() {
		return pais;
	}

	public static class Builder {
		private String email;
		private String nome;
		private String sobrenome;
		private String documento;
		private String telefone;
		private String endereco;
		private String complemento;
		private String cep;
		private String cidade;
		private Estado estado;
		private Pais pais;

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public Builder sobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
			return this;
		}

		public Builder documento(String documento) {
			this.documento = documento;
			return this;
		}

		public Builder telefone(String telefone) {
			this.telefone = telefone;
			return this;
		}

		public Builder endereco(String endereco) {
			this.endereco = endereco;
			return this;
		}

		public Builder complemento(String complemento) {
			this.complemento = complemento;
			return this;
		}

		public Builder cep(String cep) {
			this.cep = cep;
			return this;
		}

		public Builder cidade(String cidade) {
			this.cidade = cidade;
			return this;
		}

		public Builder estado(Estado estado) {
			this.estado = estado;
			return this;
		}

		public Builder pais(Pais pais) {
			this.pais = pais;
			return this;
		}

		public Cliente build() {
			return new Cliente(this);
		}
	}

}
