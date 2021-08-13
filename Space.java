public class Space {
    // using o for each space

    private String space;
    private int x, y;
    public Space(int x, int y){
        
        this.x = x;
        this.y = y;
        this.space = "☐";
        int rand = (int)(Math.random()*36);
        if (rand%6 == 0) this.space = "☒";
        if (x > 0 && x < 6){
            if (y > 0 && y < 6){
                this.space = "~";
            }
        }
    }
    
    public Space(int x, int y, String player){
        this.space = player;
        this.x = x;
        this.y = y;
    }

    public String getSpace(){
        return space;
    }

    public void changeSpace(Player p){
        space = p.getPlayer();
    }

    public void winner(Player p){
        space = p.getPlayer();
    }

    public void changeSpace(String space){
        this.space = space;
    }
    public String toString() {
        return "   " + space + " ";
    }
}
