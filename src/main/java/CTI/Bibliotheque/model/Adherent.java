package CTI.Bibliotheque.model;

import jakarta.persistence.*;
import javax.persistence.Id;
import javax.persistence. GeneratedValue;
import javax.persistence. GenerationType;
import java.util.List;

@Entity
public class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String dateInscription;

    @OneToMany(mappedBy = "adherent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vente> ventes;

    @OneToMany(mappedBy = "adherent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Don> dons;

    @OneToMany(mappedBy = "adherent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Emprunt> emprunts;

    public Adherent() {

    }

    public Adherent(String nom, String prenom, String email, String telephone, String dateInscription) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateInscription = dateInscription;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }

    public List<Don> getDons() {
        return dons;
    }

    public void setDons(List<Don> dons) {
        this.dons = dons;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

     public <HistoriqueAction> List<HistoriqueAction> getHistoriqueActions() {
         List<HistoriqueAction> historiqueActions = null;
         return historiqueActions;
     }
}