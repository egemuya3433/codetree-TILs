import java.util.*;
import java.io.*;
 
public class Main {
    static int n, r, c, size;
    static int[][] grid;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
 
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        r--; c--;
 
        size = grid[r][c];
 
        // 1) 폭탄 터뜨리기
        pop();
 
        // 2) 중력 적용하기 (아래에서 위로 올라오면서 채우기)
        int[][] tmp = new int[n][n];
        for(int col = 0 ; col < n ; col++) {
            int tmpRow = n - 1;
            for(int row = n - 1 ; row >= 0 ; row--) {
                if(grid[row][col] != 0) {
                    tmp[tmpRow][col] = grid[row][col];
                    tmpRow--;
                }
            }
        }
 
        // 3) 원본 배열로 다시 값 옮기기
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                grid[i][j] = tmp[i][j];
            }
        }
 
        print();
    }
 
    // 범위 내의 폭탄 터뜨리는 메소드
    private static void pop() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(inBombRange(i, j)) {
                    grid[i][j] = 0;
                }
            }
        }
    }
 
    private static boolean inBombRange(int x, int y) {
        return (x == r || y == c) &&
                Math.abs(x - r) + Math.abs(y - c) < size;
    }
 
    // 출력용 메소드
    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++)
                sb.append(grid[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}