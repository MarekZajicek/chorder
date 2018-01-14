package fis.cis.guitar.chorder.init;

import fis.cis.guitar.chorder.entity.Chord;
import fis.cis.guitar.chorder.entity.GuitarString;
import fis.cis.guitar.chorder.repository.api.ChordEnum;
import fis.cis.guitar.chorder.repository.api.GuitarStringEnum;
import fis.cis.guitar.chorder.service.api.ChordImageService;
import fis.cis.guitar.chorder.service.api.ChordService;
import fis.cis.guitar.chorder.service.api.GuitarStringService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InitialDataSet {

    @Autowired
    private ChordService chordService;

    @Autowired
    private GuitarStringService guitarStringService;

    @Autowired
    private ChordImageService chordImageService;

    private List<GuitarString> guitarStrings;

    public InitializingBean load() {
        initStrings();
        initChords();
        return null;
    }

    private void initStrings() {
        if (guitarStrings == null) {
            guitarStrings = new ArrayList<>();
        }

        guitarStrings.add(guitarStringService.addGuitarString(GuitarStringEnum.E1.getName(), GuitarStringEnum.E1.getAlternativeName(), GuitarStringEnum.E1.getNameSmallCaps()));
        guitarStrings.add(guitarStringService.addGuitarString(GuitarStringEnum.H.getName(), GuitarStringEnum.H.getAlternativeName(), GuitarStringEnum.H.getNameSmallCaps()));
        guitarStrings.add(guitarStringService.addGuitarString(GuitarStringEnum.G.getName(), GuitarStringEnum.G.getAlternativeName(), GuitarStringEnum.G.getNameSmallCaps()));
        guitarStrings.add(guitarStringService.addGuitarString(GuitarStringEnum.D.getName(), GuitarStringEnum.D.getAlternativeName(), GuitarStringEnum.D.getNameSmallCaps()));
        guitarStrings.add(guitarStringService.addGuitarString(GuitarStringEnum.A.getName(), GuitarStringEnum.A.getAlternativeName(), GuitarStringEnum.A.getNameSmallCaps()));
        guitarStrings.add(guitarStringService.addGuitarString(GuitarStringEnum.E6.getName(), GuitarStringEnum.E6.getAlternativeName(), GuitarStringEnum.E6.getNameSmallCaps()));
    }

    private void initChords() {
        // Dur chords
        initChord(ChordEnum.C, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(1, 2, 3, 3), 0, 0);
        initChord(ChordEnum.D, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G), Arrays.asList(2, 3, 2), 0, 0);
        initChord(ChordEnum.E, Arrays.asList(GuitarStringEnum.G, GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(1, 2, 2), 0, 0);
        initChord(ChordEnum.F, Arrays.asList(GuitarStringEnum.G, GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(2, 3, 3), 1, 0);
        initChord(ChordEnum.G, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.A, GuitarStringEnum.E6), Arrays.asList(3, 2, 3), 0, 0);
        initChord(ChordEnum.A, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(2, 2, 2), 0, 0);
        initChord(ChordEnum.H, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(3, 3, 3), 1, 0);

        // Moll chords
        initChord(ChordEnum.Cmi, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(2, 3, 3), 1, 3);
        initChord(ChordEnum.Dmi, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G), Arrays.asList(1, 3, 2), 0, 0);
        initChord(ChordEnum.Emi, Arrays.asList(GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(2, 2), 0, 0);
        initChord(ChordEnum.Fmi, Arrays.asList(GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(3, 3), 1, 0);
        initChord(ChordEnum.Gmi, Arrays.asList(GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(3, 3), 1, 3);
        initChord(ChordEnum.Ami, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(1, 2, 2), 0, 0);
        initChord(ChordEnum.Hmi, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(3, 4, 4), 2, 0);

        // Maj7 chords
        initChord(ChordEnum.Cmaj7, Arrays.asList(GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(2, 3), 0, 0);
        initChord(ChordEnum.Dmaj7, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G), Arrays.asList(2, 2, 2), 0, 0);
        initChord(ChordEnum.Emaj7, Arrays.asList(GuitarStringEnum.G, GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(1, 1, 2), 0, 0);
        initChord(ChordEnum.Fmaj7, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(1, 2, 3), 0, 0);
        initChord(ChordEnum.Gmaj7, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.A, GuitarStringEnum.E6), Arrays.asList(2, 2, 3), 0, 0);
        initChord(ChordEnum.Amaj7, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(2, 1, 2), 0, 0);
        initChord(ChordEnum.Hmaj7, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(4, 3, 4), 2, 0);

        // 7 chords
        initChord(ChordEnum.C7, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(1, 3, 2, 3), 0, 0);
        initChord(ChordEnum.D7, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G), Arrays.asList(2, 1, 2), 0, 0);
        initChord(ChordEnum.E7, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(3, 1, 2, 2), 0, 0);
        initChord(ChordEnum.F7, Arrays.asList(GuitarStringEnum.G, GuitarStringEnum.A), Arrays.asList(2, 3), 1, 0);
        initChord(ChordEnum.G7, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.A, GuitarStringEnum.E6), Arrays.asList(1, 2, 3), 0, 0);
        initChord(ChordEnum.A7, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.D), Arrays.asList(2, 2), 0, 0);
        initChord(ChordEnum.H7, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.G, GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(2, 2, 1, 2), 0, 0);

        initChord(ChordEnum.Cmi7, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(3, 1, 2, 2), 0, 4);
        initChord(ChordEnum.Dmi7, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G), Arrays.asList(1, 1, 2), 0, 0);
        initChord(ChordEnum.Emi7, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(3, 2, 2), 0, 0);
        initChord(ChordEnum.Fmi7, Arrays.asList(GuitarStringEnum.H, GuitarStringEnum.D, GuitarStringEnum.A), Arrays.asList(4, 3, 3), 1, 0);
        initChord(ChordEnum.Gmi7, Arrays.asList(GuitarStringEnum.A), Arrays.asList(3), 1, 3);
        initChord(ChordEnum.Ami7, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(3, 1, 2, 2), 0, 0);
        initChord(ChordEnum.Hmi7, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(3, 1, 2, 2), 0, 3);

        initChord(ChordEnum.Cdim, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(2, 1, 2, 1), 0, 0);
        initChord(ChordEnum.Ddim, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.G), Arrays.asList(1, 1), 0, 0);
        initChord(ChordEnum.Edim, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(3, 2, 3, 2), 0, 0);
        initChord(ChordEnum.Fdim, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(4, 3, 4, 3), 0, 0);
        initChord(ChordEnum.Gdim, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(3, 2, 3, 2), 0, 0);
        initChord(ChordEnum.Adim, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(2, 1, 2, 1), 0, 0);
        initChord(ChordEnum.Hdim, Arrays.asList(GuitarStringEnum.E1, GuitarStringEnum.H, GuitarStringEnum.G, GuitarStringEnum.D), Arrays.asList(4, 3, 4, 3), 0, 0);


    }

    private void initChord(ChordEnum chord, List<GuitarStringEnum> strings, List<Integer> fingers, Integer barrePosition, Integer realBarrePosition) {
        if (strings.size() != fingers.size()) {
            throw new IllegalArgumentException("Inputs has to be with same size");
        }
        addChord(chord.getName(), mapChordFingers(strings, fingers), barrePosition, realBarrePosition);
    }

    private Map<GuitarString, Integer> mapChordFingers(List<GuitarStringEnum> strings, List<Integer> fingers) {
        Map<GuitarString, Integer> fingersMap = new HashMap<>();
        for (int i = 0; i < strings.size(); i++) {
            fingersMap.put(loadStringByName(strings.get(i).getName()), fingers.get(i));
        }
        return fingersMap;
    }

    private void addChord(String chordName, Map<GuitarString, Integer> fingersMap, Integer barrePosition, Integer realBarrePosition) {
        Chord chord = new Chord();
        chord.setName(chordName);
        chord.setFingers(fingersMap);
        chord.setBarrePosition(barrePosition);
        chord.setRealBarrePositon(realBarrePosition);
        chord.setBlobImg(chordImageService.generateImage(chord));
        chordService.addChord(chord);
    }

    private GuitarString loadStringByName(String name) {
        return guitarStrings.stream().filter(t -> t.getName() == name).findFirst().get();
    }

}
