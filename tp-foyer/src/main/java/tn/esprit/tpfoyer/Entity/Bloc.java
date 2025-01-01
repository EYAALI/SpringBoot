package tn.esprit.tpfoyer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = {"idBloc","foyer","chambres"}, includeFieldNames = false)
@EqualsAndHashCode(exclude = {"idBloc","foyer","chambres"})  // Exclut id de equals() et hashCode()
@FieldDefaults(level = AccessLevel.PRIVATE)   // Default visibility set to private for all fields
@NoArgsConstructor  // No-argument constructor
@AllArgsConstructor //constructeur parmatrer avec tous les variables
@Builder  // Génère un constructeur Builder pour la classe

//@RequiredArgsConstructor   si je veux ajouter ca ave des parametre spicifique au niveau des attribut j'ajout @NonNull
//si je sais que j'ai un seul constructeur dans ma classe j'utilise required sinon @Builder

@Table(name = "T_bloc")
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bl_id")
    @Setter(AccessLevel.NONE)
    Long idBloc;
    //@ToString.Exclude  autre methode pour exclure de toString
   // @EqualsAndHashCode.Exclude  autre methode
    @Column(name = "bl_nom")
    String nomBloc;

    @Column(name = "bl_capacite")
    Long capaciteBloc;

    @ManyToOne
    @JsonIgnore
    Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    Set<Chambre> chambres; //Set n'accepte pas les doublons
}
