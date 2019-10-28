package model;
public class Inert extends Waste {
    //Attributes
    private String advice;

    //Methods
    /**
     * @param id
     * @param name
     * @param source
     * @param color
     * @param decompositionTime
     * @param advice
     */
    public Inert(String id, String name, String source, String color, int decompositionTime, String advice) {
        super(id, name, source, color, decompositionTime);
        this.advice = advice;
    }

    /**
     * @return the advice
     */
    public String getAdvice() {
        return advice;
    }

    /**
     * @param advice the advice to set
     */
    public void setAdvice(String advice) {
        this.advice = advice;
    }

    @Override
    public String toString() {
        return super.toString() + " advice: " + getAdvice();
    }
}