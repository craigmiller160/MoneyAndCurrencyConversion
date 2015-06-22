package currency;

import java.io.Serializable;

/**
 * Enum <tt>CurrencyType</tt> contains the constant values of all supported
 * Currency Types. Each enum value has a 0-based index number assigned
 * to it, a String representation of its ISO4217 currency code, and a String
 * representation of its plain English name.
 * 
 * @author Craig Miller
 * @version 2.0
 */
public enum CurrencyType implements Serializable{

	/**
	 * AED - United Arab Emirates Dirham
	 */
	AED (0, "AED", "United Arab Emirates Dirham"),
	/**
	 * AUD - Australian Dollars
	 */
	AUD (1, "AUD", "Australian Dollars"),
	/**
	 * CAD - Canadian Dollars
	 */
	CAD (2, "CAD", "Canadian Dollars"),
	/**
	 * CHF - Swiss Franc
	 */
	CHF (3, "CHF", "Swiss Franc"),
	/**
	 * CNY - Chinese Yuan
	 */
	CNY (4, "CNY", "Chinese Yuan"),
	/**
	 * DKK - Danish Krones
	 */
	DKK (5, "DKK", "Danish Krones"),
	/**
	 * EGP - Egyptian Pounds
	 */
	EGP (6, "EGP", "Egyptian Pounds"),
	/**
	 * EUR - European Euros
	 */
	EUR (7, "EUR", "European Euros"),
	/**
	 * GBP - British Pounds Sterling
	 */
	GBP (8, "GBP", "British Pounds Sterling"),
	/**
	 * HKD - Hong Kong Dollars
	 */
	HKD (9, "HKD", "Hong Kong Dollars"),
	/**
	 * ILS - Israeli New Shekels
	 */
	ILS (10, "ILS", "Israeli New Shekels"),
	/**
	 * INR - Indian Rupees
	 */
	INR (11, "INR", "Indian Rupees"),
	/**
	 * JPY - Japanese Yen
	 */
	JPY (12, "JPY", "Japanese Yen"),
	/**
	 * KRW - South Korean Won
	 */
	KRW (13, "KRW", "South Korean Won"),
	/**
	 * KWD - Kuwaiti Dinar
	 */
	KWD (14, "KWD", "Kuwaiti Dinar"),
	/**
	 * MXN - Mexican Pesos
	 */
	MXN (15, "MXN", "Mexican Pesos"),
	/**
	 * NZD - New Zealand Dollars
	 */
	NZD (16, "NZD", "New Zealand Dollars"),
	/**
	 * RUB - Russian Rubles
	 */
	RUB (17, "RUB", "Russian Rubles"),
	/**
	 * SAR - Saudi Arabian Riyals
	 */
	SAR (18, "SAR", "Saudi Arabian Riyals"),
	/**
	 * SEK - Sweedish Kronas
	 */
	SEK (19, "SEK", "Sweedish Kronas"),
	/**
	 * SGD - Singapore Dollars
	 */
	SGD (20, "SGD", "Singapore Dollars"),
	/**
	 * TWD - Taiwan New Dollars
	 */
	TWD (21, "TWD", "Taiwan New Dollars"),
	/**
	 * USD - US Dollars
	 */
	USD (22, "USD", "US Dollars"),
	/**
	 * ZAR - South African Rands
	 */
	ZAR (23, "ZAR", "South African Rands");
	
	/**
	 * The index number of the enum value. It uses
	 * 0-based indexing, exactly the same as arrays.
	 * The index numbers are in alphabetical order by
	 * their code.
	 */
	public final int INDEX;
	
	/**
	 * The currency code, ISO4217
	 */
	private String code;
	
	/**
	 * The plain English name of the currency type
	 */
	private String name;
	
	/**
	 * Private constructor assigns the three values to each
	 * enum constant.
	 * 
	 * @param index		the 0-based index number of the enum value
	 * @param code		the ISO4217 currency code
	 * @param name		the plain English name of the currency
	 */
	private CurrencyType(int index, String code, String name){
		this.INDEX = index;
		this.code = code;
		this.name = name;
	}
	
	/**
	 * Get a String representation of the enum's
	 * currency code.
	 * 
	 * @return		the ISO4217 currency code
	 */
	public String getCode(){
		return code;
	}
	
	/**
	 * Get a String representation of the enum's
	 * currency name.
	 * 
	 * @return		the plain English name of the currency
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Default toString() method returns the name of the currency
	 * 
	 * @return		the plain English name of the currency
	 */
	@Override
	public String toString(){
		return name;
	}
	
}
