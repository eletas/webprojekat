package com.example.demo.configuration;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private TipKupcaRepository tipKupcaRepository;

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    private  KorisnikRepository korisnikRepository;

    @Bean
    public boolean instantiate(){

        Lokacija lokacija = new Lokacija();
        lokacija.setGeografskaDuzina(42.227);
        lokacija.setGeografskaSirina(14.524);
        lokacija.setAdresa("Strazilovska 14");
        lokacijaRepository.save(lokacija);

        Restoran restoran = new Restoran();
        restoran.setNazivRestorana("Pizza master");
        restoran.setTipRestorana("Italijanski");
        restoran.setLokacija(lokacija);
        restoranRepository.save(restoran);

        Artikal artikal = new Artikal();
        artikal.setNazivArtikla("Kapricoza");
        artikal.setCenaArtikla(1000.0);
        artikal.setTip(TipArtikla.JELO);
        artikal.setKolicinaArtikla(3.0);
        artikal.setOpisArtikla("XXL Kapricoza extra pecurke");
        artikal.setRestoran(restoran);
        artikalRepository.save(artikal);

        Artikal artikal2 = new Artikal();
        artikal.setNazivArtikla("Djavolja");
        artikal.setCenaArtikla(900.00);
        artikal.setTip(TipArtikla.JELO);
        artikal.setKolicinaArtikla(4.00);
        artikal.setOpisArtikla("Extra kulen i ljuti kecap");
        artikal.setRestoran(restoran);
        artikalRepository.save(artikal2);

        TipKupca tipKupca = new TipKupca();
        tipKupca.setTip(TipKupcaEnum.BRONZANI);
        tipKupca.setPopust(2.0);
        tipKupca.setTrazeniBrBodova(200.0);
        tipKupcaRepository.save(tipKupca);

        TipKupca tipKupca2 = new TipKupca();
        tipKupca2.setTip(TipKupcaEnum.SREBRNI);
        tipKupca2.setPopust(10.0);
        tipKupca2.setTrazeniBrBodova(400.0);
        tipKupcaRepository.save(tipKupca2);

        TipKupca tipKupca3 = new TipKupca();
        tipKupca3.setTip(TipKupcaEnum.ZLATNI);
        tipKupca3.setPopust(15.0);
        tipKupca3.setTrazeniBrBodova(600.0);
        tipKupcaRepository.save(tipKupca3);

        Korisnik korisnik = new Korisnik();
        korisnik.setIme("Igor");
        korisnik.setPrezime("Andjelkovic");
        korisnik.setPol(Pol.MUSKI);
        Date korisnikDatumRodjenja = new GregorianCalendar(1999,11,19).getTime();
        korisnik.setDatum(korisnikDatumRodjenja);
        korisnik.setKorisnickoIme("iggy");
        korisnik.setLozinka("iggy99");
        korisnik.setUloga(Uloga.ADMIN);
        korisnikRepository.save(korisnik);

        Menadzer menadzer = new Menadzer();
        menadzer.setIme("Marko");
        menadzer.setPrezime("Perovic");
        menadzer.setPol(Pol.MUSKI);
        Date menadzerDatumRodjenja = new GregorianCalendar(1998,10,16).getTime();
        menadzer.setDatum(menadzerDatumRodjenja);
        menadzer.setKorisnickoIme("markop");
        menadzer.setLozinka("markic1998");
        menadzer.setUloga(Uloga.MENADZER);
        menadzer.setRestoran(restoran);
        menadzerRepository.save(menadzer);

        Kupac kupac = new Kupac();
        kupac.setIme("Marija");
        kupac.setPrezime("Kesic");
        kupac.setPol(Pol.ZENSKI);
        Date kupacDatumRodjenja = new GregorianCalendar(1994,5,8).getTime();
        kupac.setDatum(kupacDatumRodjenja);
        kupac.setKorisnickoIme("marija");
        kupac.setLozinka("marijakk");
        kupac.setUloga(Uloga.KUPAC);
        kupac.setTipKupca(tipKupca);
        kupac.setBrBodova(219.0);
        kupacRepository.save(kupac);

        Dostavljac dostavljac = new Dostavljac();
        dostavljac.setIme("Darko");
        dostavljac.setPrezime("Lazic");
        dostavljac.setPol(Pol.MUSKI);
        Date datumRodjenja = new GregorianCalendar(2000,12,18).getTime();
        dostavljac.setDatum(datumRodjenja);
        dostavljac.setKorisnickoIme("darkol");
        dostavljac.setLozinka("prase");
        dostavljac.setUloga(Uloga.DOSTAVLJAC);
        dostavljacRepository.save(dostavljac);

        Set<Artikal> artikli = new HashSet<>();
        artikli.add(artikal);
        artikli.add(artikal2);

        Porudzbina porudzbina = new Porudzbina();
        porudzbina.setCenaPorudzbine(artikal.getCenaArtikla() + artikal2.getCenaArtikla());
        porudzbina.setStatus(Status.U_PRIPREMI);
        porudzbina.setVremeNarucivanja(new Date());
        porudzbina.setTrenutniKupac(kupac);
        porudzbina.setRestoran(restoran);
        porudzbina.setTrenutniDostavljac(dostavljac);
        porudzbina.setPoruceniArtikli(artikli);
        porudzbinaRepository.save(porudzbina);

        Set<Porudzbina> svePorudzbine = new HashSet<>();
        svePorudzbine.add(porudzbina);
        kupac.setPorudzbine(svePorudzbine);
        kupacRepository.save(kupac);

        Komentar komentar = new Komentar();
        komentar.setKupacKomentar(kupac);
        komentar.setKomentarisaniRestoran(restoran);
        komentar.setOcena(4);
        komentar.setTekstKomentara("Losa hrana, ne dolazite!");
        komentarRepository.save(komentar);




        return true;
    }
    }


