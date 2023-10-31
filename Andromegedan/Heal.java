package FinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.screenX;
import basicgraphics.CollisionEventType;

public class Heal extends Sprite {

    static Picture Heal;
    double xVel = 0.5;
    double yVel = 0.5;

    public Heal(SpriteComponent sc) {
        super(sc);
        Heal = new Picture("heal.png");
        setPicture(Heal);
        setVelX(-xVel);
        setX(screenX * .75);
        setY(screenX * .25);
    }

    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.eventType == CollisionEventType.WALL) {
            if (se.xlo) {
               setActive(false);
            }
            if (se.xhi) {
                setVelX(-xVel);
            }
            if (se.ylo) {
                setVelY(yVel);
            }
            if (se.yhi) {
                setVelY(-yVel);
            }
        }
    }
}
