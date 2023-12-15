package br.com.limpay.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
