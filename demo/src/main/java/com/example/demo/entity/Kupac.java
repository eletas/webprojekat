package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column
    //private String svePorudzbine;

    @Column
    private double brBodova;

    //private String tipKupca;   //veza sa tip kupca many to one
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private TipKupca tipKupca;

    @OneToMany(mappedBy = "trenutniKupac",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Porudzbina> porudzbine = new HashSet<>();

    @OneToMany(mappedBy = "kupacKomentar", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Komentar> komentar = new HashSet<>();

//--------------------------------------------------------------------------------------------------------------------//


    public Kupac() {
    }

    public Kupac(Long id, String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datum, Uloga uloga, Long id1, double brBodova, TipKupca tipKupca, Set<Porudzbina> porudzbine, Set<Komentar> komentar) {
        super(id, korisnickoIme, lozinka, ime, prezime, pol, datum, uloga);
        this.id = id1;
        this.brBodova = brBodova;
        this.tipKupca = tipKupca;
        this.porudzbine = porudzbine;
        this.komentar = komentar;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public double getBrBodova() {
        return brBodova;
    }

    public void setBrBodova(double brBodova) {
        this.brBodova = brBodova;
    }

    public TipKupca getTipKupca() {
        return tipKupca;
    }

    public void setTipKupca(TipKupca tipKupca) {
        this.tipKupca = tipKupca;
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

    @Override
    public String toString() {
        return "Kupac{" +
                "id=" + id +
                ", brBodova=" + brBodova +
                ", tipKupca=" + tipKupca +
                ", porudzbine=" + porudzbine +
                ", komentar=" + komentar +
                '}';
    }
}
