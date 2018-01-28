package com.lapots.breed.editor.domain;

import lombok.Data;

@Data
public class PlayerSkeleton {
    private BodyOval head;
    private BodyOval pelvis;
    private BodyOval leftHipJoint;
    private BodyOval rightHipJoint;
}
