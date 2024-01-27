package edu.uwm.apc430;

import edu.uwm.apc430.util.IntMath;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Name: Maggie Herms
 * Class to perform integer calculations online given method calls.
 * It uses normal arithmetic operator precedence, defined on the Operation enum,
 * and assumes left associativity. A calculator can be in one of three states:
 * <ol>
 * <li> Clear: Nothing pending
 * <li> Ready: A value is available
 * <li> Waiting: An operator has been started and we're waiting for a value
 * </ol>
 * At any point if a division by zero is caused, the appropriate exception is raised.
 * 
 */
public class Calculator {
	
	Stack<Long> integers;
	Stack<Operation> operators;
	private int state = 0; 
	private int openParens = 0;
	
	/**
	 * Constructor, creates an empty integer and operator stack
	 * Puts Calculator in "empty" (0) state
	 */
	public Calculator() {
		integers = new Stack<Long>();
		operators = new Stack<Operation>();
		this.state = 0;
	}
		
	
	/**
	 * Clears the calculator (i.e., integer and operator stacks) and the default value
	 * Updates calculator state to "empty" (0)
	 */
	public void clear() {
		this.integers.clear();
		this.operators.clear();
		this.state = 0;
	}
	
	/**
	 * Enter a value to be pushed onto the integer stack and update calculator state to "ready" (1)
	 * @param long value
	 * @throws IllegalStateException if calculator is already in "ready" (1) state
	 */
	public void value (long x) throws IllegalStateException {
		if (state == 1) throw new IllegalStateException("Calculator is in wrong state for value method");
		
		integers.push(x);
		this.state = 1;		
	}
	
	/**
	 * Enter a binary operator to be pushed onto the operator stack and update calculator state to "waiting" (2)
	 * @param Operation, Binary Operator
	 * @throws IllegalStateException if calculator is already in "waiting" (2) state
	 * @throws IllegalArgumentException if argument is an illegal operator
	 */
	public void binop(Operation o) throws IllegalStateException {
		if (state == 2) throw new IllegalStateException("Calculator is in wrong state for binop method");
		if (o == Operation.RPAREN || o == Operation.LPAREN) throw new IllegalArgumentException("Illegal operator");
		
		if ((!operators.isEmpty()) && (o.precedence() < operators.peek().precedence() || o.precedence() == operators.peek().precedence())) {
			compute();
			operators.push(o);
		} else {
			operators.push(o);
		}
		
		this.state = 2;
	}
	
	/**
	 * Replace the current value with its square root using unsigned integer square root method
	 * calculator state remains unchanged
	 * @throws IllegalStateException, if calculator is in "waiting" (2) state
	 */
	public void sqrt() throws IllegalStateException {
		if (state == 2) throw new IllegalStateException("Calculator is in wrong state for sqrt method");
		
		if (integers.isEmpty()) { 
			integers.push(IntMath.isqrt(0));
		} else {
			integers.push(IntMath.isqrt(getCurrent()));
		}
	}
	
	/**
	 * push an open (i.e., Left Parentheses) onto the operator stack, 
	 * increment open parentheses count, and update state to "waiting" (2)
	 * @throws IllegalStateException, if calculator is in "Ready" (1) state
	 */
	public void open() throws IllegalStateException {
		if (state == 1) throw new IllegalStateException("Calculator is in wrong state for open method");
		
		openParens++;
		this.operators.push(Operation.LPAREN);
		this.state = 2;
	}
	
	/**
	 * Starts computing operations up until we hit an open parentheses, remove open/left parentheses, 
	 * and decrement open parentheses count. Calculator state remains unchanged
	 * @throws EmptyStackException, if there's no previously unclosed open parentheses
	 * @throws IllegalStateException, if calculator is in "empty" (0) or "waiting" (2) state
	 */
	public void close() throws EmptyStackException, IllegalStateException {
		if (state == 0 || state == 2) throw new IllegalStateException("Calculator is in wrong state for close method");
		if (openParens == 0) throw new EmptyStackException();
		
		Operation op;
		long v1;
		long v2;
		long total = 0;
	
		while (!integers.isEmpty() && !operators.isEmpty() && operators.peek() != Operation.LPAREN) {
			v1 = integers.pop();
			op = operators.pop();
			
			if (integers.isEmpty()) {
				v2 = 0;
			} else {
				v2 = integers.pop();
			}
			
			total = op.operate(v2, v1);
			integers.push(total);
			
		}
		
		if (!operators.isEmpty() && operators.peek() == Operation.LPAREN) {
			operators.pop();
			openParens--;
		}
	}
	
	/**
	 * Performs all pending computations, uses close() to perform computations if there are unclosed open parentheses
	 * updates calculator state to "empty" (0) 
	 * @return long value which is the result of all remaining computations
	 * @throws IllegalStateException if the calculator is in "waiting" (2) state
	 */
	public long compute() throws IllegalStateException {
		if (state == 2) throw new IllegalStateException("Calculator in wrong state for compute method");
		if (integers.isEmpty()) return 0;
		
		//default close any open parentheses
		while (openParens > 0) { 
			close();
		}
		
		long v1 = 0;
		long v2 = 0;
		long total = 0;
		Operation op;
		
		while (!integers.isEmpty() && !operators.isEmpty()) {
			v1 = integers.pop();
			op = operators.pop();
			
			if (integers.isEmpty()) {
				v2 = 0;
			} else {
				v2 = integers.pop();
			}
			
			total = op.operate(v2, v1);
			integers.push(total);
		}

		this.state = 0;
		return integers.peek();
	}
	
	/**
	 * return the current value. Either the default value if we recently finished a computation, 
	 * or the top of the integer stack. Calculator state remains unchanged.
	 * @return long, the current value
	 */
	public long getCurrent() {
		if (integers.isEmpty()) return 0;
		
		return integers.peek(); 
		
	}
	
}
