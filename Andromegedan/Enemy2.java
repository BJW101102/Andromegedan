package FinalProject;

import basicgraphics.Clock;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.RAND;
import static FinalProject.Andromegedan.eCount;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Andromegedan.screenY;
import java.util.Random;

public class Enemy2 extends Sprite {

    boolean e2Alive = true;
    double vel = 0.8;
    double e2xVel = RAND.nextDouble();
    double e2yVel = RAND.nextDouble();
    double e2bVel = 0.5;
    Picture Enemy2;

    public Enemy2(SpriteComponent sc) {
        super(sc);
        Random rand = new Random(2);
        eCount++;
        Enemy2 = new Picture("e2.png");
        setPicture(Enemy2);
        setX(screenX - 200);
        setVelX(e2xVel);
        setVelY(e2yVel);

        Task bound = new Task() {
            @Override
            public void run() {
                if (getX() <= screenX / 2 - 100 && e2Alive == true) {
                    setVelX(e2xVel);
                    EBullet pl = new EBullet(sc, 1);
                    pl.setVelX(-e2bVel);
                    pl.setVelY(0);
                    pl.setX(centerX());
                    pl.setY(centerY());
                }
                double shootX = screenX * 0.6;
                if (screenX >= 1000) {
                    double bound = (screenX / 2) + 300;
                    if (getX() >= bound && getX() <= bound + 1 && e2Alive == true) {
                        EBullet b = new EBullet(sc, 1);
                        b.setVelX(-e2bVel);
                        b.setVelY(0);
                        b.setX(centerX());
                        b.setY(centerY());
                        EBullet b2 = new EBullet(sc, 1);
                        b2.setVelX(-e2bVel);
                        b2.setVelY(0);
                        b2.setX(centerX() - 10);
                        b2.setY(centerY());
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
            e2Alive = false;
            eCount--;
        }
        super.setActive(b);
    }

    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.eventType == CollisionEventType.WALL) {
            if (se.xlo) {
                setVelX(e2xVel + 0.125);
            }
            if (se.xhi) {
                setVelX(-(e2xVel + 0.125));
            }
            if (se.ylo) {
                setVelY(e2yVel + 0.125);
            }
            if (se.yhi) {
                setVelY(-(e2xVel + 0.125));
            }
        }
    }
}
