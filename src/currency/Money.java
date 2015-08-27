package currency;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

/**
 * Class <tt>Money</tt> represents an amount of money. It contains a
 * <tt>BigDecimal</tt> value for the amount, and a <tt>Currencies</tt>
 * constant for the type of currency. 
 * 
 * 
 * @author Craig
 * @version 2.0
 */
public final class Money implements Comparable<Money>, Serializable{

	/**
	 * serialVersionUID - do not change except to break backwards
	 * compatibility
	 */
	private static final long serialVersionUID = -1426025741143489539L;

	/**
	 * BigDecimal value for the raw amount of this
	 * <tt>Money</tt> object
	 */
	private BigDecimal amount;
	
	/**
	 * <tt>Currencies</tt> constant for the type of
	 * currency of this <tt>Money</tt> object.
	 */
	private CurrencyType currency;
	
	/**
	 * Create a new <tt>Money</tt> object with a value of 0
	 * but with the <tt>CurrencyType</tt> set.
	 * 
	 * @param currency		the type of currency
	 */
	public Money(CurrencyType currency){
		this.amount = new BigDecimal(0.0);
		this.currency = currency;
	}
	
	/**
	 * Create a new <tt>Money</tt> object with a double value
	 * for the <tt>amount</tt> and a <tt>Currencies</tt> constant
	 * for the currency type
	 * 
	 * @param amount	the amount of money
	 * @param currency	the type of currency
	 */
	public Money(double amount, CurrencyType currency){
		this.amount = new BigDecimal(amount);
		this.currency = currency;
	}
	
	/**
	 * Create a new <tt>Money</tt> object with a BigDecimal value
	 * for the <tt>amount</tt> and a <tt>Currencies</tt> constant
	 * for the currency type
	 * 
	 * @param amount	the amount of money
	 * @param currency	the type of currency
	 */
	public Money(BigDecimal amount, CurrencyType currency){
		this.amount = amount;
		this.currency = currency;
	}
	
	/**
	 * Create a new <tt>Money</tt> object, wrapping an existing
	 * <tt>Money</tt> object
	 * 
	 * @param m		the <tt>Money</tt> object
	 */
	public Money(Money m){
		this.amount = m.getBigDecimalAmount();
		this.currency = m.getType();
	}
	
	/**
	 * Internal method to get the BigDecimal value inside
	 * the <tt>Money</tt> object for the purpose of adding/
	 * subtracting.
	 * 
	 * @return		the raw amount of of the <tt>Money</tt> object
	 */
	protected BigDecimal getBigDecimalAmount(){
		return amount;
	}
	
	/**
	 * Get the type of currency of the <tt>Money</tt>
	 * 
	 * @return	the type of currency
	 */
	public CurrencyType getType(){
		return currency;
	}
	
	/**
	 * Add another <tt>Money</tt> object to this one
	 * to increase the value of this <tt>Money</tt> object. 
	 * 
	 * @param m		the <tt>Money</tt> object being added
	 * 				to this one.
	 * @return		the new value of the <tt>Money</tt> object 
	 */
	public Money add(Money m){
		CurrencyType type = m.getType();
		
		if(!type.equals(currency)){
			m = CurrencyConverter.convertTo(m, currency);
		}
		BigDecimal bd = m.getBigDecimalAmount();
		return new Money((amount.add(bd)), currency);
	}
	
	/**
	 * Subtract another <tt>Money</tt> object from this one
	 * to decrease the value of this <tt>Money</tt> object.
	 * 
	 * @param m		the <tt>Money</tt> object being subracted
	 * 				from this one.
	 * @return		the new value of the <tt>Money</tt> object
	 */
	public Money subtract(Money m){
		CurrencyType type = m.getType();
		if(!type.equals(currency)){
			m = CurrencyConverter.convertTo(m, currency);
		}
		BigDecimal bd = m.getBigDecimalAmount();
		return new Money((amount.subtract(bd)), currency);
	}
	
	/**
	 * Multiply the amount of <tt>Money</tt> by a double multiplicand value.
	 * 
	 * @param d			the multiplicand value
	 * @return		the new value of the <tt>Money</tt> object
	 */
	public Money multiply(double d){
		BigDecimal bd = new BigDecimal(d);
		BigDecimal newAmount = amount.multiply(bd);
		return new Money(newAmount, currency);
	}
	
	/**
	 * Multiply the amount of <tt>Money</tt> by a <tt>BigDecimal</tt> multiplicand value.
	 * 
	 * @param bd			the multiplicand value
	 * @return		the new value of the <tt>Money</tt> object
	 */
	public Money multiply(BigDecimal bd){
		BigDecimal newAmount = amount.multiply(bd);
		return new Money(newAmount, currency);
	}
	
	/**
	 * Divide the amount of <tt>Money</tt> by a double divisor value.
	 * 
	 * @param d				the divisor value
	 * @return		the new value of the <tt>Money</tt> object
	 */
	public Money divide(double d){
		BigDecimal bd = new BigDecimal(d);
		BigDecimal newAmount = amount.divide(bd, new MathContext(200));
		return new Money(newAmount, currency);
	}
	
	/**
	 * Divide the amount of <tt>Money</tt> by a <tt>BigDecimal</tt> divisor value.
	 * 
	 * @param bd			the divisor value
	 * @return		the new value of the <tt>Money</tt> object
	 */
	public Money divide(BigDecimal bd){
		BigDecimal newAmount = amount.divide(bd, new MathContext(200));
		return new Money(newAmount, currency);
	}
	
	/**
	 * Get a String representation of this <tt>Money</tt> object
	 * 
	 * @return		a String representation of this <tt>Money</tt> object
	 */
	@Override
	public String toString(){
		DecimalFormat format = new DecimalFormat("###,###,###,###,###.00");
		String output = format.format(amount.doubleValue()) + " " + currency.getCode();
		
		return output;
	}

	/**
	 * This method implements the Comparable interface, allowing this Money
	 * object to be compared to other Money objects.
	 * 
	 * @param m		The <tt>Money</tt> object to compare to
	 * @return 		The result of the comparison between the two objects
	 */
	@Override
	public int compareTo(Money m){
		CurrencyType type = m.getType();
		if(type != currency){
			m = CurrencyConverter.convertTo(m, currency);
		}
		BigDecimal bd = m.getBigDecimalAmount();
		
		return amount.compareTo(bd);
	}
	
}
