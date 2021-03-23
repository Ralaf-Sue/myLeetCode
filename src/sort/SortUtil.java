package sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author SuZuQi
 * @title: SortUtil
 * @projectName myLeetCode
 * @description: 关于排序的算法
 * @date 2021/3/22
 */
public class SortUtil {

    public static void main(String[] args) {
        int[] arr = {12, 3, 33, 3, 55, 24, 79, 03, 42, 29, 24};
//        bubbleSort(arr);
//        insertSort(arr);
//        chooseSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    //冒泡排序
    public static void bubbleSort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) return;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                //两两交换，总会把大的数据带到后面去
                int first = arr[j];
                int sencond = arr[j + 1];
                if (first > sencond) {
                    arr[j + 1] = first;
                    arr[j] = sencond;
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) return;
        int size = arr.length;
        //假设前面的数字都是正确的顺序
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                int temp = arr[j];
                if (arr[j] < arr[j - 1]) {
                    //将前面数往后挪，空出位置，后数插入
                    int k = arr[j - 1];
                    arr[j] = k;
                    arr[j - 1] = arr[j];

                } else {
                    break;
                }
            }

        }

    }


    //选择排序
    //选择排序，总是在选择后面的数中最小的，跟要排序的的数进行交换
    public static void chooseSort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) return;
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

    }

    //希尔排序
    //插入排序的变种，先逻辑分组，分组内进行调整
    public static void shellSort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) return;
        int size = arr.length;
        //确定每次的偏移量
        for (int i = size / 2; i > 0; i /= 2) {
            //对每个分组进行插入排序
            //获取每组的起始索引
            System.out.println(arr);
            for (int j = 0; j < i; j++) {
                //组内排序
                for (int h = j; h < size - i; h += i) {
                    for (int k = h + i; k > h; k -= i) {
                        if (arr[k-i] > arr[k]) {
                            int temp = arr[k];
                            arr[k] = arr[k-i];
                            arr[k-i] = temp;
                        }
                    }
                }

            }


        }
    }


}
