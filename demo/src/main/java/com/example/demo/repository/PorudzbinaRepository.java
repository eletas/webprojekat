package com.example.demo.repository;

import com.example.demo.entity.Porudzbina;
import com.example.demo.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long> {
    List<Porudzbina> getByRestoranId(Long restoranId);

    List<Porudzbina> getByKupacId(Long kupacId);

    List<Porudzbina> getByStatus(Status status);

    List<Porudzbina> getByDostavljacId(Long dostavljacId);

    Optional<Porudzbina> findByUuid(UUID uuid);
}
