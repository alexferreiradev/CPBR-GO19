package dev.alexferreira.tddproject.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Receita {

    @PrimaryKey
    private Long id;
    @ColumnInfo
    private String nome;
    @ColumnInfo
    private String descricao;
    @ColumnInfo
    private String link;

    Receita(Long id, String nome, String descricao, String link) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receita receita = (Receita) o;

        if (id != null ? !id.equals(receita.id) : receita.id != null) return false;
        if (nome != null ? !nome.equals(receita.nome) : receita.nome != null) return false;
        if (descricao != null ? !descricao.equals(receita.descricao) : receita.descricao != null)
            return false;
        return link != null ? link.equals(receita.link) : receita.link == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Receita{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
