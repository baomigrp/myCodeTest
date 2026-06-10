
void main() throws IOException {
    Solution sl = new Solution();
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    String hand = "right";
    String clickedStr = sl.soulution(numbers, hand);
    System.out.println("입력손 => " + clickedStr);
}