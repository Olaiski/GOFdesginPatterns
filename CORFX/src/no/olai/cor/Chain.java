package no.olai.cor;

public interface Chain {

    void setNextChain(Chain nextChain);
    double calculate(Numbers request);

}
