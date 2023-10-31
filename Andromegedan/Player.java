package FinalProject;

import basicgraphics.Clock;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Andromegedan.screenY;
import static FinalProject.Andromegedan.vel;
import java.awt.Dimension;

public class Player extends Sprite {

    Picture Rocket;
    static double rocketX = screenX * .3;
    static double rocketY = screenY * .25;
    public static int health = 10;

    public Player(SpriteComponent sc) {
        super(sc);
        Rocket = new Picture("Player.png");
        setPicture(Rocket);
        Dimension d = sc.getSize();
        setX(rocketX); //Change To Middle
        setY(rocketY); //Change To Middle 
        setVelX(0);
        setVelY(0);
        Task bound = new Task() {
            @Override
            public void run() {
                if (getX() >= (screenX - 350)) {
                    setVelX(-vel);
                }
            }
        };
        Clock.addTask(bound);
    }

    @Override
    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.xlo) {
            setVelX(vel);
        }
        if (se.xhi) {
            setX(0);
        }
        if (se.ylo) {
            setVelY(vel);
        }
        if (se.yhi) {
            setVelY(-vel);
        }
    }
}
