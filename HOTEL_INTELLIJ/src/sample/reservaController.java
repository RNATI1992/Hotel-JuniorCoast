package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sample.Models.Reserva;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class reservaController implements Initializable {

    @FXML
    private Circle circulo_mov;

    @FXML
    private ImageView client;

    @FXML
    private ImageView habitacio;

    @FXML
    private ImageView hotel;


    @FXML
    private Pane hotel_caixa_1;

    @FXML
    private Pane hotel_caixa_2;

    @FXML
    private Pane hotel_caixa_3;

    @FXML
    private Pane hotel_caixa_4;

    @FXML
    private Pane hotel_caixa_5;

    @FXML
    private Pane hotel_caixa_6;

    @FXML
    private Pane hotel_caixa_7;

    @FXML
    private ImageView imprimir;

    @FXML
    private Rectangle rectangle_mov;

    @FXML
    private ImageView hotel_;

    @FXML
    private ImageView client_;

    @FXML
    private ImageView equipatge_;

    @FXML
    private ImageView habitacio_;

    @FXML
    private GridPane gridpane;

    @FXML
    private TextField search_data_reserva;

    @FXML
    private AnchorPane root_anchor;

    @FXML
    private TableColumn<?, ?> t_numero;

    @FXML
    private TableColumn<?, ?> t_dni_client;

    @FXML
    private TableColumn<?, ?> t_dni_recepcionista;

    @FXML
    private TableColumn<?, ?> t_data_entrada;

    @FXML
    private TableColumn<?, ?> t_hora_entrada;

    @FXML
    private TableColumn<?, ?> t_data_sortida;

    @FXML
    private TableColumn<?, ?> t_hora_sortida;

    @FXML
    private TableColumn<?, ?> t_preu;

    @FXML
    private TableColumn<?, ?> t_estat;

    @FXML
    private TableView<Reserva> tabla_reserves;

    private Button btnCancelar;
    private Button btnRegisterBungalow;
    private ComboBox combo_client;
    private ComboBox combo_recepcionista;
    private ComboBox combo_reserva;
    private ComboBox combo_bungalow;
    private TextField txtPreu;
    private TextField txtHoraEntrada;
    private TextField txtHoraSortida;
    private DatePicker txtDataEntrada;
    private DatePicker txtDataSortida;
    private ObservableList llistaClients;

    @Override
   public void initialize(URL url, ResourceBundle resourceBundle){


    }



}
