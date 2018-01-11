package fis.cis.guitar.chorder.service.api;

import fis.cis.guitar.chorder.entity.GuitarString;
import fis.cis.guitar.chorder.repository.api.GuitarStringDao;

import java.util.List;

public interface GuitarStringService {
    GuitarString findById(Long id);

    List<GuitarString> findAll();

    GuitarString findByName(String name);

    GuitarString addGuitarString(GuitarString guitarString);

    GuitarString addGuitarString(String name, String alternativeName, String smallCapsName);

}
