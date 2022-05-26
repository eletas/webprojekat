package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restoran implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nazivRestorana;

    @Column
    private String tipRestorana;

    @OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL)//one to many
    private Set<Artikal> artikliUPonudi = new HashSet<>();  //dodati klasu koja spaja


    @OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Porudzbina> porudzbine = new HashSet<>();

    @OneToMany(mappedBy = "komentarisaniRestoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Komentar> komentar = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "lokacija_id")
    private Lokacija lokacija;


//--------------------------------------------------------------------------------------------------------------------//

    public Restoran() {
    }

    public Restoran(Long id, String nazivRestorana, String tipRestorana, Set<Artikal> artikliUPonudi, Set<Porudzbina> porudzbine, Set<Komentar> komentar, Lokacija lokacija) {
        this.id = id;
        this.nazivRestorana = nazivRestorana;
        this.tipRestorana = tipRestorana;
        this.artikliUPonudi = artikliUPonudi;
        this.porudzbine = porudzbine;
        this.komentar = komentar;
        this.lokacija = lokacija;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivRestorana() {
        return nazivRestorana;
    }

    public void setNazivRestorana(String nazivRestorana) {
        this.nazivRestorana = nazivRestorana;
    }

    public String getTipRestorana() {
        return tipRestorana;
    }

    public void setTipRestorana(String tipRestorana) {
        this.tipRestorana = tipRestorana;
    }

    public Set<Artikal> getArtikliUPonudi() {
        return artikliUPonudi;
    }

    public void setArtikliUPonudi(Set<Artikal> artikliUPonudi) {
        this.artikliUPonudi = artikliUPonudi;
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }

    public Set<Komentar> getKomentar() {
        return komentar;
    }

    public void setKomentar(Set<Komentar> komentar) {
        this.komentar = komentar;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
}