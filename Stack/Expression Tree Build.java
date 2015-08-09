/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        
        Stack<ExpressionTreeNode> rec = new Stack<ExpressionTreeNode>();
        Stack<String> opr = new Stack<String>();
        String list = "+-*/";
        
        for (String cur : expression) {
            if (cur.equals("(")) {
                opr.push(cur);
            }
            else if (cur.equals(")")) {
                while (!opr.peek().equals("(")) {
                    helper(opr.pop(), rec);
                }
                
                opr.pop();
            }
            else if (list.contains(cur)) {
                while (!opr.empty() && !opr.peek().equals("(") && priority(opr.peek(), cur)) {
                    helper(opr.pop(), rec);
                }
                
                opr.push(cur);
            }
            else {
                rec.push(new ExpressionTreeNode(cur));
            }
        }
        
        while (!opr.empty()) {
            helper(opr.pop(), rec);
        }
                
        return rec.empty() ? null : rec.peek();
    }
    
    private void helper(String cur, Stack<ExpressionTreeNode> rec) {
        ExpressionTreeNode node = new ExpressionTreeNode(cur);
        node.right = rec.pop();
        node.left = rec.pop();
        rec.push(node);
    }
    
    private boolean priority(String a, String b) {
        if (a.equals("*") || a.equals("/")) {
            return true;
        }
        else if (b.equals("+") || b.equals("-")) {
            return true;
        }
        else {
            return false;
        }
    }
}
