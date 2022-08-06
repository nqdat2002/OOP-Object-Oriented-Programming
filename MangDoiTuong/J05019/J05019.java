package OOPs.MangDoiTuong.J05019;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class J05019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Raining> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i)
            list.add(Raining.nextRaining(sc, i));
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (list.get(i).getAddress().compareTo(list.get(j).getAddress()) == 0
                && list.get(i).getVisited() == false && list.get(j).getVisited() == false) {
                    list.get(i).setTotalAmount(list.get(j).getAmount());
                    list.get(i).setTotalMinute(list.get(j).getMinute());
                    list.get(j).setVisited(true);
                }
            }
        }
        for (Raining rain : list) {
            if (rain.getVisited() == false) {
                System.out.println(rain);
            }
        }
        sc.close();
    }
}

class Raining {
    private String address, time_start, time_end, code;
    private int minute, amount;
    private boolean visited;

    public Raining() {
        this.address = this.time_end = this.time_start = "";
        this.minute = this.amount = 0;
        this.visited = false;
    }

    public Raining(String address, String time_start, String time_end, int amount, int cnt) {
        this.code = "T" + (cnt < 10 ? ("0" + cnt) : cnt);
        this.address = address;
        this.amount = amount;
        this.time_start = time_start;
        this.time_end = time_end;
        this.visited = false;
        setMinute();
    }

    public void setMinute() {
        DateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        long getDiff = 0;
        try {
            String startDate = getTimeStart();
            String endDate = getTimeEnd();
            Date date1 = (Date) simpleDateFormat.parse(startDate);
            Date date2 = (Date) simpleDateFormat.parse(endDate);
            getDiff = (long) (date2.getTime() - date1.getTime());
            getDiff /= (long) (60 * 1000);
            this.minute = (int) (getDiff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTotalAmount(int sum1) {
        this.amount += sum1;
    }

    public void setTotalMinute(int sum2) {
        this.minute += sum2;
    }

    public void setVisited(boolean vs) {
        this.visited = vs;
    }

    public String getTimeStart() {
        return time_start;
    }

    public String getTimeEnd() {
        return time_end;
    }

    public String getAddress() {
        return address;
    }

    public int getMinute() {
        return minute;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getVisited() {
        return visited;
    }

    public static Raining nextRaining(Scanner sc, int cnt) {
        return new Raining(sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()), cnt);
    }

    @Override
    public String toString() {
        return code + " " + address + " " + String.format("%.2f", (double) getAmount() * 60 / getMinute());
    }
}