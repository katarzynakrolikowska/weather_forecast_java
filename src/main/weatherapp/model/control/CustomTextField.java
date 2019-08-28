package main.weatherapp.model.control;

import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.util.Map;
import java.util.stream.Collectors;

public class CustomTextField {

    public static void setAutoCompleteTextField(TextField textField, Map<String, Integer> map) {

        TextFields.bindAutoCompletion(textField, t -> {
            return map.keySet().stream().filter(elem
                    -> {
                return elem.toLowerCase().startsWith(t.getUserText().toLowerCase());
            }).collect(Collectors.toList());
        });
    }
}
