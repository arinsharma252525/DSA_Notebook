//Job Sequencing Problem
import java.util.*;
public class Question134 {
    static class Job {
        char job_id;
        int deadline;
        int profit;

        Job(char job_id, int deadline, int profit) {
            this.deadline = deadline;
            this.job_id = job_id;
            this.profit = profit;
        }
    }

    static void printJobScheduling(ArrayList<Job> arr) {
        int n = arr.size();

        Collections.sort(arr, (a, b) -> {
            return a.deadline - b.deadline;
        });

        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.profit - a.profit;
        });

        for (int i = n - 1; i >= 0; i--) {
            int slot_available;

            if (i == 0) {
                slot_available = arr.get(i).deadline;
            } else {
                slot_available = arr.get(i).deadline - arr.get(i - 1).deadline;
            }

            maxHeap.add(arr.get(i));

            while (slot_available > 0 && maxHeap.size() > 0) {
                Job job = maxHeap.remove();
                slot_available--;
                result.add(job);
            }
        }

        Collections.sort(result, (a, b) -> {
            return a.deadline - b.deadline;
        });

        for (Job job : result) {
            System.out.print(job.job_id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<Job>();

        arr.add(new Job('a', 4, 20));
        arr.add(new Job('b', 1, 10));
        arr.add(new Job('c', 1, 40));
        arr.add(new Job('d', 1, 30));
        

        System.out.println("Following is maximum profit sequence of jobs");
        printJobScheduling(arr);
    }
}
