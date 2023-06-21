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

}
