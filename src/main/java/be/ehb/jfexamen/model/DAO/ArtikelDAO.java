package be.ehb.jfexamen.model.DAO;

import be.ehb.jfexamen.model.entities.Artikel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;

public interface ArtikelDAO extends CrudRepository<Artikel, Integer> {

    public Iterable<Artikel> getArtikelByPublicatieDatum(Date today);

}
