enum Mark { X, O, EMPTY }

public class Board {
    Mark[][] grid = new Mark[3][3];

    Board(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j] = Mark.EMPTY;
            }
        }
    }

    public Mark getMark(int row, int col) {
        return grid[row][col];
    }
    public boolean placeMark(int row, int col, Mark mark) {
        if(grid[row][col]==Mark.EMPTY){
            grid[row][col] = mark;
            return true;
        }
        else return false;
    }
    public void reset() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j] = Mark.EMPTY;
            }
        }
    }
    public boolean isDraw() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j] == Mark.EMPTY) return false;
            }
        }
        return true;
    }
    public Mark checkWinner() {
        // rows
        for(int i=0;i<3;i++){
            if(grid[i][0] == grid[i][1] &&
                    grid[i][1] == grid[i][2] &&
                    grid[i][0] != Mark.EMPTY){
                return grid[i][0];  // what do you return here?
            }
        }

        // cols
        for(int i=0;i<3;i++){
            if(grid[0][i] == grid[1][i] &&
                    grid[1][i] == grid[2][i] &&
                    grid[0][i] != Mark.EMPTY){
                return grid[0][i];  // which cell?
            }
        }

        // diagonal 1
        if(grid[0][0] == grid[1][1] &&
                grid[1][1] == grid[2][2] &&
                grid[0][0] != Mark.EMPTY){
            return grid[0][0];
        }
        // diagonal 2
        if(grid[0][2] == grid[1][1] &&
                grid[1][1] == grid[2][0] &&
                grid[1][1] != Mark.EMPTY){
            return grid[1][1];
        }
        return Mark.EMPTY;
    }
    int[][] getWinningCells() {
        // check rows
        for(int i=0; i<3; i++){
            if(grid[i][0] == grid[i][1] &&
                    grid[i][1] == grid[i][2] &&
                    grid[i][0] != Mark.EMPTY){
                return new int[][]{{i,0},{i,1},{i,2}};
            }
        }
        // you do cols and diagonals!
        for(int i=0;i<3;i++){
            if(grid[0][i] == grid[1][i] &&
            grid[1][i] == grid[2][i] && grid[0][i] != Mark.EMPTY){
                return new int[][]{{0,i},{1,i},{2,i}};
            }
        }
        if(grid[0][0] == grid[1][1] &&
                grid[1][1] == grid[2][2] &&
                grid[0][0] != Mark.EMPTY){
            return new int[][]{{0,0},{1,1},{2,2}};
        }
        if(grid[0][2] == grid[1][1] &&
                grid[1][1] == grid[2][0] &&
                grid[1][1] != Mark.EMPTY){
            return new int[][]{{0,2},{1,1},{2,0}};
        }
        return null;
    }
}
