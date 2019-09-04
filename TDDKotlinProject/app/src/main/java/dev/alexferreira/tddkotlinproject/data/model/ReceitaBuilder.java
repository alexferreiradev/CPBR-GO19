package dev.alexferreira.tddkotlinproject.data.model;

public class ReceitaBuilder {
    private Long id;
    private String nome;
    private String descricao;
    private String link;

    public ReceitaBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ReceitaBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ReceitaBuilder setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ReceitaBuilder setLink(String link) {
        this.link = link;
        return this;
    }

    public Receita createReceita() {
        return new Receita(id, nome, descricao, link);
    }
}