package no.olai.cor;

public class SubtractNumbers implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public double calculate(Numbers request) {
        if (request.getOp().equals(Operations.SUB)) {
            return (request.getN1() - request.getN2());
        }
        else
            return nextInChain.calculate(request);

    }
}
