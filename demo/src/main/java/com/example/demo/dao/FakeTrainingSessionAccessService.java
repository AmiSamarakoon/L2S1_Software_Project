package com.example.demo.dao;


import com.example.demo.model.TrainingSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")

public class FakeTrainingSessionAccessService implements TrainingSessionDao{

    private static List<TrainingSession> DB= new ArrayList<>();

    @Override
    public int insertTrainingSession(UUID sessionId, TrainingSession trainingSession) {
        DB.add(
                new TrainingSession(
                        sessionId,
                        trainingSession.getSessionName(),
                        trainingSession.getStartDate(),
                        trainingSession.getDuration(),
                        trainingSession.getMaxParticipants(),
                        trainingSession.getIfsApplicationVersion(),
                        trainingSession.getBufferTime(),
                        trainingSession.getManagerComment(),
                        trainingSession.getDeliveryMethod()
                        ));
        return 1;
    }


    @Override
    public List<TrainingSession> selectAllTrainingSession() {
        return DB;
    }

    @Override
    public Optional<TrainingSession> selectTrainingSessionById(UUID sessionId) {
        return DB.stream()
                .filter(TrainingSession -> TrainingSession.getSessionId().equals(sessionId))
                .findFirst();
    }

    @Override
    public int deleteTrainingSessionById(UUID sessionId) {
        Optional<TrainingSession> trainingSessionMaybe = selectTrainingSessionById(sessionId);
        if(trainingSessionMaybe.isPresent()){
            DB.remove(trainingSessionMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateTrainingSessionById(UUID sessionId, TrainingSession updateTrainingSession) {

        return selectTrainingSessionById(sessionId)
                .map(TrainingSession ->{
                    int indexOfTrainingSessionToUpdate = DB.indexOf(TrainingSession);
                    if(indexOfTrainingSessionToUpdate>=0){
                        DB.set(indexOfTrainingSessionToUpdate,new TrainingSession(
                                sessionId,
                                updateTrainingSession.getSessionName(),
                                updateTrainingSession.getStartDate(),
                                updateTrainingSession.getDuration(),
                                updateTrainingSession.getMaxParticipants(),
                                updateTrainingSession.getIfsApplicationVersion(),
                                updateTrainingSession.getBufferTime(),
                                updateTrainingSession.getManagerComment(),
                                updateTrainingSession.getDeliveryMethod()
                                ));
                        return 1;
                    }
                    return 0;
                } )
                .orElse(0);
    }
}
