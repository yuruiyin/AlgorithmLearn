package problem1001_1100;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1073 {

    private int[] listToArr(List<Integer> list) {
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        List<Integer> ansList = new ArrayList<>();
        int maxLen = Math.max(len1, len2);

        int[] newArr1;
        int[] newArr2;
        if (len1 == len2) {
            newArr1 = arr1;
            newArr2 = arr2;
        } else if (len1 > len2) {
            newArr2 = new int[len1];
            int i;
            for (i = 0; i < len1 - len2; i++) {
                newArr2[i] = 0;
            }

            for (int j = 0; j < len2; j++) {
                newArr2[i+j] = arr2[j];
            }
            newArr1 = arr1;
        } else {
            newArr1 = new int[len2];
            int i;
            for (i = 0; i < len2 - len1; i++) {
                newArr1[i] = 0;
            }

            for (int j = 0; j < len1; j++) {
                newArr1[i+j] = arr1[j];
            }
            newArr2 = arr2;
        }

        int carry = 0;
        for (int i = maxLen - 1; i >= 0; i--) {
            int value = (newArr1[i] + newArr2[i] + carry) % 2;
            if (value < 0) {
                // 说明有进位，而且当前arr1[i] 和 arr2[i]都等于0, 那么就要往前进两位，但是是正的
                ansList.add(1);
                carry = 1;
                continue;
            }
            carry = - (newArr1[i] + newArr2[i] + carry) / 2;
            ansList.add(value);
        }

        if (carry == -1) {
            ansList.add(1);
            ansList.add(1);
        } else if (carry == 1) {
            ansList.add(1);
        } else {
            // 去除前导0
            int removeIndex = -1;
            for (int i = ansList.size() - 1; i >= 1; i--) {
                if (ansList.get(i) != 0) {
                    break;
                }

                removeIndex = i;
            }
            List<Integer> newList = new ArrayList<>();
            if (removeIndex != -1) {
                for (int i = 0; i < removeIndex; i++) {
                    newList.add(ansList.get(i));
                }
                ansList = newList;
            }

        }
        Collections.reverse(ansList);
        return listToArr(ansList);
    }

    public static void main(String[] args) {
        int[] ansArr = new Problem1073().addNegabinary(new int[]{1,1,1,1,1}, new int[]{1,0,1});
        PrintUtil.printIntArray(ansArr);

    }

}
