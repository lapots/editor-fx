package com.lapots.breed.editor.fx.controls.canvas;

import com.lapots.breed.editor.fx.controls.canvas.layer.CharacterLayer;
import com.lapots.breed.editor.fx.controls.canvas.layer.EmptyLayer;
import com.lapots.breed.editor.fx.controls.canvas.layer.GridLayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;;
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

        // addEmptyLayer(); // initial layer
        grid = new GridLayer(canvasPane);
        grid.show();

        character = new CharacterLayer(canvasPane);
        character.show();
    }

    public void addEmptyLayer() {
        layers.add(new EmptyLayer(canvasPane));
        layersList.add(String.format(LAYER_NAME_FORMAT, layersList.size() + 1));

        if (grid.isVisible()) { grid.show(); }
        if (character.isVisible()) { character.show(); }
    }

    public void toFront(int index) {
        layers.get(index).show();

        if (grid.isVisible()) { grid.show(); }
        if (character.isVisible()) { character.show(); }
    }

    public void setGridVisibility() {
        if (grid.isVisible()) { grid.hide(); }
        else { grid.show(); }
    }

    // not sure if needed
    public void setCharacterVisibility() {
        if (character.isVisible()) { character.hide(); }
        else { character.show(); }
    }
}
