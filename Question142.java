//Job Sequencing problem
import java.util.*;
public class Question142 {
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (object1, object2) -> object2.profit - object1.profit); // descending order

        ArrayList<Integer> sequence = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                sequence.add(curr.id);
                time++;
            }
        }
        System.out.println("Maximum jobs: " + sequence.size());
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + " ");
        }
        System.out.println();
    }
}
