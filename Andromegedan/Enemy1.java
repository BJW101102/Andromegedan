package FinalProject;

import static FinalProject.Andromegedan.RAND;
import basicgraphics.Clock;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.eCount;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Andromegedan.screenY;
import java.util.Random;

public class Enemy1 extends Sprite {

    boolean e1Alive = true;
    Random rand = new Random();
    int size = 20;
    int pos;
    Picture Enemy;
    double xVel = RAND.nextDouble();
    double yVel = xVel;
    double eVel = 0.8;

    public Enemy1(SpriteComponent sc) {
        super(sc);
        eCount++;
        Enemy = new Picture("e1.png");
        setPicture(Enemy);
        setX(screenX - 150);
        setVelX(xVel);
        setVelY(yVel);
        Task bound = new Task() {
            @Override
            public void run() {
                if (getX() <= screenX / 2 - 100 && e1Alive == true) {
                    setVelX(xVel);
                    EBullet pl = new EBullet(sc);
                    pl.setVelX(-eVel);
                    pl.setVelY(0);
                    pl.setX(centerX());
                    pl.setY(centerY());
                }
                if (screenX >= 1000) {
                    double bound = (screenX / 2) + 300;
                    if (getX() >= bound && getX() <= bound + 1 && e1Alive == true) {
                        EBullet b = new EBullet(sc);
                        b.setVelX(-eVel);
                        b.setVelY(0);
                        b.setX(centerX());
                        b.setY(centerY());
                    }
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
            e1Alive = false;
        }
        eCount--;
        super.setActive(b);
    }

    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.eventType == CollisionEventType.WALL) {
            if (se.xlo) {
                setVelX(yVel + 0.125);
            }
            if (se.xhi) {
                setVelX(-(yVel + 0.125));
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
