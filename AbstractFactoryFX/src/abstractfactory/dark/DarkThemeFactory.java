package abstractfactory.dark;

import abstractfactory.components.Center;
import abstractfactory.components.Toolbar;
import abstractfactory.factory.ThemeFactory;

public class DarkThemeFactory implements ThemeFactory {

    @Override
    public Toolbar createToolbar() {
        return new DarkToolbar();
    }

    @Override
    public Center createCenter() {
        return new DarkCenter();
    }
}
