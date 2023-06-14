package edu.wat.tim.lab1.repository;

import edu.wat.tim.lab1.model.Koszyk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KoszykRepository extends JpaRepository<Koszyk, Long> {
}
