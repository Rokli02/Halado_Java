package hu.me.iit.advjava;

public class Representation {
    private String[] args;

    public Representation(String[] args) {
        this.args = args;
    }

    public void printResult(int result) {
        System.out.println("Az összeg: "+ result);
    }

    public Operands getOperands() {
        return new Operands().setA(args[0]).setB(args[1]);
    }
}
