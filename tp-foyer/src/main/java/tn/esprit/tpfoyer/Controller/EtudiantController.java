package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Etudiant;
import tn.esprit.tpfoyer.Service.IetudiantService;

import java.util.List;

@Tag(name = "GestionEtudiants")
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    @Qualifier("etudiantService")
    private IetudiantService es;

    // Créer un étudiant
    @Operation(description = "Créer un étudiant")
    @PostMapping("/create")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return es.CreateEtudiant(etudiant);
    }

    // Récupérer tous les étudiants
    @Operation(description = "Récupérer tous les étudiants")
    @GetMapping("/all")
    public List<Etudiant> getAllEtudiants() {
        return es.getAllEtudiant();
    }

    // Récupérer un étudiant par ID
    @Operation(description = "Récupérer un étudiant par ID")
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return es.getEtudiantById(id);
    }

    // Supprimer un étudiant
    @Operation(description = "Supprimer un étudiant")
    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        es.deleteEtudiant(id);
    }
}

