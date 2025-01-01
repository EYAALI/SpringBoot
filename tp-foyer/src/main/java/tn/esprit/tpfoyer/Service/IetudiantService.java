package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.Etudiant;
import tn.esprit.tpfoyer.repositories.EtudiantRepository;

import java.util.List;

public interface IetudiantService {
    Etudiant CreateEtudiant(Etudiant etudiant);
    Etudiant getEtudiantById(long id);
    List<Etudiant> getAllEtudiant();
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(long id);
}
