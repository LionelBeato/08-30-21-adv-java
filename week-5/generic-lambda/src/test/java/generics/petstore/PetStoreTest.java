package generics.petstore;

import org.junit.jupiter.api.Test;


class PetStoreTest {

    @Test
    void test() {
//        PetStore<Integer> integerPetStore = new PetStore<>();
        PetStore<Dog> dogPetStore = new PetStore<>();
        // Despite the fact that alligator is an animal
        // we cannot use it with our pet store type
        // because it does not implement Petable
//        PetStore<Alligator> alligatorPetStore = new PetStore<>();
    }
  
}