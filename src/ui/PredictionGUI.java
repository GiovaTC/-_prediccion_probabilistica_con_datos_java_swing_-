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