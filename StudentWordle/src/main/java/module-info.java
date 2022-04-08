module com.example.studentwordle {
  requires javafx.controls;
  requires javafx.fxml;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.ikonli.fontawesome;
  requires org.kordamp.ikonli.core;

  opens com.example.studentwordle to javafx.fxml;
  exports com.example.studentwordle;
}
