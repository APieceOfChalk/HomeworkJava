package services;

import dao.TestDao;
import models.Test;
import models.Test_list;

import java.util.List;

public class TestService {
    private TestDao testDao = new TestDao();

    public TestService(){}

    public void saveTest(Test test){
        testDao.save(test);
    }

    public Test findTest(int id){
        return testDao.findById(id);
    }

}
