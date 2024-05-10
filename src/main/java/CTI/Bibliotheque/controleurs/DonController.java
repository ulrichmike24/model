package CTI.Bibliotheque.controleurs;

import CTI.Bibliotheque.model.Don;
import CTI.Bibliotheque.service.DonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dons")
public class DonController {

    @Autowired
    private DonService donService;

    // Endpoint pour afficher un don par son ID
    @GetMapping("/{id}")
    public ResponseEntity<String> afficherDon(@PathVariable Long id) {
        Don don = donService.findById(id);
        if (don != null) {
            return ResponseEntity.ok("Details du don : " + don.toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun don trouvé avec l'ID : " + id);
        }
    }

    // Endpoint pour enregistrer un don
    @PostMapping("/enregistrer")
    public ResponseEntity<String> enregistrerDon(@RequestBody Don don) {
        Don newDon = donService.save(don);
        return ResponseEntity.status(HttpStatus.CREATED).body("Le don a été enregistré avec succès. ID du don : " + newDon.getId());
    }

    // Endpoint pour générer un reçu pour un don
    @PostMapping("/generer-recu")
    public ResponseEntity<String> genererRecu(@RequestBody Don don) {
        // Logique pour générer le reçu
        return ResponseEntity.ok("Reçu généré pour le don avec l'ID : " + don.getId());
    }
}
