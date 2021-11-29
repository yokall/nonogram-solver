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
}