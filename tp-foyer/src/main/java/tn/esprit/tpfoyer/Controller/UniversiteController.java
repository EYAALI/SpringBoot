package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Universite;
import tn.esprit.tpfoyer.Service.IuniversiteService;

import java.util.List;

@Tag(name = "GestionUniversite")
@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    @Autowired
    @Qualifier("universiteService")
    private IuniversiteService universiteService;

    @Operation(description = "Creation d'une université")
    @PostMapping("/create")
    public Universite createUniversite(@RequestBody Universite universite) {
        return universiteService.CreateUniversite(universite);
    }

    @Operation(description = "Recuperer une université par ID")
    @GetMapping("/get-by-id/{id}")
    public Universite getUniversiteById(@PathVariable long id) {
        return universiteService.getUniversiteById(id);
    }

    @Operation(description = "Recuperer toutes les universités")
    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversite();
    }

    @Operation(description = "Mise a jour d'une université")
    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @Operation(description = "Supprimer une université")
    @DeleteMapping("/delete/{id}")
    public void deleteUniversite(@PathVariable long id) {
        universiteService.deleteUniversite(id);
    }


    @PutMapping("/affecterFoyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(
            @PathVariable long idFoyer,
            @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
    @PutMapping("/desaffecterFoyer/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}