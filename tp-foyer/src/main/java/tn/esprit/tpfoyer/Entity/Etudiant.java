package tn.esprit.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = {"idEtudiant","reservation"}, includeFieldNames = false) //This configuration excludes the idEtudiant field from the toString() output and also ensures that the field names (like prenomEt, cin, etc.) are not printed, only their values.
@EqualsAndHashCode(exclude = {"idEtudiant","reservation"})  // Exclut idEtudiant de equals() et hashCode()
@FieldDefaults(level = AccessLevel.PRIVATE)   // Default visibility set to private for all fields
@NoArgsConstructor  // No-argument constructor
@AllArgsConstructor
@Builder  // Génère un constructeur Builder pour la classe


@Table(name = "T_etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "et_id")
    @Setter(AccessLevel.NONE)  // Exclude setter for idEtudiant

    Long idEtudiant;

    @Column(name = "et_nom")

    protected String nomEt;

    @Column(name = "et_prenom")
    String prenomEt;

    @Column(name = "et_cin")
     Long cin;

    @Column(name = "et_ecole")
    String ecole;

    @Column(name = "et_date_naissance")
     Date dateNaissance;
    @ManyToMany(mappedBy="etudiants")
    Set<Reservation> reservations;


}

