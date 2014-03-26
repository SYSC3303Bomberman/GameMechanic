import java.util.Scanner;


public class Player {

	private Board board;
	private int x, y;
	public int bombsMaxNumber;
	public int bombsNumber;
	private char command;	//command is the character received from clinet

	public Player(Board board, int x, int y){
		this.x = x;
		this.y = y;
		this.board = board;
		bombsMaxNumber = 1;
		bombsNumber = 1;
	}

	/* method to convert character command to movement*/
	public void act(){
		if ( command == 'u') {
			this.moveUp();
		}else if ( command == 'd') {
			this.moveDown();
		}else if ( command == 'r') {
			this.moveRight();
		}else if ( command == 'l') {
			this.moveLeft();
		}else if ( command == 'p') {
			this.placeBomb();
		}else if ( command == 's') {
			//stay for test
		}
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

	public void moveUp(){
		if(x > 0){
			if (board.hasDoorAt((x-1),y)&&board.enemies.size()==0) {
				System.out.println("CONGRATULATIONS");
				board.players.clear();
			}
			if (board.hasPowerUpAt((x-1),y)) {
				this.powerUp(this, (x-1),y);
				for (int i = 0; i < board.powerups.size() ; i++ ) {
					if ((board.powerups.get(i).getX()==(x-1))&&(board.powerups.get(i).getY()==y)) {
						board.powerups.remove(i);
					}
				}
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
			if (board.hasPowerUpAt((x+1),y)) {
				this.powerUp(this, (x+1),y);
				for (int i = 0; i < board.powerups.size() ; i++ ) {
					if ((board.powerups.get(i).getX()==(x+1))&&(board.powerups.get(i).getY()==y)) {
						board.powerups.remove(i);
					}
				}
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
			if (board.hasPowerUpAt(x,(y+1))) {
				this.powerUp(this, x,(y+1));
				for (int i = 0; i < board.powerups.size() ; i++ ) {
					if ((board.powerups.get(i).getX()==x)&&(board.powerups.get(i).getY()==(y+1))) {
						board.powerups.remove(i);
					}
				}
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
			if (board.hasPowerUpAt(x,(y-1))) {
				this.powerUp(this, x,(y-1));
				for (int i = 0; i < board.powerups.size() ; i++ ) {
					if ((board.powerups.get(i).getX()==x)&&(board.powerups.get(i).getY()==(y-1))) {
						board.powerups.remove(i);
					}
				}
			}
			if(!board.hasObstacleAt(x,(y-1))&&!board.hasBoxAt(x,(y-1))&&!board.hasPlayerAt(x,(y-1))&&!board.hasBombAt(x,(y-1))){
				y--;
			}
		}
	}

	public void powerUp(Player player, int x, int y){
		for(int i = 0; i < board.powerups.size(); i++){
 			if((board.powerups.get(i).getX() == x)&&(board.powerups.get(i).getY() == y)){
 				board.powerups.get(i).powerUp(this);
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
	/* ALL BELOW FOR TEST */
	public void increment(){
		System.out.println("\"u\" for up, \"d\" for down, \"r\" for right, \"l\" for left, \"s\" for stay, \"p\" for place bomb:");
		Scanner scanner = new Scanner(System.in);
		this.command = scanner.next().charAt(0);
		this.act();
	}
	/* ALL ABOVE FOR TEST */

}
