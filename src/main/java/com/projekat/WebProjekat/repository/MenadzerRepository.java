package main.java.com.projekat.WebProjekat.repository;

import main.java.com.projekat.WebProjekat.entity.Menadzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenadzerRepository extends JpaRepository<Menadzer,Long> {
}
