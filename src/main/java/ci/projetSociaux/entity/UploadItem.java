package ci.projetSociaux.entity;

import org.springframework.web.multipart.MultipartFile;
 
public class UploadItem {
 
    MultipartFile file;
    private String name;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public MultipartFile getFile() {
        return file;
    }
 
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
