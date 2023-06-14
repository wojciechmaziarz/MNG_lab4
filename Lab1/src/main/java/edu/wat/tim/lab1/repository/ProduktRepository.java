package edu.wat.tim.lab1.repository;

import edu.wat.tim.lab1.model.Koszyk;
import edu.wat.tim.lab1.model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduktRepository extends JpaRepository<Produkt, Long> {
}
