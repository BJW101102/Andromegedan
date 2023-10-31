package FinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.screenX;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class WaveBoard extends Sprite {

    static Picture wBCount;

    public WaveBoard(SpriteComponent sc, String f) {
        super(sc);
        wBCount = new Picture(f);
        setPicture(wBCount);
        setY(20);
        setX(screenX - (screenX - 25));
    }

}
