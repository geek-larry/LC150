class Solution {
    // 反向遍历
    public static int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int lengthOfLastWord = lengthOfLastWord(s);
        System.out.println(lengthOfLastWord);
    }
}
