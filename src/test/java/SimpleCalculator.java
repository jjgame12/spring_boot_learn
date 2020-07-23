import java.util.Scanner;
import java.util.Stack;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Stack<Integer> splitNums = getSplitNums(line);
        Stack<String> splitStrs = getSplitStrs(line);
        int res = getCalculationResult(splitNums, splitStrs);
        scanner.close();
        System.out.println(res);
    }

    public static Stack<Integer> getSplitNums(String line) {
        Stack<Integer> stackS = new Stack<>();
        String[] strArray = line.split("\\+|-|\\*");
        for(String s:strArray) {
            stackS.push(Integer.parseInt(s));
        }
        return stackS;
    }

    public static Stack<String> getSplitStrs(String line){
        Stack<String> stackS = new Stack<>();
        String[] strArray = line.split("[0-9]+");
        for(String s:strArray) {
            if(!s.equals("")){
                stackS.push(s);
            }
        }
        return stackS;
    }

    public static int getCalculationResult(Stack<Integer> nums, Stack<String> symbles) {
        Stack<Integer> numsStack = new Stack<>();
        Stack<String> symStack = new Stack<>();
        numsStack.push(nums.pop());
        while(!symbles.isEmpty()) {
            String symble = symbles.pop();
            if(symble.equals("*")) {
                numsStack.push(nums.pop() * numsStack.pop());
            }else {
                symStack.push(symble);
                numsStack.push(nums.pop());
            }
        }

        while(!symStack.isEmpty()) {
            int num = numsStack.pop();
            String symble = symStack.pop();
            if(symble.equals("+")){
                numsStack.push(num + numsStack.pop());
            }else if(symble.equals("-")) {
                numsStack.push(num - numsStack.pop());
            }
        }
        return numsStack.pop();
    }
}
