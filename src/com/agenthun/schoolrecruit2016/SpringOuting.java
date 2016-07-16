package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/7/16.
 * You class are planning for a spring outing. N people are voting for a destination out of K candidate places.
 * The voting progress is below:
 * First the class vote for the first candidate place.
 * If more than half of the class agreed on the place, the place is selected. The voting ends.
 * Otherwise they vote for the second candidate place.
 * If more than half of the class agreed on the place, the place is selected. The voting ends.
 * Otherwise they vote for the third candidate place in the same way and go on.
 * If no place is selected at last there will be no spring outing and everybody stays at home.
 * Before the voting, the Chief Entertainment Officer did a survey, found out every one's preference which can be represented as a permutation of 0, 1, ... K. (0 is for staying at home.) For example, when K=3, preference "1, 0, 2, 3" means that the first place is his first choice, staying at home is the second choice, the second place is the third choice and the third place is the last choice.
 * The Chief Entertainment Officer sends the survey results to the class. So everybody knows the others' preferences. Everybody wants his more prefered place to be selected. And they are very smart, they always choose the optimal strategy in the voting progress to achieve his goal.
 * Can you predict which place will be selected?
 * <p>
 * 输入描述:
 * The first line contains two integers, N and K, the number of people in your class and the number of candidate places.
 * The next N lines each contain a permutation of 0~K, representing someone's preference.
 * For 40% of the data, 1 <= N, K <= 10
 * For 100% of the data, 1 <= N, K <= 1000
 * <p>
 * 输出描述:
 * Output the selected place. Or "otaku" without quotes if no place is selected.
 * In the sample case, if the second peoson vote against the first place, no place would be selected finally because the first person must vote against the second place for his own interest. Considering staying at home is a worse choice than the first place, the second person's optimal strategy is voting for the first place. So the first place will be selected
 * <p>
 * 输入例子:
 * 2 2
 * 1 0 2
 * 2 1 0
 * <p>
 * 输出例子:
 * 1
 */
public class SpringOuting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] votes = new int[N][K + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < K + 1; j++) {
                    int index = scanner.nextInt();
                    votes[i][index] = j;
                }
            }

            int result = 0;
            for (int i = K; i > 0; i--) {
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if (votes[j][i] < votes[j][result]) {
                        count++;
                    }
                }
                if (count > N / 2) {
                    result = i;
                }
            }

            if (result == 0) {
                System.out.println("otaku");
            } else {
                System.out.println(result);
            }
        }
    }
}
