package OOPs.KhaiBaoLopvaDoiTuong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J07058 {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner ip = new Scanner(System.in);
		File file =  new File("MONHOC.in");
		Scanner ip = new Scanner (file);
		String x = ip.nextLine();
        int n = Integer.valueOf(x);
		x.isEmpty();
		List<MonThi> M = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			M.add(MonThi.nextMonThi(ip));
		}
		Collections.sort(M, new Comparator<MonThi>() {
			@Override
			public int compare(MonThi o1, MonThi o2) {
				return o1.getCode().compareTo(o2.getCode());
			}
		});
		for (MonThi s : M) {
			s.Show();
		}
		ip.close();
	}
}
class MonThi {
	private String code, name, content;

	public MonThi() {
		this.code = this.name = this.content = "";
	}

	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getContent() {
		return content;
	}

	public MonThi(String code, String name, String content) {
		this.code = code;
		this.name = name;
		this.content = content;
	}

	public static MonThi nextMonThi(Scanner sc) {
		MonThi x = new MonThi();
		x.code = sc.nextLine();
		x.name = sc.nextLine();
		x.content = sc.nextLine();
		return x;
	}

	public void Show() {
		System.out.println(this.code + " " + this.name + " " + this.content);
	}
}