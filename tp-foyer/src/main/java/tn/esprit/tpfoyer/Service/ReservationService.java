package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.*;
import tn.esprit.tpfoyer.repositories.BlocRepository;
import tn.esprit.tpfoyer.repositories.ChambreRepository;
import tn.esprit.tpfoyer.repositories.EtudiantRepository;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
class ReservationService implements IreservationService {
    @Autowired
    ReservationRepository rr;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> findReservationsWithChambreNumberGreaterThan(Long numero) {
        return null;
    }

    @Override
    public Reservation CreateReservation(Reservation reservation) {
        return rr.save(reservation);
    }

    @Override
    public Reservation getReservationById(long id) {
        return rr.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return rr.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return rr.save(reservation);
    }

    @Override
    public void deleteReservation(long id) {
        rr.deleteById(id);
    }
    private int getCapaciteMaximale(TypeChambre typeC) {
        switch (typeC) {
            case SIMPLE:
                return 1;
            case DOUBLE:
                return 2;
            case TRIPLE:
                return 3;
            default:
                throw new IllegalArgumentException("Type de chambre inconnu");
        }
    }

    private boolean isChambreDisponible(Chambre chambre) {
        int capaciteMax = getCapaciteMaximale(chambre.getTypeC());
        return chambre.getReservations().size() < capaciteMax;
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Optional<Bloc> blocOpt = blocRepository.findById(idBloc);
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        if (blocOpt.isPresent() && etudiant != null) {
            Reservation r= reservationRepository.findForReservation(idBloc);
            if ( r!=null)
            {
               r.getEtudiants().add(etudiant) ;
               Chambre c = chambreRepository.findByIdReservation(r.getIdReservation());
               if (r.getEtudiants().size()==3 || c.getTypeC()==TypeChambre.DOUBLE){
                   r.setEstValide(false);

               }
            }else {
                Chambre c = chambreRepository.findForReservation(idBloc);
                r = Reservation.builder().idReservation(c.getNumeroChambre()+"-"+blocOpt.get().getNomBloc()+"-"+new Date()).anneeUniversitaire(new Date()).estValide(true).build();
            if (c.getTypeC()==TypeChambre.SIMPLE){
                r.setEstValide(false);
                Set<Etudiant> etudiants = new HashSet<>();
                etudiants.add(etudiant);
                r.setEtudiants(etudiants);
            }
            }
            return reservationRepository.save(r);

        }

        throw new RuntimeException("Aucune chambre disponible ou étudiant non trouvé");
    }

//   @Override
//  public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
//      return reservationRepository.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
//    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        // Convert Date to String (e.g., "2023-2024")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String anneeString = sdf.format(anneeUniversitaire);  // Convert Date to String

        return null;
    }


}
