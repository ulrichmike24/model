package CTI.Bibliotheque.controleurs;

import CTI.Bibliotheque.model.Vente;
import CTI.Bibliotheque.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventes")
public class VenteController {

    @Autowired
    private VenteService venteService;

    // Endpoint pour afficher une vente par son ID
    @GetMapping("/{id}")
    public void afficherVente(@PathVariable Long id) {
        venteService.afficherVente(id);
    }

    // Endpoint pour enregistrer une vente
    @PostMapping("/enregistrer")
    public void enregistrerVente(@RequestBody Vente vente) {
        venteService.enregistrerVente(vente);
    }

    // Endpoint pour mettre à jour le stock après une vente
    @PutMapping("/mettre-a-jour-stock")
    public void mettreAJourStock(@RequestBody Vente vente) {
        venteService.mettreAJourStock(vente);
    }
}

