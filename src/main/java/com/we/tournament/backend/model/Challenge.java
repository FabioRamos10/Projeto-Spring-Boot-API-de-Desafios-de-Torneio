package com.we.tournament.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Challenge {

    @Id
    private String id;

    private String titulo;
    private LocalDate data;
    private String jogadorDesafianteId;
    private String jogadorDesafiadoId;
    private String status;

    public Challenge() {
    }

    public Challenge(String id, String titulo, LocalDate data, String jogadorDesafianteId, String jogadorDesafiadoId, String status) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.jogadorDesafianteId = jogadorDesafianteId;
        this.jogadorDesafiadoId = jogadorDesafiadoId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getJogadorDesafianteId() {
        return jogadorDesafianteId;
    }

    public void setJogadorDesafianteId(String jogadorDesafianteId) {
        this.jogadorDesafianteId = jogadorDesafianteId;
    }

    public String getJogadorDesafiadoId() {
        return jogadorDesafiadoId;
    }

    public void setJogadorDesafiadoId(String jogadorDesafiadoId) {
        this.jogadorDesafiadoId = jogadorDesafiadoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Challenge)) return false;
        Challenge that = (Challenge) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo);
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", data=" + data +
                ", jogadorDesafianteId='" + jogadorDesafianteId + '\'' +
                ", jogadorDesafiadoId='" + jogadorDesafiadoId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
