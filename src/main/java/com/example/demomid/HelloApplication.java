package com.example.demomid;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private TextField kWhInput;      // Text field for entering total kWh
    private Label resultLabel;       // Label for displaying the calculated cost
    private ToggleGroup planTypeGroup; // Group to hold radio buttons for plan selection

    @Override
    public void start(Stage primaryStage) {
        // Text field for kWh input with prompt text
        kWhInput = new TextField();
        kWhInput.setPromptText("Enter total kWh");

        // Radio buttons for selecting the electricity plan type
        RadioButton populationRadio = new RadioButton("Population");
        RadioButton highlandsRadio = new RadioButton("Highlands");
        RadioButton commercialRadio = new RadioButton("Commercial");

        // Group the radio buttons together to allow single selection
        planTypeGroup = new ToggleGroup();
        populationRadio.setToggleGroup(planTypeGroup);
        highlandsRadio.setToggleGroup(planTypeGroup);
        commercialRadio.setToggleGroup(planTypeGroup);

        // Button to calculate the monthly electric cost
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> calculateCost()); // Calls calculateCost method when clicked

        // Label to display the result
        resultLabel = new Label("Monthly Electric Cost:");

        // Layout configuration
        VBox layout = new VBox(10, kWhInput, populationRadio, highlandsRadio, commercialRadio, calculateButton, resultLabel);
        layout.setPadding(new Insets(15));

        // Set up scene and stage
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Monthly Electric Cost Calculator");
        primaryStage.show();
    }

    // Method to calculate the cost based on the selected plan and kWh input
    private void calculateCost() {
        try {
            int totalKWh = Integer.parseInt(kWhInput.getText()); // Read kWh input from user
            RadioButton selectedRadio = (RadioButton) planTypeGroup.getSelectedToggle(); // Get selected radio button

            if (selectedRadio == null) { // Check if a plan type was selected
                resultLabel.setText("Please select an electricity plan.");
                return;
            }

            // Create the appropriate plan instance based on the selected plan type
            ElectricityPlan plan;
            String selectedPlanType = selectedRadio.getText();

            switch (selectedPlanType) {
                case "Population":
                    plan = new PopulationPlan(totalKWh);
                    break;
                case "Highlands":
                    plan = new HighlandsPlan(totalKWh);
                    break;
                case "Commercial":
                    plan = new CommercialPlan(totalKWh);
                    break;
                default:
                    resultLabel.setText("Invalid plan type selected.");
                    return;
            }

            // Calculate and display the cost in the result label
            double cost = plan.calculateCost();
            resultLabel.setText("Monthly Electric Cost: " + cost + " som");

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number for kWh."); // Handle invalid kWh input
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
