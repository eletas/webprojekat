package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artikal implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nazivArtikla;

    @Column
    private Double cenaArtikla;

    @Enumerated(EnumType.STRING)
    private TipArtikla tip;

    @Column
    private Double kolicinaArtikla; //double

    @Column
    private String opisArtikla;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Restoran restoran;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Porudzbina porudzbina;


//--------------------------------------------------------------------------------------------------------------------//

    public Artikal() {
    }

    public Artikal(Long id, String nazivArtikla, Double cenaArtikla, Double kolicinaArtikla, String opisArtikla,TipArtikla tip) {
        this.id = id;
        this.nazivArtikla = nazivArtikla;
        this.cenaArtikla = cenaArtikla;
        this.kolicinaArtikla = kolicinaArtikla;
        this.opisArtikla = opisArtikla;
        this.tip = tip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }

    public Double getCenaArtikla() {
        return cenaArtikla;
    }

    public void setCenaArtikla(Double cenaArtikla) {
        this.cenaArtikla = cenaArtikla;
    }

    public Double getKolicinaArtikla() {
        return kolicinaArtikla;
    }

    public void setKolicinaArtikla(Double kolicinaArtikla) {
        this.kolicinaArtikla = kolicinaArtikla;
    }

    public String getOpisArtikla() {
        return opisArtikla;
    }

    public void setOpisArtikla(String opisArtikla) {
        this.opisArtikla = opisArtikla;
    }

    public TipArtikla getTip() {
        return tip;
    }

    public void setTip(TipArtikla tip) {
        this.tip = tip;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }

    @Override
    public String toString() {
        return "Artikal{" +
                "id=" + id +
                ", nazivArtikla='" + nazivArtikla + '\'' +
                ", cenaArtikla=" + cenaArtikla +
                ", kolicinaArtikla=" + kolicinaArtikla +
                ", opisArtikla='" + opisArtikla + '\'' +
                ", restoran=" + restoran +
                '}';
    }

}
