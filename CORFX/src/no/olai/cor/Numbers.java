package no.olai.cor;

public class Numbers {

    private double n1;
    private double n2;
    private Operations op;

    public Numbers(double n1, double n2, Operations op) {
        this.n1 = n1;
        this.n2 = n2;
        this.op = op;
    }

    public double getN1() {
        return n1;
    }

    public double getN2() {
        return n2;
    }

    public Operations getOp() {
        return op;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                ", op=" + op +
                '}';
    }
}
