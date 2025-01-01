package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Entity.Universite;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.List;

public interface IuniversiteService {
    Universite CreateUniversite(Universite universite);
    Universite getUniversiteById(long id);
    List<Universite> getAllUniversite();
    Universite updateUniversite(Universite universite);
    void deleteUniversite(long id);
    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
    public Universite desaffecterFoyerAUniversite(long idUniversite);
}

