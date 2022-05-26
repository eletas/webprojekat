package com.example.demo.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String restoran;  //one to one veza
    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

//--------------------------------------------------------------------------------------------------------------------//

    public Menadzer() {
    }

    public Menadzer(Long id, Restoran restoran) {
        this.id = id;
        this.restoran = restoran;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}
