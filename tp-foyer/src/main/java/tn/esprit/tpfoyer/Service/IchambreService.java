package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.TypeChambre;
import tn.esprit.tpfoyer.repositories.BlocRepository;
import tn.esprit.tpfoyer.repositories.ChambreRepository;

import java.util.List;

public interface IchambreService {
    Chambre CreateChambre(Chambre chambre);
    Chambre getChambreById(long id);
    List<Chambre> getAllChambre();
    Chambre updateChambre(Chambre chambre);
    void deleteChambre(long id);

    public List<Chambre> getChambresParNomUniversite(String nomUniversite);
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre( String nomUniversite,TypeChambre type) ;

}

