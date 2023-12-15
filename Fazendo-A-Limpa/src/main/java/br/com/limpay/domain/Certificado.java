package br.com.limpay.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User usario;

    @OneToOne
    private Curso curso;

    public User getUsario() {
        return usario;
    }

    public void setUsario(User usario) {
        this.usario = usario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Certificado() {
    }

    public Certificado(User usario, Curso curso) {
        this.usario = usario;
        this.curso = curso;
    }
}
