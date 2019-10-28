package model;
public class Recyclable extends Waste {
    //Attributes
    private String type;
    private String description;

    //Methods
    /**
     * @param id
     * @param name
     * @param source
     * @param color
     * @param decompositionTime
     * @param type
     * @param description
     */
    public Recyclable(String id, String name, String source, String color, int decompositionTime, String type, String description) {
        super(id, name, source, color, decompositionTime);
        this.type = type;
        this.description = description;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() + " type: " + getType() + ", description: " + getDescription();
    }
}