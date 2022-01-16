package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionListener2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String content = e.getActionCommand();
        int index = calculator.show.getText().length()-1;
        if( (calculator.show.getText().charAt(index)!= '+'  && calculator.show.getText().charAt(index)!= '-'
                &&calculator.show.getText().charAt(index)!= '×'  && calculator.show.getText().charAt(index)!= '÷'  ) &&!"Error".equals(calculator.show.getText()))
        {
            if("+".equals(content)){
                calculator.show.setText(calculator.show.getText() + "+");
                calculator.calculate.insertSymbol("+");
            }
            else if("-".equals(content)){
                calculator.show.setText(calculator.show.getText() + "-");
                calculator.calculate.insertSymbol("-");
            }
            else if("×".equals(content)){
                calculator.show.setText(calculator.show.getText() + "×");
                calculator.calculate.insertSymbol("×");
            }
            else if("÷".equals(content)){
                calculator.show.setText(calculator.show.getText() + "÷");
                calculator.calculate.insertSymbol("÷");
            }
            else if("=".equals(content)){
                calculator.calculate.answer();
                calculator.show.setText(calculator.calculate.answer);
            }
        }
    }
}
