package TrigonoChain;

public class Magic {
    TChain sinHandler;
    TChain cosHandler;
    TChain tanHandler;
    TChain defaultHandler;

    public Magic(){
        sinHandler = new SinHandler();
        cosHandler = new CosHandler();
        tanHandler = new TanHandler();
        defaultHandler = new DefaultHandler();

        sinHandler.setNext(cosHandler);
        cosHandler.setNext(tanHandler);
        tanHandler.setNext(defaultHandler);
    }
    public double startTChain(String expression){
        return sinHandler.handle(expression);
    }
}
