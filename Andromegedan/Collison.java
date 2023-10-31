package FinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.SpriteSpriteCollisionListener;
import basicgraphics.images.Picture;
import static FinalProject.Andromegedan.eCount;
import static FinalProject.Andromegedan.h;
import static FinalProject.Andromegedan.Bh;
import static FinalProject.Healthbar.Health;
import static FinalProject.BossHealthBar.bHealth;
import javax.swing.JOptionPane;
import static FinalProject.MiniBoss.MiniBoss;
import static FinalProject.Ally.Ally;
import static FinalProject.Ally.aCount;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Andromegedan.screenY;
import static FinalProject.Andromegedan.upperbound;
import static FinalProject.Boss.bossDefeated;
import static FinalProject.Andromegedan.RAND;

//Organize all the Collisons withing the game
public class Collison {

    public void collison(SpriteComponent sc) {

        /*PLAYER & ALLY <---> ENEMIES/BULLET/HEALTH COLLISON*/
        //Player <--> Enemy1 Collison
        sc.addSpriteSpriteCollisionListener(Player.class, Enemy1.class, new SpriteSpriteCollisionListener<Player, Enemy1>() {
            @Override
            public void collision(Player sp1, Enemy1 sp2) {
                rocketSpriteCollison(sp1, sc, sp2);
            }
        });

        //Ally <--> Enemy1 Collison
        sc.addSpriteSpriteCollisionListener(Ally.class, Enemy1.class, new SpriteSpriteCollisionListener<Ally, Enemy1>() {
            @Override
            public void collision(Ally sp1, Enemy1 sp2) {
                allySpriteCollison(sp1, sc, sp2);
            }
        });

        //Player <--> Enemy2 Collison
        sc.addSpriteSpriteCollisionListener(Player.class, Enemy2.class, new SpriteSpriteCollisionListener<Player, Enemy2>() {
            @Override
            public void collision(Player sp1, Enemy2 sp2) {
                rocketSpriteCollison(sp1, sc, sp2);
            }
        });

        //Ally <--> Enemy2 Collison
        sc.addSpriteSpriteCollisionListener(Ally.class, Enemy2.class, new SpriteSpriteCollisionListener<Ally, Enemy2>() {
            @Override
            public void collision(Ally sp1, Enemy2 sp2) {
                allySpriteCollison(sp1, sc, sp2);
            }
        });

        //Player <--> Enemy3 Collison
        sc.addSpriteSpriteCollisionListener(Player.class, Enemy3.class, new SpriteSpriteCollisionListener<Player, Enemy3>() {
            @Override
            public void collision(Player sp1, Enemy3 sp2) {
                rocketSpriteCollison(sp1, sc, sp2);
            }
        });

        //Ally <--> Enemy3 Collison
        sc.addSpriteSpriteCollisionListener(Ally.class, Enemy3.class, new SpriteSpriteCollisionListener<Ally, Enemy3>() {
            @Override
            public void collision(Ally sp1, Enemy3 sp2) {
                allySpriteCollison(sp1, sc, sp2);
            }
        });

        //Player <--> MiniBoss Collison
        sc.addSpriteSpriteCollisionListener(Player.class, MiniBoss.class, new SpriteSpriteCollisionListener<Player, MiniBoss>() {
            @Override
            public void collision(Player sp1, MiniBoss sp2) {
                rocketSpriteCollison(sp1, sc, sp2);
            }
        });

        //Ally <--> MiniBoss Collison
        sc.addSpriteSpriteCollisionListener(Ally.class, MiniBoss.class, new SpriteSpriteCollisionListener<Ally, MiniBoss>() {
            @Override
            public void collision(Ally sp1, MiniBoss sp2) {
                allySpriteCollison(sp1, sc, sp2);
            }
        });

        //Player <--> Boss Collison
        sc.addSpriteSpriteCollisionListener(Player.class, Boss.class, new SpriteSpriteCollisionListener<Player, Boss>() {
            @Override
            public void collision(Player sp1, Boss sp2) {
                rocketSpriteCollison(sp1, sc, sp2);
            }
        });

        //Ally <--> Boss Collison
        sc.addSpriteSpriteCollisionListener(Ally.class, Boss.class, new SpriteSpriteCollisionListener<Ally, Boss>() {
            @Override
            public void collision(Ally sp1, Boss sp2) {
                allySpriteCollison(sp1, sc, sp2);
            }
        });

        //Player <--> EBullet Collison
        sc.addSpriteSpriteCollisionListener(Player.class, EBullet.class, new SpriteSpriteCollisionListener<Player, EBullet>() {
            @Override
            public void collision(Player sp1, EBullet sp2) {
                sp2.setActive(false);
                rocketSpriteCollison(sp1, sc, sp2);
            }
        });
        //Ally <--> EBullet Collison
        sc.addSpriteSpriteCollisionListener(Ally.class, EBullet.class, new SpriteSpriteCollisionListener<Ally, EBullet>() {
            @Override
            public void collision(Ally sp1, EBullet sp2) {
                sp2.setActive(false);
                allySpriteCollison(sp1, sc, sp2);
            }
        });

        //Player <--> Heal Collison
        sc.addSpriteSpriteCollisionListener(Player.class, Heal.class, new SpriteSpriteCollisionListener<Player, Heal>() {
            @Override
            public void collision(Player sp1, Heal sp2) {
                sp1.health++;
                sp2.setActive(false);
                if (sp1.health == 9) {
                    Health = new Picture("p10.png");
                    h.setPicture(Health);
                }
                if (sp1.health == 8) {
                    Health = new Picture("p9.png");
                    h.setPicture(Health);
                }
                if (sp1.health == 7) {
                    Health = new Picture("p8.png");
                    h.setPicture(Health);
                }
                if (sp1.health == 6) {
                    Health = new Picture("p7.png");
                    h.setPicture(Health);
                }
                if (sp1.health == 5) {
                    Health = new Picture("p6.png");
                    h.setPicture(Health);
                }
                if (sp1.health == 4) {
                    Health = new Picture("p5.png");
                    h.setPicture(Health);
                }
                if (sp1.health == 3) {
                    Health = new Picture("p4.png");
                    h.setPicture(Health);
                }
                if (sp1.health == 2) {
                    Health = new Picture("p3.png");
                    h.setPicture(Health);
                }
                if (sp1.health == 1) {
                    Health = new Picture("p2.png");
                    h.setPicture(Health);
                }
                if (sp1.health == 0) {
                    Health = new Picture("p1.png");
                    h.setPicture(Health);
                }
            }
        });

        /* ENIMIES <--> BULLET COLLISION */
        //Enenmy1 <--> Bullet Collision
        sc.addSpriteSpriteCollisionListener(Enemy1.class, Bullet.class, new SpriteSpriteCollisionListener<Enemy1, Bullet>() {
            @Override
            public void collision(Enemy1 sp1, Bullet sp2) {
                sp1.setActive(false);
                sp2.setActive(false);
                System.out.println("ECOUNT: " + eCount);
                Explosion ex2 = new Explosion(sc, 1);
                ex2.setX(sp1.getX());
                ex2.setY(sp1.getY());
                ex2.setVelX(RAND.nextDouble() + 0.5);
            }
        }
        );

        //Enenmy2 <--> Bullet Collision
        sc.addSpriteSpriteCollisionListener(Enemy2.class, Bullet.class, new SpriteSpriteCollisionListener<Enemy2, Bullet>() {
            @Override
            public void collision(Enemy2 sp1, Bullet sp2) {
                sp1.setActive(false);
                sp2.setActive(false);
                System.out.println("ECOUNT: " + eCount);
                Explosion ex2 = new Explosion(sc, 1);
                ex2.setX(sp1.getX());
                ex2.setY(sp1.getY());
                ex2.setVelX(RAND.nextDouble() + 0.5);
            }
        });

        //Enenmy3 <--> Bullet Collision
        sc.addSpriteSpriteCollisionListener(Enemy3.class, Bullet.class, new SpriteSpriteCollisionListener<Enemy3, Bullet>() {
            @Override
            public void collision(Enemy3 sp1, Bullet sp2) {
                sp1.health--;
                sp2.setActive(false);
                if (sp1.health == 0) {
                    sp1.setActive(false);
                    sp2.setActive(false);
                    for (int i = 0; i < 2; i++) {
                        Explosion ex2 = new Explosion(sc, 1);
                        ex2.setX(sp1.getX());
                        ex2.setY(sp1.getY());
                        ex2.setVelX(RAND.nextDouble() + 0.5);
                        ex2.setVelY(RAND.nextDouble() + 0.5);
                    }
                    System.out.println("ECOUNT: " + eCount);
                }
            }
        });

        //MiniBoss <--> Bullet Collision
        sc.addSpriteSpriteCollisionListener(MiniBoss.class, Bullet.class, new SpriteSpriteCollisionListener<MiniBoss, Bullet>() {
            @Override
            public void collision(MiniBoss sp1, Bullet sp2) {
                miniBossSpriteCollison(sp1, sc, sp2);
                System.out.println("ECOUNT: " + eCount);
            }
        });

        //Boss <--> Bullet Collison
        sc.addSpriteSpriteCollisionListener(Boss.class, Bullet.class, new SpriteSpriteCollisionListener<Boss, Bullet>() {
            @Override
            public void collision(Boss sp1, Bullet sp2) {
                bossSpriteCollison(sp1, sc, sp2);
                System.out.println("ECOUNT: " + eCount);
            }
        });

        //Bullet <--> EBullet Collison
        sc.addSpriteSpriteCollisionListener(Bullet.class, EBullet.class, new SpriteSpriteCollisionListener<Bullet, EBullet>() {
            @Override
            public void collision(Bullet sp1, EBullet sp2) {
                sp1.setActive(false);
                sp2.setActive(false);
            }
        }
        );
    }

