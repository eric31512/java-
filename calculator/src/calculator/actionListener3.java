package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionListener3 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String content = e.getActionCommand();
        int index = calculator.show.getText().length()-1;
        if(calculator.show.getText().equals("0")&&!"Error".equals(calculator.show.getText())){
            if("1".equals(content)){
                calculator.show.setText("1");
                calculator.calculate.insertInt(1.0);
            }
            else if("2".equals(content)){
                calculator.show.setText("2");
                calculator.calculate.insertInt(2.0);
            }
            else if("3".equals(content)){
                calculator.show.setText("3");
                calculator.calculate.insertInt(3.0);
            }
            else if("4".equals(content)){
                calculator.show.setText("4");
                calculator.calculate.insertInt(4.0);
            }
            else if("5".equals(content)){
                calculator.show.setText("5");
                calculator.calculate.insertInt(5.0);
            }
            else if("6".equals(content)){
                calculator.show.setText("6");
                calculator.calculate.insertInt(6.0);
            }
            else if("7".equals(content)){
                calculator.show.setText("7");
                calculator.calculate.insertInt(7.0);
            }
            else if("8".equals(content)){
                calculator.show.setText("8");
                calculator.calculate.insertInt(8.0);
            }
            else if("9".equals(content)){
                calculator.show.setText("9");
                calculator.calculate.insertInt(9.0);
            }
            else if("0".equals(content)){
                calculator.show.setText("0");
                calculator.calculate.insertInt(0.0);
            }
            else if(".".equals(content) ){
                calculator.show.setText(calculator.show.getText() + ".");
                calculator.calculate.insertSymbol(".");
            }
        }
        else if(!calculator.show.getText().equals("0")&&!"Error".equals(calculator.show.getText())){
            if("1".equals(content)){
                calculator.show.setText(calculator.show.getText() + "1");
                calculator.calculate.insertInt(1.0);
            }
            else if("2".equals(content)){
                calculator.show.setText(calculator.show.getText() + "2");
                calculator.calculate.insertInt(2.0);
            }
            else if("3".equals(content)){
                calculator.show.setText(calculator.show.getText() + "3");
                calculator.calculate.insertInt(3.0);
            }
            else if("4".equals(content)){
                calculator.show.setText(calculator.show.getText() + "4");
                calculator.calculate.insertInt(4.0);
            }
            else if("5".equals(content)){
                calculator.show.setText(calculator.show.getText() + "5");
                calculator.calculate.insertInt(5.0);
            }
            else if("6".equals(content)){
                calculator.show.setText(calculator.show.getText() + "6");
                calculator.calculate.insertInt(6.0);
            }
            else if("7".equals(content)){
                calculator.show.setText(calculator.show.getText() + "7");
                calculator.calculate.insertInt(7.0);
            }
            else if("8".equals(content)){
                calculator.show.setText(calculator.show.getText() + "8");
                calculator.calculate.insertInt(8.0);
            }
            else if("9".equals(content)){
                calculator.show.setText(calculator.show.getText() + "9");
                calculator.calculate.insertInt(9.0);
            }
            else if("0".equals(content)){
                calculator.show.setText(calculator.show.getText() + "0");
                calculator.calculate.insertInt(0.0);
            }
            else if(".".equals(content) &&( calculator.show.getText().charAt(index)!= '+'  && calculator.show.getText().charAt(index)!= '-'
                    && calculator.show.getText().charAt(index)!= '×'  && calculator.show.getText().charAt(index)!= '÷')){
                int check=0;
                for(int a=index ; a>=0;a--){
                    if(calculator.show.getText().charAt(a)== '+'  || calculator.show.getText().charAt(a)== '-'
                            || calculator.show.getText().charAt(a)== '×'  || calculator.show.getText().charAt(index)== '÷' ) {
                        break;
                    }
                    if(calculator.show.getText().charAt(a)== '.'  ){
                        check++;
                        break;
                    }
                }
                if(check == 0)calculator.show.setText(calculator.show.getText() + ".");
                calculator.calculate.insertSymbol(".");
            }
        }
    }
}
