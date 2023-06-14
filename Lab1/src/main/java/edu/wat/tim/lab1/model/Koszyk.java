package edu.wat.tim.lab1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="koszyk")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Koszyk {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "nazwa")
    private String nazwa;

    @ManyToOne
    @JoinColumn(name="klient_id", nullable=false)
    @JsonIgnore
    private Klient klient;

    @OneToMany(mappedBy = "koszyk", cascade = CascadeType.ALL)
    private List<ProduktWKoszyku> produktywkoszyku = new ArrayList<>();
}
