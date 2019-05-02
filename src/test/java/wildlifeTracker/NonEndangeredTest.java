package wildlifeTracker;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;

public class NonEndangeredTest {
    @Rule
    public DatabaseRules database = new DatabaseRules();
    @Test
    public void NonEndangered_instantiatesCorrectly_true(){
        NonEndangered testanimal = new NonEndangered("hornets");
        assertEquals(testanimal instanceof NonEndangered, true);
    }
    @Test
    public void NonEndangered_instantiatesWithName_String(){
        NonEndangered testanimal = new NonEndangered("hornets");
        assertEquals("hornets", testanimal.getName());
    }
    @Test
    public void equals_returnsTrueIfAnimalNamesAreTrue_True(){
        NonEndangered firstAnimal = new NonEndangered("hornets");
        NonEndangered secondAnimal = new NonEndangered("hornets");
        assertTrue(firstAnimal.equals(secondAnimal));
    }
    @Test
    public void save_savesNonEndangeredAnimalsIntoDatabase(){
        NonEndangered testanimal = new NonEndangered("hornets");
        testanimal.save();
        assertTrue(NonEndangered.all().get(0).equals(testanimal));
    }
    @Test
    public void save_saveAssignsIdToNonEndangeredAnimal_int(){
        NonEndangered testAnimal = new NonEndangered("hornets");
        testAnimal.save();
        NonEndangered savedAnimal = NonEndangered.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfNonEndangeredAnimals_true(){
        NonEndangered firstAnimal = new NonEndangered("hornets");
        firstAnimal.save();
        NonEndangered secondAnimal = new NonEndangered("buffalo");
        secondAnimal.save();
        assertEquals(true, NonEndangered.all().get(0).equals(firstAnimal));
        assertEquals(true, NonEndangered.all().get(1).equals(secondAnimal));
    }
    @Test
    public void find_returnsNonEndangeredAnimalsWithSameId_firstAnimal(){
        NonEndangered firstAnimal = new NonEndangered("hornets");
        firstAnimal.save();
        NonEndangered secondAnimal = new NonEndangered("buffalo");
        secondAnimal.save();
        assertEquals(NonEndangered.find(firstAnimal.getId()), firstAnimal);
    }
}
