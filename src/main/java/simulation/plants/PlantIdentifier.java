package simulation.plants;

public enum PlantIdentifier {
    PARABOKOR("p"),
    PUFFANCS("a"),
    DELTAFA("d");

    public final String identifier;

    private PlantIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
