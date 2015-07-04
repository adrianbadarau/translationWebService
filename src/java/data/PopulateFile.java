package data;


import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adrian
 */
public class PopulateFile {
    public static String fileName = "/translations.xml";

    public static String getFileName() {
        return System.getProperty("user.dir")+fileName;
    }
    
    public static void main(String[] args) {
//        try {
//            marshal();
//        } catch (JAXBException ex) {
//            Logger.getLogger(PopulateFile.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Translations trans;
        try {
            trans = unMarshal();
            trans.getTranslations().stream().forEach((elem) -> {
                System.out.println(elem.getFromWord());
            });
        } catch (JAXBException ex) {
            Logger.getLogger(PopulateFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void marshal() throws JAXBException
    {
        ArrayList<TranslateElement> elements = new ArrayList<>();
        TranslateElement elem1 = new TranslateElement();
        elem1.setFromLang("Romana");
        elem1.setToLang("Engleza");
        elem1.setFromWord("Caine");
        elem1.setToWord("Dog");
        TranslateElement elem3 = new TranslateElement();
        elem3.setFromLang("Romana");
        elem3.setToLang("Engleza");
        elem3.setFromWord("Carnat");
        elem3.setToWord("Sausage");
        TranslateElement elem2 = new TranslateElement();
        elem2.setFromLang("Romana");
        elem2.setToLang("Engleza");
        elem2.setFromWord("Pisica");
        elem2.setToWord("Cat");
        TranslateElement elem4 = new TranslateElement();
        elem4.setFromLang("Romana");
        elem4.setToLang("Engleza");
        elem4.setFromWord("Carte");
        elem4.setToWord("Book");
        TranslateElement elem5 = new TranslateElement();
        elem5.setFromLang("Romana");
        elem5.setToLang("Engleza");
        elem5.setFromWord("Ion");
        elem5.setToWord("John");
        elem4.setToWord("Book");
        TranslateElement elem6 = new TranslateElement();
        elem6.setFromLang("Romana");
        elem6.setToLang("Engleza");
        elem6.setFromWord("Zapada");
        elem6.setToWord("Snow");

        elements.add(elem1);
        elements.add(elem2);
        elements.add(elem6);
        elements.add(elem5);
        elements.add(elem4);
        elements.add(elem3);

        Translations trans = new Translations();
        trans.setTranslations(elements);
        JAXBContext jaxbc;
        jaxbc = JAXBContext.newInstance(Translations.class);
        Marshaller marshaller = jaxbc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(trans, new File(getFileName()));
      
    }
    
    public static Translations unMarshal() throws JAXBException
    {
        JAXBContext jaxbc = JAXBContext.newInstance(Translations.class);
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        File dataFile = new File(getFileName());
        if(!dataFile.exists()){
            marshal();
        }
        Translations trans = (Translations) unmarshaller.unmarshal(dataFile);        
        return trans;
    }
    
}
