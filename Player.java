package beans;

import exceptions.ExcessPlayerException;
import exceptions.NoPlayersExist;
import exceptions.PlayerNotFoundException;
import service.PlayerService;

public class Player implements PlayerService {
	private static long lastId;
	public long getLastId() { return lastId; }
	
	private Player[] players; // 1, 2, 3, null, null
	
	private long id;
	private String name;
	private int age;
	private String type;
	
	public Player(int count) {
		players = new Player[count]; // 5
	}
	
	public Player() {} // just to create an temperory object of the class

	public long getId() { return id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	@Override public String toString() {
		return "Player [id=" + id + ", name=" + name + ", age=" + age + ", type=" + type + "]";
	}

	@Override public long addPlayer(String name, int age, String type) throws ExcessPlayerException {
		// If the new Player exceeding the count of Players in the Game then throw Exception
		if(lastId > players.length - 1) throw new ExcessPlayerException("Player Limit Exceeded");
		Player newPlayer = new Player();
		newPlayer.id = ++lastId; // incremental id
		newPlayer.name = name;
		newPlayer.age = age;
		newPlayer.type = type;
		players[(int) newPlayer.id - 1] = newPlayer;
		return newPlayer.id;
	}

	@Override public Player[] getAllPlayers() throws NoPlayersExist {
		// If the Collection is Empty throw Exception
		if(lastId == 0 || players.length == 0) throw new NoPlayersExist("No Players Exist");
		
		// get count of not null players
		int limit = 0;
		for(Player player : players) {
			if(player != null) ++limit;
		}
		
		// create a new array with limit of only not null players
		Player[] allPlayers = new Player[limit];
		
		// add all the not null players to the new array
		int newIndex = 0;
		for(int oldIndex = 0; oldIndex < players.length; ++oldIndex) {
			if(players[oldIndex] != null) allPlayers[newIndex++] = players[oldIndex];
		}
		
		return allPlayers;
	}

	@Override public Player getPlayerById(long id) throws PlayerNotFoundException {
		// if player with id given is not found then throw Exception
		if(id > lastId || id < 1) throw new PlayerNotFoundException("No Player with id " + id + " Found");
		return players[(int) id - 1];
	}

	@Override public Player updatePlayer(Player player) throws PlayerNotFoundException {
		Player existPlayer = getPlayerById(player.getId());
		players[(int) existPlayer.getId() - 1] = player;
		return player;
	}

	@Override public boolean deletePlayer(long id) throws PlayerNotFoundException {
		Player existPlayer = getPlayerById(id);
		players[(int) id - 1] = null;
		return true;
	}
}