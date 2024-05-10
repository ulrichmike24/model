package CTI.Bibliotheque.model;


public enum UserRole {
    ROLE_ADMIN("Administrateur"),
    ROLE_USER("Utilisateur"),
    ROLE_MANAGER("Gestionnaire"),
    ROLE_EDITOR("Éditeur"),
    ROLE_GUEST("Invité"),
    ROLE_EMPLOYEE("Employé");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
