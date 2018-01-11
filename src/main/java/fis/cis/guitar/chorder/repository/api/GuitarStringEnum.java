package fis.cis.guitar.chorder.repository.api;

public enum GuitarStringEnum {
    E1("e"),
    H("b"),
    G("g"),
    D("d"),
    A("a"),
    E6("E");

    private String alternativeName;

    GuitarStringEnum(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public String getName() {
        return this.toString();
    }

    public String getNameSmallCaps(){
        return this.toString().toLowerCase();
    }
}
