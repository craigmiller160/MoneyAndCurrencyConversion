# MoneyAndCurrencyConversion
###########################
VERSION 2.0
###########################
SUMMARY

A library to assist in the use of Money in programs. Specifically, it provides a Money object that links the raw value to a specific type of currency.The included utility class, CurrencyConverter, handles conversions of 24 included currencies. As a result, operations involving a Money objects of multiple currency types are automatically converted into the type of the base amount of Money, thus maintaining financial consistency when dealing with multiple currencies.
##########################
CONTENTS

public final class Money - Defines a Money object. Links a BigDecimal value with a CurrencyType, preventing the raw value from being un-associated with the type of currency it is calculated in. It contains methods for performing basic operations (add, subtract, multiply, divide) which will automatically convert another Money object to the propper currency type to maintain financial integrity while performing the operation. Finally, it implements the Comparable interface, allowing Money objects to have their values compared to one another even if they have different currency types.

public enum CurrencyType - A list of constants of different currency types. As of Version 2.0, there are 24 supported CurrencyTypes. Each constant has an index number, the ISO4217 currency code, and the plain English name of the currency. Every Money object must contain a valid CurrencyType constant to allow for operations between objects of varying currency types.

public final class CurrencyConverter - A utility class that converts the currency type of one Money object into another currency type. Utilizes the CurrencyType enum for its list of supported currencies. Designed to automatically update its definitions of currency conversion rates once every 24 hours (needs an update to save conversion rate between uses), but contains a method for force the update to occur at any time. Currency conversion rates are downloaded from Yahoo! Finance.