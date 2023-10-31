package FinalProject;

import basicgraphics.Clock;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Andromegedan.screenY;
import java.util.Random;
import static FinalProject.Andromegedan.eCount;

public class MiniBoss extends Sprite {

    boolean miniAlive = true;
    static Random rand = new Random();
    int pos;
    static double mBvel = 0.6;
    double eHealth = 5;
    static Picture MiniBoss;
    static int xPos = 600;
    static int miniBCount;
    double eVel = 0.8;

    public MiniBoss(SpriteComponent sc) {
        super(sc);
        eCount++;
        MiniBoss = new Picture("e3h5.png"); //enemy3
        setPicture(MiniBoss);
        setX(xPos);
        setX(screenY / 2);
        setVelX(mBvel);
        setVelY(mBvel);
        Task bound = new Task() {
            @Override
            public void run() {
                double point = screenX / 2 - 50;
                double point2 = screenX * .7;
                if (getX() <= point && miniAlive == true) {
                    setVelX(mBvel);
                    EBullet eb = new EBullet(sc, "bossbullet");
                    eb.setVelX(-eVel);
                    eb.setVelY(0);
                    eb.setX(centerX());
                    eb.setY(centerY());
                    EBullet eb2 = new EBullet(sc, "bossbullet");
                    eb2.setVelX(-eVel);
                    eb2.setVelY(0);
                    eb2.setX(centerX());
                    eb2.setY(centerY() - 90);
                } else if ((getX() >= point2 && getX() <= point2 + 0.5) && miniAlive == true) {
                    EBullet eb = new EBullet(sc, "bossbullet");
                    eb.setVelX(-.8);
                    eb.setVelY(0);
                    eb.setX(centerX());
                    eb.setY(centerY());
                    EBullet eb2 = new EBullet(sc, "bossbullet");
                    eb2.setVelX(-.8);
                    eb2.setVelY(0);
                    eb2.setX(centerX());
                    eb2.setY(centerY() - 90);
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
            miniAlive = false;
        }
        eCount--;
        super.setActive(b);
    }

    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.eventType == CollisionEventType.WALL) {
            if (se.xlo) {
                setVelX(mBvel + 0.25);
            }
            if (se.xhi) {
                setVelX(-(mBvel + 0.25));
            }
            if (se.ylo) {
                setVelY(mBvel + 0.25);
            }
            if (se.yhi) {
                setVelY(-(mBvel + 0.25));
            }
        }
    }
}
