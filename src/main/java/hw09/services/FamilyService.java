package hw09.services;

import hw09.app.Human;
import hw09.app.Pet;
import hw09.dao.FamilyDao;
import hw09.app.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {

    FamilyDao familyDao = new FamilyDao();

    public List<Family> getAllFamilies(){
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies(){
        familyDao.getAllFamilies().forEach(System.out::println);
    }

    public void getFamiliesBiggerThan(int size){
             familyDao.getAllFamilies().stream().filter(i->Family.count>size).forEach(System.out::println);
    }

    public void getFamiliesLessThan(int size){
       familyDao.getAllFamilies().stream().filter(i->Family.count<size).forEach(System.out::println);
    }

    public void countFamiliesWithMemberNumber(){
        familyDao.getAllFamilies().stream().filter(i->familyDao.getAllFamilies().size()==Family.count).forEach(System.out::println);
    }

    public void createNewFamily(Human father, Human mother){
        familyDao.getAllFamilies().add(new Family(father, mother));
    }

    public void deleteFamilyByIndex(int index){
        familyDao.getAllFamilies().remove(index);
    }

    public Family bornChild(Family family, String gender){
        System.out.println(family.toString());
        if (gender.equals("masculine")){
            Human me =  new Human("Aqil", "Aghamirzayev",1999);
            family.addChild(me);
        } else if (gender.equals("feminine")){
            Human me =  new Human("Aysu", "Aghamirzayeva", 2003);
            family.addChild(me);
        }
        return family;
    }

    public Family adoptChild(Family family, Human human){
        family.addChild(human);
        return family;
    }

    public List<Human> deleteAllChildrenOlderThen(int age){
              return familyDao.getAllFamilies().get(0).children.stream().filter(k->k.getAge()<age).collect(Collectors.toList());
    }

    public int count(){
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int id){
        return familyDao.getAllFamilies().get(id-1);
    }

    public ArrayList<Pet> getPets(int id){
        return familyDao.getAllFamilies().get(id-1).getPets();
    }

    public void addPet(int index, Pet pet){
        familyDao.getAllFamilies().get(index-1).getPets().add(pet);
    }
}
