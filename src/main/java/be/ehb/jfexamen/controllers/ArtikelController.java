package be.ehb.jfexamen.controllers;

import be.ehb.jfexamen.model.DAO.ArtikelDAO;
import be.ehb.jfexamen.model.entities.Artikel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ArtikelController {

    private ArtikelDAO mArtikelDAO;

    @Autowired
    public ArtikelController(ArtikelDAO mArtikelDAO) {
        this.mArtikelDAO = mArtikelDAO;
    }

    @GetMapping("/artikels")
    public Iterable<Artikel> getAllArtikels() {
        return mArtikelDAO.findAll();
    }

    @PutMapping("/artikels")
    public HttpStatus updateArtikel(@RequestParam int id,
                                     @RequestParam String titel,
                                     @RequestParam String inhoud) {

        if (!mArtikelDAO.existsById(id)) {
            return HttpStatus.NOT_FOUND;
        }

        Artikel artikelToUpdate = mArtikelDAO.findById(id).get();
        artikelToUpdate.setTitel(titel);
        artikelToUpdate.setInhoud(inhoud);
        mArtikelDAO.save(artikelToUpdate);
        return HttpStatus.OK;
    }

    @DeleteMapping("/artikels")
    public HttpStatus deleteArtikel(@RequestParam int id) {
        if (!mArtikelDAO.existsById(id)) {
            return HttpStatus.NOT_FOUND;
        }

        mArtikelDAO.deleteById(id);
        return HttpStatus.OK;
    }

    @GetMapping("/currentNews")
    public Iterable getCurrentlyPublishedArtikels() {
        LocalDate currentDate = LocalDate.now();
        Date currentDateTime = java.sql.Timestamp.valueOf(currentDate.atStartOfDay());
        return mArtikelDAO.getArtikelByPublicatieDatum(currentDateTime);
    }
}
