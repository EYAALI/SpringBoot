package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.*;
import tn.esprit.tpfoyer.repositories.ChambreRepository;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service

public class ChambreService implements IchambreService {
    @Autowired
    ChambreRepository cr;
    @Autowired
    ChambreRepository chambreRepository;
    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Chambre CreateChambre(Chambre chambre) {
        return cr.save(chambre);
    }
    @Override
    public Chambre getChambreById(long id) {
        return cr.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambre() {
        return cr.findAll();
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return cr.save(chambre);

    }

    @Override
    public void deleteChambre(long id) {
        cr.deleteById(id);
    }


    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        // Trouver l'université par son nom
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée avec le nom : " + nomUniversite));

        // Récupérer le foyer de l'université
        Foyer foyer = universite.getFoyer();
        if (foyer == null) {
            throw new RuntimeException("Aucun foyer associé à l'université : " + nomUniversite);
        }

        // Récupérer les blocs associés au foyer
        List<Bloc> blocs = foyer.getBlocs();

        // Récupérer toutes les chambres des blocs
        List<Chambre> chambres = new ArrayList<>();
        for (Bloc bloc : blocs) {
            chambres.addAll(bloc.getChambres());
        }

        // Retourner la liste des chambres
        return chambres;
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findChambresByBlocAndType(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return null;
    }


}
