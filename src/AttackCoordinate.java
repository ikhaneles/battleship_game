public class AttackCoordinate extends Coordinate {
    private boolean isHit;
    AttackCoordinate(int r, int c){
        super(r,c);
    }
    public boolean getIsHit(){
        return isHit;
    }
    public void setIsHit(boolean hit){
        isHit = hit;
    }
}
