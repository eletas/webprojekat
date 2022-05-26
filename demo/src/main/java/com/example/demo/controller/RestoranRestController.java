package com.example.demo.controller;

import com.example.demo.dto.RestoranDto;
import com.example.demo.entity.Komentar;
import com.example.demo.entity.Lokacija;
import com.example.demo.entity.Restoran;
import com.example.demo.entity.Status;
import com.example.demo.service.KomentarService;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.LokacijaService;
import com.example.demo.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestoranRestController {
    @Autowired
    private RestoranService restoranService;

    @Autowired
    LokacijaService lokacijaService;

    @Autowired
    KorisnikService korisnikService;

    @Autowired
    KomentarService komentarService;

    @PostMapping("/api/restoran/dodaj")
    public ResponseEntity<String> dodajRestoran(@RequestBody RestoranDto restoranDto) {

        if (restoranDto.getNaziv().isEmpty() || restoranDto.getTipRestorana().isEmpty()) {
            return new ResponseEntity("Niste dobro uneli podatke", HttpStatus.BAD_REQUEST);
        }

        Restoran restoran = new Restoran();
        restoran.setNazivRestorana(restoranDto.getNaziv());
        restoran.setTipRestorana(restoran.getTipRestorana());

        Lokacija lokacija = lokacijaService.getLokacijaById(restoranDto.getLokacijaId());
        restoran.setLokacija(lokacija);

        restoranService.saveRestoran(restoran);

        return ResponseEntity.ok("uspesno kreiran restoran");
    }

    @GetMapping("/api/restorani/{id}")
    public ResponseEntity<RestoranDto> getById(@PathVariable("id") Long id) {

        Restoran restoran = restoranService.findOne(id);
        List<Komentar> komentari = komentarService.getAllByRestoranId(id);

        RestoranDto restoranDto = new RestoranDto();
        restoranDto.setNaziv(restoran.getNazivRestorana());
        restoranDto.setTipRestorana(restoran.getTipRestorana());
        restoranDto.setLokacijaId(restoran.getLokacija().getId());
        restoranDto.setArtikli(restoran.getArtikliUPonudi());
        restoranDto.setKomentari(komentari);

        return ResponseEntity.ok(restoranDto);
    }

    @GetMapping("/api/restorani")
    public ResponseEntity<List<Restoran>> getRestorani() {
        List<Restoran> restorani = restoranService.getAll();
        return ResponseEntity.ok(restorani);
    }

    @GetMapping("/api/restorani/naziv/{naziv}")
    public ResponseEntity<Restoran> getByNaziv(@PathVariable String naziv) {
        Restoran restoran = restoranService.getByNaziv(naziv);
        return ResponseEntity.ok(restoran);
    }

    @GetMapping("/api/restorani/lokacija/{lokacijaId}")
    public ResponseEntity<Restoran> getByNaziv(@PathVariable("lokacijaId") Long lokacijaId) {
        Restoran restoran = restoranService.getByLokacija(lokacijaId);
        return ResponseEntity.ok(restoran);
    }

    @GetMapping("/api/restorani/tip/{tip}")
    public ResponseEntity<List<Restoran>> getByTip(@PathVariable("tip") String tip) {
        List<Restoran> restorani = restoranService.getByTip(tip);
        return ResponseEntity.ok(restorani);
    }





}
