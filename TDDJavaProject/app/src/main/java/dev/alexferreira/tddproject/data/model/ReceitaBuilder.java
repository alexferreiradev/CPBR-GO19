package dev.alexferreira.tddproject.data.model;

public class ReceitaBuilder {
    private String nome;
    private String descricao;
    private String link;

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
        return new Receita(nome, descricao, link);
    }
}