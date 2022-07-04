package main.java.com.projekat.WebProjekat.repository;

import main.java.com.projekat.WebProjekat.entity.Restoran;

import main.java.com.projekat.WebProjekat.entity.Korisnik;
import main.java.com.projekat.WebProjekat.entity.Lokacija;
import main.java.com.projekat.WebProjekat.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long>, JpaSpecificationExecutor<Restoran> {
    Optional<Restoran> findByLokacija(Lokacija lokacija);

    Optional<Restoran> findByTipRestorana(String tipRestorana);

    Optional<Restoran> findByNaziv(String naziv);
}
