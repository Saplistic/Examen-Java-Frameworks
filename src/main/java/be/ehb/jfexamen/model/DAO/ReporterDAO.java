package be.ehb.jfexamen.model.DAO;

import be.ehb.jfexamen.model.entities.Reporter;
import org.springframework.data.repository.CrudRepository;

public interface ReporterDAO extends CrudRepository<Reporter, Integer> {

    public Iterable<Reporter> findAllByNaam(String naam);
}
