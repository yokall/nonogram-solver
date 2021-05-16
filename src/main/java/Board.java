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

//    public void setCells(List<List<Boolean>> cells) {
//        this.cells = cells;
//    }

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
                output.append(printColumnCount(columnCount.get(i)));
            }

            output.append("\n");
        }

        for (int i = 0; i < rowCounts.size(); i++) {
            for (Integer count : rowCounts.get(i)) {
                output.append(printRowCount(count)).append(" ");
            }

            output.append(printRow(cells.get(i)));

            output.append("\n");
        }

        return output.toString();
    }

    private String printColumnCount(Integer count) {
        if (count == null) {
            return "   ";
        }

        return String.format(" %d ", count);
    }

    private String printRowCount(Integer count) {
        return count == null ? " " : count.toString();
    }

    private String printRow(List<Boolean> cellStates) {
        StringBuilder row = new StringBuilder();

        for (Boolean state :
                cellStates) {
            if (state == null) {
                row.append("[ ]");
            }
            else if (state) {
                row.append("[█]");
            }
            else {
                row.append("[x]");
            }
        }

        return row.toString();
    }
}
