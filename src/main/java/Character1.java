public class Character1 extends CharacterClass {
    private String name;
    protected int health = 100;
    private boolean alive;
    private int xp = 0;
    private int level = 1;

    public Character1(String name, int health, boolean alive, int xp, int level) {
        super(name, health, alive, xp, level);
    }

    public String getName() {
        return super.getName();
    }

    public int getHealth() {
        return super.getHealth();
    }

    public boolean isAlive() {
        return super.isAlive();
    }

    public int getXp() {
        return super.getXp();
    }

    public int getLevel() {
        return super.getLevel();
    }

    public void attack(Enemy opposingCharacter) {
        super.attack(opposingCharacter);
    }
}
