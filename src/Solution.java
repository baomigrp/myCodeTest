import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    int[] leftMatch = {1, 4, 7, 10};
    int[] rightMatch = {3, 6, 9, 11};
    int[] centerMatch = {2, 5, 8, 0};

    String clickedHand = "";
    int leftClicked = 10; // *이라 보면됨
    int rightClicked = 11; // #이라 보면됨

    public String soulution(int[] numbers, String useHand){


        String clickedStr = "";

        for(int insNum : numbers){ //클릭중 이라고 보면됨
            if(this.matchFl(insNum, leftMatch)){
                leftClicked = insNum;
                clickedHand = "L";
            }else if(this.matchFl(insNum, rightMatch)){
                rightClicked = insNum;
                clickedHand = "R";
            }else{ //2580 일때만 왼손으로 클릭할지 오른손으로 할지 판단필요
                moveStep(leftClicked, rightClicked, insNum, useHand);
            }
            clickedStr += clickedHand;
        }

        return clickedStr;
    }

    // 입력한 값이 어디에 속하는지
    public boolean matchFl(int insNum, int[] checkArr){
        boolean matchFl = false;
        for(int i : checkArr){
            if(insNum == i){
                matchFl = true;
                break;
            }
        }
        return matchFl;
    }

    public void moveStep(int leftClicked, int rightClicked, int insNumber, String useHand){

        int leftStep = 0;
        int rightStep = 0;

        int lookRight = 0;
        int lookLeft = 0;

        //왼쪽 스텝계산
        if(this.matchFl(leftClicked, leftMatch)){
            if(10 == leftClicked || 11 == leftClicked){
                lookRight = 0;
            }else{
                lookRight = leftClicked + 1;
            }
            leftStep++;
        }else{
            lookRight = leftClicked;
        }

        if(true){
            List<Integer> ctList = Arrays.stream(centerMatch)
                    .boxed()
                    .collect(Collectors.toList());

            int currentIndex = ctList.indexOf(lookRight);//목표 인덱스
            int targetIndex = ctList.indexOf(insNumber); //타겟 인덱스

            int steps = Math.abs(targetIndex - currentIndex);
            leftStep += steps;
        }


        //오른쪽 스텝계산
        if(this.matchFl(rightClicked, rightMatch)){
            if(10 == rightClicked || 11 == rightClicked){
                lookLeft = 0;
            }else{
                lookLeft = rightClicked - 1;
            }
            rightStep++;
        }else{
            lookLeft = rightClicked;
        }

        if(true){
            // int[] -> List<Integer> 변환
            List<Integer> ctList = Arrays.stream(centerMatch)
                    .boxed()
                    .collect(Collectors.toList());

            int currentIndex = ctList.indexOf(lookLeft);//목표 인덱스
            int targetIndex = ctList.indexOf(insNumber); //타겟 인덱스

            int steps = Math.abs(targetIndex - currentIndex);
            rightStep += steps;
        }

        if(leftStep > rightStep){
            this.clickedHand = "R";
            this.rightClicked = insNumber;
        }else if(leftStep < rightStep){
            this.leftClicked = insNumber;
            this.clickedHand = "L";
        }else if(leftStep == rightStep){
            if(useHand == "left"){
                this.clickedHand = "L";
                this.leftClicked = insNumber;
            }else{
                this.clickedHand = "R";
                this.rightClicked = insNumber;
            }
        }
    }
}
