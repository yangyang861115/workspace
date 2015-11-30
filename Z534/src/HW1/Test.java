package HW1;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "sdfaslj&dsf  &dfsa";
        if(s.contains("&")){
            s = s.replaceAll("&", "&amp;");
        }
        System.out.println(s);
    }

}
