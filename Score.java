package beans;

public class Score {
	private static long lastId;
	
	private long id;
	private Player player;
	private int score;
	
	public Score(Player player, int score) {
		id = ++lastId;
		this.player = player;
		this.score = score;
	}
	
	public long getId() { return id; }

	public Player getPlayer() { return player; }
	public void setPlayer(Player player) { this.player = player; }

	public int getScore() { return score; }
	public void setScore(int score) { this.score = score; }

	@Override public String toString() {
		return "Score [id=" + id + ", player=" + player + ", score=" + score + "]";
	}
}