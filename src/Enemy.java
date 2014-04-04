import java.util.Random;

public class Enemy extends Thread{

	public static final int DEFAULT_ENEMY_MOVE_PERIOD = 200;
	protected Board board;
	protected int x, y;
	protected int life;
	protected int direction;
	protected boolean wallPass;

	public Enemy(Board board, int x, int y){
		this.x = x;
		this.y = y;
		this.board = board;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public int getLife(){
		return life;
	}

	public void damaged(){
		life--;
	}

	public void moveUp(){
		if(x > 0){
			if (board.hasPlayerAt((x-1),y)) {
				for (int i = 0; i < board.players.size() ; i++ ) {
					if ((board.players.get(i).getX()==(x-1))&&(board.players.get(i).getY()==y)) {
						board.players.remove(i);
					}
				}
				if (board.players.size()==0){
					System.out.println("GAME OVER");
					for (int i = 0; i < board.enemies.size() ; i++ ) {
						board.enemies.get(i).stop();
					}
				}
			}
			if(board.hasObstacleAt((x-1),y)){

			}else if(board.hasBoxAt((x-1),y)){
 				if(wallPass == true){
 					x--;
 				}
 			}else if(board.hasBombAt((x-1),y)){
 
 			}else{
  				x--;
  			}
		}
	}

	public void moveDown(){
		if(x < Board.DEFAULT_BOARD_WIDTH){
			if (board.hasPlayerAt((x+1),y)) {
				for (int i = 0; i < board.players.size() ; i++ ) {
					if ((board.players.get(i).getX()==(x+1))&&(board.players.get(i).getY()==y)) {
						board.players.remove(i);
					}
				}
				if (board.players.size()==0){
					System.out.println("GAME OVER");
					for (int i = 0; i < board.enemies.size() ; i++ ) {
						board.enemies.get(i).stop();
					}
				}
			}
			if(board.hasObstacleAt((x+1),y)){
 				
 			}else if(board.hasBoxAt((x+1),y)){
 				if(wallPass == true){
 					x++;
 				}
 			}else if(board.hasBombAt((x+1),y)){
 
 			}else{
  				x++;
  			}
		}
	}

	public void moveRight(){
		if(x < Board.DEFAULT_BOARD_LENGTH){
			if (board.hasPlayerAt(x,(y+1))) {
				for (int i = 0; i < board.players.size() ; i++ ) {
					if ((board.players.get(i).getX()==x)&&(board.players.get(i).getY()==(y+1))) {
						board.players.remove(i);
					}
				}
				if (board.players.size()==0){
					System.out.println("GAME OVER");
					for (int i = 0; i < board.enemies.size() ; i++ ) {
						board.enemies.get(i).stop();
					}
				}
			}
			if(board.hasObstacleAt(x,(y+1))){
 				
 			}else if(board.hasBoxAt(x,(y+1))){
 				if(wallPass == true){
 					y++;
 				}
 			}else if(board.hasBombAt(x,(y+1))){
 
 			}else{
  				y++;
  			}
		}
	}

	public void moveLeft(){
		if(y > 0){
			if (board.hasPlayerAt(x,(y-1))) {
				for (int i = 0; i < board.players.size() ; i++ ) {
					if ((board.players.get(i).getX()==x)&&(board.players.get(i).getY()==(y-1))) {
						board.players.remove(i);
					}
				}
				if (board.players.size()==0){
					System.out.println("GAME OVER");
					for (int i = 0; i < board.enemies.size() ; i++ ) {
						board.enemies.get(i).stop();
					}
				}					
			}
			if(board.hasObstacleAt(x,(y-1))){
 				
 			}else if(board.hasBoxAt(x,(y-1))){
 				if(wallPass == true){
 					y--;
 				}
 			}else if(board.hasBombAt(x,(y-1))){
 
 			}else{
  				y--;
  			}
		}
	}
	
	@Override
	 public void run(){
		while(true){
		 	try {
		 		Thread.sleep(DEFAULT_ENEMY_MOVE_PERIOD);
	 		} catch (InterruptedException e) {
		 		// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		this.move();
	 	}
	 }
	
	public void move(){
		Random ran = new Random();
		this.direction = ran.nextInt(4);
  		if ( direction == 0) {
  			this.moveUp();
		}else if ( direction == 1) {
			this.moveDown();
		}else if ( direction == 2) {
			this.moveRight();
		}else if ( direction == 3) {
  			this.moveLeft();
  		}
  	}
}
