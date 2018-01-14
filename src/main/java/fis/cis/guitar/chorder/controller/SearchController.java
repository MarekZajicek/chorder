package fis.cis.guitar.chorder.controller;

import fis.cis.guitar.chorder.repository.api.ChordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SearchController {

    @Autowired
    private ChordDao chordDao;

    @PostMapping("/search")
    public ModelAndView searchChord(@RequestParam String chordName){
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("chords", chordDao.findByNameLike(chordName));
        return modelAndView;
    }
}
