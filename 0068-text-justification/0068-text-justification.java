
    import java.util.*;
    class Solution {
    public List<String> fullJustify(String[] words, int maxWidth)
 {
        List<String> res = new ArrayList<>();
        int i = 0, n = words.length;
        while (i < n) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < n && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            int numWords = j - i;
            // Last line or single word in a line
            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {
                int totalSpaces = maxWidth - (lineLen - (numWords - 1));
                int spaceBetween = totalSpaces / (numWords - 1);
                int extra = totalSpaces % (numWords - 1);
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spaceBetween; s++) sb.append(' ');
                        if (extra-- > 0) sb.append(' ');
                    }
                }
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }

        
    }
