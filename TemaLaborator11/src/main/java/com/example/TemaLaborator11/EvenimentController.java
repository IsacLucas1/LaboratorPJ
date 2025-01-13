package com.example.TemaLaborator11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/jpa/evenimente")
public class EvenimentController {

    @Autowired
    private EvenimentRepository evenimentRepository;

    @GetMapping
    public List<Eveniment> getAllEvenimente() {
        return evenimentRepository.findAll();
    }

    @GetMapping("/locatie/{locatie}")
    public List<Eveniment> getEvenimenteByLocatie(@PathVariable String locatie) {
        return evenimentRepository.findByLocatie(locatie);
    }

    @GetMapping("/data/{data}")
    public List<Eveniment> getEvenimenteByData(@PathVariable String data) {
        LocalDate localDate = LocalDate.parse(data);
        return evenimentRepository.findByData(localDate);
    }

    @PostMapping
    public Eveniment addEveniment(@RequestBody Eveniment eveniment) {
        return evenimentRepository.save(eveniment);
    }

    @PutMapping
    public Eveniment updateEveniment(@RequestBody Eveniment eveniment) {
        return evenimentRepository.save(eveniment);
    }

    @DeleteMapping("/id/{id}")
    public void deleteEveniment(@PathVariable Long id) {
        evenimentRepository.deleteById(id);
    }
}
