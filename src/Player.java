import java.net.SocketAddress;
import java.util.ArrayList;


public class Player extends Thread{

	SocketAddress clientAddress;
	private Board board;
	private int x, y;
	private int bombsMaxNumber;
	private int bombsNumber;
	private String command;	//command is the character received from clinet

	public Player(){}
	
	public Player(Board board, int x, int y, SocketAddress clientAddress){
		this.x = x;
		this.y = y;
		this.board = board;
		this.clientAddress = clientAddress;
		bombsMaxNumber = 1;
		bombsNumber = 1;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public int getBombsNumber() {
		return bombsNumber;		
	}

	public SocketAddress getPlayerAddress(){
		return this.clientAddress;
	}
	
	/* method to convert character command to movement*/	
	public void move(String movement){
		command = movement;
		if (command.equals("u")) {
			this.moveUp();
		}else if (command.equals("d")) {
			this.moveDown();
		}else if (command.equals("r")) {
			this.moveRight();
		}else if (command.equals("l")) {
			this.moveLeft();
		}else if (command.equals("p")) {
			this.placeBomb();
		}
	}
	
	public void moveUp(){
		if(x > 0){
			if (board.hasDoorAt((x-1),y)&&board.enemies.size()==0) {
				System.out.println("CONGRATULATIONS");
				board.players.clear();
			}
			if(!board.hasObstacleAt((x-1),y)&&!board.hasBoxAt((x-1),y)&&!board.hasPlayerAt((x-1),y)&&!board.hasBombAt((x-1),y)){
				x--;
			}
		}
	}

	public void moveDown(){
		if(x < Board.DEFAULT_BOARD_WIDTH){
			if (board.hasDoorAt((x+1),y)&&board.enemies.size()==0) {
				System.out.println("CONGRATULATIONS");
				board.players.clear();
			}
			if(!board.hasObstacleAt((x+1),y)&&!board.hasBoxAt((x+1),y)&&!board.hasPlayerAt((x+1),y)&&!board.hasBombAt((x+1),y)){
				x++;
			}
		}
	}

	public void moveRight(){
		if(x < Board.DEFAULT_BOARD_LENGTH){
			if (board.hasDoorAt(x,(y+1))&&board.enemies.size()==0) {
				System.out.println("CONGRATULATIONS");
				board.players.clear();
			}
			if(!board.hasObstacleAt(x,(y+1))&&!board.hasBoxAt(x,(y+1))&&!board.hasPlayerAt(x,(y+1))&&!board.hasBombAt(x,(y+1))){
				y++;
			}
		}
	}

	public void moveLeft(){
		if(y > 0){
			if (board.hasDoorAt(x,(y-1))&&board.enemies.size()==0) {
				System.out.println("CONGRATULATIONS");
				board.players.clear();
			}
			if(!board.hasObstacleAt(x,(y-1))&&!board.hasBoxAt(x,(y-1))&&!board.hasPlayerAt(x,(y-1))&&!board.hasBombAt(x,(y-1))){
				y--;
			}
		}
	}

	public void loadBomb(){
		bombsNumber++;
	}

	public void placeBomb(){
		if (bombsNumber > 0) {
			bombsNumber--;
			Bomb bomb = new Bomb(board, this, x, y);
			board.addBomb(bomb);
		}
	}

}
