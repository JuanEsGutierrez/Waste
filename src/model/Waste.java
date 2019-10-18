package model;
public class Waste {
    //Attributes
    private String id;
    private String name;
    private String source;
    private String color;
    private int decompositionTime;

    //Methods
    /**
     * @param id
     * @param name
     * @param source
     * @param color
     * @param decompositionTime
     */
    public Waste(String id, String name, String source, String color, int decompositionTime) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.color = color;
        this.decompositionTime = decompositionTime;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the decompositionTime
     */
    public int getDecompositionTime() {
        return decompositionTime;
    }

    /**
     * @param decompositionTime the decompositionTime to set
     */
    public void setDecompositionTime(int decompositionTime) {
        this.decompositionTime = decompositionTime;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }
}
