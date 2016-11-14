/**
 * Created by Zach on 10/16/2016.
 */
import javax.swing.*;

public class FAFSAGUI {

    public static void main(String []args){
        boolean a1 = true;
        boolean a2 = true;
        boolean a3 = true;
        boolean a4 = true;
        boolean a5 = true;
        boolean runAgain = true;

        while (runAgain == true) {
            JOptionPane.showMessageDialog(null, "Welcome to the FAFSA!", "Welcome", JOptionPane.INFORMATION_MESSAGE);

            Object[] options = {"Yes", "No"};
            int q1 = JOptionPane.showOptionDialog(null, "Have you been accepted into a degree or certificate program?", "Program Acceptance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (q1 == 1) {
                a1 = false;
            }

            int q2 = JOptionPane.showOptionDialog(null, "Are you registered for the selective service?", "Selective Service", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (q2 == 1) {
                a2 = false;
            }

            int q3 = JOptionPane.showOptionDialog(null, "Do you have a social security number?", "Social Security Number", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (q3 == 1) {
                a3 = false;
            }

            int q4 = JOptionPane.showOptionDialog(null, "Do you have valid residency status?", "Residency Status", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (q4 == 1) {
                a4 = false;
            }

            int q5 = JOptionPane.showOptionDialog(null, "Do you have valid residency status?", "Residency Status", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (q5 == 1) {
                a5 = false;
            }

            String age = JOptionPane.showInputDialog(null, "How old are you?", "Age", JOptionPane.QUESTION_MESSAGE);
            while (Integer.parseInt(age) < 0) {
                JOptionPane.showMessageDialog(null, "Age cannot be a negative number.", "Error: Age", JOptionPane.ERROR_MESSAGE);

                age = JOptionPane.showInputDialog(null, "How old are you?", "Age", JOptionPane.QUESTION_MESSAGE);
            }

            String hours = JOptionPane.showInputDialog(null, "How many credit hours do you plan on taking?", "Credit Hours", JOptionPane.QUESTION_MESSAGE);
            while (Integer.parseInt(hours) < 1 && Integer.parseInt(hours) > 24) {
                JOptionPane.showMessageDialog(null, "Credit hours must be between 1 and 24, inclusive.", "Error: Credit Hours", JOptionPane.ERROR_MESSAGE);

                hours = JOptionPane.showInputDialog(null, "How many credit hours do you plan on taking?", "Credit Hours", JOptionPane.QUESTION_MESSAGE);
            }

            String income = JOptionPane.showInputDialog(null, "What is your total yearly income?", "Student Income", JOptionPane.QUESTION_MESSAGE);
            while (Integer.parseInt(income) < 0) {
                JOptionPane.showMessageDialog(null, "Income can not be a negative number.", "Error: Student Income", JOptionPane.ERROR_MESSAGE);

                income = JOptionPane.showInputDialog(null, "What is your total yearly income??", "Student Income", JOptionPane.QUESTION_MESSAGE);
            }

            String pIncome = JOptionPane.showInputDialog(null, "How is your parent's total yearly income?", "Parent Income", JOptionPane.QUESTION_MESSAGE);
            while (Integer.parseInt(pIncome) < 0) {
                JOptionPane.showMessageDialog(null, "Income can not be a negative number.", "Error: Parent Income.", JOptionPane.ERROR_MESSAGE);

                pIncome = JOptionPane.showInputDialog(null, "How is your parent's total yearly income?", "Parent Income", JOptionPane.QUESTION_MESSAGE);
            }

            JOptionPane.showOptionDialog(null, "Are you a dependent?", "Dependency", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

            String[] choices = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};
            String year = (String) (JOptionPane.showInputDialog(null, "What is your current class standing?", "Class Standing", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]));
            if (year != "Graduate") {
                year = "Undergraduate";
            }

            FAFSA applicant = new FAFSA(a1, a2, a3, a4, a5, Integer.parseInt(age), Integer.parseInt(hours), Integer.parseInt(income), Integer.parseInt(pIncome), year);

            double loan = applicant.calcStaffordLoan();
            double grant = applicant.calcFederalGrant();
            double workS = applicant.calcWorkStudy();

            double total = loan + grant + workS;

            JOptionPane.showMessageDialog(null, "Loans: $" + loan + "\nGrants: $" + grant + "\nWork Study: $" + workS + "\n______" + "\nTotal: $" + total, "FAFSA Results", JOptionPane.INFORMATION_MESSAGE);

            int q6 = JOptionPane.showOptionDialog(null, "Would you like to complete another Application?", "Continue", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (q6 == 1){
                runAgain = false;
            }
        }

    }
}
