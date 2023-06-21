package be.ehb.jfexamen.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;

    @ManyToMany
    private List<Artikel> artikelen;

    public Tags(List<Artikel> artikelen) {
        this.artikelen = artikelen;
    }
}
