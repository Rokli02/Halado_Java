package hu.me.iit.advjava;

/**
 * Hello world!
 *
 */
public class App {
    public App() {}

    private static Integer getInt(String str, int order) {
        Integer rv = null;

        try {
            rv = Integer.valueOf(str);
        } catch (NumberFormatException nfe) {
            System.out.println(String.format("An error has occured:\n\tThe %d. parameter is not a number!", order));
        }

        return rv;
    }

    public static void main( String[] args )
    {
        Representation representation = new Representation(args);
        Operands operands = representation.getOperands();

        Integer a = getInt(operands.getA(), 1);
        Integer b = getInt(operands.getB(), 2);

        if(a != null && b != null) {
            representation.printResult(new Service().calculate(a, b));
        }

    }
}
