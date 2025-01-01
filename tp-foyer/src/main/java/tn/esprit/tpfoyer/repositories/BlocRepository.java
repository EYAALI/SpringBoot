package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.Entity.Bloc;

import java.util.List;

@Repository //quand il va trouver @Repository il va verifier si une classe il va l'instancier si c'est une interface aussi il va l'instancier
public interface BlocRepository extends JpaRepository<Bloc,Long> {
    // Méthode pour récupérer un bloc en fonction du nom de l'université en utilisant Keyword
   List<Bloc>findByFoyerUniversiteNomUniversite(String nomUniversity);
    // Méthode pour récupérer un bloc en fonction du nom de l'université en utilisant Une requette sql

    @Query(value = " SELECT * FROM t_Bloc b JOIN T_universite u ON b.foyer_fo_id = u.foyer_fo_id WHERE u.un_nom = :nomUniversite",nativeQuery = true)
   List<Bloc>findByFoyerUniversiteNomUniversite1(String nomUniversite);
    // Méthode pour récupérer un bloc en fonction du nom de l'université en utilisant JPQL

    @Query("select b from Bloc b where b.foyer.universite.nomUniversite = 'nomUniversite'")
   List<Bloc>findByFoyerUniversiteNomUniversite2(String nomUniversity);



}
