package OOPs.VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07001 {
    public static void main(String [] args) throws FileNotFoundException{
        File f = new File("DATA.in");
        Scanner sc = new Scanner(f);
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(s);
        }
        sc.close();
    }
}
