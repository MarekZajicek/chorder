package fis.cis.guitar.chorder.repository.api;

public enum ChordEnum {
    C("C", "C dur"),
    D("D", "D dur"),
    E("E", "E dur"),
    F("F", "F dur"),
    G("G", "G dur"),
    A("A", "A dur"),
    H("H", "H dur");

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
