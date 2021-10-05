package me.coley.recaf.ui.control.config;

import javafx.scene.control.CheckBox;
import me.coley.recaf.config.ConfigContainer;
import me.coley.recaf.util.ReflectUtil;

import java.lang.reflect.Field;

/**
 * Component for {@code boolean} config values.
 *
 * @author Matt Coley
 */
public class ConfigBoolean extends CheckBox {
	/**
	 * @param instance
	 * 		Config container.
	 * @param field
	 * 		Config field.
	 * @param text
	 * 		Text to represent the field.
	 */
	public ConfigBoolean(ConfigContainer instance, Field field, String text) {
		super(text);
		setSelected(ReflectUtil.quietGet(instance, field));
		selectedProperty().addListener((observable, old, current) -> ReflectUtil.quietSet(instance, field, current));
	}
}
