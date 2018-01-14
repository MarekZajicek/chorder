package fis.cis.guitar.chorder.service;

import fis.cis.guitar.chorder.entity.Chord;
import fis.cis.guitar.chorder.entity.GuitarString;
import fis.cis.guitar.chorder.service.api.ChordImageService;
import fis.cis.guitar.chorder.service.api.ColorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class ChordImageServiceImpl implements ChordImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChordImageServiceImpl.class);

    private static final String IMAGE_FORMAT = "jpg";
    private static final Integer IMAGE_WIDTH = 176;
    private static final Integer IMAGE_HEIGHT = 208;
    private static final Integer IMAGE_ZERO_POINT = 0;
    private static final Integer LINE_WIDTH = 1;
    private static final Integer IMAGE_WIDTH_OFFSET = 20;
    private static final Integer STRINGS_OFFSET = 30;
    private static final Integer FRET_OFFSET = 50;
    private static final Integer FINGER_POINT_WIDTH = 20;
    private static final Integer FINGER_POINT_HEIGHT = 20;
    private static final Integer MAIN_FRET_HEIGHT = 4;
    private static final Integer MAX_STRING_ID = 5;

    @Autowired
    private ColorService colorService;

    @Override
    public byte[] generateImage(Chord chord) {
        BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setPaint(colorService.getWhiteColor());
        graphics.fillRect(IMAGE_ZERO_POINT, IMAGE_ZERO_POINT, IMAGE_WIDTH, IMAGE_HEIGHT);
        graphics.setPaint(colorService.getBlackColor());

        drawBase(graphics);

        for (Map.Entry<GuitarString, Integer> entry : chord.getFingers().entrySet()) {
            drawFinger(getStringPosition(entry.getKey()), getFingerPosition(entry.getValue()), graphics);
        }

        if (chord.getBarrePosition() != null && chord.getBarrePosition() > 0) {
            drawBarre(chord.getBarrePosition(), graphics);
        }

        if (chord.getRealBarrePositon() != null && chord.getRealBarrePositon() > 0){
            drawBarrePosition(chord.getRealBarrePositon(), graphics);
        }


        return getByteArray(image);
    }

    private void drawBase(Graphics2D graphics) {
        //Main fret
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2, IMAGE_ZERO_POINT, IMAGE_WIDTH - IMAGE_WIDTH_OFFSET, MAIN_FRET_HEIGHT);

        //Other frets
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2, FRET_OFFSET + MAIN_FRET_HEIGHT, IMAGE_WIDTH - IMAGE_WIDTH_OFFSET, LINE_WIDTH);
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2, 2 * FRET_OFFSET + MAIN_FRET_HEIGHT + LINE_WIDTH, IMAGE_WIDTH - IMAGE_WIDTH_OFFSET, LINE_WIDTH);
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2, 3 * FRET_OFFSET + MAIN_FRET_HEIGHT + 2 * LINE_WIDTH, IMAGE_WIDTH - IMAGE_WIDTH_OFFSET, LINE_WIDTH);
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2, 4 * FRET_OFFSET + MAIN_FRET_HEIGHT + 3 * LINE_WIDTH, IMAGE_WIDTH - IMAGE_WIDTH_OFFSET, LINE_WIDTH);

        //Strings
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2, IMAGE_ZERO_POINT, LINE_WIDTH, IMAGE_HEIGHT);
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2 + STRINGS_OFFSET + LINE_WIDTH, IMAGE_ZERO_POINT, LINE_WIDTH, IMAGE_HEIGHT);
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2 + 2 * STRINGS_OFFSET + 2 * LINE_WIDTH, IMAGE_ZERO_POINT, LINE_WIDTH, IMAGE_HEIGHT);
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2 + 3 * STRINGS_OFFSET + 3 * LINE_WIDTH, IMAGE_ZERO_POINT, LINE_WIDTH, IMAGE_HEIGHT);
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2 + 4 * STRINGS_OFFSET + 4 * LINE_WIDTH, IMAGE_ZERO_POINT, LINE_WIDTH, IMAGE_HEIGHT);
        graphics.fillRect(IMAGE_WIDTH_OFFSET / 2 + 5 * STRINGS_OFFSET + 5 * LINE_WIDTH, IMAGE_ZERO_POINT, LINE_WIDTH, IMAGE_HEIGHT);
    }

    private void drawBarrePosition(Integer barrePosition, Graphics2D graphics){
        graphics.setFont(new Font("Serif", Font.BOLD, 18));
        graphics.drawString(barrePosition.toString(), 0, 35);
    }

    private void drawBarre(Integer barrePosition, Graphics2D graphics) {
        graphics.fillRoundRect(IMAGE_WIDTH_OFFSET / 2, ((barrePosition - 1) * FRET_OFFSET) + (FRET_OFFSET - FINGER_POINT_HEIGHT) / 2 + MAIN_FRET_HEIGHT, IMAGE_WIDTH - IMAGE_WIDTH_OFFSET, FINGER_POINT_HEIGHT, FINGER_POINT_WIDTH, FINGER_POINT_HEIGHT);
    }

    private void drawFinger(Integer stringPosition, Integer fingerPosition, Graphics2D graphics) {
        graphics.fillOval(stringPosition, fingerPosition - FINGER_POINT_HEIGHT / 2 + MAIN_FRET_HEIGHT, FINGER_POINT_WIDTH, FINGER_POINT_HEIGHT);
    }

    private int getStringPosition(GuitarString guitarString) {
        return (int) ((MAX_STRING_ID - (guitarString.getId() - 1)) * STRINGS_OFFSET + (MAX_STRING_ID - (guitarString.getId() - 1)) * LINE_WIDTH);
    }

    private int getFingerPosition(Integer fingerValue) {
        return ((fingerValue - 1) * FRET_OFFSET) + FRET_OFFSET / 2;
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
