import java.util.*;

public class Round {
    private char letter;
    private Map<Player, List<Response>> responses;

    public Round(char letter) {
        this.letter = letter;
        this.responses = new HashMap<>();
    }

    public char getLetter() {
        return letter;
    }

    public void addResponse(Player player, List<Response> playerResponses) {
        responses.put(player, playerResponses);
    }

    public Map<Player, List<Response>> getResponses() {
        return responses;
    }
}
