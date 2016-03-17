package Lab1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author ntn13dcm
 * @author ofk14den
 * @version 2016-02-17
 */
public enum Resolution {

	YEAR {
		public String createLabel(LocalDate date) {
			DateTimeFormatter label = DateTimeFormatter.ofPattern("yyyy");

			return date.format(label).toString();

		}
	},
	QUARTER {
		public String createLabel(LocalDate date) {

			DateTimeFormatter label = DateTimeFormatter.ofPattern("yyyy Q");

			return date.format(label).toString();

		}
	},
	MONTH {
		public String createLabel(LocalDate date) {

			DateTimeFormatter label = DateTimeFormatter.ofPattern("yyyy MM");

			return date.format(label).toString();

		}
	},
	WEEK {
		public String createLabel(LocalDate date) {
			DateTimeFormatter label = DateTimeFormatter.ofPattern("yyyy w");

			return date.format(label).toString();

		}
	},
	DAY {
		public String createLabel(LocalDate date) {
			return date.toString();
		}
	};

	public abstract String createLabel(LocalDate date);

}
