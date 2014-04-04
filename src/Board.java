import java.util.ArrayList;
import java.util.Random;


public class Board {

	public static final int DEFAULT_BOARD_LENGTH = 9;
	public static final int DEFAULT_BOARD_WIDTH = 9;
	public static final int DEFAULT_POWERUP_NUMBER = 3;
	public static final int DEFAULT_BOX_NUMBER = 4;
	public static final int DEFAULT_ENEMY_NUMBER = 3;
	public Door door;
	public ArrayList<Obstacle> obstacles;
	public ArrayList<PowerUp> powerups;
	public ArrayList<Box> boxes;
	public ArrayList<Enemy> enemies;
	public ArrayList<Player> players;
	public ArrayList<Bomb> bombs;
	private int tempX, tempY;
	public int playerLabel;

	public Board(){
		players = new ArrayList<Player>();
		playerLabel = 0;
		this.initialize();
	}
	
	public void initialize(){
		obstacles = new ArrayList<Obstacle>();
		powerups = new ArrayList<PowerUp>();
		boxes = new ArrayList<Box>();
		enemies = new ArrayList<Enemy>();	
		bombs = new ArrayList<Bomb>();
		/* ADD OBSTACLES ON TOP AND BOTTOM EDGES */
		for (int j = 0; j < DEFAULT_BOARD_LENGTH ; j++) {
			this.addObstacle(0, j);
			this.addObstacle((DEFAULT_BOARD_WIDTH-1), j);
		}
		/* ADD OBSTACLES ON RIGHT AND LEFT EDGES */
		for (int i = 0; i < DEFAULT_BOARD_WIDTH ; i++) {
			this.addObstacle(i, 0);
			this.addObstacle(i, (DEFAULT_BOARD_LENGTH-1));
		}
		/* ADD ALL OTHER OBSTACLES */
		for (int i = 2; i < DEFAULT_BOARD_WIDTH ; i+=2) {
			for (int j = 2; j < DEFAULT_BOARD_LENGTH; j+=2) {
				this.addObstacle(i, j);
			}
		}
		/* OBSTACLES INITIALIZATION DONE */

		Random ran = new Random();
		do{
			tempX = ran.nextInt(Board.DEFAULT_BOARD_WIDTH); 
			tempY = ran.nextInt(Board.DEFAULT_BOARD_LENGTH);	
		}while(this.hasObstacleAt(tempX, tempY)||this.hasBoxAt(tempX, tempY));
		door = new Door(this, tempX, tempY);	//door places at random place
		/* DOOR INITIALIZATION DONE */
		this.addBox(tempX, tempY);
		/* DOOR IS COVERED BY ONE BOX */

		for(int i = 0; i < DEFAULT_POWERUP_NUMBER; i++){
			do{
				tempX = ran.nextInt(Board.DEFAULT_BOARD_WIDTH); 
				tempY = ran.nextInt(Board.DEFAULT_BOARD_LENGTH);	
			}while(this.hasObstacleAt(tempX, tempY)||this.hasDoorAt(tempX, tempY));
			this.addPowerUp(tempX, tempY);	//enemies start at random places
			this.addBox(tempX, tempY);
		}
		/* POWERUP INITIALIZATION DONE */

		for(int i = DEFAULT_POWERUP_NUMBER+1; i < DEFAULT_BOX_NUMBER; i++){
			do{
				tempX = ran.nextInt(Board.DEFAULT_BOARD_WIDTH); 
				tempY = ran.nextInt(Board.DEFAULT_BOARD_LENGTH);	
			}while(this.hasObstacleAt(tempX, tempY)||this.hasBoxAt(tempX, tempY));
			this.addBox(tempX, tempY);	//enemies start at random places
		}
		/* BOX INITIALIZATION DONE */

		for(int i = 0; i < DEFAULT_ENEMY_NUMBER; i++){
			do{
				tempX = ran.nextInt(Board.DEFAULT_BOARD_WIDTH); 
				tempY = ran.nextInt(Board.DEFAULT_BOARD_LENGTH);	
			}while(this.hasObstacleAt(tempX, tempY)||this.hasBoxAt(tempX, tempY)||this.hasEnemyAt(tempX, tempY));
			this.addEnemy(tempX, tempY);	//boxes place at ranom places
		}
		/* ENEMY INITIALIZATION DONE */

		/* Obsatacles,door boxes, enemies can be displayed on GUI*/
	}

	public void addObstacle(int x, int y){
		Obstacle obstacle = new Obstacle(this, x, y);
		obstacles.add(obstacle);
	}	

	
	public void addPowerUp(int x, int y){
		Random ran = new Random();
		int temp;
		PowerUp powerup;
		temp = ran.nextInt(3); 
		if(temp == 0){
			powerup = new BombPowerUp(this, x, y);
		}else if(temp == 1){	
			powerup = new FlamePowerUp(this, x, y);
		}else{
			powerup = new WallPassPowerUp(this, x, y);
		}
		powerups.add(powerup);
	}

	public void addBox(int x, int y){
		Box box = new Box(this, x, y);
		boxes.add(box);
	}

	public void addEnemy(int x, int y){
		Random ran = new Random();
		int temp;
		Enemy enemy;
		temp = ran.nextInt(4); 
		if(temp == 0){
			enemy = new Balloom(this, x, y);
		}else if(temp == 1){	
			enemy = new Oneal(this, x, y);
		}else if(temp == 2){
			enemy = new Doll(this, x, y);
		}else{
			enemy = new Minvo(this, x, y);
		}
		enemies.add(enemy);
	}

