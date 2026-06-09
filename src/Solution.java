import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    int[] leftMatch = {1, 4, 7, 10};
    int[] rightMatch = {3, 6, 9, 11};
    int[] centerMatch = {2, 5, 8, 0};
    public String soulution(int[] numbers, String useHand){
        //int[] numbers = {1,2,3,4,5};
        //String hand = "left";
        numbers = new int[]{1, 2, 3, 4, 5};
        useHand = "left"; //자주 사용하는 손
        /**
        int[][] leftMatch = {
                {1, 4, 7, 10},  // 0번째 행 (안쪽 배열 1)
                {2, 5, 8, 0}   // 1번째 행 (안쪽 배열 2)
        };
        int[][] rightMatch = {
                {3, 6, 9, 11},  // 0번째 행 (안쪽 배열 1)
                {2, 5, 8, 0}   // 1번째 행 (안쪽 배열 2)
        };
         */
        String clickedHand = "";



        int leftClicked = 10; // *이라 보면됨
        int rightClicked = 11; // #이라 보면됨

        for(int insNum : numbers){ //클릭중 이라고 보면됨
            if(this.matchFl(insNum, leftMatch)){
                leftClicked = insNum;
                clickedHand = "L";
            }else if(this.matchFl(insNum, rightMatch)){
                rightClicked = insNum;
                clickedHand = "R";
            }else{ //2580 일때만 왼손으로 클릭할지 오른손으로 할지 판단필요
                int leftStep = 0;
                int rightStep = 0;

                String leftFp = "";

                if(this.matchFl(leftClicked, leftMatch)){
//                    if(10 == leftClicked){
//                        lookRight = 0;
//                    }else{
//                        lookRight = leftClicked + 1;
//                    }


                }else if(this.matchFl(leftClicked, centerMatch)){

                }
            }
        }

        return "";
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

    public int moveStep(int leftClicked, int rightClicked, int insNumber, int[] ctMatch){

        //
        int leftStep = 0;
        int rightStep = 0;

        int lookRight = 0;
        if(this.matchFl(leftClicked, leftMatch)){
            if(10 == clickedNumber || 11 == clickedNumber){
                lookRight = 0;
            }else if("L".equals(from)){
                lookRight = clickedNumber + 1;
            }else if("R".equals(from)){
                lookRight = clickedNumber - 1;
            }

        }else if(this.matchFl(leftClicked, rightMatch)){

        }else if(this.matchFl(leftClicked, centerMatch)){

        }


        // int[] -> List<Integer> 변환
        List<Integer> ctList = Arrays.stream(ctMatch)
                .boxed()
                .collect(Collectors.toList());

        int currentIndex = ctList.indexOf(lookRight);//목표 인덱스
        int targetIndex = ctList.indexOf(insNumber); //타겟 인덱스

        int steps = Math.abs(targetIndex - currentIndex);

    }
}
