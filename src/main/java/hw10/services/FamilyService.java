package hw10.services;

import hw10.dao.FamilyDao;
import hw10.human.Family;
import hw10.human.Human;
import hw10.human.Man;
import hw10.human.Woman;
import hw10.pet.Pet;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyService {

    private final FamilyDao dao;

    public FamilyService(FamilyDao familyDao) {
        this.dao = familyDao;
    }

    public List<Family> getAllFamilies(){
        return dao.getAllFamilies();
    }

    public void displayAllFamilies(){
        dao.getAllFamilies().forEach(family -> System.out.printf("%d. %s\n", getAllFamilies().indexOf(family)+1,family.toString()));
    }

    public void getFamiliesBiggerThan(int size){
             dao.getAllFamilies().stream().filter(family-> family.countFamily()>size).forEach(family -> System.out.printf("%s\n", family.toString()));
    }

    public void getFamiliesLessThan(int size){
       dao.getAllFamilies().stream().filter(family-> family.countFamily()<size).forEach(family -> System.out.printf("%s\n",family.toString()));
    }

    public int countFamiliesWithMemberNumber(int memberCount){
        List<Family> families = dao.getAllFamilies();
        families = families.stream().filter(family -> family.countFamily() == memberCount).collect(Collectors.toList());
        return families.size();
    }

    public void createNewFamily(Human father, Human mother){
        dao.saveFamily(new Family( father, mother));
    }

    public boolean deleteFamilyByIndex(int index){
        return dao.deleteFamily(dao.getFamilyByIndex(index));
    }

    public Family bornChild(Family family, String boyName, String girlName) throws ParseException {
        if (!dao.getAllFamilies().contains(family)) dao.saveFamily(family);
        Random random = new Random();
        String surname = family.getFather().getSurname();
        LocalDate birthDate = LocalDate.now();
        Human child;
        if (random.nextBoolean()) child = new Man(boyName,surname, birthDate.toEpochDay(), family);
        else child = new Woman(girlName, surname, birthDate.toEpochDay(), family);
        family.addChild(child);
        return family;
    }

    public Family adoptChild(Family family, Human human){
        if (getAllFamilies().contains(family)) family.addChild(human);
        else {
            family.addChild(human);
            dao.saveFamily(family);
        }
        return family;
    }

    public void  deleteAllChildrenOlderThen(int age){
        LocalDate year = LocalDate.now();

        getAllFamilies().forEach(family -> {
            Iterator<Human> humanIterator = family.getChildren().iterator();
            ArrayList<Human> youngChildren = new ArrayList<>();
            while (humanIterator.hasNext()){
                Human human = humanIterator.next();
                if (Period.between(LocalDate.ofEpochDay(human.getYear()), year).getYears() < age)
                    youngChildren.add(human);
            }
            family.setChildren(youngChildren);
        });
    }

    public int count(){
        return dao.getAllFamilies().size();
    }

    public Family getFamilyById(int id){
        return dao.getFamilyByIndex(id);
    }

    public Set<Pet> getPets(int id){
        return getFamilyById(id).getPet();
    }

    public void addPet(int index, Pet pet){
        getFamilyById(index).addPet(pet);
    }


}
