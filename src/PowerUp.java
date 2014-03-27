
public abstract class PowerUp {

	protected Board board;
	protected int x, y;

	public PowerUp(Board board, int x, int y){
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
	
	public abstract void powerUp(Player player);
	
}