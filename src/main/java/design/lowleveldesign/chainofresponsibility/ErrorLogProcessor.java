package design.lowleveldesign.chainofresponsibility;

public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel== LogProcessor.ERROR) {
            System.out.println(message);
        }else{
            super.log(logLevel,message);
        }
    }
}
