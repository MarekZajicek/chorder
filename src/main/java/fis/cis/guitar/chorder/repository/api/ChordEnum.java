package fis.cis.guitar.chorder.repository.api;

public enum ChordEnum {
    C("C", "C dur"),
    D("D", "D dur"),
    E("E", "E dur"),
    F("F", "F dur"),
    G("G", "G dur"),
    A("A", "A dur"),
    H("H", "H dur"),

    Cmi("Cmi", "C moll"),
    Dmi("Dmi", "D moll"),
    Emi("Emi", "E moll"),
    Fmi("Fmi", "F moll"),
    Gmi("Gmi", "G moll"),
    Ami("Ami", "A moll"),
    Hmi("Hmi", "H moll");

    private String name;
    private String fullName;

    ChordEnum(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }
}
