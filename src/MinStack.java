import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minValStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minValStack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);
        if (this.minValStack.isEmpty() || val <= this.minValStack.peek()) {
                this.minValStack.push(val);
        }
    }

    public void pop() {
        int popped = this.stack.pop();
        if (popped == this.minValStack.peek())
            this.minValStack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minValStack.peek();
    }
}
