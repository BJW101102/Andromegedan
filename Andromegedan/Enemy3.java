package FinalProject;

import basicgraphics.Clock;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Andromegedan.eCount;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Andromegedan.screenY;
import static FinalProject.Andromegedan.upperbound;

public class Enemy3 extends Sprite {

    boolean e3Alive = true;
    Picture Enemy3;
    double xVel = 0.5;
    double yVel = 0.5;
    double eVel = 0.3;
    int health = 3;

    public Enemy3(SpriteComponent sc) {
        super(sc);
        if (screenX > upperbound){
        eVel = 0.7;
        }
        eCount++;
        Enemy3 = new Picture("e3.png");
        setPicture(Enemy3);
        setX(screenX * .75);
        setVelX(eVel);
        Task bound = new Task() {
            @Override
            public void run() {
                if (getX() <= screenX / 2 - 100 && e3Alive == true) {
                    setVelX(xVel * 2);
                    EBullet pl = new EBullet(sc, 1.5);
                    pl.setVelX(-eVel);
                    pl.setVelY(0);
                    pl.setX(centerX());
                    pl.setY(centerY());
                    EBullet e2 = new EBullet(sc, 1.5);
                    e2.setVelX(-eVel);
                    e2.setVelY(0);
                    e2.setX(centerX());
                    e2.setY(centerY());
                }
            }
        };
        Task offScreen = new Task() {
            @Override
            public void run() {
                if (getX() > screenX && getX() > screenY) {
                    setActive(false);
                }
            }

        };
        Clock.addTask(offScreen);
        Clock.addTask(bound);
    }

    public void setActive(boolean b) {
        if (isActive() == b) {
            return;
        }
        if (b) {
            eCount++;
        } else {
            e3Alive = false;
            eCount--;
        }
        super.setActive(b);
    }

    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.eventType == CollisionEventType.WALL) {
            if (se.xlo) {
                setVelX(xVel + 0.125);
            }
            if (se.xhi) {
                setVelX(-(xVel + 0.125));
            }
            if (se.ylo) {
                setVelY(yVel + 0.125);
            }
            if (se.yhi) {
                setVelY(-(yVel + 0.125));
            }
        }
    }
}
