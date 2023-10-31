//Brandon Walton
//CSC-1351, Brandt
package FinalProject;

import static FinalProject.Boss.bossDefeated;
import basicgraphics.BasicContainer;
import basicgraphics.BasicFrame;
import basicgraphics.Clock;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
//import basicgraphics.sounds.ReusableClip;
import static FinalProject.Wave.boss;
import static FinalProject.Wave.wave9;
import static FinalProject.Wave.wave8;
import static FinalProject.Wave.wave7;
import static FinalProject.Wave.wave6;
import static FinalProject.Wave.wave5;
import static FinalProject.Wave.wave4;
import static FinalProject.Wave.wave3;
import static FinalProject.Wave.wave2;
import static FinalProject.Wave.wave;
import static FinalProject.WaveBoard.wBCount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Andromegedan {

    BasicFrame bf = new BasicFrame("Brandon's Game");
    public SpriteComponent sc;
    //static ReusableClip clip = new ReusableClip("BGround.wav");
    static Random RAND = new Random();
    CardLayout cards;

    static public Healthbar h;
    static public BossHealthBar Bh;
    static public WaveBoard WB;
    static public EBullet eb;
    static public Bullet b;
    Player rocket;

    static int TempNum = 1;
    static int waveCount = 1;
    Graphics Wave;
    static double vel = 1;
    static double bVel = 1;
    public static int eCount;

    static int upperbound = 1000;
    static int screenX = 800; //1500 && //800
    static int screenY = 400 / 1; //800  && //400

    int up = KeyEvent.VK_UP, up2 = KeyEvent.VK_W,
            left = KeyEvent.VK_LEFT, left2 = KeyEvent.VK_A,
            down = KeyEvent.VK_DOWN, down2 = KeyEvent.VK_S,
            right = KeyEvent.VK_RIGHT, right2 = KeyEvent.VK_D;

    public static void main(String[] args) {
        Andromegedan g = new Andromegedan();
        g.runGame();
    }

    public void runGame() {
        Container content = bf.getContentPane();
        CardLayout cards = new CardLayout();
        content.setLayout(cards);
        BasicContainer bc1 = new BasicContainer();
        content.add(bc1, "Splash");
        BasicContainer bc2 = new BasicContainer();
        content.add(bc2, "Brandon's Game");

        //Background 
        sc = new SpriteComponent() {
            int count = 0;
            int decrease;

            @Override
            public void paintBackground(Graphics g) {
                Dimension d = getSize();
                g.setColor(Color.black);
                g.fillRect(0, 0, d.width, d.height);
                if (screenX > upperbound) {
                    decrease = 20;
                } else {
                    decrease = 25;
                }
                Random rand = new Random(count++ / decrease);
                int stars = 200;
                for (int i = 0; i < stars; i++) {
                    Color myColor = new Color(240, 242, 113);
                    g.setColor(Color.white);
                    int z = rand.nextInt(5);
                    int x = rand.nextInt(d.width);
                    int y = rand.nextInt(d.height);
                    g.fillOval(x, y, z, z);
                }
                //Moon
                g.setColor(new Color(188, 188, 188));
                g.fillOval(20, 20, 100, 100);
                g.setColor(Color.black);
                g.fillOval(13, 15, 95, 95);
            }
        };

        //Start up Screen
        sc.setPreferredSize(new Dimension(screenX, screenY));
        String[][] splashLayout = {
            {"Title"},
            {"Button"}
        };
        bc1.setStringLayout(splashLayout);
        bc1.add("Title", new JLabel("ANDROMEGEDAN"));
        JButton jstart = new JButton("Start");
        jstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "Brandon's Game");
                bc2.requestFocus();
                Clock.start(5);
            }
        });
        bc1.add("Button", jstart);
        String[][] layout = {{
            "Flyer"
        }};
        bc2.setStringLayout(layout);
        bc2.add("Flyer", sc);
        bf.show();

        //Controls
        rocket = new Player(sc);
        Clock.start(10);
        KeyAdapter k = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == up || ke.getKeyCode() == up2) {
                    rocket.setVelY(rocket.getVelY() - vel);
                } else if (ke.getKeyCode() == down || ke.getKeyCode() == down2) {
                    rocket.setVelY(rocket.getVelY() + vel);
                } else if (ke.getKeyCode() == left || ke.getKeyCode() == left2) {
                    rocket.setVelX(rocket.getVelX() - vel);

                } else if (ke.getKeyCode() == right || ke.getKeyCode() == right2) {
                    rocket.setVelX(rocket.getVelX() + vel);
                }
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == up || ke.getKeyCode() == up2) {
                    rocket.setVelY(-vel);
                    rocket.setVelX(0);
                }
                if (ke.getKeyCode() == down || ke.getKeyCode() == down2) {
                    rocket.setVelY(vel);
                    rocket.setVelX(0);
                }
                if (ke.getKeyCode() == left || ke.getKeyCode() == left2) {
                    rocket.setVelY(0);
                    rocket.setVelX(-vel);
                }
                if (ke.getKeyCode() == right || ke.getKeyCode() == right2) {
                    rocket.setVelY(0);
                    rocket.setVelX(vel);
                } else if (ke.getKeyChar() == ' ') { //Placed here to avoid player from holding spacebar for infinite bullets
                    if (screenX > upperbound) {
                        bVel = 2;
                    }
                    Bullet pl = new Bullet(sc);
                    pl.setVelX(bVel);
                    pl.setVelY(0);
                    pl.setX(rocket.centerX() + 42);
                    pl.setY(rocket.centerY());
                }
            }
        };
        bc2.addKeyListener(k);

        //Background Music
        //clip.loop();
        
        //WaveBoard
        WB = new WaveBoard(sc, "W1.png");

        //Hearts   
        h = new Healthbar(sc, "P10.png");
        
        //Collisons
        Collison c = new Collison();
        c.collison(sc);

        //First wave
        wave(sc);

        //Wave Progression
        Task level2 = new Task() {
            @Override
            public void run() {
                if (waveCount == 1 && eCount == 0) {
                    wave2(sc);
                    wBCount = new Picture("W2.png");
                    WB.setPicture(wBCount);
                    waveCount++;
                }

            }
        };
        Task level3 = new Task() {
            @Override
            public void run() {
                if (waveCount == 2 && eCount == 0) {
                    wave3(sc);
                    wBCount = new Picture("W3.png");
                    WB.setPicture(wBCount);
                    waveCount++;
                }
            }

        };
        Task level4 = new Task() {
            @Override
            public void run() {
                if (waveCount == 3 && eCount == 0) {
                    wave4(sc);
                    wBCount = new Picture("W4.png");
                    WB.setPicture(wBCount);
                    waveCount++;
                }
            }

        };
        Task level5 = new Task() {
            @Override
            public void run() {
                if (waveCount == 4 && eCount == 0) {
                    wave5(sc);
                    wBCount = new Picture("W5.png");
                    WB.setPicture(wBCount);
                    waveCount++;
                }
            }

        };
        Task level6 = new Task() {
            @Override
            public void run() {
                if (waveCount == 5 && eCount == 0) {
                    wave6(sc);
                    wBCount = new Picture("W6.png");
                    WB.setPicture(wBCount);
                    waveCount++;
                }
            }

        };
        Task level7 = new Task() {
            @Override
            public void run() {
                if (waveCount == 6 && eCount == 0) {
                    wave7(sc);
                    wBCount = new Picture("W7.png");
                    WB.setPicture(wBCount);
                    waveCount++;
                }
            }

        };
        Task level8 = new Task() {
            @Override
            public void run() {
                if (waveCount == 7 && eCount == 0) {
                    wave8(sc);
                    wBCount = new Picture("W8.png");
                    WB.setPicture(wBCount);
                    waveCount++;
                }
            }
        };
        Task level9 = new Task() {
            @Override
            public void run() {
                if (waveCount == 8 && eCount == 0) {
                    wave9(sc);
                    wBCount = new Picture("W9.png");
                    WB.setPicture(wBCount);
                    waveCount++;
                }
            }
        };
        Task boss = new Task() {
            @Override
            public void run() {
                if (waveCount == 9 && eCount == 0) {
                    boss(sc);
                    wBCount = new Picture("W10.png");
                    WB.setPicture(wBCount);
                    waveCount++;
                }
            }
        };
        Task win = new Task() {
            @Override
            public void run() {
                if (waveCount == 10 && eCount == 0 && bossDefeated == true) {
                    waveCount++;
                    JOptionPane.showMessageDialog(sc, "Crisis Averted, Return Home Soldier \n~ Commander Brandt");
                    System.exit(0);
                }
            }
        };

        Clock.addTask(level2);
        Clock.addTask(level3);
        Clock.addTask(level4);
        Clock.addTask(level5);
        Clock.addTask(level6);
        Clock.addTask(level7);
        Clock.addTask(level8);
        Clock.addTask(level9);
        Clock.addTask(boss);
        Clock.addTask(win);
        bf.addKeyListener(k);
        Clock.addTask(sc.moveSprites());
    }
}