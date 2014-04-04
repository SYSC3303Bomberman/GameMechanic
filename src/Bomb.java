
public abstract class Bomb {

	protected Board board;
	protected int x, y;
	protected Player player;
	/* ALL BELOW FOR TEST */
	private int timer = 0;
	/* ALL ABOVE FOR TEST */

	public Bomb(Board board, Player player, int x, int y){
		this.x = x;
		this.y = y;
		this.board = board;
		this.player = player;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public Player getPlayer(){
		return player;
	}

	public abstract void explode();

	public void burn(int x, int y){
		Bomb tempBomb;
		if (board.hasPlayerAt(x, y)) {
			//player died
			for (int i = 0; i < board.players.size() ; i++ ) {
				if ((board.players.get(i).getX()==x)&&(board.players.get(i).getY()==y)) {
					board.players.remove(i);
				}
			}
		}else if (board.hasBoxAt(x, y)) {
			//box destroyed
			for (int i = 0; i < board.boxes.size() ; i++ ) {
				if ((board.boxes.get(i).getX()==x)&&(board.boxes.get(i).getY()==y)) {
					board.boxes.remove(i);
				}
			}
		}else if (board.hasEnemyAt(x, y)) {
			//enemy killed
			for (int i = 0; i < board.enemies.size() ; i++ ) {
				if ((board.enemies.get(i).getX()==x)&&(board.enemies.get(i).getY()==y)) {
					board.enemies.get(i).damaged();
					if (board.enemies.get(i).getLife() == 0){
						board.enemies.remove(i);
					}	
				}
			}
		}else if (board.hasBombAt(x, y)) {
			//bomb exploded
			for (int i = 0; i < board.bombs.size() ; i++ ) {
				if ((board.bombs.get(i).getX()==x)&&(board.bombs.get(i).getY()==y)) {
					//board.bombs.get(i).explode();
					tempBomb = board.bombs.get(i);
					board.bombs.remove(i);
					tempBomb.explode();
				}
			}
		}
	}
	/* ALL BELOW FOR TEST */
	public void increment(){
		timer++;
		if (timer == 7) {	//time of create = 1
			this.explode();	//after 6 steps explodes
		}
	}
	/* ALL ABOVE FOR TEST */
}



