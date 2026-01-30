package design.lowleveldesign.chainofresponsibility;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel== LogProcessor.DEBUG) {
            System.out.println(message);
        }else{
            super.log(logLevel,message);
        }
    }
}
