package doubleContest.round49;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/3
 */
public class B {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }

        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");

        if (arr1.length == arr2.length) {
            return false;
        }

        if (arr1.length < arr2.length) {

            for (int mid = -1; mid < arr1.length; mid++) {
                boolean isEqual = true;
                for (int i = 0; i <= mid; i++) {
                    if (!arr1[i].equals(arr2[i])) {
                        isEqual =false;
                        break;
                    }
                }

                if (isEqual) {

                    for (int i = arr1.length - 1; i > mid; i--) {
                        if (!arr1[i].equals(arr2[arr2.length - 1 - (arr1.length - 1 - i)])) {
                            isEqual = false;
                            break;
                        }
                    }

                    if (isEqual) {
                        return true;
                    }
                }
            }
        } else {

            for (int mid = -1; mid < arr2.length; mid++) {
                boolean isEqual = true;
                for (int i = 0; i <= mid; i++) {
                    if (!arr2[i].equals(arr1[i])) {
                        isEqual =false;
                        break;
                    }
                }

                if (isEqual) {

                    for (int i = arr2.length - 1; i > mid; i--) {
                        if (!arr2[i].equals(arr1[arr1.length - 1 - (arr2.length - 1 - i)])) {
                            isEqual = false;
                            break;
                        }
                    }

                    if (isEqual) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new B().areSentencesSimilar("My name is Haley", "My Haley"));
    }
}
