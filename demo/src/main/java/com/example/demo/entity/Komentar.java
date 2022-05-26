package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Komentar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @OneToOne(cascade = CascadeType.ALL) //many to one
    @ManyToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
    private Kupac kupacKomentar;

    // OneToOne(cascade = CascadeType.ALL)  //many to one
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Restoran komentarisaniRestoran;

    @Column
    private String tekstKomentara;

    @Column
    private int ocena;

//--------------------------------------------------------------------------------------------------------------------//

    public Komentar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kupac getKupacKomentar() {
        return kupacKomentar;
    }

    public void setKupacKomentar(Kupac kupacKomentar) {
        this.kupacKomentar = kupacKomentar;
    }

    public Restoran getKomentarisaniRestoran() {
        return komentarisaniRestoran;
    }

    public void setKomentarisaniRestoran(Restoran komentarisaniRestoran) {
        this.komentarisaniRestoran = komentarisaniRestoran;
    }

    public String getTekstKomentara() {
        return tekstKomentara;
    }

    public void setTekstKomentara(String tekstKomentara) {
        this.tekstKomentara = tekstKomentara;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "Komentar{" +
                "id=" + id +
                ", kupacKomentar=" + kupacKomentar +
                ", komentarisaniRestoran=" + komentarisaniRestoran +
                ", tekstKomentara='" + tekstKomentara + '\'' +
                ", ocena=" + ocena +
                '}';
    }
}
