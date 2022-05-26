package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Lokacija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double geografskaDuzina;

    @Column
    private Double geografskaSirina;

    @Column
    private String adresa;

//--------------------------------------------------------------------------------------------------------------------//


    public Lokacija() {
    }

    public Lokacija(Long id, Double geografskaDuzina, Double geografskaSirina, String adresa) {
        this.id = id;
        this.geografskaDuzina = geografskaDuzina;
        this.geografskaSirina = geografskaSirina;
        this.adresa = adresa;
    }

    public Long getId() {
        return id;
    }

    public Double getGeografskaDuzina() {
        return geografskaDuzina;
    }

    public Double getGeografskaSirina() {
        return geografskaSirina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGeografskaDuzina(Double geografskaDuzina) {
        this.geografskaDuzina = geografskaDuzina;
    }

    public void setGeografskaSirina(Double geografskaSirina) {
        this.geografskaSirina = geografskaSirina;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Lokacija{" +
                "id=" + id +
                ", geografskaDuzina=" + geografskaDuzina +
                ", geografskaSirina=" + geografskaSirina +
                ", adresa='" + adresa + '\'' +
                '}';
    }

}