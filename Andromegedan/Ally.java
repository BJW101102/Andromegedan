package FinalProject;

import basicgraphics.Clock;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.RAND;
import static FinalProject.Andromegedan.eCount;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Player.rocketX;
import static FinalProject.Player.rocketY;

public class Ally extends Sprite {

    boolean allyAlive = true;
    static Picture Ally;
    int health = 5;
    static int aCount;
    double axVel = 0.6;
    double ayVel = RAND.nextDouble();
    double bVel = 1;

    public Ally(SpriteComponent sc) {
        super(sc);
        aCount++;
        Ally = new Picture("Ah5.png");
        setPicture(Ally);
        setX(rocketX);
        setY(rocketY);
        setVelX(axVel);
        setVelY(ayVel);
        Task bound = new Task() {
            @Override
            public void run() {
                if (getX() >= (rocketX)) {
                    setVelX(-axVel);
                    Bullet b = new Bullet(sc);
                    b.setVelX(bVel);
                    b.setVelY(0);
                    b.setX(centerX());
                    b.setY(centerY());
                }
            }
        };
        Task shoot = new Task() {
            @Override
            public void run() {
                if (getX() <= screenX - screenX && allyAlive == true) {
                    Bullet ab = new Bullet(sc);
                    ab.setVelX(bVel);
                    ab.setVelY(0);
                    ab.setX(centerX());
                    ab.setY(centerY());
                }
            }
        };
        Clock.addTask(shoot);
        Clock.addTask(bound);
    }

    @Override
    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.xlo) {
            setVelX(axVel);
        }
        if (se.xhi) {
            setX(-axVel);
        }
        if (se.ylo) {
            setVelY(ayVel);
        }
        if (se.yhi) {
            setVelY(-ayVel);
        }
    }

    public void setActive(boolean b) {
        if (isActive() == b) {
            return;
        }
        if (b) {
            aCount++;
        } else {
            allyAlive = false;
            aCount--;
        }
        super.setActive(b);

    }
}
