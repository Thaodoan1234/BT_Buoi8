import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[][] a = inputMatrix();
        printMatrix(a);

 /**Bài 1: tìm số trong ma trận */

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần tìm trong ma trận: ");
        int n = sc.nextInt();
        findNumber(a,n);

 /**Bài 2: Ma trận số nguyên tố */

        if(checkPrime(a)) {
            System.out.println("\nĐây là ma trận số nguyên tố");
        }
        else
        {
            System.out.println("\nĐây không là ma trận số nguyên tố");
        }

 /**Bài 3: Tìm số lớn nhất trong ma trận */

        int max = maxMatrix(a);
        System.out.format("Số lớn nhất trong ma trận là: %d ", max);

/**Bài 4
 * a: tính tổng dòng d, cột c của ma trận
 * b: Tổng đường chéo chính, đường chéo phụ của ma trận vuông
 * c: nửa trên đường chéo chính/phụ của ma trận vuông
 * d: nửa trên đường chéo chính/phụ của ma trận vuông
 * */
       sumRow(a);
       sumColum(a);

    }

    //nhập ma trận
    public static int[][] inputMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số dòng: ");
        int r = sc.nextInt();

        System.out.print("Số cột: ");
        int c =sc.nextInt();

        int[][] ret = new int[r][c];

        for (int i=0; i<r; i++) {
            for (int j=0; j<c;j++) {
                System.out.format("a[%d][%d] = ", i,j);
                ret[i][j] = sc.nextInt();
            }
        }
        return ret;
    }


    //in ma trận
    public static void printMatrix(int[][] a) {
        //       int r = a.length;
        //       int c = a[0].length;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                System.out.format("%d   ", a[i][j]); //tạo chuỗi gồm 5 ký tự căn đều mảng -5 canh trái , 5 căn phải
            }
            System.out.println();
        }
    }

    //Tìm 1 số trong ma trận
    public static boolean findNumber(int[][] a, int find) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (a[i][j] == find) {
                    System.out.format("có số %d cần tìm trong ma trận ", find);
                    System.out.format("ở vị trí hàng %d và cột %d", i+1,j+1);
                    return false;
                }
            }
        }
        return true;
    }

    //kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        boolean num = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                num = false;
                break;
            }
        }
        return num;
    }

    //Kiểm tra ma trận SNT
    public static boolean checkPrime(int[][] a) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (!isPrime(a[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    //tính tổng các số
    public static int sumElements(int[][] a) {
        int s = 0;
        for (int i = 0, r = a.length; i<r; i++) {
            for (int j = 0, c = a[0].length; j<r; j++) {
                s += a[i][j];
            }
        }
        return s;
    }

    //Tìm số lớn nhất trong ma trận
    public static int maxMatrix(int[][] a) {
        int max = a[0][0];
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                }
            }
        }
        return max;
    }

    //Tổng các số trong 1 hàng bất kỳ
    public static int sumRow(int[][] a) {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập hàng cần tính tổng (số hàng bắt đầu từ 0): ");
        int d = sc.nextInt();
        int sumr = 0;
        if(d>=0 && d<a.length) {
            int i = d;
            for (int j = 0, c = a[0].length; j<c; j++) {
                sumr += a[i][j];
            }
            System.out.format("Tổng các số trong hàng %d của mảng là: %d\n", d, sumr);
        }
        else {
            System.out.println("\nSố hàng bạn nhập không tồn tại");
        }
        return sumr;
    }

    //Tổng các số trong 1 cột bất kỳ
    public static int sumColum(int[][] a) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập cột cần tính tổng (số cột bắt đầu từ 0): ");
        int c = sc.nextInt();
        int sumc = 0;
        if(c>=0 && c<a.length) {
            int j = c;
            for (int i = 0, r = a[0].length; j<r; j++) {
                sumc += a[i][j];
            }
            System.out.format("\nTổng các số trong cột %d của mảng là: %d", c, sumc);
        }
        else {
            System.out.println("\nSố cột bạn nhập không tồn tại");
        }
        return sumc;
    }

}
