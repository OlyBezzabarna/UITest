package myTest;

    import org.example.Species;
import org.example.family.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class PetTest {

        @Test
        public void testToString() {
            Pet pet = new Pet(Species.CAT, "Боня", 4, 5,
                    new String[]{"любит спать целый день", "и гулять всю ночь"});
            String petExpectedToString = "Pet{species=CAT, nickname='Боня', age=4, trickLevel=5, habits=[любит спать целый день, и гулять всю ночь]}";
            Assertions.assertEquals(petExpectedToString, pet.toString());

            Pet dog = new Pet(Species.DOG, "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
            String dogExpectedToString = "Pet{species=DOG, nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}";
            Assertions.assertEquals(dogExpectedToString, dog.toString());
        }

    }

