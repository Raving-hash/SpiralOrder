import java.util.HashMap;
import java.util.Map;

class Solution {
    public Map<Integer,Integer> flags = new HashMap<>();
    int index = 0;
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        if(matrix.length == 1 ){
            return matrix[0];
        }
        int len = matrix.length;
        int len2 = matrix[0].length;
        int[] res = new int[len * len2];
        int flag = 0;
        boolean[][] dp = new boolean[len][len2];
        int m = 0;
        flags.put(0,1);flags.put(1,2);flags.put(2,3);flags.put(3,0);
        if(matrix[0].length == 1){
            for (int[] ints: matrix){
                for (int n:ints){
                    res[m] = n;
                    m++;
                }
            }
            return res;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i][j] = false;
            }
        }
        dfs(0,0,matrix,flag,dp,res);
        return res;
    }
    private int dfs(int i, int j, int[][] matrix, int flag, boolean[][] dp, int[] res){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || dp[i][j]){
            return flags.get(flag);
        }
        dp[i][j] = true;
        res[index] = matrix[i][j];
        index++;
        while(index != (matrix.length*matrix[0].length)) {
            switch (flag) {
                case 0:
                    flag = dfs(i, j + 1, matrix, flag, dp, res);
                    break;
                case 1:
                    flag = dfs(i + 1, j, matrix, flag, dp, res);
                    break;
                case 2:
                    flag = dfs(i, j - 1, matrix, flag, dp, res);
                    break;
                case 3:
                    flag = dfs(i - 1, j, matrix, flag, dp, res);
                    break;
                default:
                    break;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        Solution st = new Solution();
        int[][] n =new int[][]{{2,5},{8,4},{0,-1}};
        int[] ints = st.spiralOrder(n);
        for(int i : ints){
            System.out.print(i+",");
        }
    }
}