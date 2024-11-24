import java.io.*;
import java.util.*;

public class Main {
    /** * Static method main
     * * @param args
     * * @throws FileNotFoundException
     * */
public static void main(String[] args) throws FileNotFoundException {
    int nRows;
    char[][] arr;
    String filler;
    Scanner in = new Scanner(System.in);
    File dataFile = new File("MyFile.txt");
    PrintWriter fout = new PrintWriter(dataFile);
    System.out.print("Введіть розмір квадратної матриці: ");
    nRows = in.nextInt();
    in.nextLine();
    arr = new char[nRows][];
    for (int i = 0; i<nRows/2;i++){
        arr[i] = new char[nRows-(2*i+1)];
    }
    arr[nRows/2] = new char[0];
    for (int i = nRows/2+1;i<nRows;i++){
        arr[i] = new char[(2*(i-nRows/2))];
    }
    System.out.print("\nВведіть символ-заповнювач: ");
    filler = in.nextLine();
    if (filler.length() == 1){
        for (int i = 0; i< arr.length; i++){
            int spaces = arr.length - arr[i].length;
            for(int j=0; j<arr[i].length/2;j++){
                System.out.print(filler);
                fout.print(filler);
            }
            System.out.print(" ".repeat(spaces));
            fout.print(" ".repeat(spaces));
            for (int j=arr[i].length/2;j<arr[i].length;j++){
                System.out.print(filler);
                fout.print(filler);
            }
            System.out.print("\n");
            fout.print("\n");
        }
    }
    else if (filler.isEmpty()) {
        System.out.print("\nНе введено символ");
    }
    else {
        System.out.print("Забагато символів");
    }
    System.out.print("\n");
    fout.print("\n");
    fout.flush();
    fout.close();
}
}