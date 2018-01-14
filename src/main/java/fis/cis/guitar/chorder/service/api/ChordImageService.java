package fis.cis.guitar.chorder.service.api;

import fis.cis.guitar.chorder.entity.Chord;

public interface ChordImageService {

    byte[] generateImage(Chord chord);
}
