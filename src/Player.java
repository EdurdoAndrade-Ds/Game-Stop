public class Player {
    private String name;
    private int scoreTotal;

    public Player(String name) {
        this.name = name;
        this.scoreTotal = scoreTotal = 0;
    }

    public String getName() {
        return name;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void addScore(int score) {
        this.scoreTotal += score;
    }
}
