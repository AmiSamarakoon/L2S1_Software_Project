package com.example.demo.service;

import com.example.demo.dao.TrainingSessionDao;
import com.example.demo.model.TrainingSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrainingSessionService {

    private final TrainingSessionDao trainingSessionDao;

    @Autowired
    public TrainingSessionService(@Qualifier("fakeDao")TrainingSessionDao trainingSessionDao) {
        this.trainingSessionDao = trainingSessionDao;
    }


    public int addTrainingSession(TrainingSession trainingSession){
        return trainingSessionDao.insertTrainingSession(trainingSession);
    }

    public List<TrainingSession> getAllTrainingSession(){
        return trainingSessionDao.selectAllTrainingSession();
    }

    public Optional<TrainingSession> getTrainingSessionById(UUID sessionId){
        return trainingSessionDao.selectTrainingSessionById(sessionId);
    }

    public int deleteTrainingSession(UUID sessionId){
        return trainingSessionDao.deleteTrainingSessionById(sessionId);
    }

    public int updateTrainingSession(UUID sessionId,TrainingSession newTrainingSession){
        return trainingSessionDao.updateTrainingSessionById(sessionId,newTrainingSession);
    }
}
