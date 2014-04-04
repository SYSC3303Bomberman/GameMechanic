
public class Doll extends Enemy{

	public Doll(Board board, int x, int y) {
		super(board, x, y);
		this.life = 2;
		this.wallPass = false;
	}

}
