package be.ehb.jfexamen.controllers;

import be.ehb.jfexamen.model.DAO.ArtikelDAO;
import be.ehb.jfexamen.model.entities.Artikel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
