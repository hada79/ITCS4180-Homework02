package com.jasonhada.homework02;

import java.io.Serializable;

public class Evaluation implements Serializable{
    String nickname;
    String study;
    int avatarImageId;
    int structured;
    int deadlines;
    int aligned;

    public Evaluation(String nickname, String study, int avatarImageId, int structured, int deadlines, int aligned) {
        this.nickname = nickname;
        this.study = study;
        this.avatarImageId = avatarImageId;
        this.structured = structured;
        this.deadlines = deadlines;
        this.aligned = aligned;
    }
}
