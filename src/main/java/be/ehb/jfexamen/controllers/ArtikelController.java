package be.ehb.jfexamen.controllers;

import be.ehb.jfexamen.model.DAO.ArtikelDAO;
import be.ehb.jfexamen.model.entities.Artikel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    private HttpStatus updateArtikel(@RequestParam int id,
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
}
