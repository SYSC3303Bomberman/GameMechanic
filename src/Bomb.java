public class Bomb extends Thread{

	public static final int DEFAULT_BOMB_EXPOLSION_TIME = 800;
	private Board board;
	private int x, y;
	private Player player;

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

	public void explode(){
		this.burn((x + 1), y);
		this.burn((x - 1), y);
		this.burn(x, y);
		this.burn(x, (y + 1));
		this.burn(x, (y - 1));
		player.loadBomb();	// player loads one bomb at the time his bomb explodes
		board.bombs.remove(this);
		this.stop();
	}

	public void burn(int x, int y){
		if (board.hasBoxAt(x, y)) {
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
					board.enemies.get(i).stop();
					board.enemies.remove(i);
				}
			}
		}
	}
	
	@Override
	 public void run(){
		while(true){
		 	try {
		 		Thread.sleep(DEFAULT_BOMB_EXPOLSION_TIME);
	 		} catch (InterruptedException e) {
		 		// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		this.explode();
	 	}
	 }
	
}



