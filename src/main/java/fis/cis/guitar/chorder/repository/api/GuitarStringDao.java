package fis.cis.guitar.chorder.repository.api;

import fis.cis.guitar.chorder.entity.GuitarString;

import java.util.List;

public interface GuitarStringDao {

    GuitarString findById(Long id);

    List<GuitarString> findAll();

    GuitarString findByName(String name);

    GuitarString addGuitarString(GuitarString guitarString);

    GuitarString addGuitarString(String name, String alternativeName, String smallCapsName);

}
