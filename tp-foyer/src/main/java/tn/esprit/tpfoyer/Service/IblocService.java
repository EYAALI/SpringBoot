package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.repositories.BlocRepository;

import java.util.List;

public interface IblocService {  //IblocService est une interface pour définir les opérations de service liées à l'entité Bloc.
    Bloc CreateBloc(Bloc bloc);
    Bloc getBlocById(long id);
    List<Bloc> getAllBloc();
    Bloc updateBloc(Bloc bloc);
    void deleteBloc(long id);
    Bloc getBlocByNomUniversite(String nomUniversite);



}

