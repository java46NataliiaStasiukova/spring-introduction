package telran.spring.calculator.service;

import java.lang.reflect.Method;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import telran.spring.calculator.dto.DataDaysOperationData;
import telran.spring.calculator.dto.OperationData;
@Service("dates")
public class DatesSimpleOperation implements Operation{
	@Override
	public String execute(OperationData data) {
		DataDaysOperationData dates = (DataDaysOperationData) data;
		Method method = null;
		String res;
			try {
				method = this.getClass().getDeclaredMethod(dates.additionalData,
						String.class, int.class);
				res = (String) method.invoke(this, new Object[] {dates.date, dates.days});
			} catch (Exception e) {
				res = "Wrong operation";
			}
			return res.toString();
	}

	String minus(String date, int days) {
		
		return LocalDate.parse(date).minusDays(days).toString();
	}

	String plus(String date, int days) {
	
		return LocalDate.parse(date).plusDays(days).toString();
	}

}
