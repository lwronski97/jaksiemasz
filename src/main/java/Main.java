import java.time.temporal.Temporal;
import java.util.Random;

public class Main {

    public static void main(String[] args)  {

//        TeamManager A = new TeamManager("A",EmployeeType.Manager,2);
//        TeamManager B = new TeamManager("B",EmployeeType.Manager,2);
//        TeamManager C = new TeamManager("C",EmployeeType.Manager,2);
//
//        A.hire(B);
//        A.hire(C);
//
//        Developer D = new Developer("D",EmployeeType.Developer);
//        Developer E = new Developer("E",EmployeeType.Developer);
//
//        B.hire(D);
//        B.hire(E);
//
//        Developer F = new Developer("F",EmployeeType.Developer);
//        Developer G = new Developer("G",EmployeeType.Developer);
//
//        C.hire(F);
//        C.hire(G);
//
////        System.out.println(A);
//
//        Task A1 = new Task("sdssdds", 10);
//        Task A2 = new Task("sd2323ssdds", 20);
//
//        B.assignTask(A1);
//        A.assignTask(A2);
//        A.assignTask(A2);
//        A.assignTask(A2);
//        A.assignTask(A1);
//        A.assignTask(A2);
//        A.assignTask(A1);
//        A.assignTask(A1);
//        System.out.println(A);

         CompanyFactory companyFactory = new CompanyFactory();
         companyFactory.generateCompany(10);
    }

}
