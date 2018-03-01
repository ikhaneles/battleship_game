public class Coordinate {
    private int Row;
    private int Col;
    public Coordinate(){}
    public Coordinate(int r, int c) {
        this.Row = r;
        this.Col = c;
    }


    public int getCol()
    {
        return Col; }
    public int getRow() {
        return Row;
    }
    public void setCol(int c){
        this.Col = c;
    }
    public void setRow(int r){
        this.Row = r;
    }
    public void printCoordinate(){
        System.out.print("{" + Row + "," + Col + "}");
    }

}
