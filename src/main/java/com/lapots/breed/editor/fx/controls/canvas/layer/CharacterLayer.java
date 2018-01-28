package com.lapots.breed.editor.fx.controls.canvas.layer;

import com.lapots.breed.editor.domain.BodyOval;
import com.lapots.breed.editor.domain.PlayerSkeleton;
import com.lapots.breed.editor.fx.controls.canvas.AbstractCanvasWrapper;
import com.lapots.breed.editor.fx.controls.canvas.LayerUtils;
import com.lapots.breed.editor.fx.controls.canvas.MathUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import static com.lapots.breed.editor.fx.controls.UiConstants.*;

public class CharacterLayer extends AbstractCanvasWrapper {
    private Canvas layer;
    private PlayerSkeleton playerSkeleton;

    public CharacterLayer(Pane pane) {
        super(pane);
    }

    public PlayerSkeleton getPlayerSkeleton() {
        return playerSkeleton;
    }

    @Override
    protected void init(Pane pane) {
        layer = LayerUtils.createLayer(pane.getPrefWidth(), pane.getPrefHeight(), BLANK_COLOR);
        double roundCanvasHeight = MathUtils.nearestDivision(layer.getHeight(), GRID_LINES_NUMBER);
        double gridLineOffset = roundCanvasHeight / GRID_LINES_NUMBER;

        playerSkeleton = new PlayerSkeleton();
        // TODO: there ought to be a way to define roundCanvasHeight and gridLineOffset in separate objects
        playerSkeleton.setHead(createHeadOval(roundCanvasHeight, gridLineOffset));
        playerSkeleton.setPelvis(createPelvisOval(roundCanvasHeight, gridLineOffset));
        playerSkeleton.setLeftHipJoint(createLeftHipJoint(playerSkeleton.getPelvis()));
        playerSkeleton.setRightHipJoint(createRightHipJoint(playerSkeleton.getPelvis(),
                playerSkeleton.getLeftHipJoint()));

        drawCharacterCircle(0, playerSkeleton.getHead().getTopLeftX(), playerSkeleton.getHead().getTopLeftY(),
                playerSkeleton.getHead().getHeight(), playerSkeleton.getHead().getWidth());
        drawCharacterCircle(3, playerSkeleton.getPelvis().getTopLeftX(), playerSkeleton.getPelvis().getTopLeftY(),
                playerSkeleton.getPelvis().getHeight(), playerSkeleton.getPelvis().getWidth());
        drawCharacterCircle(3, playerSkeleton.getLeftHipJoint().getTopLeftX(),
                playerSkeleton.getLeftHipJoint().getTopLeftY(), playerSkeleton.getLeftHipJoint().getHeight(),
                playerSkeleton.getLeftHipJoint().getWidth());
        drawCharacterCircle(3, playerSkeleton.getRightHipJoint().getTopLeftX(),
                playerSkeleton.getRightHipJoint().getTopLeftY(), playerSkeleton.getRightHipJoint().getHeight(),
                playerSkeleton.getRightHipJoint().getWidth());

        setCanvas(layer);
    }

    private void drawCharacterCircle(int index, double leftTopX, double leftTopY, double height, double width) {
        GraphicsContext gc = layer.getGraphicsContext2D();
        gc.setStroke(CHARACTER_LINE_COLOR);
        gc.setLineWidth(CHARACTER_LINE_WIDTH);
        gc.strokeOval(leftTopX, leftTopY, width, height);
    }

    private double getXOffset(double circleWidth) {
        return layer.getWidth() / 2 - circleWidth / 2;
    }

    private BodyOval createHeadOval(double roundCanvasHeight, double gridBlockHeight) {
        BodyOval head = new BodyOval();
        head.setHeight(roundCanvasHeight / GRID_LINES_NUMBER);
        head.setWidth(OVAL_WIDTH);
        head.setTopLeftX(getXOffset(OVAL_WIDTH));
        head.setTopLeftY(gridBlockHeight);
        return head;
    }

    private BodyOval createPelvisOval(double roundCanvasHeight, double gridBlockHeight) {
        BodyOval pelvis = new BodyOval();
        pelvis.setHeight(roundCanvasHeight / GRID_LINES_NUMBER);
        pelvis.setWidth(OVAL_WIDTH * 1.5);
        pelvis.setTopLeftX(getXOffset(pelvis.getWidth()));
        pelvis.setTopLeftY(gridBlockHeight * 4);
        return pelvis;
    }

    private BodyOval createLeftHipJoint(BodyOval pelvis) {
        BodyOval lHipJoint = new BodyOval();
        lHipJoint.setHeight(pelvis.getHeight() / 4);
        lHipJoint.setWidth(OVAL_WIDTH / 4);
        lHipJoint.setTopLeftX(pelvis.getTopLeftX() - lHipJoint.getWidth() / 2);
        lHipJoint.setTopLeftY(pelvis.getTopLeftY() - lHipJoint.getHeight() / 4
                + pelvis.getHeight() - lHipJoint.getHeight());
        return lHipJoint;
    }

    private BodyOval createRightHipJoint(BodyOval pelvis, BodyOval leftHipJoint) {
        BodyOval rHipJoint = new BodyOval();
        rHipJoint.setHeight(leftHipJoint.getHeight());
        rHipJoint.setWidth(leftHipJoint.getWidth());
        rHipJoint.setTopLeftX(pelvis.getTopLeftX() - rHipJoint.getWidth() / 2 + pelvis.getWidth());
        rHipJoint.setTopLeftY(leftHipJoint.getTopLeftY());
        return rHipJoint;
    }
}
