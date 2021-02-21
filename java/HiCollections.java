import java.util.ArrayList;
import java.util.List;

public class HiCollections {
    public static void main(String[] agrs) {
        List<String> list = new ArrayList<>();
        list.add("apple"); // size=1
        list.add(null); // size=2
        list.add("pear"); // size=3
        String second = list.get(1); // null
        System.out.println(second);
    }
}

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[j] == target - nums[i]) {
//                     return new int[] { i, j };
//                 }
//             }
//         }
//         throw new IllegalArgumentException("No two sum solution");
//     }
// }