	public void addPlayer(){
		Random ran = new Random();
		do{
			tempX = ran.nextInt(Board.DEFAULT_BOARD_WIDTH); 
			tempY = ran.nextInt(Board.DEFAULT_BOARD_LENGTH);	
		}while(this.hasObstacleAt(tempX, tempY)||this.hasBoxAt(tempX, tempY)||this.hasEnemyAt(tempX, tempY)||this.hasPlayerAt(tempX, tempY));
		Player player = new Player(this, tempX, tempY);	//player starts at random place
		players.add(player);
	}
	
	public void addExcitingPlayers(ArrayList<Player> players){
		for(int i = 0; i < players.size(); i++){
		Random ran = new Random();
		do{
			tempX = ran.nextInt(Board.DEFAULT_BOARD_WIDTH); 
			tempY = ran.nextInt(Board.DEFAULT_BOARD_LENGTH);	
		}while(this.hasObstacleAt(tempX, tempY)||this.hasBoxAt(tempX, tempY)||this.hasEnemyAt(tempX, tempY)||this.hasPlayerAt(tempX, tempY));
			players.get(i).setX(tempX);
			players.get(i).setY(tempY);	//player starts at random place
		}
	}

	public void addBomb(Bomb bomb){
		bombs.add(bomb);
	}

	public boolean hasDoorAt(int x, int y){
		if((door.getX() == x)&&(door.getY() == y)){
			return true;
		}else{
			return false;
		}
	}

	public boolean hasObstacleAt(int x, int y){
		for(int i = 0; i < obstacles.size(); i++){
			if((obstacles.get(i).getX() == x)&&(obstacles.get(i).getY() == y)){return true;}
		}
		return false;
	}

	public boolean hasBoxAt(int x, int y){
		for(int i = 0; i < boxes.size(); i++){
			if((boxes.get(i).getX() == x)&&(boxes.get(i).getY() == y)){return true;}
		}
		return false;
	}

	public boolean hasEnemyAt(int x, int y){
		for(int i = 0; i < enemies.size(); i++){
			if((enemies.get(i).getX() == x)&&(enemies.get(i).getY() == y)){return true;}
		}
		return false;
	}

	public boolean hasPlayerAt(int x, int y){
		for(int i = 0; i < players.size(); i++){
			if((players.get(i).getX() == x)&&(players.get(i).getY() == y)){return true;}
		}
		return false;
	}

	public boolean hasBombAt(int x, int y){
		for(int i = 0; i < bombs.size(); i++){
			if((bombs.get(i).getX() == x)&&(bombs.get(i).getY() == y)){return true;}
		}
		return false;
	}

	public boolean hasPowerUpAt(int x, int y){
		for(int i = 0; i < powerups.size(); i++){
			if((powerups.get(i).getX() == x)&&(powerups.get(i).getY() == y)){return true;}
		}
		return false;
	}
	
	public String toString(){
		String str = "";
		int p;
		for(int i = 0; i < DEFAULT_BOARD_WIDTH; i++){
			for(int j = 0; j < DEFAULT_BOARD_LENGTH; j++){
				if(this.hasObstacleAt(i,j)){
					str += 'O';
				}else if(this.hasPlayerAt(i,j)){
					str += 'P';
				}else if(this.hasEnemyAt(i,j)){
					for(int k = 0; k < enemies.size(); k++){
						if((enemies.get(k).getX() == i)&&(enemies.get(k).getY() == j)){
							if(enemies.get(k) instanceof Balloom){
								str += 'm';
							}else if(enemies.get(k) instanceof Oneal){
								str += 'l';
							}else if(enemies.get(k) instanceof Doll){
								str += 'd';
							}else if(enemies.get(k) instanceof Minvo){
								str += 'v';
							}
						}
					}			
				}else if(this.hasBoxAt(i,j)){
					str += 'B';
				}else if(this.hasBombAt(i,j)){
					str += 'X';
				}else if(this.hasPowerUpAt(i,j)){
					for(int k = 0; k < powerups.size(); k++){
						if((powerups.get(k).getX() == i)&&(powerups.get(k).getY() == j)){
							if(powerups.get(k) instanceof FlamePowerUp){
								str += 'L';
							}else if(powerups.get(k) instanceof BombPowerUp){
								str += 'U';
							}else if(powerups.get(k) instanceof WallPassPowerUp){
								str += 'W';
							}else if(powerups.get(k) instanceof BombPassPowerUp){
								str += 'b';
							}
						}
					}
				}else if(this.hasDoorAt(i,j)){
					str += 'D';
				}else{
					str += ' ';
				}
			}
			str += '\n';
		}
		return str;
	}

	public void printBoard(){
		System.out.println(this.toString());
	}
	
	/* ALL BELOW FOR TEST */
	public void increment(){
		for(int i = 0; i < enemies.size(); i++){	
			enemies.get(i).increment();
		}	
		for(int i = 0; i < players.size(); i++){	
			players.get(i).increment();
		}
		for(int i = 0; i < bombs.size(); i++){	
			bombs.get(i).increment();
		}
	}

	public void play(){
		this.addPlayer();
		while(players.size()!=0){
			this.printBoard();
			this.increment();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Board board = new Board();		
		board.play();
	}
	/* ALL ABOVE FOR TEST */
}
