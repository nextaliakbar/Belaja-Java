public class ForEach {
    public static void main(String[] args) {
        String[] names = new String[]{
                "Ali","Akbar","Rafsanjani"
        };
//      Tanpa for each
        for(int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        System.out.println("==== For Each ====");
//      Dengan for each
        for(String name : names) {
            System.out.println(name);
        }
    }
}
