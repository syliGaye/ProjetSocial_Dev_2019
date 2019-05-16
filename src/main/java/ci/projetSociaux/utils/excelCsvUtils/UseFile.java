/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.utils.excelCsvUtils;

import java.io.File;

/**
 *
 * @author soumabkar
 */
public class UseFile { 
    
    private File fileModele;

       public UseFile() {
      
    }
    
    public File getFileModele() {
        return fileModele;
    }

    public void setFileModele(File fileModele) {
        this.fileModele = fileModele;
    }

    public UseFile(File fileModele) {
        this.fileModele = fileModele;
    }
    
     
    
    
}
