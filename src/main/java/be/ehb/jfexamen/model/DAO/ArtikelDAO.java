package be.ehb.jfexamen.model.DAO;

import be.ehb.jfexamen.model.entities.Artikel;
import org.springframework.data.repository.CrudRepository;

public interface ArtikelDAO extends CrudRepository<Artikel, Integer> {
}
