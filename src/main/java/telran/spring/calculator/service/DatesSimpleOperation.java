package telran.spring.calculator.service;
import java.time.LocalDate;
import org.springframework.stereotype.*;
import telran.spring.calculator.dto.*;
@Service
public class DatesSimpleOperation implements Operation {

	@Override
	public String execute(OperationData data) {
		String res = "";
		DataDaysOperationData dateData = null;
		try {
			dateData = (DataDaysOperationData) data;
			LocalDate date = LocalDate.parse(dateData.date);
			int days = dateData.days;
			if(data.additionalData.equalsIgnoreCase("before")) {
				days = -days;
			}
			res = date.plusDays(days).toString();
			LOG.debug("result message: {}", res);
		} catch (ClassCastException e) {
			res = wrongDtoMessage;
			LOG.error("error: {}", res);
		} 
		return res;
	}

	@Override
	public String getName() {
		
		return "dates";
	}

}
