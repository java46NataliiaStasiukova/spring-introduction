package telran.spring.calculator.service;
import java.time.LocalDate;
import org.springframework.stereotype.*;
import telran.spring.calculator.dto.*;
@Service
@Component("dates")
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
		} catch (Exception e) {
			res = "Operation data mismatch operation type";
		} 
		return res;
	}

}
