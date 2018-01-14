package fis.cis.guitar.chorder.repository.api;

import fis.cis.guitar.chorder.entity.Chord;

import java.util.List;

public interface ChordDao {

    Chord findById(Long id);

    List<Chord> findAll();

    Chord findByName(String name);

    List<Chord> findByNameLike(String name);

    Chord addChord(Chord chord);
}
