package DataBase;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The class which handles the interaction between the database and the user.
 * It consists of one constructor and ten methods.
 * @author Tzavatoi
 */
public class TableHelper {
  Table t;
  boolean created;
  
  public TableHelper(){
  }
    
  private boolean created() {
    if (!created) {
      System.out.println("Error: Table is not created!");
    }
    return created;
  }
    
  /**
   * Shapes the table that holds all the columns of our database and their titles respectively.
   * Boolean variable created informs whether the table has been created or not.
   */
  public void create() {
    Scanner in = new Scanner(System.in);
        
    if (created) {
      System.out.println("This will overwrite current table! Continue (y/n)?");
      String answer = in.next();
      if (!answer.equals("y")) {
        return;
      }
    }
        
    System.out.print("Enter number of columns: ");
    int N = in.nextInt();
        
    String[] column_names = new String[N];
    for (int i = 0; i < N; i++) {
      System.out.print("Enter name of column " + i + ": ");
      column_names[i] = in.next();
    }
        
    t = new Table(N, column_names);
    created = true;
  }
    
  /**
   * Inserts the values for each column by user's input.
   */
  public void add() {    
    if (!created()) {
      return;
    }
        
    Scanner in = new Scanner(System.in);
    System.out.println("Enter values: ");
    String[] values = new String[t.n];
    for (int i = 0; i < t.n; i++) {
      System.out.print(t.column_names[i] + ": ");
      values[i] = in.next();
    }
    t.add(values);
  }
  
  /**
   * Prints the database if it has been created.
   */
  public void show() {    
    if (!created()) {
      return;
    }
        
    t.printAll();
  }
    
  /**
   * Asks the user for a number that represents a column of the database.
   * The aforementioned number is held by the variable N. 
   * @return the column number or -1 if invalid column number is inserted 
   */
  private int selectColumn() {     //select columns via number
    Scanner in = new Scanner(System.in);
        
    System.out.println("Select column number");
    t.printColumns();
    System.out.print(": ");
        
    int N = in.nextInt();
    if (N < 0 || N >= t.n) {
      System.out.println("Invalid column number");
      return -1;
    } else {
      return N;
    }
  }
    
  /**
   * Uses selectColumn method 
   * and deletes a string from the rows of a specific column that both result from user input.
   */
  public void delete() {    
    if (!created()) {
      return;
    }
                
    int c = selectColumn();
    if (c == -1) {
      return;
    }
    System.out.print("Search value: " + t.column_names[c]  + " = ");
    Scanner in = new Scanner(System.in);
    String key = in.next();
    t.delete(c, key);
  }
    
  /**
   * Uses selectColumn method and then searches for a value inside it.
   * Next it uses selectColumn method again, for another column
   * and asks the user for a new value to put in the later column replacing an existing value.
   * Finally it calls the edit method of the Table class. 
   */
  public void edit() { 
    if (!created()) {
      return;
    }
                
    Scanner in = new Scanner(System.in);
                
    int c = selectColumn();
    if (c == -1) {
      return;
    }
    System.out.print("Search value: " + t.column_names[c]  + " = ");
    String key = in.next();
        
    System.out.println("Update value");
    int e = selectColumn();
    if (e == -1) {
      return;
    }
    System.out.print("New value: " + t.column_names[e]  + " = ");
    String snew = in.next();
        
    t.edit(c, key, e, snew);
  }
    
  /**
   * Method that uses select column and then asks the user for a value.
   * Calls search method of the Table class, for the given column and value.
   * and uses it as a parameter to call printSome method also in Table class.
   */
  public void select() {      
    if (!created()) {
      return;
    }
                
    int c = selectColumn();
    if (c == -1) {
      return;
    }
                
    System.out.print("Search value: " + t.column_names[c]  + " = ");
    Scanner in = new Scanner(System.in);
    String key = in.next();
    t.printSome(t.search(c, key));
  }
    
  /**
   * Exports all columns and rows to a csv file.
   * @exception FileNotFoundException - if the file can not be found
   */
  public void export() {      
    if (!created()) {
      return;
    }
        
    System.out.print("Give filename: ");
    Scanner in = new Scanner(System.in);
    String fname = in.next();
        
    try {  
      PrintWriter writer = new PrintWriter(fname + ".csv");
            
      //print column names
      for (int i = 0; i < t.n; i++) {
        //print before each column except first
        if (i > 0){
          writer.print(",");
        }
        writer.print(t.column_names[i]);
      }
      writer.print("\n");
            
      //print data
      for (int j = 0; j < t.data.size(); j++) {
        String[] value = t.data.get(j);
        for (int i = 0; i < t.n; i++) {
          //print before each column except first
          if (i > 0) {
            writer.print(",");
          }
          writer.print(value[i]);
        }
        writer.print("\n");
      }
      writer.close();
    
    } catch (FileNotFoundException e) { 
      System.err.println(e);
    }

    System.out.println(fname + ".csv: " + t.data.size() + " rows written");
  }
}
