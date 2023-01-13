import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Holiday;
import model.services.HolydayService;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {

            System.out.println("--------------------------");
            System.out.println("Welcome to Holydayzer");
            System.out.println("--------------------------");
    
            HolydayService service = new HolydayService();

            service.addHoliday(new Holiday(LocalDate.parse("01/01/2023", fmt), "Confraternização mundial"));
            service.addHoliday(new Holiday(LocalDate.parse("21/02/2023", fmt), "Carnaval"));
            service.addHoliday(new Holiday(LocalDate.parse("17/04/2023", fmt), "Páscoa"));
            service.addHoliday(new Holiday(LocalDate.parse("21/04/2023", fmt), "Tiradentes"));
            service.addHoliday(new Holiday(LocalDate.parse("01/05/2023", fmt), "Dia do trabalho"));
            service.addHoliday(new Holiday(LocalDate.parse("08/06/2023", fmt), "Corpus Christi"));
            service.addHoliday(new Holiday(LocalDate.parse("07/09/2023", fmt), "Independência do Brasil"));
            service.addHoliday(new Holiday(LocalDate.parse("12/10/2023", fmt), "Nossa Senhora Aparecida"));
            service.addHoliday(new Holiday(LocalDate.parse("02/11/2023", fmt), "Finados"));
            service.addHoliday(new Holiday(LocalDate.parse("15/11/2023", fmt), "Proclamação da República"));
            service.addHoliday(new Holiday(LocalDate.parse("25/12/2023", fmt), "Natal"));
            
            int option = -1;
            
            do {
                System.out.println("Press one option below:");
                
                System.out.println("1: List all holidays orderded by Date");
                System.out.println("2: List all holidays orderded by Description");
                System.out.println("3: Add a holiday");
                System.out.println("0: Exit");
    
                System.out.print(" => ");
                option = sc.nextInt();
    
                if (option == 1) {
                    service.getHolidaysOrderByDate();
                    System.out.println(service);
                } else if (option == 2) {
                    service.getHolidaysOrderByDescription();
                    System.out.println(service);
                } else if (option == 3) {
                    System.out.print("Enter the date (dd/MM/yyyy): ");
                    sc.nextLine();
                    LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
                    System.out.print("Enter the description: ");
                    String description = sc.nextLine();
                    service.addHoliday(new Holiday(date, description));
                } else if (option == 0) {
                    System.out.println("Bye");
                } else {
                    System.out.println("Invalid option! Bye");
                }
    
                System.out.println();
    
            } while (option > 0 && option < 4);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input data");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date");
        } catch (Exception e) {
            System.out.println("Ooops");
        } finally {
            sc.close();
            System.out.println("--------------------------");
        }

    }
}
