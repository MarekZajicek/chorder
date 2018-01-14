package fis.cis.guitar.chorder.service;

import fis.cis.guitar.chorder.entity.Chord;
import fis.cis.guitar.chorder.entity.GuitarString;
import fis.cis.guitar.chorder.service.api.ChordImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class ChordImageServiceImpl implements ChordImageService {

    private static final String IMAGE_FORMAT = "jpg";

    private static final Logger LOGGER = LoggerFactory.getLogger(ChordImageServiceImpl.class);

    @Override
    public byte[] generateImage(Chord chord) {
        BufferedImage image = new BufferedImage(176, 208, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setPaint(new Color(255, 255, 255));
        graphics.fillRect(0, 0, 176, 208);
        graphics.setPaint(new Color(0, 0, 0));
        drawBase(graphics);

        for (Map.Entry<GuitarString, Integer> entry : chord.getFingers().entrySet()) {
            Integer stringPosition = getStringPosition(entry.getKey());
            Integer fingerPosition = getFingerPosition(entry.getValue());
            drawFinger(stringPosition, fingerPosition, graphics);
        }

        if (chord.getBarrePosition() != null){
            drawBarre(chord.getBarrePosition(), graphics);
        }

        return getByteArray(image);
    }

    private void drawBarre(Integer barrePosition, Graphics2D graphics){
        if(barrePosition > 0) {
            graphics.fillRoundRect(10, ((barrePosition - 1) * 50) + 15, 156, 20, 20, 20);
        }
    }

    private void drawFinger(Integer stringPosition, Integer fingerPosition, Graphics2D graphics){
        graphics.fillOval(stringPosition, fingerPosition - 10, 20, 20);
    }

    private int getStringPosition(GuitarString guitarString) {
        return (int) (5 - (guitarString.getId() - 1)) * 30;
    }

    private int getFingerPosition(Integer fingerValue) {
        return ((fingerValue - 1) * 50) + 25;
    }

    private void drawBase(Graphics2D graphics) {
        //Hlavní pražec
        graphics.fillRect(10, 0, 156, 4);

        //Další pražce
        graphics.fillRect(10, 54, 156, 1);
        graphics.fillRect(10, 105, 156, 1);
        graphics.fillRect(10, 156, 156, 1);
        graphics.fillRect(10, 207, 156, 1);

        //Struny
        graphics.fillRect(10, 0, 1, 208);
        graphics.fillRect(41, 0, 1, 208);
        graphics.fillRect(72, 0, 1, 208);
        graphics.fillRect(103, 0, 1, 208);
        graphics.fillRect(134, 0, 1, 208);
        graphics.fillRect(165, 0, 1, 208);
    }

    private byte[] getByteArray(BufferedImage image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteImage = null;
        try {
            ImageIO.write(image, IMAGE_FORMAT, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteImage = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            LOGGER.debug("Error occured during transforming BufferedImage into byte array. Error: %s", e.getMessage());
        }
        return byteImage;
    }
}
