package edu.uwm.apc430;

public enum Operation {
	PLUS("+",1) {
		@Override
		public long operate(long d1, long d2) {
			return d1 +d2;
		}

	}, 
	MINUS("-",1) {
		@Override
		public long operate(long d1, long d2) {
			return d1 - d2;
		}
	}, 
	TIMES("*",2) {
		@Override
		public long operate(long d1, long d2) {
			return d1 * d2;
		}
	}, 
	DIVIDE("/",2) {
		@Override
		public long operate(long d1, long d2) {
			return d1 / d2;
		}
	},
	LPAREN("(",0),
	RPAREN(")",0),
	;
	
	private final String _name;
	private final int _precedence;
	private Operation(String name, int prec) {
		_name = name;
		_precedence = prec;
	}
	
	public static Operation find(String name) {
		for (Operation op : Operation.values()) {
			if (op._name.equals(name)) return op;
		}
		throw new IllegalArgumentException("no such operation: " + name);
	}
	
	public String toString() {
		return _name;
	}
	
	public long operate(long d1, long d2) {
		throw new UnsupportedOperationException("unbalanced parenthesis");
	}
	public int precedence() {
		return _precedence;
	}
}
