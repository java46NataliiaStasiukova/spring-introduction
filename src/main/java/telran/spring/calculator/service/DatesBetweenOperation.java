package telran.spring.calculator.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.*;
import telran.spring.calculator.dto.*;
@Service
@Component("datesBetween")
public class DatesBetweenOperation implements Operation{
	@Override
	public String execute(OperationData data) {
		String res = "";
		DatesOperationData datesData;
		try {
			datesData = (DatesOperationData) data;
			LocalDate dateFrom = LocalDate.parse(datesData.dateFrom);
			LocalDate dateTo = LocalDate.parse(datesData.dateTo);
			res = ChronoUnit.DAYS.between(dateFrom, dateTo) + "";
		} catch (Exception e){
			res = "Operation data mismatch operation type";
		}
		return res;
	}

}
