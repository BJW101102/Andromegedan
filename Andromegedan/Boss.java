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
import static FinalProject.Andromegedan.eCount;

public class Boss extends Sprite {

    boolean bossAlive = true;
    Picture Boss;
    static double bHealth = 20;
    static double bVel = 0.3;
    double eVel = 0.3;
    static boolean bossDefeated = false;

    public Boss(SpriteComponent sc) {
        super(sc);
        eCount++;
        Boss = new Picture("Boss.png");
        setPicture(Boss);
        setX(screenX - 100);
        setY(screenY / 2);
        setVelX(bVel);
        setVelY(bVel);
        Task bound = new Task() {
            @Override
            public void run() {
                double point = screenX / 2 - 50;
                double point2 = screenX * .7;
                if (getX() <= point && bossAlive == true) {
                    Enemy2 e2 = new Enemy2(sc);
                    e2.setX(getX());
                    e2.setY(getY());
                    setVelX(bVel);
                    Enemy1 e1 = new Enemy1(sc);
                    e1.setX(getX());
                    e1.setY(getY());
                    bVel = bVel + 0.05;
                    if (bVel >= 1.5) {
                        bVel = 1.5;
                    }
                    System.out.println(bVel);
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
            bossAlive = false;
        }
        eCount--;
        super.setActive(b);
    }

    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.eventType == CollisionEventType.WALL) {
            if (se.xlo) {
                setVelX(bVel);
            }
            if (se.xhi) {
                setVelX(-bVel);
            }
            if (se.ylo) {
                setVelY(bVel);
            }
            if (se.yhi) {
                setVelY(-bVel);
            }
        }
    }
}
