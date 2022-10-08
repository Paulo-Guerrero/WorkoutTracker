package View;

import Controller.Controllers;
import com.mindfusion.charting.swing.LineChart;

import javax.swing.*;
import java.awt.*;

public class HistoryGraph extends JPanel {
    Controllers controllers;

    public HistoryGraph(Controllers controllers){
        this.controllers = controllers;
        LineChart lineChart = this.intializeChart();
        this.add(lineChart);
        this.setBackground(Color.blue);
    }

    private LineChart intializeChart(){
        LineChart lineChart = new LineChart();

        lineChart.getXAxis().setTitle("Date");
        lineChart.getXAxis().setMinValue(0.0);
        lineChart.getXAxis().setMaxValue(10.0);

        lineChart.getYAxis().setTitle("Measurement");
        lineChart.getYAxis().setMinValue(0.0);
        lineChart.getYAxis().setMaxValue(10.0);



        return lineChart;
    }
}
