package wildlifeTracker;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;

public class EndangeredTest{
    @Rule
    public DatabaseRules database = new DatabaseRules();
    @Test
    public void endangered_instantiatesCorrectly_true(){
        Endangered testAnimal = new Endangered("cheetah","okay", "young");
        assertEquals(testAnimal instanceof Endangered, true);
    }
    @Test
    public void endangered_instantiatesWithAnimalName_String(){
        Endangered testAnimal = new Endangered("cheetah","okay", "young");
        assertEquals("cheetah", testAnimal.getName());
    }
    @Test
    public void endangered_instantiatesWIthAnimalHealth_String(){
        Endangered testAnimal = new Endangered("cheetah","okay", "young");
        assertEquals("okay", testAnimal.getHealth());
    }
    @Test
    public void endangered_instantiatesWithAgeOfAnimal_String(){
        Endangered testAnimal = new Endangered("cheetah","okay", "young");
        assertEquals("young", testAnimal.getAge());
    }
    @Test
    public void save_savesEndangeredAnimalObjectsIntoDB(){
        Endangered testAnimal = new Endangered("cheetah","okay", "young");
        testAnimal.save();
        assertTrue(Endangered.all().get(0).equals(testAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfEndangeredAnimals_true(){
        Endangered firstAnimal = new Endangered("cheetah","okay", "young");
        firstAnimal.save();
        Endangered secondAnimal = new Endangered("lion","healthy", "adult");
        secondAnimal.save();
        assertEquals(true, Endangered.all().get(0).equals(firstAnimal));
        assertEquals(true, Endangered.all().get(1).equals(secondAnimal));
    }
    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondAnimal(){
        Endangered firstAnimal = new Endangered("cheetah","okay", "young");
        firstAnimal.save();
        Endangered secondAnimal = new Endangered("lion","healthy", "adult");
        secondAnimal.save();
        assertEquals(Endangered.find(secondAnimal.getId()), secondAnimal);
    }

}
