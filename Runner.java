import java.util.ArrayList;
import java.util.Scanner;


public class Runner{

    public Runner() {
        Scanner in = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player("1", 0, 0, 0, 0));
        players.add(new Player("2", 0, 6, 0, 6));
        players.add(new Player("3", 6, 6, 6, 6));
        players.add(new Player("4", 6, 0, 6, 0));

        BoardGame board = new BoardGame(7, 7, players);
        board.introduction();
        board.printBoard();
        System.out.println("Start? (y/n)");
        String s = in.nextLine();
        if (s.equals("y")){
            while (!board.checkWinner()){

                for(int player = 0; player < board.getPlayers().size(); player++){
                    System.out.print("\033[H\033[2J");
                    Player p = board.getPlayers().get(player);
                    board.takeTurn(p);
                    board.printBoard();
                    String sentinel = in.nextLine();
                }

            }
            for(Player p : players) { 
                System.out.println(p.winner()); 
                
            }
        } else {
            System.out.println("Bye!");
        }
        

        in.close();
        
    }

    public static void main(String[] args){
        new Runner();
    }
}