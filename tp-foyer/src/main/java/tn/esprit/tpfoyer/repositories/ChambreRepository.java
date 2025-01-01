package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.TypeChambre;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    //List<Chambre> findByNumber(Long numberChambre);
    Optional<Chambre> findByNumeroChambre(Long numeroChambre);

    List<Chambre> findByBlocIn(Set<Bloc> blocs);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findChambresByBlocAndType(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);


    @Query("SELECT c from Chambre c join Reservation r on (r not member of c.reservations) where   c.bloc.idBloc=:idBloc and year(r.anneeUniversitaire)=year(current date) order by c.idChambre LIMIT 1")
    Chambre findForReservation (long idBloc);
    @Query("SELECT c from Chambre c join Reservation r on (r  member of c.reservations) where r.idReservation=:idReservation ")
    Chambre findByIdReservation(String idReservation);
}
