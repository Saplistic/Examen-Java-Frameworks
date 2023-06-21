package be.ehb.jfexamen.controllers;

import be.ehb.jfexamen.model.DAO.ReporterDAO;
import be.ehb.jfexamen.model.entities.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class ReporterController {

    private ReporterDAO mReporterDAO;

    @Autowired
    public ReporterController(ReporterDAO mReporterDAO) {
        this.mReporterDAO = mReporterDAO;
    }

    @GetMapping("/reporters")
    public Iterable<Reporter> getAllReporters() {
        return mReporterDAO.findAll();
    }

    @GetMapping("/reporter/{naam}")
    public Iterable findReportersByName(@PathVariable String naam) {
        return mReporterDAO.findAllByNaam(naam);
    }

    @PostMapping("/reporter")
    public void insertReporter(@RequestParam String naam,
                               @RequestParam String email) {
        Reporter newReporter = new Reporter();
        newReporter.setNaam(naam);
        newReporter.setEmail(email);
        mReporterDAO.save(newReporter);
    }
}
