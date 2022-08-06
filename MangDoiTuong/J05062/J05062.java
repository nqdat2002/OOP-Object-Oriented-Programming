package OOPs.MangDoiTuong.J05062;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        List<Pupil> arr = new ArrayList<>();
        List<Pupil> arr1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine().trim().replaceAll("\\s+", " ");
            String[] tmp = sc.nextLine().trim().split("\\s+");
            double mediumScore = Double.parseDouble(tmp[0]);
            int trainingScore = Integer.parseInt(tmp[1]);
            Pupil pupil = new Pupil(name, mediumScore, trainingScore);
            arr.add(pupil);
            arr1.add(pupil);
        }
        arr1.sort((a, b) -> {
            double s1 = a.getMediumScore();
            double s2 = b.getMediumScore();
            return Double.compare(s1, s2) * -1;
        });
        double score = arr1.get(m - 1).getMediumScore();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i) + arr.get(i).getType(score));
        }
        sc.close();
    }
}

class Pupil {
    private String name;
    private double mediumScore;
    private int trainingScore;
    private String type;

    public Pupil(String name, double mediumScore, int trainingScore) {
        this.name = name;
        this.mediumScore = mediumScore;
        this.trainingScore = trainingScore;

    }

    public double getMediumScore() {
        return mediumScore;
    }

    public String getType(double score) {
        if (mediumScore < score)
            this.type = "KHONG";
        else {
            if (mediumScore >= 3.6 && trainingScore >= 90)
                this.type = "XUATSAC";
            else if (mediumScore >= 3.2 && trainingScore >= 80)
                this.type = "GIOI";
            else if (mediumScore >= 2.5 && trainingScore >= 70)
                this.type = "KHA";
            else
                this.type = "KHONG";
        }
        return this.type;
    }

    public String toString() {
        return name + ": ";
    }

}
