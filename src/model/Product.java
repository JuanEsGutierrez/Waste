package model;
public class Product {
    //Attributes
    private String id;
    private String name;
    private String description;
    
    //Relationships
    private Waste[] wasteList;
    
    //Methods
    public Product(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        wasteList = new Waste[10];
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

    /**
     * @return the wasteList
     */
    public Waste[] getWasteList() {
        return wasteList;
    }

    /**
     * @param i the wasteList position
     * @return the waste object thats into the specified wasteList position
     */
    public Waste getWaste(int i) {
        return wasteList[i];
    }

    /**
	 * @param waste the waste object to set into wasteList
	 */
	public void setWasteList(Waste waste) {
		for(int i = 0; i < wasteList.length; i++) {
            if(wasteList[i] == null) {
                wasteList[i] = waste;
            }
        }
	}
    
    @Override
    public String toString() {
        return "name: " + getName() + ", id: " + getId() + ", description: " + getDescription();
    }
}