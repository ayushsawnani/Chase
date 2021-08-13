

public class Player {
    
    private String player;
    private int piecesInField;
    private int startingx, startingy, x, y;
    public Player(String player, int startingx, int startingy, int x, int y){
        this.player = player;
        piecesInField = 1;
        this.startingx = startingx;
        this.startingy = startingy;
        this.x = x;
        this.y = y;
    }

    public String getPlayer() {
        return player;
    }

    public int getStartingX() {
        return startingx;
    }

    public int getStartingY() {
        return startingy;
    }

    public int getPiecesInField() {
        return piecesInField;
    }

    public void setPlayer(String icon){
        player = icon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void roll(){
      
        int dice = (int)(Math.random()*6) + 1;
        System.out.println("Player " + player + " rolled a " + dice);
        for(int i = 0; i < dice; i++){
            if (y == 0){
                if (x == 0){
                    y++;
                }
                else {
                    x--;
                }
            }
    
            else if (y == 6){
                if (x == 6){
                    y--;
                }
                else {
                    x++;
                }
            }
    
            else if (x == 0){
                y++;
            }
            else if (x == 6){
                y--;
            }
        }
        if (dice == 6){
            System.out.println("Player" + player + " gets to roll again!\n");
            roll();
        }
           
    }

    

    public String toString(){
        return "Player" + player + ": " + " alive!";
    }

    public String winner() {
        return "Player " + player + " wins!";
    }


    
}
