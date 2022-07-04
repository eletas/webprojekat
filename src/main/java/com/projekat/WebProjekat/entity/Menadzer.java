package main.java.com.projekat.WebProjekat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable {

    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datumRodjenja, Restoran restoran) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja);
        this.restoran = restoran;
        super.setUloga(Uloga.Menadzer);
    }
    public Menadzer(Korisnik k, Restoran restoran) {
        super(k.getKorisnickoIme(), k.getLozinka(), k.getIme(), k.getPrezime(), k.getPol(), k.getDatumRodjenja());
        this.restoran = restoran;
        super.setUloga(Uloga.Menadzer);
    }

    public Menadzer() {
        super();
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    @Override
    public String toString() {
        return "Menadzer{} " + super.toString();
    }
}
