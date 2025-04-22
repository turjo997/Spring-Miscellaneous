package problems;

public class ReverseStringRecursively {
    public static void reversePrint(String str) {
        // Base case: if string is empty or null
        if (str == null || str.length() == 0) {
            return;
        }

        // Recursive call on the substring excluding the first character
        reversePrint(str.substring(1));

        // Print the first character after the recursive call
        System.out.print(str.charAt(0));
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.print("Reversed: ");
        reversePrint(input);  // Output: olleh
    }
}
