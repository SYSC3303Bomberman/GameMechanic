
public class Enemy {

	private Board board;
	private int x, y;

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
			if (board.hasPlayerAt((x-1),y)) {
				for (int i = 0; i < board.players.size() ; i++ ) {
					if ((board.players.get(i).getX()==(x-1))&&(board.players.get(i).getY()==y)) {
						board.players.remove(i);
					}
				}
			}
			if(!board.hasObstacleAt((x-1),y)&&!board.hasBoxAt((x-1),y)&&!board.hasBombAt((x-1),y)){
				x--;
			}
		}
	}

	public void moveDown(){
		if(x < Board.DEFAULT_BOARD_WIDTH){
			if (board.hasPlayerAt((x-1),y)) {
				for (int i = 0; i < board.players.size() ; i++ ) {
					if ((board.players.get(i).getX()==(x+1))&&(board.players.get(i).getY()==y)) {
						board.players.remove(i);
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
			if (board.hasPlayerAt((x-1),y)) {
				for (int i = 0; i < board.players.size() ; i++ ) {
					if ((board.players.get(i).getX()==x)&&(board.players.get(i).getY()==(y+1))) {
						board.players.remove(i);
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
			if (board.hasPlayerAt((x-1),y)) {
				for (int i = 0; i < board.players.size() ; i++ ) {
					if ((board.players.get(i).getX()==x)&&(board.players.get(i).getY()==(y-1))) {
						board.players.remove(i);
					}
				}
			}
			if(!board.hasObstacleAt(x,(y-1))&&!board.hasBoxAt(x,(y-1))&&!board.hasPlayerAt(x,(y-1))&&!board.hasBombAt(x,(y-1))){
				y--;
			}
		}
	}
	
}
