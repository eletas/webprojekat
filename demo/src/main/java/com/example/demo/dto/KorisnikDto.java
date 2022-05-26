package com.example.demo.dto;

import com.example.demo.entity.Pol;
import com.example.demo.entity.Uloga;

import java.util.Date;

public class KorisnikDto {

    private String korisnickoIme;
    private String ime;
    private String prezime;
    private String datumRodjenja;
    private String pol;
    private String uloga;

    public KorisnikDto() {
    }

    public KorisnikDto(String korisnickoIme, String ime, String prezime, String datumRodjenja, String pol, String uloga) {
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.uloga = uloga;
    }

    public KorisnikDto(String korisnickoIme, String ime, String prezime, Date datum, Pol pol, Uloga uloga) {
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

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
}
