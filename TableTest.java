package DataBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * It's the database's JUnit test case 
 * and it contains the test methods for the respective methods of the Table class.
 * It includes five test methods.
 * @author Tzavatoi
 *
 */
class TableTest {

  String[] cnames = {"Name", "Age", "Gender", "Occupation"};
  int cnumbers = 4;
  String[] entries  = {"John", "20", "Male", "Student"};
  ArrayList<String[]> data;
  Table testTable = new Table(cnumbers, cnames);

  int column;
  String string;

  @Test
  public void testAdd() {
    testTable.data.add(entries); //now that the database has values output is true
    assertTrue(!testTable.data.isEmpty());
  }

  @Test
  public void testSearch() {
    testAdd();
    column = 0;
    string = "John";
    ArrayList<Integer> results = testTable.search(column, string);
    assertEquals(1,results.size());
  }

  @Test
  void testEdit() {
    testSearch();
    column = 0;
    string = "John";
    int newColumn = 0;
    String s_new = "Jim";
    testTable.edit(column, string, newColumn, s_new);
    ArrayList<Integer> results = testTable.search(newColumn, s_new);
    assertEquals(1, results.size());
  }

  @Test
  void testDelete() {
    testSearch();
    column = 2;
    string = "Male";
    testTable.delete(column, string);
    assertTrue(!testTable.data.contains(string));
  }
  
  @Test 
  void testPrintColumns() {
    int currentSize = testTable.n;
    for (int i = 0; i < currentSize; i++) {
      assertEquals((i + 1) + ". " + cnames[i], (i + 1) + ". " + testTable.column_names[i]);
    }
  }
}



