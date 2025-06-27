package com.we.tournament.backend.dto;

import java.time.LocalDate;

public class ChallengeDTO {
    private String id;
    private String titulo;
    private LocalDate data;
    private String jogadorDesafianteId;
    private String jogadorDesafiadoId;
    private String status;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public String getJogadorDesafianteId() { return jogadorDesafianteId; }
    public void setJogadorDesafianteId(String jogadorDesafianteId) { this.jogadorDesafianteId = jogadorDesafianteId; }

    public String getJogadorDesafiadoId() { return jogadorDesafiadoId; }
    public void setJogadorDesafiadoId(String jogadorDesafiadoId) { this.jogadorDesafiadoId = jogadorDesafiadoId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
