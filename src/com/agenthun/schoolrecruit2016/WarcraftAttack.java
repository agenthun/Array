package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/14.
 * 赫柏在绝域之门击败鲁卡斯后，从鲁卡斯身上掉落了一本高级技能书，赫柏打开后惊喜地发现这是一个早已失传的上古技能---禁忌雷炎。
 * 该技能每次发动只需扣很少的精神值，而且输出也非常高。
 * 具体魔法描述如下：
 * 把地图抽象为一个二维坐标，技能发动者位于(0,0)位置。以技能发动者为中心，做一个半径为r的圆，满足r^2=S，如果敌人位于这个圆上，且位置为整点坐标，这个敌人将收到该技能的输出伤害。。
 * 例如当S=25时，将有12个敌人受到该技能的输出伤害，如下图所示：
 * 更厉害的是，禁忌雷炎可以通过改变魔法输入来控制S的大小，因此数学好的魔法师可以通过该技能攻击到更多的敌人。
 * 赫柏想将这个技能学会并成为自己的主技能，可数学是他的硬伤，所以他请求你为他写一个程序，帮帮他吧，没准他就把禁忌雷炎与你分享了 : )
 * 输入描述:
 * 多组测试数据，请处理到文件结束。
 * 对于每组测试数据，只包含一个整数S。
 * 保证：
 * 1<=S<=2,000,000,000。
 * 输出描述:
 * 输出一个整数，代表受到禁忌雷炎伤害的敌人数量。
 * 输入例子:
 * 25
 * 3
 * 输出例子:
 * 12
 * 0
 */
public class WarcraftAttack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int s = scanner.nextInt();

            double r = Math.sqrt(s);
            int count = 0;
            for (int i = 1; i < (int) r + 1; i++) {
                double j = Math.sqrt(s - Math.pow(i, 2));
                if (j <= r && j == (int) j) {
                    count++;
                }
            }
            System.out.println(4 * count);
        }
    }
}
