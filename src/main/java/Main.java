
public class Main {

    public static void main(String[] args)  {

        CompanyFactory companyFactory = new CompanyFactory();
        System.out.println(companyFactory.generateCompany(100));

        smallTest();

    }

    public static void smallTest() {
        TeamManager A = new TeamManager("A",EmployeeType.Manager,2);
        TeamManager B = new TeamManager("B",EmployeeType.Manager,2);
        TeamManager C = new TeamManager("C",EmployeeType.Manager,2);

        A.hire(B);
        A.hire(C);

        Developer D = new Developer("D",EmployeeType.Developer);
        Developer E = new Developer("E",EmployeeType.Developer);

        B.hire(D);
        B.hire(E);

        Developer F = new Developer("F",EmployeeType.Developer);
        Developer G = new Developer("G",EmployeeType.Developer);

        C.hire(F);
        A.hire(G);

        Task A1 = new Task("sdssdds", 10);
        Task A2 = new Task("sd2323ssdds", 20);

        B.assignTask(A1);
        A.assignTask(A2);
        A.assignTask(A2);
        A.assignTask(A2);
        A.assignTask(A1);
        A.assignTask(A2);
        A.assignTask(A1);
        A.assignTask(A1);
        System.out.println(A);

        System.out.println(B);

        System.out.println(C);
    }
}
