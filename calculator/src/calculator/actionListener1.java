package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class actionListener1 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String content = e.getActionCommand();
        if("AC".equals(content)){
            calculator.show.setText("0");
            calculator.calculate.allClear();
        }
        else if("D".equals(content)){
            if(calculator.show.getText().length()>1 && !"Error".equals(calculator.show.getText())){
                calculator.show.setText(calculator.show.getText().substring(0,calculator.show.getText().length()-1));
                calculator.calculate.delete();
            }
            else if(calculator.show.getText().length()==1 && !"Error".equals(calculator.show.getText())){
                calculator.calculate.allClear();
                calculator.show.setText("0");
            }
        }
    }
}
