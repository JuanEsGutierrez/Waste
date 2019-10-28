package model;
import java.util.Arrays;
public class Reciclamos implements Usable {
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
            if(wastes[i] != null) {
                if(wastes[i].getName().equals(wasteName)) {
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
                i = wastes.length + 1;
            }
        }
    }

    public void addWaste(String id, String name, String source, String color, int decompositionTime, String advice) {
        for(int i = 0; i < wastes.length; i++) {
            if(wastes[i] == null) {
                wastes[i] = new Inert(id, name, source, color, decompositionTime, advice);
                i = wastes.length + 1;
            }
        }
    }

    public void addWaste(String id, String name, String source, String color, int decompositionTime, String type, String description) {
        for(int i = 0; i < wastes.length; i++) {
            if(wastes[i] == null) {
                wastes[i] = new Recyclable(id, name, source, color, decompositionTime, type, description);
                i = wastes.length + 1;
            }
        }
    }
    
    public String wasteReport() {
        String bioMessage = "Biodegradable\n";
        String inertMessage = "Inert\n";
        String recyMessage = "Recyclable\n";
        for (int i = 0; i < wastes.length; i++) {
            if(wastes[i] != null) {
                if(wastes[i] instanceof Biodegradable) {
                    bioMessage += wastes[i].toString() + "\n";
                }
                if(wastes[i] instanceof Inert) {
                    inertMessage += wastes[i].toString() + "\n";
                }
                if(wastes[i] instanceof Recyclable) {
                    recyMessage += wastes[i].toString() + "\n";
                }
            }
        }
        return bioMessage + inertMessage + recyMessage;
    }

    public void addProduct(String id, String name, String description, String[] wasteNames) {
        for(int i = 0; i < products.length; i++) {
            if(products[i] == null) {
                products[i] = new Product(id, name, description);
                i = products.length + 1;
                for(int v = 0; v < wastes.length; v++) {
                    if(wastes[v] != null) {
                        for(int z = 0; z < wasteNames.length; z++) {
                            if(wasteNames[z].equals(wastes[v].getName())) {
                                products[i].setWasteList(wastes[v]);
                                z = wasteNames.length + 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public String search(String wasteName, String productId) {
        String message = "";
        boolean x = true;
        if(!wasteName.isBlank()) {
            for(int i = 0; i < wastes.length; i++) {
                if(wastes[i] != null) {
                    if(wasteName.equals(wastes[i].getName())) {
                        message += wastes[i].toString();
                        x = false;
                    }
                }
            }
        }
        if(x && !productId.isBlank()) {
            for(int i = 0; i < products.length; i++) {
                if(products[i] != null) {
                    if(productId.equals(products[i].getId())) {
                        for(int v = 0; v < products[i].getWasteList().length; v++) {
                            if(products[v] != null) {
                                message += products[v].getWaste(v).toString() + "\n";
                            }
                        }
                    }
                }
            }
        }
        return message;
    }

    public String productList() {
        String message = "Products\n";
        for(int i = 0; i < products.length; i++) {
            if(products[i] != null) {
                message += products[i].toString() + "\n";
            }
        }
        return message;
    }

    public String harmfulEffectList() {
        double[] harmfulEffects = new double[400];
        String message = "";
        for(int i = 0; i < wastes.length; i++) {
            if(wastes[i] != null) {
                harmfulEffects[i] = harmfulEffect(wastes[i].getName());
            }
        }
        double[] harmfulEffectsSorted = harmfulEffects;
        Arrays.sort(harmfulEffectsSorted);
        for(int i = harmfulEffectsSorted.length - 1; i >= 0; i--) {
            for(int v = 0; v < 400; v++) {
                if(harmfulEffectsSorted[i] != 0.0 && harmfulEffects[v] != 0.0) {
                    if(harmfulEffectsSorted[i] == harmfulEffects[v]) {
                        message += wastes[v].toString() + "\n";
                        v = 401;
                    }
                }
            }
        }
        return message;
    }
}