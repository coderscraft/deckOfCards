package com.ravi.home.deckOfCards;

public class Card {
	private String type;
	private String value;
	public String getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	public Card(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Card [type=" + type + ", value=" + value + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	
}
