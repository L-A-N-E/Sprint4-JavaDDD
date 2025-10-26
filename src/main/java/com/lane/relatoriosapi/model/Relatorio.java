package com.lane.relatoriosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String autor;
    private String crm;
    private LocalDate dataCriacao;
    private Double largura;
    private Double comprimento;
    private Double espessura;
    private LocalDate dataMedicao;
    private LocalTime horaMedicao;

    public Relatorio() {
    }

    public Relatorio(Long id, String titulo, String descricao, String autor, String crm, LocalDate dataCriacao, Double largura, Double comprimento, Double espessura, LocalDate dataMedicao, LocalTime horaMedicao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
        this.crm = crm;
        this.dataCriacao = dataCriacao;
        this.largura = largura;
        this.comprimento = comprimento;
        this.espessura = espessura;
        this.dataMedicao = dataMedicao;
        this.horaMedicao = horaMedicao;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAutor() {
        return autor;
    }

    public String getCrm() {
        return crm;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Double getLargura() {
        return largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public Double getEspessura() {
        return espessura;
    }

    public LocalDate getDataMedicao() {
        return dataMedicao;
    }

    public LocalTime getHoraMedicao() {
        return horaMedicao;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public void setEspessura(Double espessura) {
        this.espessura = espessura;
    }

    public void setDataMedicao(LocalDate dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public void setHoraMedicao(LocalTime horaMedicao) {
        this.horaMedicao = horaMedicao;
    }
}

