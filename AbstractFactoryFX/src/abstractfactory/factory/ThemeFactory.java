package abstractfactory.factory;

import abstractfactory.components.Center;
import abstractfactory.components.Toolbar;

public interface ThemeFactory {

    Toolbar createToolbar();

    Center createCenter();


}
