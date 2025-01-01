package tn.esprit.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.tpfoyer.Entity.Foyer;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString(exclude = {"idUniversite"}, includeFieldNames = false)
@EqualsAndHashCode(exclude = {"idUniversite"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder  // Génère un constructeur Builder pour la classe

@Table(name = "T_universite")
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "un_id")
    @Setter(AccessLevel.NONE)
    Long idUniversite;

    @Column(name = "un_nom")
    String nomUniversite;

    @Column(name = "un_adresse")
    String adresse;


    @OneToOne(cascade = CascadeType.ALL)
    Foyer foyer;


}

