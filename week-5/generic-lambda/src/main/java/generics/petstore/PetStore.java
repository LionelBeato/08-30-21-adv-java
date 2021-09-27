package generics.petstore;

import java.util.List;

//
public class PetStore<T extends Petable> {

    private String name;
    private List<T> listOfPets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getListOfPets() {
        return listOfPets;
    }

    public void setListOfPets(List<T> listOfPets) {
        this.listOfPets = listOfPets;
    }


}
