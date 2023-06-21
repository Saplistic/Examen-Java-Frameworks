package be.ehb.jfexamen.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reporter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;
    private String email;

    @OneToMany(mappedBy = "reporter")
    private List<Artikel> artikelen;




}