    //Created a method rocketSpriteCollison method to decrease the healthbar, and eliminates redudant code 
    public void rocketSpriteCollison(Player sp1, SpriteComponent sc, Sprite sp2) {
        sp1.health--;
        if (sp1.health == 9) {
            Health = new Picture("p9.png");
            h.setPicture(Health);
        }
        if (sp1.health == 8) {
            Health = new Picture("p8.png");
            h.setPicture(Health);
        }
        if (sp1.health == 7) {
            Health = new Picture("p7.png");
            h.setPicture(Health);
        }
        if (sp1.health == 6) {
            Health = new Picture("p6.png");
            h.setPicture(Health);
        }
        if (sp1.health == 5) {
            Health = new Picture("p5.png");
            h.setPicture(Health);
        }
        if (sp1.health == 4) {
            Health = new Picture("p4.png");
            h.setPicture(Health);
        }
        if (sp1.health == 3) {
            Health = new Picture("p3.png");
            h.setPicture(Health);
        }
        if (sp1.health == 2) {
            Health = new Picture("p2.png");
            h.setPicture(Health);
        }
        if (sp1.health == 1) {
            Health = new Picture("p1.png");
            h.setPicture(Health);
        }
        if (sp1.health == 0) {
            sp2.setActive(false);
            sp1.setActive(false);
            for (int i = 0; i < 10; i++) {
                Explosion ex = new Explosion(sc);
                ex.setX(sp1.getX());
                ex.setY(sp1.getY());
                ex.setVelX(-(RAND.nextDouble() + 0.5));
                ex.setVelY(RAND.nextDouble() + 0.5);
            }
            JOptionPane.showMessageDialog(sc, "You Lose");
            System.exit(0);
        }
    }

