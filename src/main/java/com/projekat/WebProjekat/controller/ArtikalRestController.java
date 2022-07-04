package main.java.com.projekat.WebProjekat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.projekat.WebProjekat.dto.ArtikalDto.ArtikalDto;
import main.java.com.projekat.WebProjekat.entity.Artikal;
import main.java.com.projekat.WebProjekat.entity.Menadzer;
import main.java.com.projekat.WebProjekat.entity.Restoran;
import main.java.com.projekat.WebProjekat.service.ArtikalService;
import main.java.com.projekat.WebProjekat.service.RestoranService;
import main.java.com.projekat.WebProjekat.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RestController
public class ArtikalRestController {
    @Autowired
    private ArtikalService artikalService;

    @Autowired
    private SessionService sessionService;

    @PostMapping("/api/artikli/dodajArtikal")
    public ResponseEntity<Artikal> dodajArtikal(@RequestBody ArtikalDto artikalDto, HttpSession session) throws JsonProcessingException {
        Boolean proveraSesije = sessionService.validateRole(session, "Menadzer");

        if(!proveraSesije){
            return new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        if(artikalDto.getNaziv().isEmpty() || artikalDto.getCena() <= 0 || artikalDto.getTip() == null){
            return new ResponseEntity("Ova polja ne smeju biti prazna!", HttpStatus.BAD_REQUEST);
        }


        Menadzer menadzer = (Menadzer) session.getAttribute("user");

        return new ResponseEntity(artikalService.addArtikal(artikalDto, menadzer) , HttpStatus.OK);
    }

    @PutMapping("/api/artikli/izmeniArtikal/{id}")
    public ResponseEntity izmeniArtikal(@PathVariable(name = "id") Long id, @RequestBody ArtikalDto artikalDto, HttpSession session){
        Boolean proveraSesije = sessionService.validateRole(session, "Menadzer");

        if(!proveraSesije){
            return new ResponseEntity("Nemate potrebne privilegije!",HttpStatus.BAD_REQUEST);
        }

        Menadzer menadzer = (Menadzer) session.getAttribute("user");

        artikalService.update(id, artikalDto, menadzer);

        return ResponseEntity.ok("Uspesno izmenjen!");
    }

    @DeleteMapping("/api/artikli/obrisiArtikal/{id}")
    public ResponseEntity obrisiArtikal(@PathVariable(name = "id") Long id, HttpSession session){
        Boolean proveraSesije = sessionService.validateRole(session, "Menadzer");

        if(!proveraSesije){
            return new ResponseEntity("Nemate potrebne privilegije!",HttpStatus.BAD_REQUEST);
        }

        Menadzer menadzer = (Menadzer) session.getAttribute("user");
        Restoran restoran = menadzer.getRestoran();

        artikalService.delete(id, restoran);

        return ResponseEntity.ok("Uspesno obrisan!");
    }
}
