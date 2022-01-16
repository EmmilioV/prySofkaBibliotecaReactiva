package com.sofka.bibliotecaReactiva.models;

import java.time.LocalDate;
import java.util.Objects;

public class RecursoDto {
    private String id;
    private String nombre;
    private LocalDate ultimaFechaPrestamo;
    private Boolean disponible;
    private String tipo;
    private String tematica;

    public RecursoDto() {
    }

    public RecursoDto(String nombre, LocalDate ultimaFechaPrestamo, Boolean disponible, String tipo, String tematica) {
        this.nombre = nombre;
        this.ultimaFechaPrestamo = ultimaFechaPrestamo;
        this.disponible = disponible;
        this.tipo = tipo;
        this.tematica = tematica;
    }

    public RecursoDto(String id, String nombre, LocalDate ultimaFechaPrestamo, Boolean disponible, String tipo, String tematica) {
        this.id = id;
        this.nombre = nombre;
        this.ultimaFechaPrestamo = ultimaFechaPrestamo;
        this.disponible = disponible;
        this.tipo = tipo;
        this.tematica = tematica;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getUltimaFechaPrestamo() {
        return ultimaFechaPrestamo;
    }

    public void setUltimaFechaPrestamo(LocalDate ultimaFechaPrestamo) {
        this.ultimaFechaPrestamo = ultimaFechaPrestamo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        return "RecursoDto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ultimaFechaPrestamo=" + ultimaFechaPrestamo +
                ", disponible=" + disponible +
                ", tipo='" + tipo + '\'' +
                ", tematica='" + tematica + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoDto that = (RecursoDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(ultimaFechaPrestamo, that.ultimaFechaPrestamo) && Objects.equals(disponible, that.disponible) && Objects.equals(tipo, that.tipo) && Objects.equals(tematica, that.tematica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, ultimaFechaPrestamo, disponible, tipo, tematica);
    }
}