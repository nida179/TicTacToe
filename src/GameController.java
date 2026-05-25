public class GameController {
    Board board;
    HumanPlayer human;
    AIPlayer ai;
    Mark currentTurn;

    GameController() {
        board = new Board();
        human = new HumanPlayer(Mark.O);
        ai = new AIPlayer(Mark.X);
        currentTurn = Mark.O;
    }
    void switchTurn() {
        if(currentTurn == Mark.O){
            currentTurn = Mark.X;
        } else {
            currentTurn = Mark.O;
        }
    }
    boolean isGameOver() {
        return board.isDraw() || board.checkWinner() != Mark.EMPTY;
    }
    boolean handleHumanMove(int row, int col) {
        if(currentTurn == Mark.O) {
            boolean success = board.placeMark(row,col,human.getMark());
            if(success) {
                if(!isGameOver()) {
                    switchTurn();
                }
                return true;
            }
        }
        return false;
    }
    void makeAIMove() {
        ai.makeChoice(board);
        switchTurn();
    }
    void reset() {
        board.reset();
        currentTurn = Mark.O;
    }
}
