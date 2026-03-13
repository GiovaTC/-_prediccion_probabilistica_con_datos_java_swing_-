# -_prediccion_probabilistica_con_datos_java_swing_- :.
📊 Predicción Probabilística con Datos (Java Swing):

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/54855df9-5074-414e-9ca2-4bac077f1546" />	



Proyecto desarrollado en Java con interfaz gráfica (Swing) que permite analizar datos históricos y calcular probabilidades de ocurrencia.

Este tipo de aplicación se utiliza en:

estadística aplicada

análisis predictivo

machine learning básico

ciencia de datos introductoria.

Un ejemplo práctico es calcular la probabilidad de aprobar un curso según las notas registradas.

## 🎯 Objetivo del Proyecto:

Cargar datos históricos y calcular automáticamente:

Probabilidad de cada evento

Frecuencia de ocurrencia

Distribución de probabilidades

Ejemplo de datos
```
Nota	| Cantidad
A	    | 10
B	    | 15
C	    | 5
```
## 🧰 Tecnologías Utilizadas:

Java 17 / Java 21

Swing (Interfaz Gráfica)

IntelliJ IDEA

```

📁 Estructura del Proyecto
src
 ├── model
 │     DataRecord.java
 │
 ├── service
 │     PredictionService.java
 │
 └── ui
       PredictionGUI.java

```
Arquitectura simple basada en capas:

Model → estructura de datos

Service → lógica de cálculo probabilístico

UI → interfaz gráfica

1️⃣ Modelo de Datos:
Archivo:
DataRecord.java
```
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
```

Este modelo representa un evento dentro del dataset.
Ejemplo:
```
Categoria	Cantidad	Probabilidad
A	        10	      0.40
```
2️⃣ Servicio de Prediccion:
Archivo:
PredictionService.java
```
package service;

import model.DataRecord;

import java.util.List;

public class PredictionService {

    public void calculateProbabilities(List<DataRecord> data) {

        int total = 0;

        for(DataRecord r : data) {
            total += r.getCount();
        }

        for(DataRecord r : data) {

            double probability = (double) r.getCount() / total;

            r.setProbability(probability);
        }
    }
}
```
Funcionamiento:
Calcula el total de observaciones
Calcula la probabilidad:

<img width="429" height="73" alt="image" src="https://github.com/user-attachments/assets/4e0d0e9b-8b80-4320-8217-41cf71d88cf5" />
	​
Guarda el resultado dentro del objeto DataRecord .

3️⃣ Interfaz Grafica:
Archivo:
PredictionGUI.java
```
package ui;

import model.DataRecord;
import service.PredictionService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PredictionGUI extends JFrame {

    private JTextField categoryField;
    private JTextField countField;

    private JTable table;
    private DefaultTableModel model;

    private List<DataRecord> data = new ArrayList<>();

    private PredictionService service = new PredictionService();

    public PredictionGUI() {

        setTitle("Prediccion Probabilistica con Datos");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();

        categoryField = new JTextField(10);
        countField = new JTextField(5);

        JButton addButton = new JButton("Agregar");
        JButton calculateButton = new JButton("Calcular Probabilidad");

        inputPanel.add(new JLabel("Categoria"));
        inputPanel.add(categoryField);

        inputPanel.add(new JLabel("Cantidad"));
        inputPanel.add(countField);

        inputPanel.add(addButton);
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{"Categoria","Cantidad","Probabilidad"},0);

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(e -> addData());
        calculateButton.addActionListener(e -> calculate());

    }

    private void addData() {

        String category = categoryField.getText();
        int count = Integer.parseInt(countField.getText());

        DataRecord record = new DataRecord(category,count);

        data.add(record);

        model.addRow(new Object[]{category,count,"-"});

        categoryField.setText("");
        countField.setText("");
    }

    private void calculate() {

        service.calculateProbabilities(data);

        model.setRowCount(0);

        for(DataRecord r : data) {

            model.addRow(new Object[]{
                    r.getCategory(),
                    r.getCount(),
                    r.getProbability()
            });
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new PredictionGUI().setVisible(true);
        });
    }
}
```
## 🖥 Interfaz Esperada:
```
+------------------------------------------------+
| Prediccion Probabilistica con Datos            |
+------------------------------------------------+

Categoria: [ A ]  Cantidad: [10]  [Agregar]

                 [Calcular Probabilidad]

--------------------------------------------------
| Categoria | Cantidad | Probabilidad             |
--------------------------------------------------
| A         | 10       | 0.40                      |
| B         | 8        | 0.32                      |
| C         | 7        | 0.28                      |
--------------------------------------------------
```
## 📈 Aplicaciones Reales:

Este tipo de programa se puede utilizar en diferentes áreas:

### 🎓 Educacion:

Calcular la probabilidad de aprobar un curso según resultados históricos.

### 💻 Sistemas:

Análisis de probabilidad de fallos en software.

### 🏢 Negocios:

Predicción de ventas por categoría de producto.

### 📊 Ciencia de Datos:

Estimar la distribución de eventos dentro de un dataset .

## 🚀 Mejoras Recomendadas (Excelente para Proyecto Universitario)	

Puedes ampliar el sistema agregando:

### 📊 Visualización de Datos:

gráficos de probabilidad con JFreeChart

### 📁 Importacion de Datos:

cargar datos desde CSV
cargar datos desde Excel

### 📉 Modelos Estadisticos:

distribución Normal
distribución Binomial

### 📚 Gestión de Análisis

historial de predicciones

### 🤖 Machine Learning Básico

implementación de Naive Bayes simple / .
