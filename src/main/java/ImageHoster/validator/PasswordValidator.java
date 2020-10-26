package ImageHoster.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator{

	  private Pattern pattern_1;
	  private Pattern pattern_2;
	  private Matcher matcher_1;
	  private Matcher matcher_2;

	  private static final String PASSWORD_PATTERN_1 =
              "^(?=.*\\d)(?=.*[a-z])(?=.*[@#$%^+=!]).{3,9999}$";
	  private static final String PASSWORD_PATTERN_2 =
              "^(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%^+=!]).{3,9999}$";

	  public PasswordValidator(){
		  pattern_1 = Pattern.compile(PASSWORD_PATTERN_1);
		  pattern_2 = Pattern.compile(PASSWORD_PATTERN_2);
	  }

	  /**
	   * Validate password with regular expression
	   * @param password password for validation
	   * @return true valid password, false invalid password
	   */
	  public boolean validate(final String password){

		  matcher_1 = pattern_1.matcher(password);
		  matcher_2 = pattern_2.matcher(password);
		  return matcher_1.matches() || matcher_2.matches();

	  }
	  
}