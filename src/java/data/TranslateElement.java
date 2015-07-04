package data;


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

@XmlRootElement(name = "translation") 
@XmlAccessorType(XmlAccessType.FIELD)
public class TranslateElement {
    private String fromLang, toLang, fromWord, toWord;

    public String getFromLang() {
        return fromLang;
    }

    public void setFromLang(String fromLang) {
        this.fromLang = fromLang;
    }

    public String getToLang() {
        return toLang;
    }

    public void setToLang(String toLang) {
        this.toLang = toLang;
    }

    public String getFromWord() {
        return fromWord;
    }

    public void setFromWord(String fromWord) {
        this.fromWord = fromWord;
    }

    public String getToWord() {
        return toWord;
    }

    public void setToWord(String toWord) {
        this.toWord = toWord;
    }
}
