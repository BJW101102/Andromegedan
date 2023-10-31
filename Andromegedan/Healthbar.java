package FinalProject;

import static FinalProject.Andromegedan.RAND;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Andromegedan.vel;
import basicgraphics.SpriteCollisionEvent;
import java.awt.Dimension;

public class Healthbar extends Sprite {

    static Picture Health;
    String pic;



    public Healthbar(SpriteComponent sc, String f) {
        super(sc);
        Health = new Picture(f);
        Dimension d = sc.getSize();
        setPicture(Health);
        setX((200));
        setY(10);       
    }
}
