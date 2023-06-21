package be.ehb.jfexamen.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reporter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "reporter")
    private List<Artikel> artikelen;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Artikel> getArtikelen() {
        return artikelen;
    }

    public void setArtikelen(List<Artikel> artikelen) {
        this.artikelen = artikelen;
    }
}
