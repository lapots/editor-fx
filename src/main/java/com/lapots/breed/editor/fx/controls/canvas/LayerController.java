package com.lapots.breed.editor.fx.controls.canvas;

import com.lapots.breed.editor.fx.controls.canvas.layer.CharacterLayer;
import com.lapots.breed.editor.fx.controls.canvas.layer.EmptyLayer;
import com.lapots.breed.editor.fx.controls.canvas.layer.GridLayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.lapots.breed.editor.fx.controls.UiConstants.LAYER_NAME_FORMAT;

@Data
public class LayerController {
    private Pane canvasPane;
    private GridLayer grid;
    private CharacterLayer character;
    private List<AbstractCanvasWrapper> layers = new ArrayList<>();
    private ObservableList<String> layersList = FXCollections.observableArrayList();

    public LayerController(Pane pane) {
        canvasPane = pane;

        grid = new GridLayer(canvasPane);
        grid.show();

        character = new CharacterLayer(canvasPane);
        character.show();
    }

    public void addEmptyLayer() {
        layers.add(new EmptyLayer(canvasPane));
        layersList.add(String.format(LAYER_NAME_FORMAT, layersList.size() + 1));

        checkVisibility();
    }

    public void toFront(int index) {
        layers.get(index).show();

        checkVisibility();
    }

    public void setGridVisibility() {
        checkAndSetVisibility(grid);
    }

    // not sure if needed
    public void setCharacterVisibility() {
        checkAndSetVisibility(character);
    }

    private void checkAndSetVisibility(AbstractCanvasWrapper layer) {
        if (layer.isVisible()) { layer.hide(); }
        else { layer.show(); }
    }

    private void checkVisibility() {
        if (grid.isVisible()) { grid.show(); }
        if (character.isVisible()) { character.show(); }
    }
}
