package problems;

import java.util.Scanner;

public class clearDigits {

    boolean isNum(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        clearDigits c = new clearDigits();
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        sb.append(sc.nextLine());

        for (int i = 0; i < sb.length(); ++i) {
            if (c.isNum(sb.charAt(i))) {
                sb.deleteCharAt(i);
                --i;
                if (i >= 0) {
                    sb.deleteCharAt(i);
                    --i;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
