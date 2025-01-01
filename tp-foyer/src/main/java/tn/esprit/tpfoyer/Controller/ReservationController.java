package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Service.IreservationService;

import java.util.List;

@Tag(name = "GestionReservations")
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    @Qualifier("reservationService")
    private IreservationService rs;

    // Création d'une réservation
    @Operation(description = "Créer une nouvelle réservation")
    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return rs.CreateReservation(reservation);
    }

    // Récupérer toutes les réservations
    @Operation(description = "Récupérer toutes les réservations")
    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return rs.getAllReservation();
    }

    // Récupérer une réservation par ID
    @Operation(description = "Récupérer une réservation par ID")
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return rs.getReservationById(id);
    }

    // Supprimer une réservation
    @Operation(description = "Supprimer une réservation")
    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        rs.deleteReservation(id);
    }


    @PostMapping("/ajouterReservation/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idBloc, @PathVariable long cinEtudiant) {
        return rs.ajouterReservation(idBloc, cinEtudiant);
    }

}