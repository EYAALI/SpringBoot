package tn.esprit.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"idFoyer","blocs","universite"}, includeFieldNames = false)
@EqualsAndHashCode(exclude = {"idFoyer","blocs","universite"})  // Exclut id de equals() et hashCode()
@FieldDefaults(level = AccessLevel.PRIVATE)   // Default visibility set to private for all fields
@NoArgsConstructor  // No-argument constructor
@AllArgsConstructor
@Builder  // Génère un constructeur Builder pour la classe

@Table(name = "T_foyer")
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fo_id")
    @Setter(AccessLevel.NONE)
    Long idFoyer;

    @Column(name = "fo_nom")
    String nomFoyer;

    @Column(name = "fo_capacite")
    Long capaciteFoyer;

    @OneToMany(mappedBy = "foyer", cascade = CascadeType.PERSIST)
    List<Bloc> blocs;

    @OneToOne(mappedBy = "foyer")
    Universite universite;




}

