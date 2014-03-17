import java.util.Random;

public class Enemy extends Thread{

	public static final int DEFAULT_ENEMY_MOVE_PERIOD = 200;
	private Board board;
	private int x, y;
	private int direction;

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
	
	public void moveUp(){
		if(x > 0){
			if(!board.hasObstacleAt((x-1),y)&&!board.hasBoxAt((x-1),y)&&!board.hasBombAt((x-1),y)){
				x--;
			}
		}
	}

	public void moveDown(){
		if(x < Board.DEFAULT_BOARD_WIDTH){
			if(!board.hasObstacleAt((x+1),y)&&!board.hasBoxAt((x+1),y)&&!board.hasBombAt((x+1),y)){
				x++;
			}
		}
	}

	public void moveRight(){
		if(x < Board.DEFAULT_BOARD_LENGTH){
			if(!board.hasObstacleAt(x,(y+1))&&!board.hasBoxAt(x,(y+1))&&!board.hasBombAt(x,(y+1))){
				y++;
			}
		}
	}

	public void moveLeft(){
		if(y > 0){
			if(!board.hasObstacleAt(x,(y-1))&&!board.hasBoxAt(x,(y-1))&&!board.hasBombAt(x,(y-1))){
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
