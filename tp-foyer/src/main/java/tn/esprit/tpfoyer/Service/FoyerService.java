package tn.esprit.tpfoyer.Service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Entity.Universite;
import tn.esprit.tpfoyer.repositories.BlocRepository;
import tn.esprit.tpfoyer.repositories.FoyerRepository;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
class FoyerService implements IfoyerService {
    UniversiteRepository universiteRepository;
BlocRepository blocRepository;
    FoyerRepository foyerRepository;

    @Override
    public Foyer CreateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyerById(long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(long id) {
        foyerRepository.deleteById(id);
    }



    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() ->  new RuntimeException("Université non trouvée avec l'ID : " + idUniversite));
        Foyer f = foyerRepository.save(foyer);
        universite.setFoyer(f);
        universiteRepository.save(universite);
        List<Bloc> blocs = new ArrayList<>(foyer.getBlocs());
        for (Bloc bloc : blocs) {
            bloc.setFoyer(f);
            System.err.println(bloc.getFoyer().getIdFoyer());
            blocRepository.save(bloc);
        }
        return f;
    }
}