    //General Ally Sprite Collison method 
    public void allySpriteCollison(Ally sp1, SpriteComponent sc, Sprite sp2) {
        sp1.health--;
        if (sp1.health == 4) {
            Ally = new Picture("Ah4.png");
            sp1.setPicture(Ally);
        }
        if (sp1.health == 3) {
            Ally = new Picture("Ah3.png");
            sp1.setPicture(Ally);
        }
        if (sp1.health == 2) {
            Ally = new Picture("Ah2.png");
            sp1.setPicture(Ally);
        }
        if (sp1.health == 1) {
            Ally = new Picture("Ah1.png");
            sp1.setPicture(Ally);
        }
        if (sp1.health == 0) {
            sp1.setActive(false);
            for (int i = 0; i < 4; i++) {
                Explosion ex2 = new Explosion(sc, 1);
                ex2.setX(sp1.getX());
                ex2.setY(sp1.getY());
                ex2.setVelX(RAND.nextDouble() + 0.5);
                ex2.setVelY(RAND.nextDouble() + 0.5);
            }
        }
    }

    public void miniBossSpriteCollison(MiniBoss sp1, SpriteComponent sc, Sprite sp2) {
        sp1.eHealth -= 0.5;
        sp2.setActive(false);
        if (sp1.eHealth == 4) {
            MiniBoss = new Picture("e3h4.png");
            sp1.setPicture(MiniBoss);
        } else if (sp1.eHealth == 3) {
            MiniBoss = new Picture("e3h3.png");
            sp1.setPicture(MiniBoss);
            Enemy2 e3 = new Enemy2(sc);
            e3.setY(sp1.getY());
            e3.setX(sp1.getX());

        } else if (sp1.eHealth == 2) {
            MiniBoss = new Picture("e3h2.png");
            sp1.setPicture(MiniBoss);
        } else if (sp1.eHealth == 1) {
            MiniBoss = new Picture("e3h1.png");
            sp1.setPicture(MiniBoss);
            Enemy2 e3 = new Enemy2(sc);
            e3.setY(sp1.getY());
            e3.setX(sp1.getX());
            Enemy2 e4 = new Enemy2(sc);
            e4.setY(sp1.getY());
            e4.setX(sp1.getX());
            Heal h = new Heal(sc);
            h.setX(sp1.getX());
            h.setY(sp1.getY());
        }

        if (sp1.eHealth == 0) {
            sp1.setActive(false);
            sp2.setActive(false);
            for (int i = 0; i < 5; i++) {
                Explosion ex2 = new Explosion(sc, 1);
                ex2.setX(sp1.getX());
                ex2.setY(sp1.getY());
                ex2.setVelX(RAND.nextDouble() + 0.5);
                ex2.setVelY(RAND.nextDouble() + 0.5);
                System.out.println("ECOUNT: " + eCount);
            }
        }

    }

