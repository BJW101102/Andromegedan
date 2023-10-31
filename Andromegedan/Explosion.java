/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import static FinalProject.Andromegedan.RAND;
import static FinalProject.Andromegedan.screenX;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

/**
 *
 * @author ender
 */
public class Explosion extends Sprite {

    Picture Explosion;
    double eVelx = 0.5;
    double eVely;
    static int exCount;

    public Explosion(SpriteComponent sc) {
        super(sc);
        Explosion = new Picture("explosion.png");
        setPicture(Explosion);
        setVelX(eVelx);
        setVelY(eVelx);  
    }
    
    public Explosion(SpriteComponent sc, int n){
     super(sc);
        Explosion = new Picture("explosion2.png");
        setPicture(Explosion);
        setVelX(eVelx);
        setVelY(eVelx);  
    }

    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.eventType == CollisionEventType.WALL_INVISIBLE) {
            if (se.xlo) {
                setActive(false);
            }
            if (se.xhi) {
                setActive(false);
            }
            if (se.ylo) {
                setActive(false);
            }
            if (se.yhi) {
                setActive(false);
            }
        }
    }

}
