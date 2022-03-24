package com.company;



    public class Main extends Application {
        TextField textField = new TextField();;
        Circle circle = new Circle(100.0f);
        Label statusLbl = new Label();
        Color color;

        //Program's point of entry.
        public static void main(String[] args){
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            //Event handler with the function that converts input color to a color object
            //and sets it as the color of the circle. It's assigned to the button btn.
            EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //Get color entered by user
                    String colorInput = textField.getText();
                    //Clear message label
                    statusLbl.setText("");

                    try{
                        //Convert input color value to a Color object
                        color = Color.web(colorInput);
                        //Set fill circle with input color
                        circle.setFill(color);

                        //Change stroke/border of circle to Grey if
                        //color is white (not visible on a white background.
                        if(color == Color.WHITE){
                            circle.setStroke(Color.GREY);
                        }else{
                            circle.setStroke(color);
                        }
                    }catch(Exception ex){
                        //Display error message if entered color is invalid.
                        statusLbl.setTextFill(Color.RED);
                        statusLbl.setText("Oops. That color is unknown.");
                    }
                }
            };

            //Button that is assigned the event handler.
            Button btn = new Button();
            btn.setText("Change Color");
            btn.setOnAction(eventHandler);

            //This label and the textfield are put in a HBox to
            //align horizontally.
            Label label = new Label("Enter a color:");
            HBox hBox = new HBox(5, label, textField);
            hBox.setAlignment(Pos.BASELINE_CENTER);

            //VBox initializes with the textfield and its label on the same row,
            //and adds the button, the circle and a status label.
            VBox vBox = new VBox(20, hBox);
            vBox.getChildren().addAll(btn, circle, statusLbl);
            vBox.setPadding(new Insets(20, 10, 10, 10));
            vBox.setAlignment(Pos.BASELINE_CENTER);


            //Put the VBox into the GUI
            Scene scene = new Scene(vBox);

            primaryStage.setScene(scene);
            primaryStage.setTitle("GUI with Circle");
            primaryStage.show();
        }
    }
