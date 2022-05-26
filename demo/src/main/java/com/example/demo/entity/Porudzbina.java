package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Porudzbina implements Serializable {
    @Id
    @GeneratedValue (generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @OneToMany(mappedBy = "porudzbina")
    private Set<Artikal> poruceniArtikli = new HashSet<>();  //one to many

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Restoran restoran;

    @Column
    private Date vremeNarucivanja;

    @Column
    private Double cenaPorudzbine;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Kupac trenutniKupac;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Dostavljac trenutniDostavljac;

    @Enumerated(EnumType.STRING)
    private Status status;

//--------------------------------------------------------------------------------------------------------------------//

    public Porudzbina() {
    }

    public Porudzbina(UUID id, Set<Artikal> poruceniArtikli, Restoran restoran, Date vremeNarucivanja, Double cenaPorudzbine, Kupac trenutniKupac, Dostavljac trenutniDostavljac, Status status) {
        this.id = id;
        this.poruceniArtikli = poruceniArtikli;
        this.restoran = restoran;
        this.vremeNarucivanja = vremeNarucivanja;
        this.cenaPorudzbine = cenaPorudzbine;
        this.trenutniKupac = trenutniKupac;
        this.trenutniDostavljac = trenutniDostavljac;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<Artikal> getPoruceniArtikli() {
        return poruceniArtikli;
    }

    public void setPoruceniArtikli(Set<Artikal> poruceniArtikli) {
        this.poruceniArtikli = poruceniArtikli;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Date getVremeNarucivanja() {
        return vremeNarucivanja;
    }

    public void setVremeNarucivanja(Date vremeNarucivanja) {
        this.vremeNarucivanja = vremeNarucivanja;
    }

    public Double getCenaPorudzbine() {
        return cenaPorudzbine;
    }

    public void setCenaPorudzbine(Double cenaPorudzbine) {
        this.cenaPorudzbine = cenaPorudzbine;
    }

    public Kupac getTrenutniKupac() {
        return trenutniKupac;
    }

    public void setTrenutniKupac(Kupac trenutniKupac) {
        this.trenutniKupac = trenutniKupac;
    }

    public Dostavljac getTrenutniDostavljac() {
        return trenutniDostavljac;
    }

    public void setTrenutniDostavljac(Dostavljac trenutniDostavljac) {
        this.trenutniDostavljac = trenutniDostavljac;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}