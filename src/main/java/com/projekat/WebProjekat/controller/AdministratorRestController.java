package main.java.com.projekat.WebProjekat.controller;

import main.java.com.projekat.WebProjekat.dto.MenadzerDto.NoviMenadzerDto;
import main.java.com.projekat.WebProjekat.dto.NoviDostavljacDto;
import main.java.com.projekat.WebProjekat.entity.Dostavljac;
import main.java.com.projekat.WebProjekat.entity.Menadzer;
import main.java.com.projekat.WebProjekat.service.KorisnikService;
import main.java.com.projekat.WebProjekat.service.RestoranService;
import main.java.com.projekat.WebProjekat.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class AdministratorRestController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private RestoranService restoranService;


    @Autowired
    private SessionService sessionService;

    @PostMapping("/api/korisnici/dodaj/menadzer")
    public ResponseEntity dodajMenadzera(HttpSession session, @RequestBody NoviMenadzerDto dto) throws ParseException {
        Boolean provera = sessionService.validateRole(session, "Admin");

        if(!provera){
            return new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        if(korisnikService.containsKorisnickoIme(dto.getKorisnickoIme())){
            return new ResponseEntity("Uneto korisnicko ime vec postoji.",HttpStatus.BAD_REQUEST);
        }

        Date datum = new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDatumRodjenja());
        Menadzer menadzer = new Menadzer(dto.getKorisnickoIme(), dto.getLozinka(), dto.getIme(), dto.getPrezime(), dto.getPol(), datum, restoranService.findOneByNaziv(dto.getNazivRestorana()));

        korisnikService.save(menadzer, menadzer.getUloga());

        return new ResponseEntity("Uspesno dodat menadzer!" , HttpStatus.OK);
    }

    @PostMapping("/api/korisnici/dodaj/dostavljac")
    public ResponseEntity dodajDostavljaca(HttpSession session,@RequestBody NoviDostavljacDto dto) throws ParseException {
        Boolean provera = sessionService.validateRole(session, "Admin");

        if(!provera){
            return new ResponseEntity("Nemate potrebne privilegije!",HttpStatus.BAD_REQUEST);
        }

        if(korisnikService.containsKorisnickoIme(dto.getKorisnickoIme())){
            return new ResponseEntity("Uneto korisnicko ime vec postoji.",HttpStatus.BAD_REQUEST);
        }

        Date datum = new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDatumRodjenja());
        Dostavljac dostavljac = new Dostavljac(dto.getKorisnickoIme(), dto.getLozinka(), dto.getIme(), dto.getPrezime(), dto.getPol(), datum);

        korisnikService.save(dostavljac, dostavljac.getUloga());

        return new ResponseEntity("Uspesno dodat dostavljac!" , HttpStatus.OK);
    }
}
