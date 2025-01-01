package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Entity.Universite;
import tn.esprit.tpfoyer.repositories.FoyerRepository;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.List;

@Service
class UniversiteService implements IuniversiteService {
    @Autowired
    UniversiteRepository Ur;
    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    public Universite CreateUniversite(Universite universite) {
        return Ur.save(universite);
    }

    @Override
    public Universite getUniversiteById(long id) {
        return Ur.findById(id).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return Ur.findAll();    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return Ur.save(universite);    }

    @Override
    public void deleteUniversite(long id) {
        Ur.deleteById(id);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée avec le nom : " + nomUniversite));

        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé avec l'ID : " + idFoyer));

        universite.setFoyer(foyer);

        return universiteRepository.save(universite);
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée avec l'ID : " + idUniversite));

        universite.setFoyer(null);
        return universiteRepository.save(universite);
    }
}
