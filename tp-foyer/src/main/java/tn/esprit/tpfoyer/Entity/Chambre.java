package tn.esprit.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = {"idChambre","bloc","reservations"}, includeFieldNames = false)
@EqualsAndHashCode(exclude = {"idChambre","bloc","reservations"})  // Exclut id de equals() et hashCode()
@FieldDefaults(level = AccessLevel.PRIVATE)// Default visibility set to private for all fields
@NoArgsConstructor  // No-argument constructor
@AllArgsConstructor
@Builder  // Génère un constructeur Builder pour la classe

@Table(name = "T_chambre") // Nom de la table dans la base de données
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ch_id")
    @Setter(AccessLevel.NONE)
     Long idChambre;

    @Column(name = "ch_numero")
     Long numeroChambre;


    @Enumerated(EnumType.STRING)
    @Column(name = "ch_type")
    TypeChambre typeC;

    @ManyToOne
    Bloc bloc;
    @OneToMany
    Set<Reservation> reservations; //Set n'accepte pas les doublons


}
