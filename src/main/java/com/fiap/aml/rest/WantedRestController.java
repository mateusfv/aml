package com.fiap.aml.rest;

import com.fiap.aml.dao.WantedDAO;
import com.fiap.aml.dto.WantedDTO;
import com.fiap.aml.entity.Wanted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WantedRestController {

    private WantedDAO wantedDAO;

    public WantedRestController(WantedDAO theWantedDAO) {
        this.wantedDAO = theWantedDAO;
    }

    @GetMapping("/wanted/{partialName}")
    public List<WantedDTO> findByPartialName(@PathVariable String partialName) {
        List<WantedDTO> wantedDTOs = new ArrayList<>();
        List<Wanted> wanteds = wantedDAO.findByPartialName(partialName);
        System.out.println(wanteds);
        for (Wanted wanted : wanteds) {
            WantedDTO wantedDTO = new WantedDTO(wanted);
            wantedDTOs.add(wantedDTO);
        }

        return wantedDTOs;
    }

    @GetMapping("/wanted/id/{wantedId}")
    public WantedDTO findById(@PathVariable int wantedId) {

        Wanted theWanted = wantedDAO.findById(wantedId);
        if (theWanted == null) {
            throw new RuntimeException("Wanted id not found: " + wantedId);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        WantedDTO wantedDTO = new WantedDTO(theWanted);
        return wantedDTO;
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

    //    @GetMapping("/wanted")
//    public List<WantedDTO> findAll() {
//        List<Wanted> wantedList = wantedDAO.findAll();
//
//        if (wantedList.isEmpty()) {
//            throw new RuntimeException("No entities found");
//        }
//
//        List<WantedDTO> wantedDTOList = new ArrayList<>();
//        for (Wanted wanted : wantedList) {
//            wantedDTOList.add(new WantedDTO((wanted)));
//        }
//
//        return wantedDTOList;
//    }
}