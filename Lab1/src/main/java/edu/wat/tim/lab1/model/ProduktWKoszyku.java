package edu.wat.tim.lab1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produktWKoszyku")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ProduktWKoszyku {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int ilosc;

    @ManyToOne
    @JoinColumn(name="produkt_id", nullable=false)
    private Produkt produkt;

    @ManyToOne
    @JoinColumn(name="koszyk_id", nullable=false)
    @JsonIgnore
    private Koszyk koszyk;

}
