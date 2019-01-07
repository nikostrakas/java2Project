package DataBase;

import java.util.Scanner;

/**
 * The database's main class.
 * It manages the menu of our database. 
 * @author Tzavatoi
 * 
 */
public class DB {

  public static void main(String[] args) {
    TableHelper th = new TableHelper();
        
    int choice;
    while ((choice = menu()) != 0) {
      switch (choice){
        case 1:
          th.create();
          break;
        case 2:
          th.add();
          break;
        case 3:
          th.edit();
          break;
        case 4:
          th.delete();
          break;
        case 5:
          th.select();
          break;
        case 6:
          th.show();
          break;
        case 7:
          th.export();
          break;                    
        default:
          System.out.println("Wrong choice!");
      }
    }
        
  }
    
  private static int menu() {
    System.out.println("\n1. Create table");
    System.out.println("2. Insert entry");
    System.out.println("3. Modify entry");
    System.out.println("4. Delete entry");
    System.out.println("5. Select entries");
    System.out.println("6. Show all entries");
    System.out.println("7. Export to file");        
    System.out.println("0. Exit");
    System.out.print(": ");
        
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    return N;
      
  }  
}

