package FinalProject;

import basicgraphics.SpriteComponent;
import static FinalProject.Andromegedan.Bh;
import static FinalProject.Andromegedan.waveCount;
import static FinalProject.Andromegedan.RAND;
import static FinalProject.Andromegedan.eCount;
import static FinalProject.Andromegedan.screenX;
import static FinalProject.Andromegedan.screenY;
import static FinalProject.Andromegedan.upperbound;
import java.util.Random;

public class Wave {

    public static void wave(SpriteComponent sc) {
        int e1c = 3;
        if (screenX >= upperbound) {
            for (int i = 1; i < 9; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(100 * i);
            }
        } else if (screenX <= upperbound) {
            for (int i = 1; i < 4; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(100 * i);
            }
        }
        System.out.println("Wave: " + waveCount + "\neCount: " + eCount);
    }

    public static void wave2(SpriteComponent sc) {
        int e1c = 2;
        int e2c = 4;
        Heal h = new Heal(sc);
        h.setX(screenX - 200);
        if (screenX >= upperbound) {
            for (int i = 1; i < e1c * 2; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(75 * i);
            }
            for (int i = 1; i < e2c * 2; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(95 * i);
            }
            h.setX(screenX - 110);
            h.setY(screenY / 2);
        } else if (screenX < upperbound) {
            for (int i = 1; i < e1c + 2; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(50 * i);
            }
            for (int i = 1; i < e2c; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(25 * i);
            }
            h.setX(screenX - 100);
            h.setY(screenY - 150);
        }
        System.out.println("Wave: " + waveCount + "\neCount: " + eCount);
    }

    public static void wave3(SpriteComponent sc) {
        Heal h = new Heal(sc);
        Ally a = new Ally(sc);
        h.setX(screenX - 200);
        if (screenX > upperbound) {
            for (int i = 1; i < 5; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(100 * i);
            }
            for (int i = 1; i < 6; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(95 * i);
            }
        } else {
            for (int i = 1; i < 8; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(75 * i);
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(40);
            }
        }
        System.out.println("Wave: " + waveCount + "\neCount: " + eCount);
    }

    public static void wave4(SpriteComponent sc) {
        int e1c = 3;
        int e2c = 3;
        int e3c = 2;
        Heal h = new Heal(sc);
        h.setX(screenX - 200);
        if (screenX >= upperbound) {
            for (int i = 0; i < e1c * 2; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(50 * i);
            }

            for (int i = 1; i < e1c * 2; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(95 * i);
            }
            for (int i = 1; i < e3c; i++) {
                Enemy3 e3 = new Enemy3(sc);
                e3.setY(250 * i);
            }
        } else if (screenX < upperbound) {
            for (int i = 1; i < 6; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(50 * i);
            }
            for (int i = 1; i < 6; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(50 * i);
            }
            for (int i = 1; i < 2; i++) {
                Enemy3 e3 = new Enemy3(sc);
                e3.setY(250 * i);
            }
        }
        System.out.println("Wave: " + waveCount + "\neCount: " + eCount);
    }

    public static void wave5(SpriteComponent sc) {
        Heal h = new Heal(sc);
        h.setX(screenX - 200);
        if (screenX > upperbound) {
            for (int i = 1; i < 7; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(50 * i);
            }
            for (int i = 1; i < 7; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(95 * i);
            }
            Enemy3 e3 = new Enemy3(sc);
            e3.setY(screenY / 2);
            Enemy3 e4 = new Enemy3(sc);
            e4.setY(screenY / 4);
            e4.setX(screenX - 300);
        } else if (screenX < upperbound) {
            for (int i = 1; i < 7; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(50 * i);
            }
            for (int i = 1; i < 7; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(50 * i);
            }
            for (int i = 1; i < 2; i++) {
                Enemy3 e3 = new Enemy3(sc);
                e3.setY(175 * i);
                e3.setVelX(RAND.nextDouble());
            }
        }
        System.out.println("Wave: " + waveCount + "\neCount: " + eCount);
    }

    public static void wave6(SpriteComponent sc) {
        Heal h = new Heal(sc);
        h.setX(screenX - 200);
        Ally a = new Ally(sc);
        if (screenX > upperbound) {
            MiniBoss mb = new MiniBoss(sc);
            mb.setX(screenX - 300);
            mb.setY((screenY / 2));
            MiniBoss mb2 = new MiniBoss(sc);
            mb2.setX(screenX - 125);
            mb2.setY((screenY / 2) - 300);
            for (int i = 1; i < 5; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(50 * i);
            }
        } else {
            MiniBoss mb = new MiniBoss(sc);
            mb.setX(screenX - 300);
            mb.setY((screenY / 2));
            Enemy3 e3 = new Enemy3(sc);
            e3.setY(screenY / 2);
        }
        System.out.println("Wave: " + waveCount + "\neCount: " + eCount);
    }

