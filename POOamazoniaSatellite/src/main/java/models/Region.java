package models;

/**
 * Modelo para intermediar os esquadrões
 */
public class Region {
    private int id;
    private String name;
    private boolean protectedArea;
    private String environmentalProtection;
    private String urbanRegion;
    private int squadResponsable;


    /**
     * construtor sem parametros
     */
    public Region() {
    }

    /**
     * @param id id do squad
     * @param name nome
     * @param protectedArea se é area protegida
     * @param squadResponsable id do esquadrão responsavel
     * @param environmentalProtection diz se é area ambiental protegida
     * @param urbanRegion diz se é area urbana
     */
    public Region(int id, String name, boolean protectedArea, int squadResponsable, String environmentalProtection, String urbanRegion) {
        this.id = id;
        this.name = name;
        this.protectedArea = protectedArea;
        this.environmentalProtection = environmentalProtection;
        this.urbanRegion = urbanRegion;
        this.squadResponsable = squadResponsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isProtectedArea() {
        return protectedArea;
    }


    public void setProtectedArea(boolean protectedArea) {
        this.protectedArea = protectedArea;
    }

    public int getSquadResponsable() {
        return squadResponsable;
    }

    public void setSquadResponsable(int squadResponsable) {
        this.squadResponsable = squadResponsable;
    }


    public String getEnvironmentalProtection() {
        return environmentalProtection;
    }

    public void setEnvironmentalProtection(String environmentalProtection) {
        this.environmentalProtection = environmentalProtection;
    }

    public String getUrbanRegion() {
        return urbanRegion;
    }

    public void setUrbanRegion(String urbanRegion) {
        this.urbanRegion = urbanRegion;
    }
}