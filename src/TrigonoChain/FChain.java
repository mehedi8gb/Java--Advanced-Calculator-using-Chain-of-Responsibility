package TrigonoChain;

import controller.IChain;

public class FChain {
    TChain sinHandler;
    TChain cosHandler;
    TChain tanHandler;
    TChain defaultHandler;

    IChain nextInIChain;

    public FChain(IChain nextInIChain){
        sinHandler = new SinHandler();
        cosHandler = new CosHandler();
        tanHandler = new TanHandler();
        defaultHandler = new DefaultHandler();
        this.nextInIChain = nextInIChain;
        sinHandler.setNext(cosHandler, this.nextInIChain);
        cosHandler.setNext(tanHandler, this.nextInIChain);
        tanHandler.setNext(defaultHandler, this.nextInIChain);
    }

      public double startTChain(String functionName,String value){

        return sinHandler.handle(functionName,value);
    }
}
