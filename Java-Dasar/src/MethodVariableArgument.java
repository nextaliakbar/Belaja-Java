public class MethodVariableArgument {
    public static void main(String[] args) {
        sayCongrats1("Akbar", new int[]{80,80,80,80});
        sayCongrats2("Akbar", 60,70,80,90);
    }

//  Method dengan array
    static void sayCongrats1(String name, int[] values) {
        var total = 0;
        for(var value : values) {
            total+=value;
        }
        var finalValue = total / values.length;

        if(finalValue >= 75) {
            System.out.println("Selamat "+name+" anda lulus");
        } else {
            System.out.println("Maaf "+name+" anda tidak lulus");
        }
    }

//  Method dengan argument
static void sayCongrats2(String name, int...values) {
    var total = 0;
    for(var value : values) {
        total+=value;
    }
    var finalValue = total / values.length;

    if(finalValue >= 75) {
        System.out.println("Selamat "+name+" anda lulus");
    } else {
        System.out.println("Maaf "+name+" anda tidak lulus");
    }
}
}
