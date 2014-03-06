GameMechanic
============
March 6th 2014

Five different classes for Board, Player, Door, Bomb, Obstacle.
Door, Bomb, Obstacle are all empty now.
Board are sized by two global variable.
*Server should create one board when start a game.
Board will genarates a Door at a random place INSIDE Board.
Player will join game as ArrayList of Player and start at random place.
Player has six methods.
*getX() and getY() for server to get updated location of players.
*other four methods are movement methods to check if movement is available and move.

QESTIONS:
1. GameMechanic in Server:
I assumed my GameMechanic is on Server side.
Notes start with * are hints for Volodymyr to insert my code into Server code.
Client sends a move to Server, Server receives it and call method of corresponding player.
Player updates its location, Server sends new location to GUI (and send acknowledge message back to client).

2. KeyEventListener.
I don't think we need KeyEventListener for this milestone. 
Every player control should be implemented in test logger.
For futrue development, the KeyEventListener should be on Client side.
I will try to see if I can give some help on it.
