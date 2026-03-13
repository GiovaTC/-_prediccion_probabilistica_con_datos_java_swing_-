package model;

public class DataRecord {

    private String category;
    private int count;
    private double probability;

    public DataRecord(String category, int count) {
        this.category = category;
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public int getCount() {
        return count;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}

/* Este modelo representa un evento dentro del dataset.
Ejemplo:
Categoria	Cantidad	Probabilidad
//A	        10	      0.40             */
