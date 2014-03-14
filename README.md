GameMechanic
============
March 13th 2014

Board:
bombExplode() is deleted from Board class. All explosion will be called in Bomb itself.

Player:
Another command 'p' for placeBomb().
More logic for movements.

Bomb:
explode() will burn() its current location, the corresponding player will loadBomb(), bomb removes from bombs.
More detials for burn() to destory things around.

Enemy:
enemy now has movement method.

March 13th 2014

Player:
SocketAddress added in Player class constrator.
move() method to convert character to movement.

Bomb:
burn(): remove target from its arraylist if burned.
searching method is not completed yet.

-----------------------------------------------------------------------------------------------------------------

March 12th 2014

All classes added. (Box, Enemy are new, total 7 classes)

Board:
All (GUI) initializations are in constrator.
Method void bombExplode(Bomb bomb): specific bomb explodes.

Bomb:
Method void explode(): this bomb explodes to burn squares around it.
Method void burn(int x, int y): different effects when burn different targets.

Player:
Added int bombsNumber: number of bombs the player has.
Added int bombsMaxNumber: the max number of bombs the player can place.
(Bomb power-up coming: increase the max number of bombs the player can place.)
void loadBomb() number of boms the player has plus one when his bomb explodes.
void placeBomb() place a bomb at his current location.

QUESTIONS:
Double Buffer:
Have no idea about Objectives:1d : Include the bomb factory and the double-buffer update.


-----------------------------------------------------------------------------------------------------------------
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

QUESTIONS:

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
