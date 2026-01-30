package design.lowleveldesign.chainofresponsibility;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel== LogProcessor.INFO) {
            System.out.println(message);
        }else{
            super.log(logLevel,message);
        }
    }
}
