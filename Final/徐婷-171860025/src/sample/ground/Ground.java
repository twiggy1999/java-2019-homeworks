package sample.ground;

import sample.Config;
import sample.creatures.*;
import sample.position.Position;

public class Ground {
    private final int N = 15;
    private final int M = 9;
    private Cell[][]cells;
    private GoodTeam goods;
    private BadTeam bads;
    public Ground(GoodTeam goods, BadTeam bads){
        this.goods = goods;
        this.bads = bads;
        cells = new Cell[N][M];
        for(int i = 0;i<N;i++){
            for(int j =0 ; j<M;j++){
                cells[i][j] = new Cell();
            }
        }
        for(Good good: goods.getTeamMember()){
            int x = good.getX();
            int y = good.getY();
            cells[x][y].setCreature(good);
        }
        for(Bad bad: bads.getTeamMember()){
            int x = bad.getX();
            int y = bad.getY();
            cells[x][y].setCreature(bad);
        }
    }

    public void moveTo(Creature creature, Position from , Position to){
        int x= from.getX();
        int y = from.getY();
        int toX = to.getX();
        int toY = to.getY();
        cells[x][y].setCreature(null);
        cells[toX][toY].setCreature(creature);
    }

    public void update(){
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++)
                cells[i][j].setCreature(null);
        }
        for(Good good: goods.getTeamMember()){
            int x = good.getX();
            int y = good.getY();
            Cell c = cells[x][y];
            c.setCreature(good);
        }
        for(Bad bad: bads.getTeamMember()){
            cells[bad.getX()][bad.getY()].setCreature(bad);
        }
    }
    public Creature findEnemy(Creature creature){
        int x  = creature.getX();
        int y = creature.getY();
        int dir[]={-1, 1};
        for(int i = 0;i< 2;i++){
            int j = y+dir[i];
            if(j>=0&&j<M&&creature instanceof Good && cells[x][j].getLiveCreature() instanceof Bad)
                return cells[x][j].getCreature();
            if(j>=0&&j<M&&creature instanceof Bad && cells[x][j].getLiveCreature() instanceof Good)
                return cells[x][j].getCreature();
        }
        for(int i = 0;i< 2;i++){
            int j = x+dir[i];
            if(j>=0&&j<N&&creature instanceof Good && cells[j][y].getLiveCreature() instanceof Bad)
                return cells[j][y].getCreature();
            if(j>=0&&j<N&&creature instanceof Bad && cells[j][y].getLiveCreature() instanceof Good)
                return cells[j][y].getCreature();
        }
        return null;
    }

    public Position findNearestEnemy(Creature creature){
        int x = creature.getX();
        int y = creature.getY();
        int min = N;
        Position ret = null;
        for(int i = 0; i< N;i++){
            for(int j = 0;j<M;j++){
                if(i==x&&j==y)continue;
                int tmp = Math.min(Math.abs(x-i), Math.abs(y-j));
                if(tmp < min ){
                    /** RTTI*/
                    if(creature instanceof Bad && cells[i][j].getLiveCreature() instanceof Good)
                        ret = cells[i][j].getCreature().getPos();
                    else if(creature instanceof Good && cells[i][j].getLiveCreature() instanceof Bad){
                        ret = cells[i][j].getCreature().getPos();
                    }
                }
            }
        }
        return ret;
    }

    public Creature getCreature(int i, int j){
        return cells[i][j].getCreature();
    }
    public void print(){
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                Creature c = cells[i][j].getCreature();
                if(c==null)System.out.print("  ");
                else System.out.println(c.name);
            }
            System.out.println();
        }
    }
}
