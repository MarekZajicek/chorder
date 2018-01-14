package fis.cis.guitar.chorder.controller;

import fis.cis.guitar.chorder.entity.Chord;
import fis.cis.guitar.chorder.repository.api.ChordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ChordController {

    @Autowired
    private ChordDao chordDao;

    @GetMapping("/chords")
    public ModelAndView getChords(){
        ModelAndView modelAndView = new ModelAndView("chords");
        modelAndView.addObject("chords", chordDao.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/image/id/{chord_id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImageByID(@PathVariable("chord_id") Long chordID) {
        Chord chord = chordDao.findById(chordID);
        byte[] imageContent = chord.getBlobImg();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/image/name/{chord_name}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImageByName(@PathVariable("chord_name") String name) {
        Chord chord = chordDao.findByName(name);
        byte[] imageContent = chord.getBlobImg();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
    }
}
