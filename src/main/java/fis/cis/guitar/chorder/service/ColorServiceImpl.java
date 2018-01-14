package fis.cis.guitar.chorder.service;

import fis.cis.guitar.chorder.service.api.ColorService;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class ColorServiceImpl implements ColorService {

    @Override
    public Color getWhiteColor() {
        return new Color(255, 255, 255);
    }

    @Override
    public Color getBlackColor() {
        return new Color(0, 0 ,0);
    }
}
