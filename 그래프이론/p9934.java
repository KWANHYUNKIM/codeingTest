import java.util.*;
import java.io.*;

public class p9934{
    static int K;
    static int[] inOrder;
    static ArrayList<Integer>[] levels;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        int nodeCount = (1 << K) - 1;

        inOrder = new int[nodeCount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< nodeCount; i++){
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        levels = new ArrayList[K + 1];
        for (int i = 1; i<=K; i++){
            levels[i] = new ArrayList<>();
        }

        buildTree(0, nodeCount -1, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=K; i++){
            for(int num : levels[i]){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void buildTree(int left, int right, int level){
        if(left > right){
            return;
        }

        int mid = (left + right) / 2;

        levels[level].add(inOrder[mid]);
        // 왼쪽구간 (왼쪽 서브트리)
        buildTree(left, mid-1, level + 1);
        // 오른쪽구간 (오른쪽 서브트리)
        buildTree(mid + 1, right, level + 1);
    }
}