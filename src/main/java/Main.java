import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> columnCounts = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(null, 3, 1),
                        Arrays.asList(1, 1, 1),
                        Arrays.asList(1, 1, 1),
                        Arrays.asList(1, 1, 1),
                        Arrays.asList(null, 1, 3)
                )
        );

        List<List<Integer>> rowCounts = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(null, null, 5),
                        Arrays.asList(null, null, 5),
                        Arrays.asList(null, null, 5),
                        Arrays.asList(null, null, 5),
                        Arrays.asList(null, null, 5)
                )
        );

        Board board = new Board(columnCounts, rowCounts);

        System.out.println(board.print());
    }
}