package model;
public class Reciclamos {
    //Relationships
    private Waste[] wastes;
    private Product[] products;
    
    //Methods
    public Reciclamos() {
        wastes = new Waste[100];
        products = new Product[100];
    }
}