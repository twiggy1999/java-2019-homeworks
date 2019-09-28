package ground;


public class Ground{
    public static int sizeOfTiles = 20;
    public static Tile[][] tiles = new Tile[sizeOfTiles][sizeOfTiles];
    {
        for (int i = 0; i < sizeOfTiles; i++){
            for(int j = 0; j < sizeOfTiles; j++){
                tiles[i][j] = new Tile(i, j);
            }
        }
    }

    private static void printName(Tile t){
        String name = String.format("%5s", t.life.getName());
        System.out.print(name);
    }

    public static void printToScreen(){
        for(int i = 0; i < sizeOfTiles; i++){
            for(int j = 0; j < sizeOfTiles; j++){
                printName(tiles[j][i]);
            }
            System.out.println();
        }
    }
}