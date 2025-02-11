import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface extends JFrame{
    public JTextField output_field;
    private JButton PIButton;
    private JButton rootButton;
    private JButton button_clear;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton button_multiply;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a0Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton button_divide;
    private JButton a2Button;
    private JButton button_dot;
    private JButton a3Button;
    private JButton button_equals;
    private JButton button_plus;
    private JButton button_minus;
    private JPanel MainPanel;
    private JButton button_ans;

    ArrayList <Double> numbers = new ArrayList<Double>();
    ArrayList <String> methods = new ArrayList<String>();

    String num =  "";
    double ans = 0.0;
    public String display_text = "";
    public String current_number = "";

    public double convert(String input){
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);

        }
    }

    public Interface(){
        setContentPane(MainPanel);
        setTitle("Calc");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(true);
        setSize(450, 300);
        setVisible(true);

        button_dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = ".";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "0";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "1";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "2";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "3";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "4";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "5";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "6";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "7";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "8";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = "9";
                display_text = display_text + num;
                current_number = current_number + num;

                output_field.setText(display_text);
            }
        });
        button_ans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                num = Double.toString(ans);
                numbers.add(ans);

                current_number = num;

                display_text = display_text + "Ans";
                output_field.setText(display_text);

            }
        });

        button_plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numbers.add(convert(current_number));
                methods.add("+");

                current_number = "";
                display_text = display_text + "+";
                output_field.setText(display_text);
            }
        });
        button_minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display_text.isEmpty()){
                    methods.add("f-");
                }
                else {
                    numbers.add(convert(current_number));
                    methods.add("-");
                }

                current_number = "";
                display_text = display_text + "-";
                output_field.setText(display_text);
            }
        });
        button_equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numbers.addLast(convert(current_number));

                System.out.println("Begin first input:");
                System.out.println(numbers);
                System.out.println(methods);
                System.out.println("---");

                if (methods.contains("sqrt")){
                    while(methods.contains("sqrt")){
                        int func_pointer = methods.indexOf("sqrt");
                        double num = numbers.get(func_pointer);
                        methods.remove(func_pointer);
                        numbers.set(func_pointer, Math.sqrt(num));
                    }
                }

                if (methods.getFirst().equals("f-")){
                    methods.removeFirst();

                    numbers.set(0, numbers.getFirst() * -1);
                }

                if (methods.contains("-")){
                    while (methods.contains("-")){
                        int minus_pointer = methods.indexOf("-");
                        methods.set(minus_pointer, "+");
                        int minus_number = minus_pointer + 1;

                        numbers.set(minus_number, numbers.get(minus_number) * -1);
                    }
                }

                if (methods.size() < numbers.size() * 2 ) {
                    //brackets feature will go here

                    //call calculation class
                    String final_result = null;
                    try {
                        final_result = Double.toString(new Calculation().calc(numbers, methods));
                    } catch (Exception e) {
                        output_field.setText("SYNTAX ERROR");
                        throw new RuntimeException(e);
                    }


                    ans = convert(final_result);

                    if (final_result.equals("Infinity") || final_result.equals("NaN")){
                        output_field.setText("SYNTAX ERROR");
                    }
                    else {
                        output_field.setText(display_text + "  =  " + final_result);
                    }


                }
                else {
                    output_field.setText("SYNTAX ERROR");
                }

                current_number = "";
                display_text = "";
                numbers.removeAll(numbers);
                methods.removeAll(methods);
            }
        });
        button_clear.addActionListener(new ActionListener() { //Full reset all values
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display_text = "";
                current_number = "";

                numbers.removeAll(numbers);
                methods.removeAll(methods);

                output_field.setText(display_text);
            }
        });
        button_multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numbers.add(convert(current_number));
                methods.add("*");

                current_number = "";
                display_text = display_text + "*";
                output_field.setText(display_text);

            }
        });
        button_divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numbers.add(convert(current_number));
                methods.add("/");

                current_number = "";
                display_text = display_text + "/";
                output_field.setText(display_text);
            }
        });
        rootButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                methods.add("sqrt");

                display_text = display_text + "√";
                output_field.setText(display_text);
            }
        });
    }

}