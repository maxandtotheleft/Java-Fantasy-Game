import java.io.PrintStream;
import java.util.*;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Terminal {

        Scanner user;
        public static Map<String, CharacterClass> toons = new HashMap();
        Enemy randBot;
        Random rand;
        private int totalXp;

        public Terminal() {
            this.user = new Scanner(System.in);
            this.rand = new Random();
        }

        public boolean beginMenu() {
            System.out.println("MAIN MENU");
            System.out.println("Press 'A' To Select A Character");
            System.out.println("Press 'B' to Fight");
            String aOrB = this.user.nextLine();
            if ((!aOrB.equalsIgnoreCase("a") || !aOrB.equalsIgnoreCase("b")) && toons.isEmpty()) {
                createCharacter();
            }
            if ((!aOrB.equalsIgnoreCase("a") || !aOrB.equalsIgnoreCase("b")) && !toons.isEmpty()) {
                fightMenu();
            }
            if (aOrB.equalsIgnoreCase("a") && toons.isEmpty()) {
                this.createCharacter();
            } else if (aOrB.equalsIgnoreCase("a") && !toons.isEmpty()) {
                System.out.println("");
                System.out.println("Character Has Already Been Chosen");
                this.fightMenu();
            } else if (aOrB.equalsIgnoreCase("b") && !toons.isEmpty()) {
                this.fightMenu();
            } else if (aOrB.equalsIgnoreCase("b") && toons.isEmpty()) {
                System.out.println("");
                System.out.println("Please Select Character First!");
                System.out.println("");
                this.createCharacter();
            }

            return false;
        }

        public void createCharacter() {
            System.out.println("");
            System.out.println("Press 'A' for Warrior or 'B' for Mage");
            String aOrB2 = this.user.nextLine();
            Character1 yourMageChar;
            if (aOrB2.equalsIgnoreCase("a")) {
                yourMageChar = new Character1("Warrior", 100, true, 0, 1);
                System.out.println("");
                System.out.println(yourMageChar.getName() + " selected");
                toons.put(yourMageChar.getName(), yourMageChar);
                System.out.println("");
                this.beginMenu();
            } else if (aOrB2.equalsIgnoreCase("b")) {
                yourMageChar = new Character1("Mage", 100, true, 0, 1);
                System.out.println("");
                System.out.println(yourMageChar.getName() + " selected");
                toons.put(yourMageChar.getName(), yourMageChar);
                System.out.println("");
                this.beginMenu();
            }

        }

        public void resetHealth() {
            CharacterClass value;
            for(Iterator var1 = toons.values().iterator(); var1.hasNext(); value.health = 100) {
                value = (CharacterClass)var1.next();
            }

        }

        public void enemyGetter() {
            int enemyRand = this.rand.nextInt(21);
            if (enemyRand != 2 && enemyRand != 6) {
                if (enemyRand != 12 && enemyRand != 9) {
                    if (enemyRand != 18 && enemyRand != 20) {
                        if (enemyRand % 5 == 0) {
                            this.randBot = new Enemy("Cursed Slime", 50, true, 15);
                        } else if (enemyRand != 4 && enemyRand != 8) {
                            this.randBot = new Enemy("Astral Spectre", 60, true, 18);
                        } else {
                            this.randBot = new Enemy("Haunted Armor", 70, true, 25);
                        }
                    } else {
                        this.randBot = new Enemy("Skeleton Warrior", 80, true, 30);
                    }
                } else {
                    this.randBot = new Enemy("Dire Wolf", 60, true, 20);
                }
            } else {
                this.randBot = new Enemy("Cave Bat", 20, true, 10);
            }

        }

        public boolean fightMenu() {
            this.enemyGetter();
            System.out.println("");
            System.out.println("You are walking through Westfall when suddenly - ");
            System.out.println("");
            System.out.println(this.randBot.getName() + " attacks!");
            PrintStream var10000 = System.out;
            String var10001 = this.randBot.getName();
            var10000.println(var10001 + " has " + this.randBot.getHealth() + " health");
            System.out.println("");

            while(true) {
                while(this.randBot.isAlive()) {
                    System.out.println("Press 'A' to attack");
                    String attackChoice = this.user.nextLine();
                    Iterator var2;
                    CharacterClass value;
                    if (attackChoice.equalsIgnoreCase("a") && toons.containsKey("Warrior")) {
                        System.out.println("");
                        System.out.println("You swing your broadsword - ");
                        System.out.println("Thwack!!");
                        var2 = toons.values().iterator();

                        while(var2.hasNext()) {
                            value = (CharacterClass)var2.next();
                            value.attack(this.randBot);
                        }

                        var10000 = System.out;
                        var10001 = this.randBot.getName();
                        var10000.println(var10001 + " health: " + this.randBot.getHealth());
                        System.out.println("");
                        var2 = toons.values().iterator();

                        while(var2.hasNext()) {
                            value = (CharacterClass)var2.next();
                            System.out.println(this.randBot.getName() + " attacks!");
                            this.randBot.enemyAttack(value);
                            System.out.println("your health is " + value.getHealth());
                            System.out.println("");
                        }
                    } else if (attackChoice.equalsIgnoreCase("a") && toons.containsKey("Mage")) {
                        System.out.println("");
                        System.out.println("You cast a frostbolt - ");
                        System.out.println("Whoosh!!");
                        var2 = toons.values().iterator();

                        while(var2.hasNext()) {
                            value = (CharacterClass)var2.next();
                            value.attack(this.randBot);
                        }

                        var10000 = System.out;
                        var10001 = this.randBot.getName();
                        var10000.println(var10001 + " health: " + this.randBot.getHealth());
                        System.out.println("");
                        var2 = toons.values().iterator();

                        while(var2.hasNext()) {
                            value = (CharacterClass)var2.next();
                            System.out.println(this.randBot.getName() + " attacks!");
                            this.randBot.enemyAttack(value);
                            System.out.println("your health is " + value.getHealth());
                            System.out.println("");
                        }
                    }
                }

                this.totalXp += this.randBot.getXpPayout();
                System.out.println("**************************************");
                System.out.println(this.randBot.getName() + " defeated!");
                System.out.println("");
                System.out.println("XP gained: " + this.randBot.getXpPayout());
                System.out.println("total XP: " + this.totalXp);
                System.out.println("**************************************");
                System.out.println("");
                this.resetHealth();
                toons.clear();
                return this.beginMenu();
            }
        }
    }

