package by.academy.pharmacy.service.util;

import java.util.Locale;
import java.util.ResourceBundle;

import static by.academy.pharmacy.entity.Constant.DE;
import static by.academy.pharmacy.entity.Constant.DE1;
import static by.academy.pharmacy.entity.Constant.EN;
import static by.academy.pharmacy.entity.Constant.ES;
import static by.academy.pharmacy.entity.Constant.ES1;
import static by.academy.pharmacy.entity.Constant.LANGUAGES_TEXT;
import static by.academy.pharmacy.entity.Constant.RU;
import static by.academy.pharmacy.entity.Constant.RU1;
import static by.academy.pharmacy.entity.Constant.US;

public enum ContentManager {
    /**
     * A constant holding Locale object which references to the file
     * "text_de_DE.properties".
     */
    DE_DE(ResourceBundle.getBundle(
            LANGUAGES_TEXT, new Locale(DE, DE1))),
    /**
     * A constant holding Locale object which references to the file
     * "text_en_US.properties".
     */
    EN_US(ResourceBundle.getBundle(
            LANGUAGES_TEXT, new Locale(EN, US))),
    /**
     * A constant holding Locale object which references to the file
     * "text_es_ES.properties".
     */
    ES_ES(ResourceBundle.getBundle(
            LANGUAGES_TEXT, new Locale(ES, ES1))),
    /**
     * A constant holding Locale object which references to the file
     * "text_ru_RU.properties".
     */
    RU_RU(ResourceBundle.getBundle(
            LANGUAGES_TEXT, new Locale(RU, RU1)));

    /**
     * Internal state variable, which contains ResourceBundle value and named
     * "bundle".
     */
    private final ResourceBundle bundle;

    ContentManager(final ResourceBundle newBundle) {
        bundle = newBundle;
    }

    /**
     * Gets string value of the key in property file.
     *
     * @param key references to string which should be print.
     * @return string value of the key.
     */
    public String getString(final String key) {
        return bundle.getString(key);
    }
}
