package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Schedule;
import za.ac.cput.factory.ScheduleFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ScheduleServiceImplTest {

    @Autowired
    private ScheduleServiceImpl service;

    Schedule schedule = ScheduleFactory.createSchedule(LocalDateTime.of(2022, 4, 7, 2 ,15 ) ,LocalDateTime.now());
    ;

    @Test
    void a_create() {
        Schedule created = this.service.create(schedule);
        assertNotNull(created);
        System.out.println("Create : " + created);
    }

    @Test
    void b_read() {
        Schedule save =this.service.update(schedule);
        String read = schedule.getScheduleID();
        System.out.println("Read reservation: " + read);
    }

    @Test
    void c_update() {
        Schedule updated = new Schedule.Builder().copy(schedule).build();
        assertNull(service.create(updated));
        System.out.println("Update : " + updated);
    }

    @Test
    void d_delete() {
        boolean delete = this.service.delete(schedule.getScheduleID());
        assertTrue(delete);
    }
}