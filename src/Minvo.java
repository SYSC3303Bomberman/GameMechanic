
public class Minvo extends Enemy{

	public Minvo(Board board, int x, int y) {
		super(board, x, y);
		this.life = 2;
		this.wallPass = true;
	}

}
