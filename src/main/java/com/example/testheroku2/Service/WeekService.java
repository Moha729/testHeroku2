package com.example.testheroku2.Service;

import com.example.testheroku2.Repository.WeekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeekService {


    @Autowired
    WeekRepo weekRepo;

    public int currentWeek;

/*
    public void updateWeek (int updatedWeek) {
        weekRepo.updateWeek(updatedWeek);
    }

    public int getBeforeWeek() {
        return weekRepo.beforeWeek();
    }
*/
}
