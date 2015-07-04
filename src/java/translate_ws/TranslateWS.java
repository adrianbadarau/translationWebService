/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translate_ws;

import data.PopulateFile;
import data.TranslateElement;
import data.Translations;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBException;

/**
 *
 * @author adrian
 */
@WebService(serviceName = "TranslateWS")
public class TranslateWS {

    /**
     * Web service operation
     * @param word String cuvantul cerut
     * @param fromLang String limba materna
     * @param toLang String limba straina
     * @return String traducerea 
     * @throws javax.xml.bind.JAXBException
     */
    @WebMethod(operationName = "translate")
    public String translate(@WebParam(name = "word") String word, @WebParam(name = "fromLang") String fromLang, @WebParam(name = "toLang") String toLang) throws JAXBException {
        
        Translations data = PopulateFile.unMarshal();
        String error = "";
        for(TranslateElement elem : data.getTranslations()){
            if(fromLang.equals(elem.getFromLang())){
                if(toLang.equals(elem.getToLang())){
                    if(word.equals(elem.getFromWord())){
                        return "Traducerea ceruta este: "+elem.getToWord();
                    }else{
                        error = "Cuvantul cautat nu exista in memorie ";
                    }
                }else{
                    error = "Limba de traducere ceruta nu exista in memorie ";
                }
            }else if(fromLang.equals(elem.getToLang())){
                if(toLang.equals(elem.getFromLang())){
                    if(word.equals(elem.getToWord())){
                        return "Traducerea ceruta este: "+elem.getFromWord();
                    }else{
                        error = "Cuvantul cautat nu exista in memorie ";
                    }
                }else{
                    error = "Limba de traducere ceruta nu exista in memorie ";
                }            
            }else{
                error = "Limba sursa cerut nu exista in memorie ";
            }
        }
        if(!error.equals("")){
            return error;
        }else{
            return "A aparut o eroare";
        }
    }
}
