package stack;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class Simple_exercises_01 {


    public static void main(String[] args){
        Simple_exercises_01 exercises01 = new Simple_exercises_01();
        int[] nums = {2, 7, 11, 15} ;
        int target = 9 ;
        System.out.println(Arrays.toString(exercises01.twoSum(nums,target)));
    }


    public int[] twoSum(int[] nums, int target) {
       if(nums== null || nums.length <1 ) return null ;
       int[] indexs = new int[2] ;
        Map<Integer,Integer>  numIndexMap = new HashMap<>() ;
       for(int i = 0 ;i<nums.length;i++){
           int num1 =  nums[i] ;
           int num2 = target-num1 ;
           if(numIndexMap.get(num2)==null){
               numIndexMap.put(num1,i) ;
           }else {
               indexs[1] = i ;
               indexs[0] = numIndexMap.get(num2)  ;

           }

       }
       return indexs ;
    }

}
