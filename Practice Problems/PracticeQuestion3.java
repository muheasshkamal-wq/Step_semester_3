import java.util.HashSet;

public class CategoryBQuestion3 {

    // Approach 1: Brute Force
    static boolean bruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // Approach 2: HashSet
    static boolean usingSet(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(target - num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(bruteForce(nums, target));
        System.out.println(usingSet(nums, target));
    }
}
