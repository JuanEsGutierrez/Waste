package model;
public class Biodegradable extends Waste {
    //Attributes
    private boolean composting;
    
    //Methods
    /**
     * @param id
     * @param name
     * @param source
     * @param color
     * @param decompositionTime
     * @param composting
     */
    public Biodegradable(String id, String name, String source, String color, int decompositionTime, boolean composting) {
        super(id, name, source, color, decompositionTime);
        this.composting = composting;
    }

    /**
     * @return the composting
     */
    public boolean getComposting() {
        return composting;
    }

    /**
     * @param composting the composting to set
     */
    public void setComposting(boolean composting) {
        this.composting = composting;
    }
}