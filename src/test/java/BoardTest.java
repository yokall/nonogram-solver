import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Board tests")
class BoardTest {

    Board board;

    @BeforeEach
    void setUp() {
        List<List<Integer>> columnCounts = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(null, 3, 1),
                        Arrays.asList(1, 1, 1),
                        Arrays.asList(1, 1, 1),
                        Arrays.asList(1, 1, 1),
                        Arrays.asList(null, null, 5)
                )
        );

        List<List<Integer>> rowCounts = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(null, null, 5),
                        Arrays.asList(null, 1, 1),
                        Arrays.asList(null, null, 5),
                        Arrays.asList(null, null, 1),
                        Arrays.asList(null, null, 5)
                )
        );

        board = new Board(columnCounts, rowCounts);
    }

    @Nested
    @DisplayName("Tests for printing the board")
    class Print {

        @Test
        @DisplayName("Print a blank board")
        void blankCells() {
            String expected = "       111 \n      3111 \n      11115\n    5      \n  1 1      \n    5      \n    1      \n    5      \n";

            Assertions.assertEquals(expected, board.print());
        }

        @Test
        @DisplayName("Print a board with coloured cells")
        void colouredCells() {

            for (List<Boolean> row : board.getCells()) {
                for (int i = 0; i < row.size(); i++) {
                    row.set(i, true);
                }
            }

            String expected = "       111 \n      3111 \n      11115\n    5 #####\n  1 1 #####\n    5 #####\n    1 #####\n    5 #####\n";

            Assertions.assertEquals(expected, board.print());
        }

        @Test
        @DisplayName("Print a board with X'd cells")
        void xedCells() {

            for (List<Boolean> row : board.getCells()) {
                for (int i = 0; i < row.size(); i++) {
                    row.set(i, false);
                }
            }
            String expected = "       111 \n      3111 \n      11115\n    5 -----\n  1 1 -----\n    5 -----\n    1 -----\n    5 -----\n";

            Assertions.assertEquals(expected, board.print());
        }
    }

    @Nested
    @DisplayName("Tests for solving a line")
    class SolveLine {
        @Test
        @DisplayName("Full line")
        void fullLine() {
            List<Boolean> line = new ArrayList<>(Arrays.asList(null, null, null, null, null));
            List<Integer> counts = new ArrayList<>(Arrays.asList(null, null, 5));

            List<Boolean> actual = board.solveLine(line, counts);

            List<Boolean> expected = new ArrayList<>(Arrays.asList(true, true, true, true, true));

            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests for solving a board")
    class SolveBoard {
        @Test
        @DisplayName("Full row")
        void fullRow() {
            board.solveBoard();

            List<Boolean> expected = new ArrayList<>(Arrays.asList(true, true, true, true, true));

            // Rows 1, 3 and 5 should be full
            Assertions.assertEquals(expected, board.getCells().get(0));
            Assertions.assertEquals(expected, board.getCells().get(2));
            Assertions.assertEquals(expected, board.getCells().get(4));
        }

        @Test
        @DisplayName("Full column")
        void fullColumn() {
            board.solveBoard();

            // Column 5 should be full
            Assertions.assertEquals(true, board.getCells().get(0).get(4));
            Assertions.assertEquals(true, board.getCells().get(1).get(4));
            Assertions.assertEquals(true, board.getCells().get(2).get(4));
            Assertions.assertEquals(true, board.getCells().get(3).get(4));
            Assertions.assertEquals(true, board.getCells().get(4).get(4));
        }
    }
}