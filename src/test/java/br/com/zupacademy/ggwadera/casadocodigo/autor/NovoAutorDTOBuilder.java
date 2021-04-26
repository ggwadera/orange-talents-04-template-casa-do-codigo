package br.com.zupacademy.ggwadera.casadocodigo.autor;

public final class NovoAutorDTOBuilder {
    private String email;
    private String nome;
    private String descricao;

    private NovoAutorDTOBuilder() {
    }

    public static NovoAutorDTOBuilder aNovoAutorDTO() {
        return new NovoAutorDTOBuilder();
    }

    public NovoAutorDTOBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public NovoAutorDTOBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public NovoAutorDTOBuilder withDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public NovoAutorDTO build() {
        NovoAutorDTO novoAutorDTO = new NovoAutorDTO();
        novoAutorDTO.setEmail(email);
        novoAutorDTO.setNome(nome);
        novoAutorDTO.setDescricao(descricao);
        return novoAutorDTO;
    }
}
