//Multidimensional Arraylist
import java.util.ArrayList;
public class Question82 {
    public static void printArraylist(ArrayList<ArrayList<Integer>> mainlist) {
        for (int i = 0; i < mainlist.size(); i++) {
            ArrayList<Integer> currentlist = mainlist.get(i);
            for (int j = 0; j < currentlist.size(); j++) {
                System.out.print(currentlist.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        ArrayList<Integer> nums3 = new ArrayList<>();
        ArrayList<Integer> nums4 = new ArrayList<>();
        ArrayList<Integer> nums5 = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            nums1.add(i * 1);
            nums2.add(i * 2);
            nums3.add(i * 3);
            nums4.add(i * 4);
            nums5.add(i * 5);
        }
        mainList.add(nums1);
        mainList.add(nums2);
        mainList.add(nums3);
        mainList.add(nums4);
        mainList.add(nums5);

        System.out.println(mainList);
        printArraylist(mainList);
    }
}
