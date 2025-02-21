import java.util.ArrayList;

public class Calculation {
    public double calc(ArrayList <Double> number_array, ArrayList <String> func_array){
        double cn1 = 0;
        double cn2 = 0;
        double calculation = 0;

        int fp = 0; //Function pointer
        int np1 = 0; //Number pointer 1
        int np2 = 1; //Number pointer 2

        double output = 0;

        int cycle = 1;

        while (!func_array.isEmpty()){
            //Reset vars used for calculation
            calculation = 0;
            np1 = 0;
            np2 = 1;
            fp = 0;
            cycle++;

            //Debug Cycle display
            System.out.println("Cycle:" + cycle );

            if (func_array.contains("*") && func_array.contains("/")){
               if (func_array.indexOf("*") < func_array.indexOf("/")){
                   fp = func_array.indexOf("*");
               }
               else {
                   fp = func_array.indexOf("/");
               }
                np1 = fp;
                np2 = fp + 1;


                cn1 = number_array.get(np1);
                cn2 = number_array.get(np2);

                calculation = switch (func_array.get(fp)) {
                    case "*" -> cn1 * cn2;
                    case "/" -> cn1 / cn2;
                    default -> calculation;
                };
                func_array.remove(fp);
                number_array.set(np1, calculation);
                number_array.remove(np2);
            }
            else if (func_array.contains("*") || func_array.contains("/")){ //Check if priority is important
                if (!func_array.get(fp).equdals("*") && !func_array.get(fp).equals("/")){
                    if (func_array.contains("*")){
                        fp = func_array.indexOf("*");
                    }
                    else {
                        fp = func_array.indexOf("/");
                    }
                    np1 = fp;
                    np2 = fp + 1;
                }

                cn1 = number_array.get(np1);
                cn2 = number_array.get(np2);

                calculation = switch (func_array.get(fp)) {
                    case "*" -> cn1 * cn2;
                    case "/" -> cn1 / cn2;
                    default -> calculation;
                };
                func_array.remove(fp);
                number_array.set(np1, calculation);
                number_array.remove(np2);
            }
            else if (func_array.get(fp).equals("+")){ //Because - is already managed in the input state only + operations are needed
                cn1 = number_array.get(np1);
                cn2 = number_array.get(np2);

                calculation = cn1 + cn2;

                func_array.remove(fp);
                number_array.set(np1, calculation);
                number_array.remove(np2);
            }
        }

        //Output the finished calculation
        output = number_array.getFirst();


        System.out.println("----");
        System.out.println(output);

        return output;
    }
}
