import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArithmeticSubarrays {

    public static boolean isArthimetic(List<Integer> input){
        Collections.sort(input);
        int diff = input.get(1)-input.get(0);

        for (int i=2; i<input.size(); i++){
            int rem = input.get(i)-input.get(i-1);
            if (rem != diff){
                return false;
            }
        }
        return true;
    }

    public static List<Boolean> checkSubArrays(int[] nums, int[] l, int[] r){
        List<Boolean> out = new ArrayList<>();
        List<Integer> input = new ArrayList<>();

        for (int i=0; i<l.length; i++){
            if (l[i] == r[i]) {
                out.add(false);
                continue;
            }
            for (int k=l[i]; k<=r[i]; k++){
                input.add(nums[k]);
            }
            if (isArthimetic(input)){
                out.add(true);
            }else {
                out.add(false);
            }

            input = new ArrayList<>();
        }
        return out;
    }
    public static void main(String[] args) {
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        System.out.println(checkSubArrays(nums, l , r));
    }
}
