package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.repositories.FoyerRepository;

import java.util.List;

public interface IfoyerService {
    Foyer CreateFoyer(Foyer foyer);
    Foyer getFoyerById(long id);
    List<Foyer> getAllFoyer();
    Foyer updateFoyer(Foyer foyer);
    void deleteFoyer(long id);
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);

}

