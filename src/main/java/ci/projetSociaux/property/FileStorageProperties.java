package ci.projetSociaux.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String dossierImage;

    public String getDossierImage() {
        return dossierImage;
    }

    public void setDossierImage(String dossierImage) {
        this.dossierImage = dossierImage;
    }
}
