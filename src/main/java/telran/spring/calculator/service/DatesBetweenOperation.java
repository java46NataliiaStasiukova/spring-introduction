package telran.spring.calculator.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import telran.spring.calculator.dto.DatesOperationData;
import telran.spring.calculator.dto.OperationData;
@Service("datesBetween")
public class DatesBetweenOperation implements Operation{
	@Override
	public String execute(OperationData data) {
		DatesOperationData dates = (DatesOperationData) data;
		long res;
		res = ChronoUnit.DAYS.between(LocalDate.parse(dates.dateFrom),
				LocalDate.parse(dates.dateTo));
		
		return String.valueOf(res);
	}

}
