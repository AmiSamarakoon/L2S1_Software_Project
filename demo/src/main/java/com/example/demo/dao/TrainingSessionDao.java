package com.example.demo.dao;

import com.example.demo.model.TrainingSession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TrainingSessionDao {

    int insertTrainingSession(UUID sessionId, TrainingSession trainingSession);

    default int insertTrainingSession(TrainingSession trainingSession){
        UUID sessionId=UUID.randomUUID();
        return insertTrainingSession(sessionId,trainingSession);
    }

    List<TrainingSession> selectAllTrainingSession();

    Optional<TrainingSession> selectTrainingSessionById(UUID sessionId);

    int deleteTrainingSessionById(UUID sessionId);

    int updateTrainingSessionById(UUID sessionId, TrainingSession trainingSession);

}
