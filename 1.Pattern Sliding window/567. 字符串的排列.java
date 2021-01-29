class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
            滑窗思想
            2个字符串的排列 相等 -> 2个字符串 各个字符 的个数都一一相等。
        */
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2)
            return false;
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        // 也可改成单数组，相当于count2变为count1的减法操作
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int cur = len1;
        for (int i = 0; i < len1; i++) {
            count1[char1[i] - 'a']++;
        }
        for (int i = 0; i < len1; i++) {
            count2[char2[i] - 'a']++;
        }
        while (cur < char2.length) {
            if (isEquals(count1, count2)) {
                return true;
            }
            // cur 滑窗后移的最右端
            count2[char2[cur] - 'a']++;
            // cur - len1 滑窗右移淘汰的最左侧
            count2[char2[cur - len1] - 'a']--;
            cur++;
        }
        // return fasle; 错误：缺少s2最后一位计算数量后的最后一次判断。
        return isEquals(count1, count2);
    }

    private boolean isEquals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
}