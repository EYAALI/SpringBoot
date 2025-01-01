package tn.esprit.tpfoyer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Service.BlocService;
import tn.esprit.tpfoyer.Service.IblocService;

import java.util.List;


@RestController
@RequestMapping("/api/blocs")
public class BlocController {

    @Autowired
    public BlocService blocService;

    @PostMapping("create")
    public Bloc createBloc(@RequestBody Bloc bloc) {
        return blocService.CreateBloc(bloc);
    }   @GetMapping("get-by-id/{id}")
    public Bloc getBlocById(@PathVariable long id) {
        return blocService.getBlocById(id);
    }

    @GetMapping("get-all")
    public List<Bloc> getAllBloc() {
        return blocService.getAllBloc();
    }

    @PutMapping("update")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBloc(@PathVariable long id) {
        blocService.deleteBloc(id);
    }
}

