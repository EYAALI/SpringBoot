package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Etudiant;
import tn.esprit.tpfoyer.repositories.EtudiantRepository;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.List;

@Service
class EtudiantService implements IetudiantService {
    @Autowired
    EtudiantRepository er;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public Etudiant CreateEtudiant(Etudiant etudiant) {
        return er.save(etudiant);

    }

  //  @Override
  //  public Etudiant getEtudiantById(long id) {
      //  return er.findById(id).orElse(null);
  //  }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return er.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return er.save(etudiant);
    }

    @Override
    public void deleteEtudiant(long id) {
        er.deleteById(id);

    }
    @Override
    public Etudiant getEtudiantById(long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with id: " + id));
    }
}