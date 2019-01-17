package task_t9.converter;
//Set types output symbols and set binding to input letter code.For example 

// we have to generate '2' if code symbols >= 'A' and < 'D' .Count symbols was generated depends from number code;

public enum OutputSymbolType {

	ZERO('0', ' ', '!'), TWO('2', 'A', 'D'), THREE('3', 'D', 'G'), FOUR('4', 'G', 'J'), FIVE('5', 'J', 'M'), SIX('6',
			'M', 'P'), SEVEN('7', 'P', 'T'), EIGHT('8', 'T', 'W'),
	// after Z next '['
	NINE('9', 'W', '['), UNSUPPORTED;

	private char charValue;

	private char startRange;

	private char endRange;

	private OutputSymbolType(char charValue, char startRange, char endRange) {
		this.charValue = charValue;
		this.startRange = startRange;
		this.endRange = endRange;
	}

	private OutputSymbolType() {
		
		
	}
	
	public char getCharValue() {
		return charValue;
	}

	// include char
	public char getStartRange() {
		return startRange;
	}

	// not include char
	public char getEndRange() {
		return endRange;
	}
	
	
	public static OutputSymbolType getTypeByCode(int code) {
		
		OutputSymbolType [] values= OutputSymbolType.values();
		
		for (int i=0;i<values.length;i++) {
			
			
			if ((code>=values[i].startRange) && (code<values[i].endRange))
			
				return values[i];
			
			
		}
		
		return UNSUPPORTED;
		
	}
	
}
