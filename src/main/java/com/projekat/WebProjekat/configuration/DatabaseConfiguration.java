package main.java.com.projekat.WebProjekat.configuration;

import main.java.com.projekat.WebProjekat.entity.*;
import main.java.com.projekat.WebProjekat.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private TipKupcaRepository tipKupcaRepository;

    @Bean
    public boolean instantiate(){

        Korisnik admin = new Korisnik();
        admin.setKorisnickoIme("admin");
        admin.setLozinka("admin123");
        admin.setIme("Admin");
        admin.setPrezime("Adminovic");
        admin.setPol(Pol.Musko);
        admin.setDatumRodjenja(new Date(101, Calendar.JULY, 4));
        admin.setUloga(Uloga.Admin);
        korisnikRepository.save(admin);

        Dostavljac dostavljac1 = new Dostavljac();
        dostavljac1.setKorisnickoIme("iggy");
        dostavljac1.setLozinka("iggy123");
        dostavljac1.setIme("Igor");
        dostavljac1.setPrezime("Andjelkovic");
        dostavljac1.setPol(Pol.Musko);
        dostavljac1.setDatumRodjenja(new Date(101, Calendar.JULY, 4));
        dostavljac1.setUloga(Uloga.Dostavljac);
        dostavljacRepository.save(dostavljac1);

        TipKupca tip1 = new TipKupca();
        tip1.setIme("zlatni");
        tip1.setPopust(20);
        tip1.setTrazeniBrojBodova(5);
        tipKupcaRepository.save(tip1);

        Lokacija lokacija1 = new Lokacija();
        lokacija1.setGeografskaDuzina(100.5);
        lokacija1.setGeografskaSirina(94);
        lokacija1.setAdresa("Bulevar Cara Lazara");
        lokacijaRepository.save(lokacija1);

        Lokacija lokacija2 = new Lokacija();
        lokacija2.setGeografskaDuzina(200.5);
        lokacija2.setGeografskaSirina(340.6);
        lokacija2.setAdresa("Jevrejska 15");
        lokacijaRepository.save(lokacija2);

        Restoran restoran1 = new Restoran();
        restoran1.setNaziv("Sokace");
        restoran1.setTipRestorana("kafana");
        restoran1.setLokacija(lokacija1);
        restoranRepository.save(restoran1);

        Restoran restoran2 = new Restoran();
        restoran2.setNaziv("Makijato fax");
        restoran2.setTipRestorana("kafic");
        restoran2.setLokacija(lokacija2);
        restoranRepository.save(restoran2);

        Kupac kupac1 = new Kupac();
        kupac1.setKorisnickoIme("pera");
        kupac1.setLozinka("1234");
        kupac1.setIme("Pera");
        kupac1.setPrezime("Peric");
        kupac1.setPol(Pol.Musko);
        kupac1.setDatumRodjenja(new Date(99, Calendar.JULY, 4));
        kupac1.setTipKupca(tip1);
        kupac1.setBrojSakupljenihBodova(20);
        kupac1.setUloga(Uloga.Kupac);
        kupacRepository.save(kupac1);
        ;
        Kupac kupac2 = new Kupac();
        kupac2.setKorisnickoIme("mika");
        kupac2.setLozinka("3004");
        kupac2.setIme("Mika");
        kupac2.setPrezime("Mikic");
        kupac2.setPol(Pol.Zenski);
        kupac2.setDatumRodjenja(new Date(89, Calendar.SEPTEMBER, 27));
        kupac2.setTipKupca(tip1);
        kupac2.setBrojSakupljenihBodova(20);
        kupac2.setUloga(Uloga.Kupac);
        kupacRepository.save(kupac2);

        Artikal artikal1 = new Artikal();
        artikal1.setNaziv("Coca-cola");
        artikal1.setCena(70);
        artikal1.setTip(Tip.pice);
        artikal1.setKolicina(20);
        artikal1.setOpis("gazirani sok");
        artikal1.setRestoran(restoran1);
        artikalRepository.save(artikal1);

        Artikal artikal2 = new Artikal();
        artikal2.setNaziv("Becka snicla");
        artikal2.setCena(300);
        artikal2.setTip(Tip.jelo);
        artikal2.setKolicina(20);
        artikal2.setOpis("pohovano meso");
        artikal2.setRestoran(restoran2);
        artikalRepository.save(artikal1);

        Menadzer menadzer1 = new Menadzer();
        menadzer1.setKorisnickoIme("strahinja");
        menadzer1.setLozinka("1111");
        menadzer1.setIme("Strahinja");
        menadzer1.setPrezime("Eleta");
        menadzer1.setPol(Pol.Musko);
        menadzer1.setDatumRodjenja(new Date(93, Calendar.FEBRUARY, 16));
        menadzer1.setRestoran(restoran1);
        menadzerRepository.save(menadzer1);

        Komentar komentar1 = new Komentar();
        komentar1.setRestoranKomentar(restoran1);
        komentar1.setKupacKomentar(kupac1);
        komentar1.setTekstKomentara("Sve preporuke");
        komentar1.setOcena(10);
        komentarRepository.save(komentar1);


        Komentar komentar2 = new Komentar();
        komentar2.setRestoranKomentar(restoran2);
        komentar2.setKupacKomentar(kupac2);
        komentar2.setTekstKomentara("Odlicna hrana");
        komentar2.setOcena(9);
        komentarRepository.save(komentar2);


        return true;
    }
}
