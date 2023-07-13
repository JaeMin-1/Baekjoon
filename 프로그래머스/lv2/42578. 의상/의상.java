import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1); // 각 종류별 옷 개수 + 1을 곱해줌
        }

        return answer - 1; // 아무것도 입지 않은 경우 1을 빼줌
    }
}
