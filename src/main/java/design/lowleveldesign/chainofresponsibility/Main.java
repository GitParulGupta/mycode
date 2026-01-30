package design.lowleveldesign.chainofresponsibility;

public class Main {

    public static void main(String[] args) {
        LogProcessor obj = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        obj.log(LogProcessor.DEBUG,"Debug Message...");
        obj.log(LogProcessor.ERROR,"Error Message...");
        obj.log(LogProcessor.INFO,"Info Message...");
        obj.log(4,"Warning");//not able to handle this as handler not present
    }
}
