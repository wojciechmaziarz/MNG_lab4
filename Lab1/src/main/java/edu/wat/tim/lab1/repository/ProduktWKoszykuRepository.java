package edu.wat.tim.lab1.repository;

import edu.wat.tim.lab1.model.Koszyk;
import edu.wat.tim.lab1.model.ProduktWKoszyku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduktWKoszykuRepository extends JpaRepository<ProduktWKoszyku, Long> {
}
