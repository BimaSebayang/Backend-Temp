package id.co.buara.varia.computama.lib;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MoneyConverter {

	public static String convertPercentageNumber(double amountBefore, double amountAfter) {
		if(amountBefore<=amountAfter) {
			double diff = amountAfter-amountBefore;
			double value = (diff/amountBefore)*100;
			return value+"%";
		}
		else {
			double diff = amountBefore-amountAfter;
			double value = (diff/amountBefore)*100;
			return value+"%";
		}
	}
	
	public static BigDecimal convertStringToMoney(String registryMoney) {
		String str = registryMoney.replaceAll("[^\\d]", "");
		System.out.println("after convert " + str);
		return new BigDecimal(str);
	}
	
	public static String convert(Integer money) {
		String moneyInStr = Integer.toString(money);
		String convert = "";
		int delimeter = 0;
		for(int i = moneyInStr.length()-1; i>=0; i--) {
			if(delimeter==3) {
				convert += ".";
				delimeter=0;
			}
			delimeter++;
			convert = convert + moneyInStr.charAt(i);
		}
		return reverseString(convert);
	}
	
	public static String convert(BigDecimal money) {
		if(money==null) {
			return "0";
		}
		String moneyInStr = money.toString();
		String convert = "";
		int delimeter = 0;
		for(int i = moneyInStr.length()-1; i>=0; i--) {
			if(delimeter==3) {
				convert += ".";
				delimeter=0;
			}
			delimeter++;
			convert = convert + moneyInStr.charAt(i);
		}
		return reverseString(convert);
	}
	
	protected static String reverseString(String strm) {
		String val = "";
		for(int i = strm.length()-1; i>=0; i--) {
			val = val + strm.charAt(i);
		}
		return val;
	}
	
	public static void main(String[] args) {
		String rp = "Rp 1,000,000,000";
		System.out.println(convertStringToMoney(rp));
	
	}
	
}
