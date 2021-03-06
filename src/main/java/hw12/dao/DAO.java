package hw12.dao;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.List;

public interface DAO<T>{

     List<T> getAllFamilies();
     T getFamilyByIndex(int index);
     boolean deleteFamily(T family);
     boolean deleteFamily(int index);
     void saveFamily(T family);

}
