import java.util.ArrayList;
import java.util.List;

public class BoardSolver {
    private final Board board;

    public BoardSolver(Board board) {
        this.board = board;
    }

    public void solveBoard() {
        // foreach row
        for (int i = 0; i < board.getCells().size(); i++) {
            List<Boolean> row = board.getCells().get(i);

            solveLine(row, board.getRowCounts().get(i));
        }

        // foreach column
        for (int x = 0; x < board.getCells().get(0).size(); x++) {
            List<Boolean> column = new ArrayList<>();

            for (List<Boolean> row : board.getCells()) {
                column.add(row.get(x));
            }

            column = solveLine(column, board.getColumnCounts().get(x));

            for (int c = 0; c < column.size(); c++) {
                board.getCells().get(c).set(x, column.get(c));
            }
        }
    }

    public List<Boolean> solveLine(List<Boolean> line, List<Integer> counts) {
        for (Integer count :
                counts) {
            if (count != null && count == line.size()) {
                for (int i = 0; i < line.size(); i++) {
                    line.set(i, true);
                }
            }
        }

        return line;
    }
}
