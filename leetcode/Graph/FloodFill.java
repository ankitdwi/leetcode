package leetcode.Graph;

public class FloodFill {

    public static void floodFill(int[][] arr, int row, int col, String psf, boolean[][] visited) {

        if (row < 0 || col < 0 || row == arr.length || col == arr[0].length || arr[row][col] == 1 || visited[row][col]) {
            return;
        }

        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return;
        }

        visited[row][col] = true;
        floodFill(arr, row - 1, col, psf + "t", visited);
        floodFill(arr, row, col - 1, psf + "l", visited);
        floodFill(arr, row + 1, col, psf + "d", visited);
        floodFill(arr, row, col + 1, psf + "r", visited);
        visited[row][col] = false;
    }
}
