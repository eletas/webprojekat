package main.java.com.projekat.WebProjekat.repository;

import main.java.com.projekat.WebProjekat.entity.TipKupca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipKupcaRepository extends JpaRepository<TipKupca,Long> {
}
