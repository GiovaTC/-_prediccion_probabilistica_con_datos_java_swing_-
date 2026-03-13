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
