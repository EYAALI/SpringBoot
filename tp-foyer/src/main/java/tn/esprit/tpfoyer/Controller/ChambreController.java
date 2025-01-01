package tn.esprit.tpfoyer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.TypeChambre;
import tn.esprit.tpfoyer.Service.IchambreService;

import java.util.List;


@Tag(name = "GestionChambres")
@RestController
@RequestMapping("/chambre")
public class ChambreController {

    @Autowired
    @Qualifier("chambreService")
    private IchambreService cs;

    // Créer une chambre
    @Operation(description = "Créer une chambre")
    @PostMapping("/create")
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return cs.CreateChambre(chambre);
    }

    // Récupérer toutes les chambres
    @Operation(description = "Récupérer toutes les chambres")
    @GetMapping("/all")
    public List<Chambre> getAllChambres() {
        return cs.getAllChambre();
    }

    // Récupérer une chambre par ID
    @Operation(description = "Récupérer une chambre par ID")
    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return cs.getChambreById(id);
    }

    // Supprimer une chambre
    @Operation(description = "Supprimer une chambre")
    @DeleteMapping("/delete/{id}")
    public void deleteChambre(@PathVariable Long id) {
        cs.deleteChambre(id);
    }
    @GetMapping("/parUniversite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return cs.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("/parBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc, @PathVariable TypeChambre typeC) {
        return cs.getChambresParBlocEtType(idBloc, typeC);
    }

//    @Autowired
//    private ChambreService chambreService;

//    @GetMapping("/non-reserve")
//    public List<Chambre> getChambresNonReserve(
//            @RequestParam String nomUniversite,
//            @RequestParam TypeChambre type
//           @RequestParam Date anneeUniversitaire) {
//        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type, anneeUniversitaire);
//    }
}

