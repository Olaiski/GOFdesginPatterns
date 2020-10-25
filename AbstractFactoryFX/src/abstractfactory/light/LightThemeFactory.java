package abstractfactory.light;

import abstractfactory.components.Center;
import abstractfactory.components.Toolbar;
import abstractfactory.factory.ThemeFactory;

public class LightThemeFactory implements ThemeFactory {

    @Override
    public Toolbar createToolbar() {
        return new LightToolbar();
    }

    @Override
    public Center createCenter() {
        return new LightCenter();
    }
}
