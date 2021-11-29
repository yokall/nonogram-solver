import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private final List<List<Integer>> columnCounts;
    private final List<List<Integer>> rowCounts;
    private List<List<Boolean>> cells;

    public List<List<Boolean>> getCells() {
        return cells;
    }

    public Board(List<List<Integer>> columnCounts, List<List<Integer>> rowCounts) {
        this.columnCounts = columnCounts;
        this.rowCounts = rowCounts;

        cells = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(null, null, null, null, null),
                        Arrays.asList(null, null, null, null, null),
                        Arrays.asList(null, null, null, null, null),
                        Arrays.asList(null, null, null, null, null),
                        Arrays.asList(null, null, null, null, null)
                )
        );
    }

    public String print() {
        StringBuilder output = new StringBuilder();

        String columnRowPadding = "      ";

        for (int i = 0; i < columnCounts.get(0).size(); i++) {
            output.append(columnRowPadding);

            for (List<Integer> columnCount : columnCounts) {
                output.append(printCount(columnCount.get(i)));
            }

            output.append("\n");
        }

        for (int i = 0; i < rowCounts.size(); i++) {
            for (Integer count : rowCounts.get(i)) {
                output.append(printCount(count)).append(" ");
            }

            output.append(printRow(cells.get(i)));

            output.append("\n");
        }

        return output.toString();
    }

    private String printCount(Integer count) {
        return count == null ? " " : count.toString();
    }

    private String printRow(List<Boolean> cellStates) {
        StringBuilder row = new StringBuilder();

        for (Boolean state :
                cellStates) {
            if (state == null) {
                row.append(" ");
            }
            else if (state) {
                row.append("#");
            }
            else {
                row.append("-");
            }
        }

        return row.toString();
    }

    public void solveBoard() {
        // foreach row
        for (int i = 0; i < cells.size(); i++) {
            List<Boolean> row = cells.get(i);

            solveLine(row, rowCounts.get(i));
        }

        // foreach column
        for (int x = 0; x < cells.get(0).size(); x++) {
            List<Boolean> column = new ArrayList<>();

            for (List<Boolean> row : cells) {
                column.add(row.get(x));
            }

            column = solveLine(column, columnCounts.get(x));

            for (int c = 0; c < column.size(); c++) {
                cells.get(c).set(x, column.get(c));
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
