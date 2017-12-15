import companyfactory.CompanyFactory;
import employee.*;

public class Main {

    public static void main(String[] args) {

        TeamManager teamManager = new TeamManager.Builder("dsds", "sddssd", EmployeeRole.CEO).
                strategyInHire(EmployeePredicate.requireEmail("gmail.com")).
                setAcademy("AGH").build();

        Developer developer = new Developer.Builder("sdds", "dssd").setSex(Sex.Female).setEmail("sddssd@gmail.com").build();

        teamManager.hire(developer);


        CompanyFactory companyFactory = new CompanyFactory();
        companyFactory.generateCompany(10);
        companyFactory.getCeo().reportWork().sortListReport().showReport();

    }

}