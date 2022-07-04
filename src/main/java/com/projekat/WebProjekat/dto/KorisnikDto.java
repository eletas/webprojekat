package main.java.com.projekat.WebProjekat.dto;

import main.java.com.projekat.WebProjekat.entity.Korisnik;
import main.java.com.projekat.WebProjekat.entity.Pol;
import main.java.com.projekat.WebProjekat.entity.Uloga;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KorisnikDto {
    private String korisnickoIme;

    private String ime;

    private String prezime;

    private Pol pol;

    private String datumRodjenja;

    private Uloga uloga;

    public KorisnikDto(String korisnickoIme, String ime, String prezime, Pol pol, Date datumRodjenja) {
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");
        this.datumRodjenja = dateFormat.format(datumRodjenja);
    }

    public KorisnikDto(Korisnik korisnik) {
        this.korisnickoIme = korisnik.getKorisnickoIme();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.pol = korisnik.getPol();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.datumRodjenja = dateFormat.format(korisnik.getDatumRodjenja());
        this.uloga = korisnik.getUloga();
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.datumRodjenja = dateFormat.format(datumRodjenja);
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }
}
