package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Service.IfoyerService;

import java.util.List;


@Tag(name = "GestionFoyers")
@RestController
@RequestMapping("/foyer")
public class FoyerController {

    @Autowired
    @Qualifier("foyerService")
    private IfoyerService fs;

    // Créer un foyer
    @Operation(description = "Créer un foyer")
    @PostMapping("/create")
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        return fs.CreateFoyer(foyer);
    }

    // Récupérer tous les foyers
    @Operation(description = "Récupérer tous les foyers")
    @GetMapping("/all")
    public List<Foyer> getAllFoyers() {
        return fs.getAllFoyer();
    }

    // Récupérer un foyer par ID
    @Operation(description = "Récupérer un foyer par ID")
    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable Long id) {
        return fs.getFoyerById(id);
    }

    // Supprimer un foyer
    @Operation(description = "Supprimer un foyer")
    @DeleteMapping("/delete/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        fs.deleteFoyer(id);
    }


    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return fs.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
