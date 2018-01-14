package fis.cis.guitar.chorder.service;

import fis.cis.guitar.chorder.entity.Chord;
import fis.cis.guitar.chorder.repository.api.ChordDao;
import fis.cis.guitar.chorder.service.api.ChordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChordServiceImpl implements ChordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChordService.class);

    @Autowired
    private ChordDao chordDao;


    @Override
    public Chord findById(Long id) {
        LOGGER.debug(String.format("Chord with id '%d' will be searched in the database", id));
        return chordDao.findById(id);
    }

    @Override
    public List<Chord> findAll() {
        LOGGER.debug("All chords will be retrieved from the database");
        return chordDao.findAll();
    }

    @Override
    public List<Chord> findByName(String name) {
        LOGGER.debug(String.format("Chord with name '%s' will be searched in the database", name));
        return chordDao.findByName(name);
    }

    @Override
    public Chord addChord(Chord chord) {
        if (chordDao.findByName(chord.getName()) != null){
            LOGGER.debug(String.format("Chord with name '%s' already exists. No operation will be performed", chord.getName()));
        }
        LOGGER.debug(String.format("Chord with name '%s' will be added to the database", chord.getName()));
        return chordDao.addChord(chord);
    }
}
