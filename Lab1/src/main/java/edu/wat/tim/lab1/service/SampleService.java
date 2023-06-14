package edu.wat.tim.lab1.service;

import edu.wat.tim.lab1.model.Koszyk;
import edu.wat.tim.lab1.model.Klient;
import edu.wat.tim.lab1.model.Produkt;
import edu.wat.tim.lab1.model.ProduktWKoszyku;
import edu.wat.tim.lab1.repository.KoszykRepository;
import edu.wat.tim.lab1.repository.KlientRepository;
import edu.wat.tim.lab1.repository.ProduktRepository;
import edu.wat.tim.lab1.repository.ProduktWKoszykuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final KlientRepository klientRepository;
    private final KoszykRepository koszykRepository;
    private final ProduktRepository produktRepository;
    private final ProduktWKoszykuRepository produktWKoszykuRepository;

    public Klient createKlient(Klient entity) {
        return klientRepository.save(new Klient(entity.getNazwa(),entity.getEmail()));
    }
    public Produkt createProdukt(Produkt entity) {
        return produktRepository.save(new Produkt(entity.getNazwa(),entity.getJednostkaMiary()));
    }

    public List<Klient> getAllEntities() {
        return klientRepository.findAll();
    }

    //moja funkcja do produktow
    public List<Produkt> getAllChildEntities() {return produktRepository.findAll();}

    public Koszyk addKoszyk(Koszyk koszyk, Long parentId) {
        Klient klient = klientRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono encji o id " + parentId));
        koszyk.setKlient(klient);
        return koszykRepository.save(koszyk);
    }

    public void deleteKoszyk(Long childId) {
        koszykRepository.deleteById(childId);
    }

    public Klient updateEntity(Klient updatedEntity, Long id) {
        Klient entity = klientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono encji o id " + id));

        entity.setNazwa(updatedEntity.getNazwa());
        entity.setEmail(updatedEntity.getEmail());
        return klientRepository.save(entity);
    }

    public ProduktWKoszyku addprodukt(ProduktWKoszyku produktWKoszyku,Long produktId, Long koszykId) {
        Koszyk koszyk = koszykRepository.findById(koszykId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono encji o id " + koszykId));
        Produkt produkt = produktRepository.findById(produktId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono encji o id " + produktId));
        produktWKoszyku.setProdukt(produkt);
        produktWKoszyku.setKoszyk(koszyk);
        return produktWKoszykuRepository.save(produktWKoszyku);
    }

    public void deleteProduktWKoszyku(Long id) {
        produktWKoszykuRepository.deleteById(id);
    }

    public ProduktWKoszyku updateilosc(Long id,int ilosc) {
        ProduktWKoszyku entity = produktWKoszykuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono encji o id " + id));
        entity.setIlosc(ilosc);
        return produktWKoszykuRepository.save(entity);
    }
}
