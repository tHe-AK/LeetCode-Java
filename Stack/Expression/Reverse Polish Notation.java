public class Calculator {
    private Stack<Double> stack;
    private TokenFactory tokenFactory;
    
    public Calculator() {
        stack = new Stack<>();
        tokenFactory = new TokenFactory();
    }
    
    public double process(String str) {
        stack.clear();
        String[] tokens = str.split(" ");
        
        for (String token : tokens) {
            tokenFactory.getToken(token).process(stack);
        }
        
        return stack.empty() ? 0 : stack.pop();
    }
    
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.process("5 5 + 2 / 3 * 4 -"));
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

abstract class Token {
    public abstract void process(Stack<Double> stack);
}

class TokenFactory {
    private Map<String, Operator> map;
    
    public TokenFactory() {
        map = new HashMap<>();
        map.put("+", new Add(2));
        map.put("-", new Substract(2));
        map.put("*", new Multiply(2));
        map.put("/", new Divide(2));
    }
    
    public Token getToken(String token) {
        if (map.containsKey(token)) {
            return map.get(token);
        } else {
            return new Operand(token);
        }
    }
}


class Operand extends Token {
    private double num;

    public Operand(String token) {
        super();
        num = Double.parseDouble(token);
    }
    
    @Override
    public void process(Stack<Double> stack) {
        stack.push(num);
    }
}

abstract class Operator extends Token {
    protected int numOfOprand;
    
    public Operator(int numOfOprand) {
        super();
        this.numOfOprand = numOfOprand;
    }
}

class Add extends Operator {
    public Add(int numOfOprand) {
        super(numOfOprand);
    }
    
    @Override
    public void process(Stack<Double> stack) {
        double[] nums = new double[numOfOprand];
        
        for (int i = 0; i < numOfOprand; i++) {
            nums[i] = stack.pop();
        }
        
        stack.push(nums[1] + nums[0]);
    }
}

class Substract extends Operator {
    public Substract(int numOfOprand) {
        super(numOfOprand);
    }
    
    @Override
    public void process(Stack<Double> stack) {
        double[] nums = new double[numOfOprand];
        
        for (int i = 0; i < numOfOprand; i++) {
            nums[i] = stack.pop();
        }
        
        stack.push(nums[1] - nums[0]);
    }
}

class Multiply extends Operator {
    public Multiply(int numOfOprand) {
        super(numOfOprand);
    }
    
    @Override
    public void process(Stack<Double> stack) {
        double[] nums = new double[numOfOprand];
        
        for (int i = 0; i < numOfOprand; i++) {
            nums[i] = stack.pop();
        }
        
        stack.push(nums[1] * nums[0]);
    }
}

class Divide extends Operator {
    public Divide(int numOfOprand) {
        super(numOfOprand);
    }
    
    @Override
    public void process(Stack<Double> stack) {
        double[] nums = new double[numOfOprand];
        
        for (int i = 0; i < numOfOprand; i++) {
            nums[i] = stack.pop();
        }
        
        stack.push(nums[1] / nums[0]);
    }
}
