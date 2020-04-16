package models;

public class Squad {
    private int id;
    private String name;
    private String regionResponsable;
    private int quantityOfSoldiers;

    /**
     * Construtor da classe
     *
     */
    public Squad() {
    }


    /**
     * Construtor com parâmetros
     *
     * @param id id do esquadrao
     * @param name nome do esquadrao
     * @param regionResponsable regiaoresponsavel
     * @param quantityOfSoldiers quantidade de soldaoos
     */
    public Squad(int id, String name, String regionResponsable, int quantityOfSoldiers) {
        this.id = id;
        this.name = name;
        this.regionResponsable = regionResponsable;
        this.quantityOfSoldiers = quantityOfSoldiers;
    }


    /**
     * Getter do Id
     *
     * @return retorna o id do esquadrao
     */
    public int getId() {
        return id;
    }

    /**
     * Setter do Id
     *
     * @param id seta o id do esquadrao
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Getter do name
     *
     * @return retorna o nome
     */
    public String getName() {
        return name;
    }

    /**
     * Setter do name
     *
     * @param name seta o nome
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter do regionResponsable
     *
     * @return retorna a regiao responsavel
     */
    public String getRegionResponsable() {
        return regionResponsable;
    }


    /**
     * Setter do RegionResponsable
     *
     * @param regionResponsable seta a regiao responsavel
     */
    public void setRegionResponsable(String regionResponsable) {
        this.regionResponsable = regionResponsable;
    }


    /**
     * Getter do QuantityOfSoldiers
     *
     * @return retorna a quantidade de soldados
     */
    public int getQuantityOfSoldiers() {
        return quantityOfSoldiers;
    }


    /**
     * Setter do QuantityOfSoldiers
     *
     * @param quantityOfSoldiers seta a quantidade de soldados
     */
    public void setQuantityOfSoldiers(int quantityOfSoldiers) {
        this.quantityOfSoldiers = quantityOfSoldiers;
    }
}
