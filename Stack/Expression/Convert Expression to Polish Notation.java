class ExpressionTreeNode {
    String symbol;
    ExpressionTreeNode left, right;
    
    ExpressionTreeNode(String symbol) {
        this.symbol = symbol;
        this.left = this.right = null;
    }
 }
 
 public class Solution {
    /**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    public ArrayList<String> convertToPN(String[] expression) {
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
                
        ExpressionTreeNode root = rec.empty() ? null : rec.peek();
        ArrayList<String> result = new ArrayList<String>();
        preorder(root, result);
        
        return result;
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
    
    private void preorder(ExpressionTreeNode root, ArrayList<String> result) {
        if (root == null) {
            return;
        }
        
        result.add(root.symbol);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
