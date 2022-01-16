package calculator;
import java.util.ArrayList;
import java.util.Stack;

public class calculate {
       String answer;
       boolean checkDecimal;
       double decimalTimes;
       boolean checkExSymbol;
       static ArrayList<Double> nums = new ArrayList<>();
       static ArrayList<String> charact = new ArrayList<>();
       static Stack<String> calChar = new Stack<>();
       static Stack<Double> calNum = new Stack<>();
       public calculate(){
              answer = "0";
              checkDecimal = false;
              decimalTimes = 1;
              checkExSymbol = true;
              nums.add(0.0);
       }
       public void insertInt(Double in){
              double reset ;
              int size = nums.size();
              if( !"Error".equals(answer)){
                     if(nums.size()==1 &&nums.get(0) == 0){
                            nums.set(0,in);
                            checkExSymbol = false;
                     }
                     else{
                            if(checkExSymbol){
                                   nums.add(in);
                                   checkExSymbol = false;
                            }
                            else{
                                   if(checkDecimal){
                                          decimalTimes *= 10;
                                          reset = nums.get(size-1)+in/decimalTimes;
                                   }
                                   else {
                                          reset = nums.get(size-1)*10 + in;
                                   }
                                   nums.set(size-1,reset);

                            }
                     }
              }
       }
       public void insertSymbol(String string){
              if(!"Error".equals(answer)){
                     if(".".equals(string)){
                            checkDecimal = true;
                            decimalTimes = 1;
                     }
                     else{
                            checkExSymbol = true;
                            checkDecimal = false;
                            charact.add(string);
                     }
              }
       }
       public void delete(){
              if(!"Error".equals(answer)){
                     int index = calculator.show.getText().length()-1;
                     if(calculator.show.getText().charAt(index)== '+'  || calculator.show.getText().charAt(index)== '-'
                             || calculator.show.getText().charAt(index)== '×'  || calculator.show.getText().charAt(index)== '÷'){
                            charact.remove(charact.size()-1);
                     }
                     else{
                            if(nums.get(nums.size()-1)%1 == 0){
                                   double reset = nums.get(nums.size()-1)/10;
                                   reset = Math.floor(reset);
                                   nums.set(nums.size()-1,reset);
                            }else if(nums.get(nums.size()-1)%1 != 0){
                                   double time = 1.0;
                                   double set = nums.get(nums.size()-1);
                                   while(set%1 != 0){
                                          set *= 10;
                                          time *= 10;
                                   }
                                   set /= 10;
                                   set = Math.floor(set);
                                   set /= time/10;
                                   nums.set(nums.size()-1,set);

                            }

                     }
              }

       }
       public void allClear(){
              answer = "0";
              checkDecimal = false;
              decimalTimes = 1;
              calChar.removeAllElements();
              calNum.removeAllElements();
              nums.clear();
              charact.clear();
              nums.add(0.0);
       }
       public void answer(){
              charact.add(" ");
              if(nums.size()==1 && !"Error".equals(answer)){
                     answer = String.valueOf(nums.get(0));
              }
              else{
                     for(int i = 0 ; i < nums.size() ; i++){
                            if("Error".equals(answer)){
                                   checkDecimal = false;
                                   decimalTimes = 1;
                                   calChar.removeAllElements();
                                   calNum.removeAllElements();
                                   nums.clear();
                                   charact.clear();
                                   nums.add(0.0);
                                   break;
                            }
                            if(calChar.isEmpty()){
                                   calChar.push(charact.get(i));
                                   calNum.push(nums.get(i));
                            }
                            else if(("×".equals(charact.get(i)) || "÷".equals(charact.get(i))) && ("+".equals(calChar.get(calChar.size() - 1)) || "-".equals(calChar.get(calChar.size() - 1)))){
                                   calChar.push(charact.get(i));
                                   calNum.push(nums.get(i));
                            }
                            else{
                                   calNum.push(nums.get(i));
                                   while( !calChar.isEmpty() &&  !( ("×".equals(charact.get(i)) || "÷".equals(charact.get(i)) ) &&
                                           ( "+".equals(calChar.get(calChar.size()-1)) || "-".equals(calChar.get(calChar.size()-1)) ) ) ){
                                          int size = calChar.size()-1;
                                          calcu(calChar.get(size));
                                   }
                                   calChar.push(charact.get(i));
                            }
                            if(!"Error".equals(answer))
                            answer = String.valueOf(calNum.get(0));
                     }
                     if(!"Error".equals(answer)){
                            nums.clear();
                            nums.add(calNum.get(0));
                            checkDecimal = false;
                            decimalTimes = 1;
                            calChar.removeAllElements();
                            calNum.removeAllElements();
                            charact.clear();
                     }

              }

       }
       public void calcu(String x){
              double Answer = 0;
              switch (x) {
                     case "+" -> {
                            Answer = calNum.get(calNum.size() - 2) + calNum.get(calNum.size() - 1);
                            calNum.pop();
                            calNum.pop();
                            calChar.pop();
                            calNum.push(Answer);
                     }
                     case "-" -> {
                            Answer = calNum.get(calNum.size() - 2) - calNum.get(calNum.size() - 1);
                            calNum.pop();
                            calNum.pop();
                            calChar.pop();
                            calNum.push(Answer);
                     }
                     case "×" -> {
                            Answer = calNum.get(calNum.size() - 2) * calNum.get(calNum.size() - 1);
                            calNum.pop();
                            calNum.pop();
                            calChar.pop();
                            calNum.push(Answer);
                     }
                     case "÷" -> {
                            try {
                                   if (calNum.get(calNum.size() - 1) == 0) throw new ArithmeticException();
                                   Answer = calNum.get(calNum.size() - 2) / calNum.get(calNum.size() - 1);
                            } catch (ArithmeticException e) {
                                   answer = "Error";
                            }
                            calNum.pop();
                            calNum.pop();
                            calChar.pop();
                            calNum.push(Answer);
                     }
                     default -> {
                     }
              }
       }
}
