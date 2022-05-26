package com.example.demo.controller;


import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Uloga;
import com.example.demo.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/api")
    public String welcome() {
        return "Cao iz apija!";
    }

    @PostMapping("/api/registracija")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (registerDto.getKorisnickoIme().isEmpty() || registerDto.getLozinka().isEmpty() || registerDto.getIme().isEmpty() || registerDto.getPrezime().isEmpty()) {
            return new ResponseEntity("Niste dobro uneli podatke", HttpStatus.BAD_REQUEST);
        }

        if (korisnikService.getByKorisnickoIme(registerDto.getKorisnickoIme()) != null) {
            return new ResponseEntity("Korisnicko ime vec postoji", HttpStatus.BAD_REQUEST);
        }

        String uloga;

        if (registerDto.getUloga().isEmpty()) {
            uloga = Uloga.KUPAC.toString();
        } else {
            uloga = registerDto.getUloga();
        }

        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(registerDto.getKorisnickoIme());
        korisnik.setLozinka(registerDto.getLozinka());
        korisnik.setIme(registerDto.getIme());
        korisnik.setPrezime(registerDto.getPrezime());
        //korisnik.setPol(registerDto.getPol());
        //korisnik.setDatum(registerDto.getDatumRodjenja());
        //korisnik.setUloga(registerDto.setUloga());
        korisnikService.registerKorisnik(korisnik);

        return ResponseEntity.ok("uspesna registracija");

    }

    @PostMapping("/api/prijava")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session) {
        if (loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty()) {
            return new ResponseEntity("Niste dobro uneli podatke", HttpStatus.BAD_REQUEST);
        }

        Korisnik prijavljeniKorisnik = new Korisnik();
        if (prijavljeniKorisnik == null)
            return new ResponseEntity<>("korisnik ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", prijavljeniKorisnik);
        return ResponseEntity.ok("Uspesna prijava");
    }

    @PostMapping("api/odjava")
    public ResponseEntity logout(HttpSession session){
        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (prijavljeniKorisnik == null)
            return new ResponseEntity("Zabranjeno", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("uspesna odjava", HttpStatus.OK);
    }

    @GetMapping("/api/korisnici")
    public ResponseEntity<List<KorisnikDto>> getKorisnici(HttpSession session){
        List<Korisnik> korisnici = korisnikService.findAll();

        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(prijavljeniKorisnik == null) {
            System.out.println("Nema sesije");
        } else {
            System.out.println(prijavljeniKorisnik);
        }

        List<KorisnikDto> dtos = new ArrayList<>();
        for(Korisnik korisnik : korisnici){
            KorisnikDto dto = new KorisnikDto(korisnik.getKorisnickoIme(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getDatum(), korisnik.getPol(), korisnik.getUloga());
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/api/korisnici/{id}")
    public Korisnik getKorisnik(@PathVariable(name = "id") Long id, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        //System.out.println(korisnik.getFirstname());
        //session.invalidate();
        return korisnikService.findOne(id);
    }

    @PostMapping("/api/edit")
    public String editKorisnik(@RequestBody Korisnik korisnik) {
        Korisnik editKorisnik = korisnikService.getByKorisnickoIme(korisnik.getKorisnickoIme());
        editKorisnik.setIme(korisnik.getIme());
        editKorisnik.setPrezime(korisnik.getPrezime());
        editKorisnik.setDatum(korisnik.getDatum());
        editKorisnik.setPol(korisnik.getPol());
        editKorisnik.setLozinka(korisnik.getLozinka());
        this.korisnikService.save(editKorisnik);
        return "uspesno sacuvano";
    }





}
