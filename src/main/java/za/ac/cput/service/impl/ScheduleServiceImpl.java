package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Payment;
import za.ac.cput.entity.Schedule;
import za.ac.cput.repository.IScheduleRepository;
import za.ac.cput.service.ScheduleService;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private IScheduleRepository repository;

    private ScheduleServiceImpl(IScheduleRepository repository){
        this.repository = repository;
    }

    @Override
    public Schedule create(Schedule schedule) {
        return this.repository.save(schedule);
    }

    @Override
    public Schedule read(String s) {
        return (Schedule) this.repository.findById(s).orElse(null);
    }

    @Override
    public Schedule update(Schedule schedule) {
        if(this.repository.existsById(schedule.getScheduleID())){
            return this.repository.save(schedule);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
