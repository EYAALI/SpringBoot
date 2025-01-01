package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.repositories.FoyerRepository;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.util.Date;
import java.util.List;

public interface IreservationService {
    Reservation CreateReservation(Reservation reservation);
    Reservation getReservationById(long id);
    List<Reservation> getAllReservation();
    Reservation updateReservation(Reservation reservation);
    List<Reservation> findReservationsWithChambreNumberGreaterThan(Long numero);

    void deleteReservation(long id);
   public Reservation ajouterReservation(long idBloc, long cinEtudiant);
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) ;

}

