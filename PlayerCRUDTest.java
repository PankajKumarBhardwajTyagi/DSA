import beans.Player;
import exceptions.ExcessPlayerException;
import exceptions.NoPlayersExist;
import exceptions.PlayerNotFoundException;
import service.PlayerService;

public class PlayerCRUDTest {
	public static void main(String[] args) {
		PlayerService service = new Player(5); // Properway of Creating Objects of a Service Interface
		try {
			try {
				try {
					System.out.println("Player added with id " + service.addPlayer("Dilip", 50, "Bowler"));
					System.out.println("Player added with id " + service.addPlayer("Rajesh", 30, "Batsman"));
					System.out.println("Player added with id " + service.addPlayer("Bharath", 32, "All-Rounder"));
					System.out.println();
				} catch (ExcessPlayerException epe) {
					System.err.println(epe.getMessage());
				}
				for(Player player : service.getAllPlayers()) System.out.println(player);
				System.out.println();
			} catch (NoPlayersExist npe) {
				System.err.println(npe.getMessage());
			}
			System.out.println(service.getPlayerById(3));
			System.out.println();
			Player updatePlayer = service.getPlayerById(3);
			updatePlayer.setName("Ashok");
			updatePlayer.setAge(21);
			updatePlayer.setType("Batsman");
			System.out.println("Player with id " + updatePlayer.getId() + " Updated: " + service.updatePlayer(updatePlayer));
			System.out.println();
			long id = 1;
			if(service.deletePlayer(id)) System.out.println("Player with id " + id + " Deleted");
			System.out.println();
			for(Player player : service.getAllPlayers()) System.out.println(player);
			System.out.println();
		} catch (PlayerNotFoundException pnfe) {
			System.err.println(pnfe.getMessage());
		} catch (NoPlayersExist npe) {
			System.err.println(npe.getMessage());
		}
	}
}