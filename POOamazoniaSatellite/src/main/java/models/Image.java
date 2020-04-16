package models;
/**
 * Classe utilizada apenas para intermediar os dados da imagens que serão enviados para o drive
 */
public class Image{
    private String fileName;
    private int scale;
    private int regionId;
    private int generatedTime;
    private boolean read;

    /**
     * Construtor da classe sem parametros
     */
    public Image() {
        this.read = false;
    }

    /**
     * Construtor da classe image recebe o id nome e a hora que foi gerado em inteiro
     * @param fileName nome
     * @param generatedTime hora em que foi gerado em inteiros
     */
    public Image( String fileName, int generatedTime) {
        this.fileName = fileName;
        this.generatedTime = generatedTime;
        this.read = false;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public int getGeneratedTime() {
        return generatedTime;
    }

    public void setGeneratedTime(int generatedTime) {
        this.generatedTime = generatedTime;
    }

     public boolean isRead() {
        return read;
    }

     public void setRead(boolean read) {
        this.read = read;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}
