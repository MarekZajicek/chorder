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
    Hmi("Hmi", "H moll"),

    Cmaj7("Cmaj7", "C maj7"),
    Dmaj7("Dmaj7", "D maj7"),
    Emaj7("Emaj7", "E maj7"),
    Fmaj7("Fmaj7", "F maj7"),
    Gmaj7("Gmaj7", "G maj7"),
    Amaj7("Amaj7", "A maj7"),
    Hmaj7("Hmaj7", "H maj7"),

    C7("C7", "C 7"),
    D7("D7", "D 7"),
    E7("E7", "E 7"),
    F7("F7", "F 7"),
    G7("G7", "G 7"),
    A7("A7", "A 7"),
    H7("H7", "H 7"),

    Cmi7("Cmi7", "C mi7"),
    Dmi7("Dmi7", "D mi7"),
    Emi7("Emi7", "E mi7"),
    Fmi7("Fmi7", "F mi7"),
    Gmi7("Gmi7", "G mi7"),
    Ami7("Ami7", "A mi7"),
    Hmi7("Hmi7", "H mi7"),

    Cdim("Cdim", "C dim"),
    Ddim("Ddim", "D dim"),
    Edim("Edim", "E dim"),
    Fdim("Fdim", "F dim"),
    Gdim("Gdim", "G dim"),
    Adim("Adim", "A dim"),
    Hdim("Hdim", "H dim"),

    Csus4("Csus4", "C sus4"),
    Dsus4("Dsus4", "D sus4"),
    Esus4("Esus4", "E sus4"),
    Fsus4("Fsus4", "F sus4"),
    Gsus4("Gsus4", "G sus4"),
    Asus4("Asus4", "A sus4"),
    Hsus4("Hsus4", "H sus4"),

    Cadd9("Cadd9", "C add9"),
    Dadd9("Dadd9", "D add9"),
    Eadd9("Eadd9", "E add9"),
    Fadd9("Fadd9", "F add9"),
    Gadd9("Gadd9", "G add9"),
    Aadd9("Aadd9", "A add9"),
    Hadd9("Hadd9", "H add9");

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
