package problems;

public class StringOperations {
    public static void main(String[] args) {
        String s = "    Java Programming   ";
        System.out.println(s.trim());
        System.out.println(s.trim().toUpperCase());
        System.out.println(s.trim().substring(2,7));
        System.out.println(s.trim().subSequence(2,7));
        System.out.println(s.trim().contains("Java"));
        System.out.println(s.trim().replace("Java" , "Python"));
        System.out.println(new StringBuilder(s.trim()).reverse().toString());
        System.out.println(s.trim().isEmpty());
        System.out.println(s.trim().isBlank());
        s += "Language";
        System.out.println(s);

        System.out.println("---------------String Builder -----------------");
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");
        System.out.println(sb.toString());
        sb.insert(4 , " Language");
        System.out.println(sb.toString());
        System.out.println(sb.replace(0 , 4 , "Python"));
        System.out.println(sb.delete(4, 9));
        System.out.println(sb.reverse().toString());

    }
}
