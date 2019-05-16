package ci.projetSociaux.entity;

public class ImageRecipiendaire {

    private String nomImage;

    private String lienTelechargementImage;

    private String typeImage;

    private long tailleImage;

    public ImageRecipiendaire() {
    }

    public ImageRecipiendaire(String nomImage, String lienTelechargementImage, String typeImage, long tailleImage) {
        this.nomImage = nomImage;
        this.lienTelechargementImage = lienTelechargementImage;
        this.typeImage = typeImage;
        this.tailleImage = tailleImage;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public String getLienTelechargementImage() {
        return lienTelechargementImage;
    }

    public void setLienTelechargementImage(String lienTelechargementImage) {
        this.lienTelechargementImage = lienTelechargementImage;
    }

    public String getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(String typeImage) {
        this.typeImage = typeImage;
    }

    public long getTailleImage() {
        return tailleImage;
    }

    public void setTailleImage(long tailleImage) {
        this.tailleImage = tailleImage;
    }
}
