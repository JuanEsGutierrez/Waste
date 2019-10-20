package model;
public class Reciclamos {
    //Relationships
    private Waste[] wastes;
    private Product[] products;
    
    //Methods
    public Reciclamos() {
        wastes = new Waste[400];
        products = new Product[100];
    }

    public double harmfulEffect(String wasteName) {
        double harmEffect = 0;
        for(int i = 0; i < wastes.length; i++) {
            if(wastes[i].getName().equals(wasteName) && wastes[i] != null) {
                switch(wastes[i].getSource()) {
                    case "INDUSTRIAL":
                        harmEffect = wastes[i].getDecompositionTime() * 0.1;
                        break;
                    case "DOMICILIARY":
                        harmEffect = wastes[i].getDecompositionTime() * 0.05;
                        break;
                    case "CONSTRUCTION":
                        harmEffect = wastes[i].getDecompositionTime() * 0.08;
                        break;
                    case "MUNICIPAL":
                        harmEffect = wastes[i].getDecompositionTime() * 0.12;
                        break;
                    case "HOSPITAL":
                        harmEffect = wastes[i].getDecompositionTime() * 0.15;
                        break;
                }
                if(wastes[i] instanceof Recyclable) {
                    harmEffect *= 0.98;
                }
                else if(wastes[i] instanceof Biodegradable && ((Biodegradable)wastes[i]).getComposting() == true) {
                    harmEffect *= 0.99;
                }
            }
        }
        return harmEffect;
    }

    public boolean usable(String wasteName) {
        boolean usable = false;
        for(int i = 0; i < wastes.length; i++) {
            if(wastes[i] != null) {
                if(wastes[i] instanceof Biodegradable && ((Biodegradable)wastes[i]).getDecompositionTime() < 365 && ((Biodegradable)wastes[i]).getComposting() == true) {
                    usable = true;
                }
                if(wastes[i] instanceof Recyclable && !((Recyclable)wastes[i]).getDescription().equals("")) {
                    usable = true;
                }
            }
        }
        return usable;
    }

    public void addWaste(String id, String name, String source, String color, int decompositionTime, boolean composting) {
        for(int i = 0; i < wastes.length; i++) {
            if(wastes[i] == null) {
                wastes[i] = new Biodegradable(id, name, source, color, decompositionTime, composting);
            }
        }
    }

    public void addWaste(String id, String name, String source, String color, int decompositionTime, String advice) {
        for(int i = 0; i < wastes.length; i++) {
            if(wastes[i] == null) {
                wastes[i] = new Inert(id, name, source, color, decompositionTime, advice);
            }
        }
    }

    public void addWaste(String id, String name, String source, String color, int decompositionTime, String type, String description) {
        for(int i = 0; i < wastes.length; i++) {
            if(wastes[i] == null) {
                wastes[i] = new Recyclable(id, name, source, color, decompositionTime, type, description);
            }
        }
    }
}