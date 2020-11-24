package services;

import dao.ScheduleDao;
import models.Schedule;

public class ScheduleService {
    private ScheduleDao scheduleDao = new ScheduleDao();

    public ScheduleService(){}

    public void saveSchedule(Schedule Schedule){
        scheduleDao.save(Schedule);
    }

    public Schedule findSchedule(int id){
        return scheduleDao.findById(id);
    }
}
