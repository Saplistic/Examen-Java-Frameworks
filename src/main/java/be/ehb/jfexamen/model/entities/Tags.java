package be.ehb.jfexamen.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;

    @JsonIgnore
    @ManyToMany
    private List<Artikel> artikelen;

    public Tags(List<Artikel> artikelen) {
        this.artikelen = artikelen;
    }

    public Tags() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Artikel> getArtikelen() {
        return artikelen;
    }

    public void setArtikelen(List<Artikel> artikelen) {
        this.artikelen = artikelen;
    }
}
