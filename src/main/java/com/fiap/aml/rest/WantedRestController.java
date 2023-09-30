package com.fiap.aml.rest;

import com.fiap.aml.dao.WantedDAO;
import com.fiap.aml.entity.Wanted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WantedRestController {

    private WantedDAO wantedDAO;

    public WantedRestController(WantedDAO theWantedDAO) {
        this.wantedDAO = theWantedDAO;
    }

    @GetMapping("/wanted")
    public List<Wanted> findAll() {
        return wantedDAO.findAll();
    }

    @GetMapping("/wanted/{wantedId}")
    public Wanted findById(@PathVariable int wantedId) {

        Wanted theWanted = wantedDAO.findById(wantedId);

        if (theWanted == null) {
            throw new RuntimeException("Wanted id not found: " + wantedId);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return theWanted;
    }

    @PostMapping("/wanted")
    public Wanted addWanted(@RequestBody Wanted theWanted) {
        theWanted.setId(0);
        Wanted dbWanted = wantedDAO.save(theWanted);
        return dbWanted;
    }

    @PutMapping("/wanted")
    public Wanted updateWanted(@RequestBody Wanted theWanted) {
        Wanted dbWanted = wantedDAO.save(theWanted);
        return dbWanted;
    }

    @DeleteMapping("/wanted/{wantedId}")
    public String deleteWanted(@PathVariable int wantedId) {
        Wanted tempWanted = wantedDAO.findById(wantedId);
        if (tempWanted == null) {
            throw new RuntimeException("Wanted id not found: " + wantedId);
        }

        wantedDAO.deleteById(wantedId);
        return "Wanted deleted successfully:\n" + tempWanted.toString();
    }
}