    //Boss Sprite Collison (Used to avoid cluttered code)
    public void bossSpriteCollison(Boss sp1, SpriteComponent sc, Sprite sp2) {
        if (screenX > upperbound) {
            sp1.bHealth -= 0.0625; //320 Health Points
        } else {
            sp1.bHealth -= 0.125;//160 Health Points
        }
        sp2.setActive(false);
        if (sp1.bHealth == 19) {
            bHealth = new Picture("Bh19.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 18) {
            bHealth = new Picture("Bh18.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 17) {
            bHealth = new Picture("Bh17.png");
            Bh.setPicture(bHealth);;
            for (int i = 0; i < 4; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setX(sp1.getX());
                e2.setY(sp1.getY());
            }
            for (int i = 0; i < 2; i++) {
                Heal h = new Heal(sc);
                h.setX(sp1.getX());
                h.setY(sp1.getY());
            }
        }
        if (sp1.bHealth == 16) {
            bHealth = new Picture("Bh16.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 15) {
            if (screenX > upperbound) {
                Ally a = new Ally(sc);
            }
            bHealth = new Picture("Bh15.png");
            Bh.setPicture(bHealth);;
            Bh.setPicture(bHealth);;
            MiniBoss mB = new MiniBoss(sc);
            mB.setX(sp1.getX());
            mB.setY(sp1.getY());
        }
        if (sp1.bHealth == 14) {
            bHealth = new Picture("Bh14.png");
            Bh.setPicture(bHealth);;
            Enemy2 e2 = new Enemy2(sc);
            e2.setX(sp1.getX());
            e2.setY(sp1.getY());
        }
        if (sp1.bHealth == 13) {
            bHealth = new Picture("Bh13.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 12) {
            bHealth = new Picture("Bh12.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 11) {
            bHealth = new Picture("Bh11.png");
            Bh.setPicture(bHealth);;
            Enemy3 e3 = new Enemy3(sc);
            e3.setY(screenY - (screenY - 100));
            Enemy3 e4 = new Enemy3(sc);
            e4.setY(screenY - (screenY - 300));
        }
        if (sp1.bHealth == 10) {
            bHealth = new Picture("Bh10.png");
            Bh.setPicture(bHealth);;
            MiniBoss mB = new MiniBoss(sc);
            mB.setX(sp1.getX());
            mB.setY(sp1.getY());
        }
        if (sp1.bHealth == 9) {
            bHealth = new Picture("Bh9.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 8) {
            bHealth = new Picture("Bh8.png");
            Bh.setPicture(bHealth);;
            for (int i = 0; i < 6; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setX(sp1.getX());
                e2.setY(sp1.getY());
            }
            for (int i = 0; i < 2; i++) {
                Heal h = new Heal(sc);
                h.setX(sp1.getX());
                h.setY(sp1.getY());
                h.setVelX(RAND.nextDouble());
                h.setVelY(RAND.nextDouble());
            }
        }
        if (sp1.bHealth == 7) {
            bHealth = new Picture("Bh7.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 6) {
            bHealth = new Picture("Bh6.png");
            Bh.setPicture(bHealth);
        }
        if (sp1.bHealth == 5) {
            if (screenX > upperbound) {
                Ally a = new Ally(sc);
            }
            bHealth = new Picture("Bh5.png");
            Bh.setPicture(bHealth);;
            MiniBoss mB = new MiniBoss(sc);
            mB.setX(sp1.getX());
            mB.setY(sp1.getY());

        }
        if (sp1.bHealth == 4) {
            bHealth = new Picture("Bh4.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 3) {
            bHealth = new Picture("Bh3.png");
            Bh.setPicture(bHealth);;
            for (int i = 0; i < 8; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setX(sp1.getX());
                e2.setY(sp1.getY());
            }
            for (int i = 0; i < 4; i++) {
                Heal h = new Heal(sc);
                h.setX(sp1.getX());
                h.setY(sp1.getY());
                h.setVelX(RAND.nextDouble());
                h.setVelY(RAND.nextDouble());
            }
        }
        if (sp1.bHealth == 2) {
            bHealth = new Picture("Bh2.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 1) {
            bHealth = new Picture("Bh1.png");
            Bh.setPicture(bHealth);;
        }
        if (sp1.bHealth == 0) {
            int count;
            int amount = 2;
            if (screenX > upperbound) {
                count = 30;
                amount = 4;
            } else {
                count = 15;
            }
            for (int i = 0; i < count; i++) {
                Explosion ex = new Explosion(sc);
                ex.setX(sp1.getX());
                ex.setY(sp1.getY());
                ex.setVelX(RAND.nextDouble() + 0.5);
                ex.setVelY(RAND.nextDouble() + 0.5);
            }
            for (int i = 0; i < amount; i++) {
                MiniBoss mb = new MiniBoss(sc);
                mb.setX(sp1.getX());
                mb.setY(sp1.getY());
                mb.setVelX(RAND.nextDouble());
                mb.setVelY(RAND.nextDouble());
            }
            sp1.setActive(false);
            Bh.setActive(false);
            bossDefeated = true;
        }
    }
}
