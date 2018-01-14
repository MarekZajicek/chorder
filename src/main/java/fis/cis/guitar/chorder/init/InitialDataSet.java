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
        initChord(ChordEnum.C.getName(), Arrays.asList(GuitarStringEnum.H.getName(), GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName(), GuitarStringEnum.A.getName()), Arrays.asList(1, 2, 3, 3), 0);
        initChord(ChordEnum.D.getName(), Arrays.asList(GuitarStringEnum.E1.getName(), GuitarStringEnum.H.getName(), GuitarStringEnum.G.getName()), Arrays.asList(2, 3, 2), 0);
        initChord(ChordEnum.E.getName(), Arrays.asList(GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName(), GuitarStringEnum.A.getName()), Arrays.asList(1, 2, 2), 0);
        initChord(ChordEnum.F.getName(), Arrays.asList(GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName(), GuitarStringEnum.A.getName()), Arrays.asList(2, 3, 3), 1);
        initChord(ChordEnum.G.getName(), Arrays.asList(GuitarStringEnum.E1.getName(), GuitarStringEnum.A.getName(), GuitarStringEnum.E6.getName()), Arrays.asList(3, 2, 3), 0);
        initChord(ChordEnum.A.getName(), Arrays.asList(GuitarStringEnum.H.getName(), GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName()), Arrays.asList(2, 2, 2), 0);
        initChord(ChordEnum.H.getName(), Arrays.asList(GuitarStringEnum.H.getName(), GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName()), Arrays.asList(3, 3, 3), 1);

        // Moll chords
        initChord(ChordEnum.Cmi.getName(), Arrays.asList(GuitarStringEnum.H.getName(), GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName(), GuitarStringEnum.A.getName()), Arrays.asList(1, 2, 3, 3), 0);
        initChord(ChordEnum.Dmi.getName(), Arrays.asList(GuitarStringEnum.E1.getName(), GuitarStringEnum.H.getName(), GuitarStringEnum.G.getName()), Arrays.asList(2, 3, 2), 0);
        initChord(ChordEnum.Emi.getName(), Arrays.asList(GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName(), GuitarStringEnum.A.getName()), Arrays.asList(1, 2, 2), 0);
        initChord(ChordEnum.Fmi.getName(), Arrays.asList(GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName(), GuitarStringEnum.A.getName()), Arrays.asList(2, 3, 3), 1);
        initChord(ChordEnum.Gmi.getName(), Arrays.asList(GuitarStringEnum.E1.getName(), GuitarStringEnum.A.getName(), GuitarStringEnum.E6.getName()), Arrays.asList(3, 2, 3), 0);
        initChord(ChordEnum.Ami.getName(), Arrays.asList(GuitarStringEnum.H.getName(), GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName()), Arrays.asList(2, 2, 2), 0);
        initChord(ChordEnum.Hmi.getName(), Arrays.asList(GuitarStringEnum.H.getName(), GuitarStringEnum.G.getName(), GuitarStringEnum.D.getName()), Arrays.asList(3, 3, 3), 1);
    }

    private void initChord(String chordName, List<String> strings, List<Integer> fingers, Integer barrePosition) {
        if (strings.size() != fingers.size()) {
            throw new IllegalArgumentException("Inputs has to be with same size");
        }
        addChord(chordName, mapChordFingers(strings, fingers), barrePosition);
    }

    private Map<GuitarString, Integer> mapChordFingers(List<String> strings, List<Integer> fingers) {
        Map<GuitarString, Integer> fingersMap = new HashMap<>();
        for (int i = 0; i < strings.size(); i++) {
            fingersMap.put(loadStringByName(strings.get(i)), fingers.get(i));
        }
        return fingersMap;
    }

    private void addChord(String chordName, Map<GuitarString, Integer> fingersMap, Integer barrePosition) {
        Chord chord = new Chord();
        chord.setName(chordName);
        chord.setFingers(fingersMap);
        chord.setBarrePosition(barrePosition);
        chord.setBlobImg(chordImageService.generateImage(chord));
        chordService.addChord(chord);
    }

    private GuitarString loadStringByName(String name) {
        return guitarStrings.stream().filter(t -> t.getName() == name).findFirst().get();
    }

}
