package FinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.screenX;
import java.awt.Dimension;

public class BossHealthBar extends Sprite {

    static Picture bHealth;

    public BossHealthBar(SpriteComponent sc, String s) {
        super(sc);
        bHealth = new Picture(s);
        Dimension d = sc.getSize();
        setPicture(bHealth);
        setY(10);
        setX(screenX - 300);
    }

}
