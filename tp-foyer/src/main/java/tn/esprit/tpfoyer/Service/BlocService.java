package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.repositories.BlocRepository;

import java.util.List;

@Service
public class BlocService implements IblocService { //BlocService est l'implémentation de cette interface, annotée avec @Service, qui est instanciée automatiquement par Spring grâce à l'injection de dépendance de BlocRepository.
    @Autowired
    BlocRepository br;

    @Override
    public Bloc CreateBloc(Bloc bloc) {
        return br.save(bloc); //  si id not null modif si null ajouter voila la diff Utilise la méthode 'save' pour insérer ou mettre à jour l'entité Bloc
    }

    @Override
    public Bloc getBlocById(long id) {
        return br.findById(id).orElse(null);
    }

    @Override
    public List<Bloc> getAllBloc() {
        return br.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return br.save(bloc);
    }

    @Override
    public void deleteBloc(long id) {
        br.deleteById(id);
    }

    @Override
    public Bloc getBlocByNomUniversite(String nomUniversite) {
        return null;
    }


}
