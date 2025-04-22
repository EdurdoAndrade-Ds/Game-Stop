import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Quantidade de jogadores
        System.out.print("Quantos jogadores irão jogar: ");
        int qtdPlayers = sc.nextInt();
        sc.nextLine();

        // Add players
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= qtdPlayers; i++) {
            System.out.print("Digite o nome do jogador: " + i + ": ");
            String name = sc.nextLine();
            names.add(name);
        }

        // Start
        StopGame game = new StopGame(names);

        // number rounds
        System.out.print("\nQuantas rodadas deseja jogar: ");
        int totalRounds = sc.nextInt();
        sc.nextLine();


        // Rodar o game
        for (int i = 0; i < totalRounds; i++) {
            System.out.println("\n--- Rodada " + (i + 1) + " ---");
            game.startRound();
        }

        game.showScores();
    }
}