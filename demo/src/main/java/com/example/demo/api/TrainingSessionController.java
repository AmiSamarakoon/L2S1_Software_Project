package com.example.demo.api;

import com.example.demo.model.TrainingSession;
import com.example.demo.service.TrainingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/trainingSession")
@RestController

public class TrainingSessionController {

    private final TrainingSessionService trainingSessionService;

    @Autowired
    public TrainingSessionController(TrainingSessionService trainingSessionService) {
        this.trainingSessionService = trainingSessionService;
    }
    @PostMapping
    public void addTrainingSession(@Valid @NonNull @RequestBody TrainingSession trainingSession){
        trainingSessionService.addTrainingSession(trainingSession);
    }

    @GetMapping
    public List<TrainingSession> getAllTrainingSession(){
        return trainingSessionService.getAllTrainingSession();
    }

    @GetMapping(path = "{sessionId}")
    public TrainingSession getTrainingSessionById(@PathVariable("sessionId") UUID sessionId){
        return trainingSessionService.getTrainingSessionById(sessionId)
                .orElse(null);

    }

    @DeleteMapping(path="{sessionId}")
    public void deleteTrainingSessionById(@PathVariable("sessionId") UUID sessionId){
        trainingSessionService.deleteTrainingSession(sessionId);
    }

    @PutMapping(path="{sessionId}")
    public void updateTrainingSession(@PathVariable("sessionId") UUID sessionId,@Valid @NonNull @RequestBody TrainingSession trainingSessionToUpdate){
        trainingSessionService.updateTrainingSession(sessionId,trainingSessionToUpdate);
    }
}
