class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null) return "";
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        int sLen = s.length();
        int tLen = t.length();
        for(int i = 0; i < tLen; i++)
            tMap[t.charAt(i)]++;
        int right = 0;
        String result = "";
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sLen - tLen; i++){
            while(right < sLen && !check(sMap, tMap)){
                sMap[s.charAt(right)]++;
                right++;
            }
            if(check(sMap, tMap) && min > right - i + 1){
                min = right - i + 1;
                result = s.substring(i, right);
            }
            sMap[s.charAt(i)]--;
        }
        return result;
    }
    private boolean check(int[] sMap, int[] tMap){
        for(int i = 0; i < sMap.length; i++){
            if(tMap[i] > sMap[i])
                return false;
        }
        return true;
    }
}