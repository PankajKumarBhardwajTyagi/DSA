package beans;

public class ScoreBoard {
	private int entries = 0; // actual number of Entries
	private Score[] scores; // array of scores (player & score)
	
	public ScoreBoard(int capacity) {
		scores = new Score[capacity]; // empty scoreboard with the given capacity for storing scores
	}
	
	// Add a new Score to the Scoreboard
	// [Kiran: 70, Dilip: 50, null, null, null]
	public long addScore(Score score) { // [Kiran: 70]
		int newScore = score.getScore();
		// check whether this newScore is the highest score in the ScoreBoard
		//  1         5                 70         50
		if(entries < scores.length || newScore > scores[entries - 1].getScore()) {
			//    1        5                2
			if(entries < scores.length) ++entries; // no score drops from the board
			// shift any lower scores than the new score rightward to make room for the newScore
			//    1
			int index = entries - 1;
			//     1      0                    50              70 
			while(index > 0 && scores[index - 1].getScore() < newScore) {
				//     1            0
				scores[index] = scores[index - 1]; // shift all the scores to the right
				// 0
				--index;
			}
			// 0           Kiran: 70
			scores[index] = score; // when done, add the newScore
		}
		return score.getId();
	}
	
	public Score removeScore(int index) throws IndexOutOfBoundsException {
		// if index is invalid throw exception
		if(index < 0 || index >= entries) throw new IndexOutOfBoundsException("Score with index " + index + " not found");
		Score existScore = scores[index - 1]; // get the score object to be removed
		for(int position = index - 1; position < entries - 1; ++position) { // count up from position (not down)
			scores[position] = scores[position + 1]; // shift all the scores to the left
		}
		scores[entries - 1] = null; // null the old last score
		--entries;
		return existScore; // return the removed score object
	}
	
	public Score[] getAllScores() {
		return scores;
	}
}