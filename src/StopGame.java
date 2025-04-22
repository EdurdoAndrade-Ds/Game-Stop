import java.util.*;

public class StopGame {
    private List<Player> players;
    private List<Category> categories;
    private List<Round> rounds;
    private Set<Character> letterDeleted;

    public StopGame(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }

        categories = Arrays.asList(Category.values());
        rounds = new ArrayList<>();

        // BlackList letter
        letterDeleted = new HashSet<>(Arrays.asList('K', 'W', 'Y', 'X', 'Z'));
    }

    public void startRound() {
        char letter = drawLetter();
        System.out.println("\nLetra sorteada: " + letter);

        Round round = new Round(letter);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Letra sorteada: " + letter);

        for (Player player : players) {
            System.out.println("Resposta de " + player.getName() + "(ou digite STOP para encerrar): ");
            List<Response> playerResponses = new ArrayList<>();

            for (Category cat: categories) {
                System.out.print(cat + ": ");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("STOP")) {
                    System.out.println(player.getName() + " parou o jogo!");
                    break;
                }

                playerResponses.add(new Response(cat, answer));
            }

            round.addResponse(player, playerResponses);
        }

        new ResponseValidator().validate(round);
        calculatePoints(round);
        rounds.add(round);
    }

    private void calculatePoints(Round round) {
        Map<Category, Map<String, Integer>> respostaFrequencia = new HashMap<>();

        for (Category cat : categories) {
            respostaFrequencia.put(cat, new HashMap<>());
        }

        for (List<Response> respostas : round.getResponses().values()) {
            for (Response r : respostas) {
                if (r.isValid()) {
                    String resposta = r.getAnswer().toLowerCase();
                    respostaFrequencia.get(r.getCategory()).put(resposta,
                            respostaFrequencia.get(r.getCategory()).getOrDefault(resposta, 0) + 1);
                }
            }
        }

        for (Map.Entry<Player, List<Response>> entry : round.getResponses().entrySet()) {
            int score = 0;
            for (Response r : entry.getValue()) {
                if (r.isValid()) {
                    String resposta = r.getAnswer().toLowerCase();
                    int vezes = respostaFrequencia.get(r.getCategory()).get(resposta);
                    score += (vezes > 1) ? 5 : 10;
                }
            }
            entry.getKey().addScore(score);
        }
    }

    public void showScores() {
        System.out.println("\n--- PLACAR FINAL ---");

        players.sort((p1, p2) -> Integer.compare(p2.getScoreTotal(), p1.getScoreTotal()));

        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            System.out.printf("%d lugar: %s - %d ponto%n", i + 1, p.getName(), p.getScoreTotal());
        }
    }

    public char drawLetter() {
        Random random = new Random();
        return (char) ('A' + random.nextInt(26));
    }

}
