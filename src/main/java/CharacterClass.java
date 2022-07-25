import java.util.Random;

public class CharacterClass {
    private String name;
    public int health;
    private boolean alive;
    protected int xp;
    private int level;
    Random rand = new Random();

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public int getXp() {
        return this.xp;
    }

    public int getLevel() {
        return this.level;
    }

    public void attack(Enemy opposingCharacter) {
        int rand_int1 = this.rand.nextInt(20);
        if (rand_int1 % 2 == 0) {
            opposingCharacter.health = opposingCharacter.getHealth() - 10;
        } else if (rand_int1 % 2 != 0) {
            opposingCharacter.health = opposingCharacter.getHealth() - 5;
        } else if (rand_int1 % 5 == 0) {
            opposingCharacter.health = opposingCharacter.getHealth() - 20;
        } else if (rand_int1 % 20 == 0) {
            System.out.println("Attack misses!");
        }

    }

    public CharacterClass(String name, int health, boolean alive, int xp, int level) {
        this.name = name;
        this.health = 100;
        this.alive = true;
        this.xp = 0;
        this.level = 1;
    }
}