    public static void wave7(SpriteComponent sc) {
        Heal h = new Heal(sc);
        h.setX(screenX - 200);
        if (screenX > upperbound) {
            MiniBoss mb = new MiniBoss(sc);
            mb.setX(screenX - 300);
            mb.setY((screenY / 2));
            Enemy3 e3 = new Enemy3(sc);
            e3.setY(screenY / 2);
            Enemy3 e4 = new Enemy3(sc);
            e4.setY(screenY / 4);
            e4.setX(screenX - 300);
            e3.setY(screenY / 2);
            for (int i = 1; i < 5; i++) {
                Enemy1 e1 = new Enemy1(sc);
                Enemy2 e2 = new Enemy2(sc);
                e1.setY(50 * i);
                e2.setY(20 * i);
            }
        } else {
            MiniBoss mb = new MiniBoss(sc);
            mb.setX(screenX - 300);
            mb.setY((screenY / 2));
            Enemy3 e3 = new Enemy3(sc);
            e3.setY(screenY / 2);
            Enemy3 e4 = new Enemy3(sc);
            e4.setY(screenY / 4);
            e4.setX(screenX - 300);
        }
        h.setX(screenX - 200);
        System.out.println("Wave: " + waveCount + "\neCount: " + eCount);

    }

    public static void wave8(SpriteComponent sc) {
        Heal h = new Heal(sc);
        h.setX(screenX - 200);
        if (screenX > upperbound) {
            MiniBoss mb = new MiniBoss(sc);
            mb.setX(screenX - 300);
            mb.setY((screenY - 600));
            MiniBoss mb2 = new MiniBoss(sc);
            mb2.setX(screenX - 450);
            mb2.setY(screenY / 2 + 100);
            Enemy3 e3 = new Enemy3(sc);
            e3.setY(screenY - (screenY - 100));
            Enemy3 e4 = new Enemy3(sc);
            e4.setY(screenY - (screenY - 300));
            Enemy3 e5 = new Enemy3(sc);
            e5.setY(screenY - (screenY - 500));

        } else {
            MiniBoss mb = new MiniBoss(sc);
            mb.setX(screenX - 300);
            mb.setY((screenY - 200));
            Enemy3 e3 = new Enemy3(sc);
            e3.setY(screenY - (screenY - 100));
            Enemy3 e4 = new Enemy3(sc);
            e4.setY(screenY - (screenY - 300));
            for (int i = 0; i < 5; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(screenY / 3);
            }
        }
    }

    public static void wave9(SpriteComponent sc) {
        Heal h = new Heal(sc);
        h.setX(screenX - 200);
        Ally a = new Ally(sc);
        if (screenX > upperbound) {
            Random rand = new Random();
            MiniBoss mb = new MiniBoss(sc);
            mb.setX(screenX - 300);
            mb.setY((screenY - 600));
            MiniBoss mb2 = new MiniBoss(sc);
            mb2.setX(screenX - 450);
            mb2.setY(screenY / 2 + 100);
            MiniBoss mb3 = new MiniBoss(sc);
            mb3.setX(screenX - 700);
            mb3.setY(screenY - 650);
            for (int i = 1; i < 6; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(50 * i);
            }
            for (int i = 1; i < 6; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(25 * i);
            }
            Enemy3 e3 = new Enemy3(sc);
            e3.setY(screenY / 2);
            Enemy3 e4 = new Enemy3(sc);
            e4.setY(screenY / 4);
            e4.setX(screenX - 300);
        } else {
            Random rand = new Random();
            MiniBoss mb = new MiniBoss(sc);
            mb.setX(screenX - 300);
            mb.setY((screenY - 600));
            MiniBoss mb2 = new MiniBoss(sc);
            mb2.setX(screenX - 450);
            mb2.setY(screenY / 2 + 100);
            for (int i = 1; i < 6; i++) {
                Enemy2 e2 = new Enemy2(sc);
                e2.setY(50 * i);
            }
            for (int i = 1; i < 6; i++) {
                Enemy1 e1 = new Enemy1(sc);
                e1.setY(25 * i);
            }
            Enemy3 e3 = new Enemy3(sc);
            e3.setY(screenY - (screenY - 100));
            Enemy3 e4 = new Enemy3(sc);
            e4.setY(screenY - (screenY - 300));
        }
    }

    public static void boss(SpriteComponent sc) {
        Heal h = new Heal(sc);
        h.setX(screenX - 200);
        Ally a = new Ally(sc);
        if (screenX > upperbound) {
            Boss b = new Boss(sc);
            b.setY(100);
            Bh = new BossHealthBar(sc, "Bh20.png");
            MiniBoss mb = new MiniBoss(sc);
            mb.setX(screenX - 300);
            mb.setY((screenY / 2));
            MiniBoss mb2 = new MiniBoss(sc);
            mb2.setX(screenX - 700);
            mb2.setY(screenY - 650);
        } else {
            Boss b = new Boss(sc);
            Bh = new BossHealthBar(sc, "Bh20.png");

        }
    }
}
