package controller.function;

import controller.function.handler.CosHandler;
import controller.function.handler.DefaultHandler;
import controller.function.handler.SinHandler;
import controller.function.handler.TanHandler;

public class FChain {
    IFunction sinHandler;
    IFunction cosHandler;
    IFunction tanHandler;
    IFunction defaultHandler;

    public FChain(){
        sinHandler = new SinHandler();
        cosHandler = new CosHandler();
        tanHandler = new TanHandler();
        defaultHandler = new DefaultHandler();
        sinHandler.setNext(cosHandler);
        cosHandler.setNext(tanHandler);
        tanHandler.setNext(defaultHandler);
    }

      public double startTChain(String functionName,String value){

        return sinHandler.handle(functionName,value);
    }
}
