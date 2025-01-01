package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.Entity.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  @Query ("Select r from Reservation  r join Chambre c on r member of c.reservations where r.estValide =TRUE and c.bloc.idBloc=:idBloc and year(r.anneeUniversitaire)=year(current date) order by r.idReservation LIMIT 1 " )
    Reservation findForReservation(long idBloc);


}
