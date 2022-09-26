package baseclass;

public class LoginPgPassBase {
	
	public int No_upperCase = 1, No_lowerCase = 1, No_digit = 1;
	public int upperCnt = 0, lowerCnt = 0, digitCnt = 0;
	
	public void passBasRequisites(String actPassword) {
	
		int passSize = actPassword.length();

		for (int i = 0; i < passSize; i++) {
			char ch = actPassword.charAt(i);
			if (Character.isUpperCase(ch))
				upperCnt++;
			if (Character.isLowerCase(ch))
				lowerCnt++;
			if (Character.isDigit(ch))
				digitCnt++;
		}
//		System.out.println("upperCnt" + upperCnt);
//		System.out.println("lowerCnt" + lowerCnt);
//		System.out.println("digitCnt" + digitCnt);
	}
	
	public boolean passUpCaseCondt() {
		if (upperCnt >= No_upperCase)
			return true;
		return false;
	}
	
	public boolean passLowCaseCondt() {
		
		if (lowerCnt >= No_upperCase)
			return true;
		return false;
	}
	
	public boolean passDigitCondt() {
		
		if (digitCnt >= No_upperCase)
			return true;
		return false;
	}
	
//	public static void main(String[] args) {
//		LoginPgPassBase lp= new LoginPgPassBase();
//		lp.passBasRequisites("123456");
//		boolean actPass = lp.passUpCaseCondt();
//		System.out.println(actPass);
//	}
}