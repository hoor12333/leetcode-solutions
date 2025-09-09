
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candi = new int[n];

        Arrays.fill(candi, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candi[i] = candi[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candi[i] <= candi[i + 1]) {
                candi[i] = candi[i + 1] + 1;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += candi[i];
        }

        return result;
    }
}


