import java.util.ArrayList;
import java.util.Random;

public class AIPlayer implements Player {

    Mark mark;

    AIPlayer(Mark mark) {  // ← outside makeChoice!
        this.mark = mark;
    }

    @Override
    public void makeChoice(Board board) {
        ArrayList<int[]> emptyCells = new ArrayList<>();

        // loop through board and find empty cells
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board.getMark(i,j) == Mark.EMPTY){
                    emptyCells.add(new int[]{i,j});
                }
            }
        }

        // pick random and place mark
        Random rand = new Random();
        int index = rand.nextInt(emptyCells.size());
        int[] cell = emptyCells.get(index);
        board.placeMark(cell[0],cell[1],mark);
    }

    public Mark getMark() { return mark; }
}