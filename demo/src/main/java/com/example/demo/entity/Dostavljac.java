package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dostavljac extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //private String porudzbine;  //one to many veza  !?!
    @OneToMany(mappedBy = "trenutniDostavljac",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Porudzbina> porudzbine = new HashSet<>();

//--------------------------------------------------------------------------------------------------------------------//

    public Dostavljac() {
    }

    public Dostavljac(Long id, String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datum, Uloga uloga, Long id1, Set<Porudzbina> porudzbine) {
        super(id, korisnickoIme, lozinka, ime, prezime, pol, datum, uloga);
        this.id = id1;
        this.porudzbine = porudzbine;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }

    @Override
    public String toString() {
        return "Dostavljac{" +
                "id=" + id +
                ", porudzbine=" + porudzbine +
                '}';
    }
}
