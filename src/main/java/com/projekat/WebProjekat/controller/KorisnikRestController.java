package main.java.com.projekat.WebProjekat.controller;

import main.java.com.projekat.WebProjekat.dto.*;
import main.java.com.projekat.WebProjekat.dto.MenadzerDto.NoviMenadzerDto;
import main.java.com.projekat.WebProjekat.dto.MenadzerDto.PrikazMenadzerDto;
import main.java.com.projekat.WebProjekat.entity.Dostavljac;
import main.java.com.projekat.WebProjekat.entity.Korisnik;
import main.java.com.projekat.WebProjekat.entity.Menadzer;
import main.java.com.projekat.WebProjekat.entity.Restoran;
import main.java.com.projekat.WebProjekat.service.KorisnikService;
import main.java.com.projekat.WebProjekat.service.RestoranService;
import main.java.com.projekat.WebProjekat.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class KorisnikRestController {
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private SessionService sessionService;

    @GetMapping("/api/korisnici")
    public ResponseEntity<List<KorisnikDto>> getKorisnici(HttpSession session){
        Boolean provera = sessionService.validateRole(session, "Admin");

        if(!provera){
            return new ResponseEntity("Nemate potrebne privilegije!",HttpStatus.BAD_REQUEST);
        }
        List<Korisnik> korisnici = this.korisnikService.findAll();

        List<KorisnikDto> dtos = new ArrayList<>();
        for(Korisnik k : korisnici){
            KorisnikDto dto = new KorisnikDto(k);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);

    }

    @GetMapping("/api/korisnici/ulogovanKorisnik")
    public ResponseEntity getUlogovan(HttpSession session){
        Korisnik ulogovanKorisnik = (Korisnik) session.getAttribute("user");

        if(ulogovanKorisnik == null){
            return new ResponseEntity("invalid", HttpStatus.FORBIDDEN);
        }

        KorisnikDto korisnikdto = new KorisnikDto(ulogovanKorisnik);

        return ResponseEntity.ok(korisnikdto);
    }

    @PutMapping("/api/korisnici/ulogovanKorisnik/izmeni")
    public ResponseEntity izmeniProfil(@RequestBody UpdateDto updateDto, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("user");

        if(updateDto.getKorisnickoIme() != null)
            korisnik.setKorisnickoIme(updateDto.getKorisnickoIme());
        if(updateDto.getLozinka() != null)
            korisnik.setLozinka(updateDto.getLozinka());
        if(updateDto.getIme() != null)
            korisnik.setIme(updateDto.getIme());
        if(updateDto.getPrezime() != null)
            korisnik.setPrezime(updateDto.getPrezime());
        if(updateDto.getPol() != null)
            korisnik.setPol(updateDto.getPol());
        if(updateDto.getDatumRodjenja() != null)
            korisnik.setDatumRodjenja(updateDto.getDatumRodjenja());

        return new ResponseEntity(korisnikService.save(korisnik, korisnik.getUloga()), HttpStatus.OK);
    }


}
