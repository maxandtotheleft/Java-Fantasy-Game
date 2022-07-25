public class Main {
    public static Terminal gameTerminal = new Terminal();

    public Main() {
    }

    public static void main(String[] args) {
        while(gameTerminal.beginMenu()) {
            gameTerminal.beginMenu();
        }

        gameTerminal.fightMenu();
    }
}
