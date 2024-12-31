import java.io.*;

public class p1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[][] friends = new char[N][N];
        
        // 친구 관계 입력
        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine().toCharArray();
        }

        int maxTwoFriends = 0;

        // 각 사람의 2-친구 수 계산
        for (int i = 0; i < N; i++) {
            boolean[] isTwoFriend = new boolean[N]; // 2-친구 여부 확인
            for (int j = 0; j < N; j++) {
                if (i == j) continue; // 자기 자신 제외
                if (friends[i][j] == 'Y') {
                    // 직접 친구
                    isTwoFriend[j] = true;
                    // 친구의 친구
                    for (int k = 0; k < N; k++) {
                        if (friends[j][k] == 'Y' && k != i) {
                            isTwoFriend[k] = true;
                        }
                    }
                }
            }

            // 2-친구 수 세기
            int twoFriendCount = 0;
            for (boolean isFriend : isTwoFriend) {
                if (isFriend) {
                    twoFriendCount++;
                }
            }
            maxTwoFriends = Math.max(maxTwoFriends, twoFriendCount);
        }

        System.out.println(maxTwoFriends);
    }
}
