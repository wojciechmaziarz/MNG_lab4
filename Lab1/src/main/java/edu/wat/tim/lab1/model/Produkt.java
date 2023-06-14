package edu.wat.tim.lab1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produkt")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produkt {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "jednostkaMiary")
    private String jednostkaMiary;

   // @OneToMany(mappedBy = "produkt", cascade = CascadeType.ALL)
    //private List<ProduktWKoszyku> zakupione = new ArrayList<>();

    public Produkt(String nazwa, String jednostkaMiary) {
        this.nazwa = nazwa;
        this.jednostkaMiary = jednostkaMiary;
    }
}
