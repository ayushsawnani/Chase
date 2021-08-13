import java.util.ArrayList;
import java.util.Scanner;

public class BoardGame implements Game{
    //11 x 11 board
    //center 4 lines are for red, yellow, green, blue
    private Space[][] board;
    private int playerCount;
    private ArrayList<Player> players;
    public BoardGame(int width, int height, ArrayList<Player> players){
        playerCount = 4;
        board = new Space[width][height];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = new Space(i, j);
            }
        }

        this.players = players;
    }

    public Space[][] getBoard() {
        return board;
    }
    public void introduction() {
        System.out.println("Welcome to - Chase!");
        System.out.println("The directions are simple: ");
        System.out.println("-Each of the four players are on the corners of the board.");
        System.out.println("---You get 1 roll per turn.");
        System.out.println("---If you roll a 6, you get to roll again.");
        System.out.println("-Sometimes, another player will land on you, which kicks your player back into your base!");
        System.out.println("-You win when you are the last one standing.");
        System.out.println("Good Luck!");
    }

    public void printBoard() {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                for(int k = 0; k < players.size(); k++){
                    Player p = players.get(k);
                    if (board[i][j].getSpace() == p.getPlayer()) board[i][j].changeSpace("☐");
                    if (checkWinner()) board[i][j].winner(p);
                    if (p.getX() == i && p.getY() == j) {
                        board[i][j].changeSpace(p);
                    }
                }
                System.out.print(board[i][j]);
            }
            System.out.println("\n");
        }

        for(Player p : players){
            System.out.println(p);
        }
        System.out.println("\n");
    }
    
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void takeTurn(Player p) {
        p.roll();
        for(int other = 0; other < players.size(); other++){
            Player o = players.get(other);
            if (!(o.getPlayer().equals(p.getPlayer()))){
                int x1 = p.getX();
                int x2 = o.getX();
                int y1 = p.getY();
                int y2 = o.getY();
                if (x1 == x2 && y1 == y2) { 
                    System.out.println("Player " + p.getPlayer() + " knocked out Player " + o.getPlayer() + "!");
                    o.setPlayer("☐");
                    players.remove(o);
                    playerCount--;  
                    break; 
                }
            }
        }

        if (board[p.getX()][p.getY()].getSpace().equals("☒")) {
            powerup(p);
        }
        
    }

    public void powerup(Player p){
        Scanner in = new Scanner(System.in);
        printBoard();
        System.out.print("Player " + p.getPlayer() + " stepped on a powerup! Choose a player to kill: ");
        String kill = in.nextLine();

        for(Player o : players){
            if (o.getPlayer().equals(kill)){
                System.out.println("Player " + p.getPlayer() + " killed Player " + o.getPlayer() + "!");
                board[o.getX()][o.getY()].changeSpace("☐");
                players.remove(o);
                playerCount--;
                break;
            }
        }

        // in.close();
    }

    public void lowerPlayerCount() {
        playerCount --;
    }

    public boolean checkWinner() {
        if (playerCount == 1) { return true; }
        return false;
    }
    
}
