import java.util.*;
import java.io.*;

public class ap328 {
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] wh = br.readLine().split(" ");
            int h = Integer.parseInt(wh[0]);
            int w = Integer.parseInt(wh[1]);
            
            // 패딩을 추가하여 외부에서 시작할 수 있도록 (h+2 x w+2)
            char[][] map = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }
            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }
            
            String keyLine = br.readLine();
            // 알파벳 a~z에 대한 보유 여부
            boolean[] hasKey = new boolean[26];
            if (!keyLine.equals("0")) {
                for (int i = 0; i < keyLine.length(); i++) {
                    hasKey[keyLine.charAt(i) - 'a'] = true;
                }
            }
            
            int answer = 0;
            boolean[][] visited = new boolean[h + 2][w + 2];
            
            // 아직 열지 못한 문들을 각 알파벳별로 저장할 리스트
            ArrayList<Point>[] doorList = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                doorList[i] = new ArrayList<>();
            }
            
            // BFS 시작: 외부 (0,0)에서 시작
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(0, 0));
            visited[0][0] = true;
            
            while (!q.isEmpty()) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    
                    if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2 || visited[nx][ny])
                        continue;
                    
                    char ch = map[nx][ny];
                    
                    // 벽은 진행 불가
                    if (ch == '*')
                        continue;
                    
                    visited[nx][ny] = true;
                    
                    // 문서 발견
                    if (ch == '$') {
                        answer++;
                    }
                    
                    // 열쇠 획득: 소문자이면
                    if (ch >= 'a' && ch <= 'z') {
                        int keyIndex = ch - 'a';
                        if (!hasKey[keyIndex]) {
                            hasKey[keyIndex] = true;
                            // 새 키 획득시 해당 문에 대해 대기 중인 좌표들을 모두 큐에 추가
                            for (Point p : doorList[keyIndex]) {
                                q.add(p);
                            }
                            doorList[keyIndex].clear();
                        }
                    }
                    
                    // 문 처리: 대문자이면
                    if (ch >= 'A' && ch <= 'Z') {
                        int doorIndex = ch - 'A';
                        // 키가 없으면 해당 좌표를 저장하고 진행 중단
                        if (!hasKey[doorIndex]) {
                            doorList[doorIndex].add(new Point(nx, ny));
                            continue;
                        }
                    }
                    
                    // 그 외의 경우 (빈 공간, 열쇠, 이미 열 수 있는 문 등) 계속 진행
                    q.add(new Point(nx, ny));
                }
            }
            System.out.println(answer);
        }
    }

    // 좌표를 표현하기 위한 간단한 클래스
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
