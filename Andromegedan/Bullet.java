package FinalProject;

import basicgraphics.BasicFrame;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends Sprite {

    //Bullet for Player
    public static Picture makeLine(Color color, int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(color);
        g.drawLine(0, 0, size, 0);
        return new Picture(im);
    }

    public Bullet(SpriteComponent sc) {
        super(sc);
        setPicture(makeLine(Color.green, 10));
    }

    @Override
    public void processEvent(SpriteCollisionEvent se) {
        setActive(false);
    }
}
