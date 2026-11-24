package com.cxdelite.launcher;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public final class CxdEliteApp extends Application {
    private static final String BG = "#090b10";
    private static final String PANEL = "#11151e";
    private static final String MUTED = "#8b93a5";
    private static final String ACCENT = "#dce2ee";

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: " + BG + ";");

        VBox sidebar = new VBox(22);
        sidebar.setPadding(new Insets(28, 18, 24, 18));
        sidebar.setPrefWidth(218);
        sidebar.setStyle("-fx-background-color: #0d1017; -fx-border-color: #202633; -fx-border-width: 0 1 0 0;");

        HBox brand = new HBox(11, logoMark(), new VBox(2, label("CxdElite", 18, "#f3f5fa", true), label("LAUNCHER", 9, MUTED, true)));
        brand.setAlignment(Pos.CENTER_LEFT);

        VBox nav = new VBox(8);
        nav.setPadding(new Insets(28, 0, 0, 0));
        nav.getChildren().addAll(
                navItem("▣", "Play", true),
                navItem("◷", "Installations", false),
                navItem("♙", "Accounts", false),
                navItem("⚙", "Settings", false)
        );
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        sidebar.getChildren().addAll(brand, nav, spacer,
                label("CXD ELITE  •  EARLY BUILD", 9, "#657087", true),
                label("Version " + getVersion(), 10, MUTED, false));

        VBox content = new VBox(24);
        content.setPadding(new Insets(38, 44, 34, 44));

        HBox top = new HBox();
        VBox heading = new VBox(5,
                label("MINECRAFT JAVA EDITION", 10, MUTED, true),
                label("Welcome back.", 30, "#f4f6fb", true),
                label("Your worlds are one click away.", 13, MUTED, false));
        Region topSpacer = new Region();
        HBox.setHgrow(topSpacer, Priority.ALWAYS);
        Label status = pill("READY TO CONFIGURE");
        top.getChildren().addAll(heading, topSpacer, status);
        top.setAlignment(Pos.TOP_LEFT);

        VBox hero = new VBox(18);
        hero.setPadding(new Insets(28));
        hero.setStyle("-fx-background-color: linear-gradient(to bottom right, #1a202d, #10141d); -fx-background-radius: 18; -fx-border-color: #30394a; -fx-border-radius: 18;");
        HBox heroTop = new HBox();
        VBox heroText = new VBox(8,
                label("THE NEXT WORLD IS YOURS", 10, "#aeb8ca", true),
                label("Ready, player?", 27, "#ffffff", true),
                label("Choose a game version and prepare your Minecraft session.", 13, "#aeb5c3", false));
        Region heroSpace = new Region();
        HBox.setHgrow(heroSpace, Priority.ALWAYS);
        Label cube = new Label("C");
        cube.setFont(Font.font("System", 66));
        cube.setTextFill(Color.web("#e9edf5"));
        cube.setStyle("-fx-font-weight: 900; -fx-effect: dropshadow(gaussian, #ffffff55, 18, 0.3, 0, 0);");
        heroTop.getChildren().addAll(heroText, heroSpace, cube);

        HBox controls = new HBox(12);
        ComboBox<String> version = new ComboBox<>();
        version.getItems().addAll("Latest Release", "1.21.10", "1.21.8", "1.20.1");
        version.getSelectionModel().selectFirst();
        version.setPrefWidth(190);
        version.setStyle("-fx-background-color: #202735; -fx-mark-color: white;");
        Button play = new Button("  PLAY  ");
        play.setPrefHeight(42);
        play.setStyle("-fx-background-color: #e8edf6; -fx-text-fill: #11151e; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 0 24 0 24;");
        play.setOnAction(e -> new Alert(Alert.AlertType.INFORMATION,
                "The launcher window is ready. Minecraft account sign-in and the download/launch engine are the next development milestones.",
                ButtonType.OK).showAndWait());
        controls.getChildren().addAll(version, play);
        controls.setAlignment(Pos.CENTER_LEFT);
        hero.getChildren().addAll(heroTop, new Separator(), controls);

        HBox lower = new HBox(16);
        lower.getChildren().addAll(infoCard("01", "INSTALLATIONS", "Manage game versions", "Version manager is being built."),
                infoCard("02", "MICROSOFT ACCOUNT", "Connect your account", "Secure sign-in is coming next."));
        content.getChildren().addAll(top, hero, lower);
        root.setLeft(sidebar);
        root.setCenter(content);

        Scene scene = new Scene(root, 1100, 700);
        stage.setTitle("CxdElite Launcher");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
    }

    private VBox infoCard(String number, String title, String headline, String detail) {
        VBox card = new VBox(9, label(number, 10, "#aeb8ca", true),
                label(title, 9, MUTED, true), label(headline, 16, "#f2f4f8", true),
                label(detail, 11, MUTED, false));
        card.setPadding(new Insets(20));
        card.setMaxWidth(Double.MAX_VALUE);
        card.setStyle("-fx-background-color: " + PANEL + "; -fx-background-radius: 14; -fx-border-color: #242b38; -fx-border-radius: 14;");
        HBox.setHgrow(card, Priority.ALWAYS);
        return card;
    }

    private HBox navItem(String icon, String name, boolean active) {
        Label glyph = label(icon, 16, active ? "#ffffff" : MUTED, false);
        Label text = label(name, 13, active ? "#ffffff" : "#a0a8b7", active);
        HBox item = new HBox(13, glyph, text);
        item.setAlignment(Pos.CENTER_LEFT);
        item.setPadding(new Insets(11, 12, 11, 12));
        item.setStyle(active ? "-fx-background-color: #252c39; -fx-background-radius: 8;" : "-fx-background-color: transparent;");
        return item;
    }

    private StackPane logoMark() {
        Label c = new Label("C");
        c.setFont(Font.font("System", 25));
        c.setTextFill(Color.web("#10141c"));
        c.setStyle("-fx-font-weight: 900;");
        StackPane mark = new StackPane(c);
        mark.setPrefSize(42, 42);
        mark.setStyle("-fx-background-color: linear-gradient(to bottom right, #ffffff, #aab4c5); -fx-background-radius: 10;");
        return mark;
    }

    private Label pill(String text) {
        Label label = label(text, 9, "#dce2ee", true);
        label.setPadding(new Insets(8, 11, 8, 11));
        label.setStyle("-fx-background-color: #252c39; -fx-background-radius: 20; -fx-border-color: #394355; -fx-border-radius: 20;");
        return label;
    }

    private Label label(String text, double size, String color, boolean bold) {
        Label label = new Label(text);
        label.setFont(Font.font("System", bold ? javafx.scene.text.FontWeight.BOLD : javafx.scene.text.FontWeight.NORMAL, size));
        label.setTextFill(Color.web(color));
        return label;
    }

    private String getVersion() {
        return getClass().getPackage().getImplementationVersion() == null ? "0.1.0" : getClass().getPackage().getImplementationVersion();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
