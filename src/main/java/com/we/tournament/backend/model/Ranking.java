package com.we.tournament.backend.model;

import java.util.Objects;

public class Ranking {
    private String id;
    private String categoria;
    private int nivel;

    public Ranking() {
    }

    public Ranking(String id, String categoria, int nivel) {
        this.id = id;
        this.categoria = categoria;
        this.nivel = nivel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ranking)) return false;
        Ranking ranking = (Ranking) o;
        return nivel == ranking.nivel &&
                Objects.equals(id, ranking.id) &&
                Objects.equals(categoria, ranking.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoria, nivel);
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "id='" + id + '\'' +
                ", categoria='" + categoria + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}