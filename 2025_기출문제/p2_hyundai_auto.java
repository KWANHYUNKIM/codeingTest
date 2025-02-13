import java.util.Scanner;

public class p2_hyundai_auto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력: 과녁 크기 N, 화살 개수 K, 목표 점수 P
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                board[i][j] = sc.nextInt();
            }
        }
        
        int[] thickness = new int[K];
        boolean hasTh1 = false; // 두께 1인 화살이 있는지 체크
        for (int i = 0; i < K; i++){
            thickness[i] = sc.nextInt();
            if(thickness[i] == 1) {
                hasTh1 = true;
            }
        }
        
        // 모든 후보 셀 (i,j)에 대해 "모든 화살이 맞았을 때" 총 점수를 계산
        // 조건: 만약 모든 화살의 두께가 1보다 크다면, 
        // 해당 화살의 영향을 받는 영역(S_t(i,j))이 "완전"하게 과녁 내부에 있어야 한다.
        boolean found = false;
        outer:
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                int totalScore = 0;
                boolean validCandidate = true; // 이 후보 (i,j)를 채택할 수 있는지 여부
                
                // 각 화살마다 점수를 구함
                for (int a = 0; a < K; a++){
                    int t = thickness[a];
                    int arrowScore = 0;
                    
                    // 영역을 구하기 위해 offset 범위: dx, dy ∈ [-(t-1), t-1]
                    // 단, 조건 |dx| + |dy| < t 인 경우에 포함됨.
                    for (int dx = -(t-1); dx <= (t-1); dx++){
                        for (int dy = -(t-1); dy <= (t-1); dy++){
                            if (Math.abs(dx) + Math.abs(dy) < t) {
                                int x = i + dx;
                                int y = j + dy;
                                // (x,y)가 과녁 내에 있는지 여부
                                if (x >= 0 && x < N && y >= 0 && y < N) {
                                    arrowScore += board[x][y];
                                } else {
                                    // 만약 두께가 t>1인 화살인데
                                    // 모든 화살의 두께가 1보다 큰 경우라면 "완전한 영역"이 요구됨.
                                    if (t > 1 && !hasTh1) {
                                        validCandidate = false;
                                        break;
                                    }
                                    // 만약 이미 두께 1인 화살이 있다면, "부분 합산"을 허용하므로
                                    // 단순히 해당 좌표는 점수에 포함되지 않고 넘어감.
                                }
                            }
                        }
                        if (!validCandidate) break;
                    }
                    
                    if (!validCandidate) break; // 이 화살에서 영역 완전성이 충족되지 않으면 후보 무효.
                    
                    totalScore += arrowScore;
                }
                
                // 후보 (i,j)가 유효하고, 총 점수가 목표 P와 같으면 해당 과녁 칸의 숫자를 출력.
                if (validCandidate && totalScore == P) {
                    System.out.println(board[i][j]);
                    found = true;
                    break outer;
                }
            }
        }
        
        if (!found) {
            System.out.println(-1);
        }
        
        sc.close();
    }
}
