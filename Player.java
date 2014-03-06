
public class Player {


	private Board board;
	private int x, y;

	public Player(Board board, int x, int y){
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
			if(!board.hasPlayerAt((x-1),y)){
				x--;
			}
		}
	}

	public void moveDown(){
		if(x < Board.DEFAULT_BOARD_WIDTH){
			if(!board.hasPlayerAt((x+1),y)){
				x++;
			}
		}
	}

	public void moveRight(){
		if(x < Board.DEFAULT_BOARD_LENGTH){
			if(!board.hasPlayerAt(x,(y+1))){
				y++;
			}
		}
	}

	public void moveLeft(){
		if(y > 0){
			if(!board.hasPlayerAt(x,(y-1))){
				y--;
			}
		}
	}


}
