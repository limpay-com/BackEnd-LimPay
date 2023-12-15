package br.com.limpay.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titutlo;
    private boolean completo;

    @ManyToOne
    private Curso curso;

    public String getTitutlo() {
        return titutlo;
    }

    public void setTitutlo(String titutlo) {
        this.titutlo = titutlo;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Video() {
    }

    public Video(String titutlo, boolean completo, Curso curso) {
        this.titutlo = titutlo;
        this.completo = completo;
        this.curso = curso;
    }
}