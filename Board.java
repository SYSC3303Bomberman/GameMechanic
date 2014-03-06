import java.util.ArrayList;
import java.util.Random;


public class Board {

	public static final int DEFAULT_BOARD_LENGTH = 10;
	public static final int DEFAULT_BOARD_WIDTH = 10;
	private ArrayList<Player> players;

	public Board(){
		Random ran = new Random();
		Door door = new Door(this, ran.nextInt(Board.DEFAULT_BOARD_WIDTH), ran.nextInt(DEFAULT_BOARD_LENGTH));

	}

	public void addPlayer(){
		Random ran = new Random();
		Player player = new Player(this, ran.nextInt(Board.DEFAULT_BOARD_WIDTH), ran.nextInt(DEFAULT_BOARD_LENGTH));
		players.add(player);
	}

	public boolean hasPlayerAt(int x, int y){
		for(int i = 0; i < players.size(); i++){
			if((players.get(i).getX() == x)&&(players.get(i).getY() == y)){return true;}
		}
		return false;
	}

	public boolean hasObstacleAt(int x, int y){
		return false;
	}

	public boolean hasBombAt(int x, int y){
		return false;
	}

	public boolean hasDoorAt(int x, int y){
		return false;
	}
}
