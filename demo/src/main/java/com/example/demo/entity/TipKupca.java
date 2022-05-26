package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TipKupca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipKupcaEnum tip;

    @Column
    private Double popust;

    @Column
    private Double trazeniBrBodova;

    @OneToMany(mappedBy = "tipKupca",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Kupac> kupac = new HashSet<>();


//--------------------------------------------------------------------------------------------------------------------//


    public TipKupca() {
    }

    public TipKupca(Long id, TipKupcaEnum tip, Double popust, Double trazeniBrBodova, Set<Kupac> kupac) {
        this.id = id;
        this.tip = tip;
        this.popust = popust;
        this.trazeniBrBodova = trazeniBrBodova;
        this.kupac = kupac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipKupcaEnum getTip() {
        return tip;
    }

    public void setTip(TipKupcaEnum tip) {
        this.tip = tip;
    }

    public Double getPopust() {
        return popust;
    }

    public void setPopust(Double popust) {
        this.popust = popust;
    }

    public Double getTrazeniBrBodova() {
        return trazeniBrBodova;
    }

    public void setTrazeniBrBodova(Double trazeniBrBodova) {
        this.trazeniBrBodova = trazeniBrBodova;
    }

    public Set<Kupac> getKupac() {
        return kupac;
    }

    public void setKupac(Set<Kupac> kupac) {
        this.kupac = kupac;
    }
}