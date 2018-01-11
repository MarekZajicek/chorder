package fis.cis.guitar.chorder.service;

import fis.cis.guitar.chorder.entity.Chord;
import fis.cis.guitar.chorder.entity.GuitarString;
import fis.cis.guitar.chorder.repository.api.ChordDao;
import fis.cis.guitar.chorder.repository.api.GuitarStringDao;
import fis.cis.guitar.chorder.service.api.ChordService;
import fis.cis.guitar.chorder.service.api.GuitarStringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarStringServiceImpl implements GuitarStringService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GuitarStringService.class);

    @Autowired
    private GuitarStringDao guitarStringDao;


    @Override
    public GuitarString findById(Long id) {
        LOGGER.debug(String.format("Guitar string with id '%d' will be searched in the database", id));
        return guitarStringDao.findById(id);
    }

    @Override
    public List<GuitarString> findAll() {
        LOGGER.debug("All guitar strings will be retrieved from the database");
        return guitarStringDao.findAll();
    }

    @Override
    public GuitarString findByName(String name) {
        LOGGER.debug(String.format("Guitar string with name '%s' will be searched in the database", name));
        return guitarStringDao.findByName(name);
    }

    @Override
    public GuitarString addGuitarString(GuitarString guitarString) {
        if (guitarStringDao.findByName(guitarString.getName()) != null){
            LOGGER.debug(String.format("Chord with name '%s' already exists. No operation will be performed", guitarString.getName()));
        }
        LOGGER.debug(String.format("Chord with name '%s' will be added to the database", guitarString.getName()));
        return guitarStringDao.addGuitarString(guitarString);
    }

    @Override
    public GuitarString addGuitarString(String name, String alternativeName, String smallCapsName) {
        if (guitarStringDao.findByName(name) != null){
            LOGGER.debug(String.format("Chord with name '%s' already exists. No operation will be performed", name));
        }
        LOGGER.debug(String.format("Chord with name '%s' will be added to the database", name));
        return guitarStringDao.addGuitarString(name, alternativeName, smallCapsName);
    }
}
