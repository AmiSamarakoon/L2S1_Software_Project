package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class TrainingSession {

    private final UUID sessionId;

    @NotBlank
    private final String sessionName;

    @NotBlank
    private final Date startDate;

    @NotBlank
    private final double duration;

    @NotBlank
    private final int maxParticipants;

    @NotBlank
    private final String ifsApplicationVersion;

    @NotBlank
    private final double bufferTime;

    @NotBlank
    private final String managerComment;

    @NotBlank
    private final String deliveryMethod;

    public TrainingSession(@JsonProperty("sessionId") UUID sessionId,
                           @JsonProperty("sessionName") String sessionName,
                           @JsonProperty("startDate") Date startDate,
                           @JsonProperty("duration") double duration,
                           @JsonProperty("maxParticipants") int maxParticipants,
                           @JsonProperty("ifsApplicationVersion") String ifsApplicationVersion,
                           @JsonProperty("bufferTime") double bufferTime,
                           @JsonProperty("managerComment") String managerComment,
                           @JsonProperty("deliveryMethod") String deliveryMethod) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.startDate = startDate;
        this.duration = duration;
        this.maxParticipants = maxParticipants;
        this.ifsApplicationVersion = ifsApplicationVersion;
        this.bufferTime = bufferTime;
        this.managerComment = managerComment;
        this.deliveryMethod = deliveryMethod;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public double getDuration() {
        return duration;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public String getIfsApplicationVersion() {
        return ifsApplicationVersion;
    }

    public double getBufferTime() {
        return bufferTime;
    }

    public String getManagerComment() {
        return managerComment;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }


}
