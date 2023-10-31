package FinalProject;

import basicgraphics.BasicFrame;
import basicgraphics.Clock;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.RAND;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class EBullet extends Sprite {

    Picture miniBullet;
    static boolean active;
    //This is needed to avoid the enemy from spawing mutliple bullets if they are get at the exact point of execution

    //Red Lazer for Enemy1
    public EBullet(SpriteComponent sc) {
        super(sc);
        setPicture(makeLine(Color.red, 10));
    }

    //Donut Lazer for Enemy2 
    public EBullet(SpriteComponent sc, int i) {
        super(sc);
        setPicture(makeBall(10));       
    }

    //Bigger Donut Lazer for Enemy3 that splits into two once hitting the barrier
    public EBullet(SpriteComponent sc, double b) {
        super(sc);
        setPicture(makeE3Ball(15));
        Task bound = new Task() {
            @Override
            public void run() {
                if (is_visible == true) {
                    if (getX() <= 10) {
                        setVelX(RAND.nextDouble());
                        setVelY(RAND.nextDouble());
                    }
                }
            }
        };
        Clock.addTask(bound);
    }
    
    //Lazer for MiniBoss
    public EBullet(SpriteComponent sc, String s) {
        super(sc);
        miniBullet = new Picture("eBleft.png");
        setPicture(miniBullet);
    }

    @Override
    public void processEvent(SpriteCollisionEvent se) {
        setActive(false);
    }

    static Picture makeE3Ball(int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(new Color(229, 229, 229));
        g.fillOval(0, 0, size, size);
        g.setColor(Color.black);
        g.fillOval((size / 2) / 2, (size / 2) / 2, size / 2, size / 2);
        return new Picture(im);
    }

    static Picture makeBall(int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(Color.pink);
        g.fillOval(0, 0, size, size);
        g.setColor(Color.black);
        g.fillOval(2, 2, 5, 5);
        return new Picture(im);
    }

    public static Picture makeLine(Color color, int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(color);
        g.drawLine(0, 0, size, 0);
        return new Picture(im);
    }
}
