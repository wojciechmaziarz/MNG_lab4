package edu.wat.tim.lab1.controller;

import edu.wat.tim.lab1.model.Koszyk;
import edu.wat.tim.lab1.model.Klient;
import edu.wat.tim.lab1.model.Produkt;
import edu.wat.tim.lab1.model.ProduktWKoszyku;
import edu.wat.tim.lab1.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SampleRestController {

    private final SampleService service;

    @GetMapping("/echo")
    public String echo(String value) {
        return value;
    }

    @GetMapping("/echo/{value}")
    public String echoPath(@PathVariable String value) {
        return value;
    }

    @PostMapping("/klient")
    public ResponseEntity<Klient> createKlient(@RequestBody Klient entity) {
        Klient savedEntity = service.createKlient(entity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    //Moja funkcja do produktow
    @PostMapping("/produkt")
    public ResponseEntity<Produkt> createProdukt(@RequestBody Produkt entity) {
        Produkt savedEntity = service.createProdukt(entity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping("/klient")
    public ResponseEntity<List<Klient>> getAllEntities() {
        List<Klient> entities = service.getAllEntities();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    //Moja funkcja do produktow
    @GetMapping("/produkt")
    public ResponseEntity<List<Produkt>> getAllChildEntities() {
        List<Produkt> entities = service.getAllChildEntities();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping("/klient/{id}/koszyk")
    public ResponseEntity<Koszyk> addKoszyk(@RequestBody Koszyk entity, @PathVariable(value = "id") Long id) {
        Koszyk savedEntity = service.addKoszyk(entity, id);
        return new ResponseEntity<>(savedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/klient/koszyk/{id}")
    public ResponseEntity<HttpStatus> deleteKoszyk(@PathVariable(value = "id") Long id) {
        service.deleteKoszyk(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/klient/{id}")
    public ResponseEntity<Klient> updateEntity(@RequestBody Klient entity, @PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(service.updateEntity(entity, id), HttpStatus.OK);
    }

    @PostMapping("/produkt/{id_produktu}/koszyk/{id_koszyka}")
    public ResponseEntity<ProduktWKoszyku> addprodukt(@RequestBody ProduktWKoszyku entity, @PathVariable(value = "id_produktu") Long produktId,@PathVariable(value = "id_koszyka") Long koszykId) {
        ProduktWKoszyku savedEntity = service.addprodukt(entity, produktId, koszykId);
        return new ResponseEntity<>(savedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/klient/koszyk/produkt/{id}")
    public ResponseEntity<HttpStatus> deleteProduktWKoszyku(@PathVariable(value = "id") Long id) {
        service.deleteProduktWKoszyku(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/klient/koszyk/produkt/{id}/ilosc/{ilosc}")
    public ResponseEntity<ProduktWKoszyku> updateilosc(@PathVariable(value = "id") Long id, @PathVariable(value = "ilosc") int ilosc) {
        return new ResponseEntity<>(service.updateilosc(id,ilosc), HttpStatus.OK);
    }
}