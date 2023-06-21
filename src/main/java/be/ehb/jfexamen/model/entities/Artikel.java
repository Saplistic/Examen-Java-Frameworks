package be.ehb.jfexamen.model.entities;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date publicatieDatum;
    private String titel;
    private String inhoud;
    @ManyToOne
    @JoinColumn(name = "reporter_id", nullable = false)
    private Reporter reporter;
    @ManyToMany
    private List<Tags> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPublicatieDatum() {
        return publicatieDatum;
    }

    public void setPublicatieDatum(Date publicatieDatum) {
        this.publicatieDatum = publicatieDatum;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
}
