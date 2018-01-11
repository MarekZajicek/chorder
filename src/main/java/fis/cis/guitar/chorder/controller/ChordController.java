package fis.cis.guitar.chorder.controller;

import fis.cis.guitar.chorder.entity.Chord;
import fis.cis.guitar.chorder.repository.api.ChordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChordController {

    @Autowired
    private ChordDao chordDao;

    @RequestMapping(value = "/chords/{chordName}", method = RequestMethod.GET)
    public Chord getChord(@PathVariable("chordName") String chordName){
        return chordDao.findByName(chordName);
    }

    @RequestMapping(value = "/chords")
    public List<Chord> getChords(){
        return chordDao.findAll();
    }
}
