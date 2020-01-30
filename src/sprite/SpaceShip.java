package sprite;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite {

    private static BackgroundAudio audio = null;
    private int dx;
    private int dy;
    private List<Missile> missiles;
    private static String path = null;


    public SpaceShip(int x, int y) {
        super(x, y);

        initSpaceShip();
    }

    private void initSpaceShip() {

        missiles = new ArrayList<>();

        loadImage("src/resources/spaceship.png");
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
        playAudio("https://filebin.net/lj0l90mfjgi8rrsn/shot.wav");
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public void setPath(String path) {
        this.path = path;
    }
    public static String getPath() {
        return path;
    }

    public void playAudio(String path) {
        setPath(path);
        if (audio == null) {
            audio = new BackgroundAudio();
        }
    }
}