package tn.esprit.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.tpfoyer.Entity.Etudiant;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = {"idReservation","chambre","etudiant"}, includeFieldNames = false)
@EqualsAndHashCode(exclude = {"idReservation","chambre","etudiant"})  // Exclut id de equals() et hashCode()
@FieldDefaults(level = AccessLevel.PRIVATE)   // Default visibility set to private for all fields
@NoArgsConstructor  // No-argument constructor
@AllArgsConstructor
@Builder  // Génère un constructeur Builder pour la classe

@Table(name = "T_reservation")
public class Reservation {

    @Id
    @Column(name = "res_id")
     String idReservation;
    private String numReservation;

    @Column(name = "res_anneeUniversitaire")
    @Temporal(TemporalType.DATE)
    Date anneeUniversitaire;



    @Column(name = "res_estValide")
    boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL )
    private Set<Etudiant> etudiants;





}
