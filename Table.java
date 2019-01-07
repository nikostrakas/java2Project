package DataBase;

import java.util.ArrayList;

/**
 * The Class which holds the basic operations of our database.
 * It consists of one constructor and seven methods.
 * @author Tzavatoi
 */
public class Table {
  String[] column_names;
  int n;
  ArrayList<String[]> data;
    
  /**
   * Constructor inserts the data in an ArrayList
   * @param n - the number of columns.
   * @param column_names - the Array which holds the names of each column.
   */
  public Table(int n, String[] column_names) {    
    this.n = n;
    this.column_names = column_names;
    data = new ArrayList<String[]>();
  }
    
  /**
   * The method used to insert the values in our database.
   * @param entry - the Array that contains the values to be added in the database.
   */
  public void add(String[] entry) {        
    data.add(entry);
  }
    
  /**
   * Searches the database by the number of a column and an entry 
   * and saves the index of the entry in an ArrayList.
   * @param col - the column to be searched
   * @param s - the entry to be found
   * @return result - the ArrayList which holds the indices where the entry is found
   */
  public ArrayList<Integer> search(int col, String s) { 
    if (col > n) {
      System.out.println("Error: column number bigger than existing columns");
      return null;
    }
        
    ArrayList<Integer> results = new ArrayList<Integer>();
    for (int counter = 0; counter < data.size(); counter++) {
      if (data.get(counter)[col].equals(s)) {
        results.add(counter);
      }
    }
    return results;
  }

  /**
   * Is responsible for deleting values from the database.
   * The values are those whose indexes are contained in the ArrayList.   
   * @param col - the columns where the value is held
   * @param s - the string value to be deleted
   */
  public void delete(int col, String s) { 
    ArrayList<Integer> indices = search(col, s);
       
    //we delete from the bottom to start of indices, so index is valid!!
    for (int i = indices.size() - 1; i >= 0; i--) {
      int index = indices.get(i);
      data.remove(index);
    }
        
    System.out.println("Rows affected: " + indices.size());
  } 
    
  /**
   * Is responsible for editing values of the database.
   * @param col - the columns where the string is to be found
   * @param s - the string to be eddited
   * @param e - the column where the new string will be held
   * @param s_new - the new string
   */
  public void edit(int col, String s, int e, String s_new) {
    ArrayList<Integer> indices = search(col, s);
       
    for (int i = 0; i < indices.size(); i++) {
      int index = indices.get(i);
      String[] value = data.get(index);
      value[e] = s_new;
      data.set(index, value);
    }
        
    System.out.println("Rows affected: " + indices.size());
  } 
    
  /**
   * Prints the column names.
   */
  public void printColumns() {   
    int i;
    for (i = 0; i < n; i++) {
      System.out.print(i + ". " + column_names[i] + "\t");
    }
    System.out.print("\n"); 
  }
    
  /**
   * Prints the number of rows in the database, the column names and each value in the database.
   */
  public void printAll() { 
    System.out.println("Rows: " + data.size());
        
    printColumns();
        
    for (int j = 0; j < data.size(); j++) {
      String[] value = data.get(j);
      for (int i = 0; i < n; i++) {
        System.out.print(value[i] + "\t");
      }
      System.out.print("\n");
    }
  }
    
  /**
   * It is used after having completed a search for specific strings in the database 
   * and having saved their indices in an ArrayList. 
   * It then prints the number of rows where these specific strings were found.
   * Also prints the column names and the specific strings.
   * @param indices - the ArrayList that holds the indices of the strings to be printed
   */
  public void printSome(ArrayList<Integer> indices) {  
    System.out.println("Rows: " + indices.size());
        
    printColumns();
        
    for (int j = 0; j < indices.size(); j++) {
      String[] value = data.get(indices.get(j));
      for (int i = 0; i < n; i++) {
        System.out.print(value[i] + "\t");
      }
      System.out.print("\n");
    }
  }
}
