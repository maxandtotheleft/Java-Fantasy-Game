import java.util.Random;

public class Enemy {
    private String name;
    public int health;
    private boolean alive;
    private int xpPayout;
    Random rand = new Random();

    public Enemy(String name, int health, boolean alive, int xpPayout) {
        this.name = name;
        this.health = 40;
        this.alive = true;
        this.xpPayout = xpPayout;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getXpPayout() {
        return this.xpPayout;
    }

    public void enemyAttack(CharacterClass yourWarChar) {
        int rand_int1 = this.rand.nextInt(20);
        if (rand_int1 % 2 == 0) {
            yourWarChar.health = yourWarChar.getHealth() - 10;
        } else if (rand_int1 % 5 != 0) {
            yourWarChar.health = yourWarChar.getHealth() - 20;
        } else if (rand_int1 == 15) {
            yourWarChar.health = yourWarChar.getHealth() - 30;
        } else if (rand_int1 % 20 == 0) {
            System.out.println("Attack misses!");
        }

    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
