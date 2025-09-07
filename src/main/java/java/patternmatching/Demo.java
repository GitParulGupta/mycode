package java.patternmatching;

/**
 * Pattern matching for a switch in Java is a powerful feature that was introduced in Java 14.
 * Before this update, a switch expression could only be used to match the type of a value, rather than its actual value.
 * However, by comparing the model, developers can now match the values of Strings, enums, and records,
 * which makes it much easier to write short and readable code.
 */
public class Demo {

    public static void main(String[] args) {
        Demo obj = new Demo();

        obj.traditionalInstanceOf();
        obj.patternMatchingWithInstanceOf();

        //switchStatement
        obj.traditionalSwitchStatement();
        obj.newSwitchStatementWithArrow();

        obj.switchExpressionWithColon();
        obj.switchExpressionWithArrow();
    }

    public void traditionalInstanceOf(){
        System.out.println("traditionalInstanceOf");
        Object obj = "Demo";

        if(obj instanceof String){
            String str = (String) obj;
            System.out.println("Object i of typeString: "+str);
        }
    }
    public void patternMatchingWithInstanceOf(){
        System.out.println("patternMatchingWithInstanceOf");
        Object obj = "Demo";

        if(obj instanceof String str){ //pattern --> initialisation casting assignment
            System.out.println("Object i of typeString: "+str);
        }
    }

    public void traditionalSwitchStatement(){
        System.out.println("traditionalSwitchStatement");
        Object obj = "Demo";

        switch (obj){
            case String s: {
                System.out.println("Objec is string: " + obj);
                break;
            }
            case Integer i: {
                System.out.println("Objec is Integer: " + obj);
                break;
            }
            default:{
                System.out.println("Invalid object");
            }
        }
    }

    public void newSwitchStatementWithArrow(){
        System.out.println("newSwitchStatementWithArrow");
        Object obj = "Demo";

        switch (obj){
            case String s ->
                System.out.println("Objec is string: " + obj);
            case Integer i ->
                System.out.println("Objec is Integer: " + obj);
            default ->
                System.out.println("Invalid object");
        }
    }

    public int switchExpressionWithColon(){
        System.out.println("switchExpressionWithColon");
        int i=10;

        return switch (i){
            case 10,11: yield 10;
            case 12: yield 12;
            default:yield 1;
        };
    }

    public int switchExpressionWithArrow(){
        System.out.println("switchExpressionWithArrow");
        int i=10;

        return switch (i){
            case 10,11-> 10;
            case 12->  12;
            default-> 1;
        };
    }
}
