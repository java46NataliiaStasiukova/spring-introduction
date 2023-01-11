package telran.spring.calculator.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.*;
import telran.spring.calculator.dto.*;
@Service
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
			LOG.debug("result message: {}", res);
		} catch (ClassCastException e){
			res = wrongDtoMessage;
			LOG.error("error: {}", res);
		}
		return res;
	}

	@Override
	public String getName() {
		
		return "dates-between";
	}

}
