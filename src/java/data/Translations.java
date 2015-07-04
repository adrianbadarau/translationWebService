package data;


import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adrian
 */
@XmlRootElement(name = "translations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Translations {
    private ArrayList<TranslateElement> translations = new ArrayList<>();

    public ArrayList<TranslateElement> getTranslations() {
        return translations;
    }

    public void setTranslations(ArrayList<TranslateElement> translations) {
        this.translations = translations;
    }
}
