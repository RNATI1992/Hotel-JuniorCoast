package sample;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXTimePicker;
import com.sun.istack.internal.Nullable;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Models.*;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class hotelController implements Initializable {

    @FXML
    private Circle circulo_mov;

    @FXML
    private CheckBox check_esmorzar;

    @FXML
    private CheckBox check_massatge;

    @FXML
    private CheckBox check_spa;

    @FXML
    private ImageView client;

    @FXML
    private ImageView habitacio;

    /* TABLA COMPROVANT */

    @FXML
    private TableColumn<?, ?> t_nom;

    @FXML
    private TableColumn<?, ?> t_cognoms;

    @FXML
    private TableColumn<?, ?> t_dni_client_comprovant;
    @FXML
    private TableColumn<?, ?> t_numero_comprovant;

    @FXML
    private TableColumn<?, ?> t_data_sortida_comprovant;
    @FXML
    private TableColumn<?, ?> t_hora_sortida_comprovant;
    @FXML
    private TableColumn<?, ?> t_preu_comprovant;

    @FXML
    private TableView<Comprovant> tabla_comprovant;

    @FXML
    private ImageView hotel;

    @FXML
    private ImageView closeButtonView;

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
    private AnchorPane root_anchor;

    @FXML
    private TableColumn<?, ?> t_numero;

    @FXML
    private TableColumn<?, ?> t_numero_reserva;

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

    @FXML
    private Button btnCancelar;
    @FXML
    private Button afegirReserva;
    @FXML
    private ComboBox combo_client;
    @FXML
    private ComboBox combo_recepcionista;
    @FXML
    private ComboBox combo_bungalow;
    @FXML
    private ComboBox combo_estatreserva;
    @FXML
    private Label label_estatreserva;
    @FXML
    private TextField preu_total;
    @FXML
    private DatePicker txtDataEntrada;
    @FXML
    private DatePicker txtDataSortida;
    @FXML
    private DatePicker reserva_desde;
    @FXML
    private DatePicker reserva_fins;
    @FXML
    private Pane pane_hotel4;
    @FXML
    private JFXTimePicker h_entrada;
    @FXML
    private ObservableList llistaClients;
    @FXML
    public javafx.scene.image.ImageView hotel_img;
    @FXML
    public javafx.scene.image.ImageView client_img;
    @FXML
    public ImageView factura_i;
    @FXML
    public ImageView img_pdf;
    @FXML
    public ImageView equipatge_im;
    @FXML
    public ImageView habitacio_im;
    @FXML
    public ComboBox tipusComboBox;
    @FXML
    public ComboBox estatComboBox;
    @FXML
    public TextArea caracteristicasBungalow;
    @FXML
    public TextField preuBungalow;
    @FXML
    public Button nouBungalow;
    @FXML
    public Label errorBungalow;
    @FXML
    public TableView gestioBungalows;
    @FXML
    public TableColumn colN_Bungalow;
    @FXML
    public TableColumn colCaract;
    @FXML
    public TableColumn colPreu;
    @FXML
    public TableColumn colEstat;
    @FXML
    public TableColumn colTipus;
    @FXML
    public Button updateBungalow;
    @FXML
    public Button deleteBungalow;
    @FXML
    public Button insertBungalow;
    @FXML
    public TextField numBungalow;
    @FXML
    public Button validaUsu;
    @FXML
    public Button eliminaUsu;
    @FXML
    public TableView UsuTaula;
    @FXML
    public TableColumn colDniUsu;
    @FXML
    public TableColumn colEmailUsu;
    @FXML
    public TableColumn colEstatUsu;
    @FXML
    public Label errorUsu;
    @FXML
    public TextField filtreUsuariTxt;
    @FXML
    public javafx.scene.image.ImageView bell1;
    @FXML
    public javafx.scene.image.ImageView bell2;
    @FXML
    public TextField filtroBungalowTxt;
    @FXML
    public Label bellTxt2;
    @FXML
    public Label bellTxt1;
    @FXML
    public javafx.scene.image.ImageView factura_img;
    @FXML
    public javafx.scene.image.ImageView img_5;
    @FXML
    public javafx.scene.image.ImageView equipatge_img;
    @FXML
    public javafx.scene.image.ImageView habitacio_img;
    @FXML
    public TextField filtroClienteTxt;
    @FXML
    public TableView tablaClientes;
    @FXML
    public TableColumn colDniCliente;
    @FXML
    public TableColumn colNomCliente;
    @FXML
    public TableColumn colApellCliente;
    @FXML
    public TableColumn colNacioCliente;
    @FXML
    public TableColumn colEmailCliente;
    @FXML
    public TableColumn colOcupacioCliente;
    @FXML
    public TableColumn colEstCivilCliente;
    @FXML
    public TextField dniTxtCliente;
    @FXML
    public TextField nomTxtCliente;
    @FXML
    public TextField nacioTxtCliente;
    @FXML
    public TextField emailTxtCliente;
    @FXML
    public TextField ocupacioTxtCliente;
    @FXML
    public TextField cognomsTxtCliente;
    @FXML
    public TextField estatCivilTxtCliente;
    @FXML
    public Button nouCliente;
    @FXML
    public Button insertCliente;
    @FXML
    public Button updateCliente;
    @FXML
    public Button deleteCliente;
    @FXML
    public TextField phoneTxtCliente;
    @FXML
    public Label errorCliente;

    private HashMap<Integer, Stack<String[]>> dateranges = new HashMap<Integer, Stack<String[]>>();
    private ArrayList<Reserva> reservaData = new ArrayList<Reserva>();

    ChangeListener<String> bungalowChange = new ChangeListener() {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue){
            Integer preuInt = 0;
            if(oldValue != null && newValue!=null){
                preuInt = parseInt(preu_total.getText().split(" ")[0])-arrayOfPreus.get(oldValue);
            } else{
                preuInt = parseInt(preu_total.getText().split(" ")[0]);
            }
            if(newValue!=null){
                preu_total.setText((arrayOfPreus.get(newValue)+preuInt)+" €");
                if(dateranges.size() > 0 && dateranges.get(newValue) != null&& !"".equalsIgnoreCase(dateranges.get(newValue).get(0)[0])){
                    txtDataEntrada.setDayCellFactory(picker -> new DateCell() {
                        @Override
                        public void updateItem(LocalDate date, boolean empty) {
                            super.updateItem(date, empty);
                            setDisable(empty || date.isBefore(LocalDate.now()) || Iterables.any(dateranges.get(newValue), new Predicate<String[]>(){
                                @Override
                                public boolean apply(@Nullable String[] strings) {
                                    return date.isAfter(LocalDate.parse(strings[0]).minusDays(1)) && date.isBefore(LocalDate.parse(strings[1]).plusDays(1));
                                }
                            }));
                        }
                    });
                    if(txtDataEntrada.getValue() != null && Iterables.any(dateranges.get(newValue), new Predicate<String[]>(){
                        @Override
                        public boolean apply(@Nullable String[] strings) {
                            return txtDataEntrada.getValue().isAfter(LocalDate.parse(strings[0]).minusDays(1)) && txtDataEntrada.getValue().isBefore(LocalDate.parse(strings[1]).plusDays(1));
                        }
                    })){
                        txtDataEntrada.setValue(null);
                    }
                    txtDataSortida.setDayCellFactory(picker -> new DateCell() {
                        @Override
                        public void updateItem(LocalDate date, boolean empty) {
                            super.updateItem(date, empty);
                            setDisable(empty || date.isBefore(LocalDate.now()) || Iterables.any(dateranges.get(newValue), new Predicate<String[]>(){
                                @Override
                                public boolean apply(@Nullable String[] strings) {
                                    return date.isAfter(LocalDate.parse(strings[0]).minusDays(1)) && date.isBefore(LocalDate.parse(strings[1]).plusDays(1));
                                }
                            }));
                        }
                    });
                    if(txtDataSortida.getValue() != null && Iterables.any(dateranges.get(newValue), new Predicate<String[]>(){
                        @Override
                        public boolean apply(@Nullable String[] strings) {
                            return txtDataSortida.getValue().isAfter(LocalDate.parse(strings[0]).minusDays(1)) && txtDataSortida.getValue().isBefore(LocalDate.parse(strings[1]).plusDays(1));
                        }
                    })){
                        txtDataSortida.setValue(null);
                    }
                }
            }
        }
    };

    ChangeListener<Boolean> checkPreu1 = new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
            Integer preuInt = parseInt(preu_total.getText().split(" ")[0]);
            if(newValue){
                preu_total.setText((25+preuInt)+" €");
            } else if(preuInt!=0){
                preu_total.setText((preuInt-25)+" €");
            }
        }
    };
    ChangeListener<Boolean> checkPreu2 = new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
            Integer preuInt = parseInt(preu_total.getText().split(" ")[0]);
            if(newValue){
                preu_total.setText((50+preuInt)+" €");
            } else if(preuInt!=0){
                preu_total.setText((preuInt-50)+" €");
            }
        }
    };
    ChangeListener<Boolean> checkPreu3 = new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
            Integer preuInt = parseInt(preu_total.getText().split(" ")[0]);
            if(newValue){
                preu_total.setText((30+preuInt)+" €");
            } else if(preuInt!=0){
                preu_total.setText((preuInt-30)+" €");
            }
        }
    };

    ChangeListener<LocalDate> limitDate = new ChangeListener() {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue){
            if(newValue == txtDataEntrada.getValue() && newValue != null){
                txtDataSortida.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isBefore(LocalDate.now()) || date.isBefore(txtDataEntrada.getValue().plusDays(1)) || (!combo_bungalow.isDisable() && dateranges.containsKey(newValue) && combo_bungalow.getValue() != null && Iterables.any(dateranges.get(combo_bungalow.getValue()), new Predicate<String[]>(){
                            @Override
                            public boolean apply(@Nullable String[] strings) {
                                return date.isAfter(LocalDate.parse(strings[0]).minusDays(1)) && date.isBefore(LocalDate.parse(strings[1]).plusDays(1));
                            }
                        })));
                    }
                });
            } else if(newValue == txtDataSortida.getValue() && newValue != null) {
                txtDataEntrada.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isBefore(LocalDate.now()) || date.isAfter(txtDataSortida.getValue().minusDays(1)) || (!combo_bungalow.isDisable() && dateranges.containsKey(newValue) && combo_bungalow.getValue() != null && Iterables.any(dateranges.get(combo_bungalow.getValue()), new Predicate<String[]>(){
                            @Override
                            public boolean apply(@Nullable String[] strings) {
                                return date.isAfter(LocalDate.parse(strings[0]).minusDays(1)) && date.isAfter(LocalDate.parse(strings[1]).plusDays(1));
                            }
                        })));
                    }
                });
            }
        }
    };

    ChangeListener<LocalDate> filterDateReserva = new ChangeListener() {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue){
            if(newValue == reserva_desde.getValue() && reserva_desde.getValue() != null && newValue != null){
                reserva_fins.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isBefore(LocalDate.now()) || reserva_desde.getValue()!=null?date.isBefore(reserva_desde.getValue().plusDays(1)):false);
                    }
                });
            } else if(newValue == reserva_fins.getValue() && reserva_fins.getValue() != null && newValue != null) {
                reserva_desde.setDayCellFactory(picker -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isBefore(LocalDate.now()) || reserva_fins.getValue()!=null?date.isAfter(reserva_fins.getValue().minusDays(1)):false);
                    }
                });
            }
            if(newValue != null){
                ObservableList<Reserva> reservaitems = FXCollections.observableArrayList(reservaData);
                ObservableList<Reserva> reservaFiltrados = FXCollections.observableArrayList(reservaData);

                reservaFiltrados.clear();
                for(Reserva r:reservaitems){
                    if(((reserva_desde.getValue() != null && LocalDate.parse(r.getDataIngres()).isAfter(reserva_desde.getValue().minusDays(1))) && (reserva_fins.getValue() != null && LocalDate.parse(r.getDataIngres()).isBefore(reserva_fins.getValue().plusDays(1)))) || (reserva_desde.getValue() != null && reserva_fins.getValue() == null && LocalDate.parse(r.getDataIngres()).isAfter(reserva_desde.getValue().minusDays(1))) || (reserva_fins.getValue() != null && reserva_desde.getValue() == null && LocalDate.parse(r.getDataIngres()).isBefore(reserva_fins.getValue().plusDays(1)))){
                        reservaFiltrados.add(r);
                    }
                }
                tabla_reserves.setItems(reservaFiltrados);
            }
        }
    };

    private Map<Integer, Integer> arrayOfPreus = new HashMap<Integer, Integer>();
    private Integer reservaId;
    private Connection con;
    private HashMap<String , String> pane4_filt = new HashMap<String , String>();
    private String rol = "";
    private String oldDate = "";
    private String currentDir = System.getProperty("user.dir");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            con = BaseDeDatos.BDConnect ();
            t_numero_reserva.setCellValueFactory (new PropertyValueFactory<>("numReserva"));
            t_numero.setCellValueFactory (new PropertyValueFactory<>("numBungalow"));
            t_dni_client.setCellValueFactory (new PropertyValueFactory<> ("dniClient"));
            t_dni_recepcionista.setCellValueFactory (new PropertyValueFactory<> ("dniRecepcionista"));
            t_data_entrada.setCellValueFactory (new PropertyValueFactory<> ("dataIngres"));
            t_hora_entrada.setCellValueFactory (new PropertyValueFactory<> ("horaIngres"));
            t_data_sortida.setCellValueFactory (new PropertyValueFactory<> ("dataSortida"));
            t_hora_sortida.setCellValueFactory (new PropertyValueFactory<> ("horaSortida"));
            t_preu.setCellValueFactory (new PropertyValueFactory<> ("preuTotal"));
            t_estat.setCellValueFactory (new PropertyValueFactory<> ("estat"));
            combo_bungalow.getSelectionModel().selectedItemProperty().addListener(bungalowChange);
            check_esmorzar.selectedProperty().addListener(checkPreu1);
            check_massatge.selectedProperty().addListener(checkPreu2);
            check_spa.selectedProperty().addListener(checkPreu3);
            txtDataEntrada.valueProperty().addListener(limitDate);
            txtDataSortida.valueProperty().addListener(limitDate);
            reserva_desde.valueProperty().addListener(filterDateReserva);
            reserva_fins.valueProperty().addListener(filterDateReserva);
        } catch (SQLException ex) {
            Logger.getLogger (hotelController.class.getName ()).log (Level.SEVERE,null,ex);
        }
        ObservableList<String> listEstatReserva = FXCollections.observableArrayList("Reservada","Anulada","Pagada");
        combo_estatreserva.setItems(listEstatReserva);

        /*  JOEL */

        ObservableList<String> listEstat = FXCollections.observableArrayList("Disponible","Ocupada","En manteniment");
        estatComboBox.setItems(listEstat);
        estatComboBox.getSelectionModel().select("Disponible");
        ObservableList<String> listTipus = FXCollections.observableArrayList("Normal","Especial","VIP");
        tipusComboBox.setItems(listTipus);
        tipusComboBox.getSelectionModel().select("Normal");

        // Tabla Gestión de Bungalows
        updateTableBung();
        // Tabla Validación Usuarios
        updateTableValidUsu();
        // Tabla Gestión de Clientes
        updateTableClientes();
    }



    @FXML
    public ObservableList<Bungalow> updateTableBung(){
        // Tabla Gestión de Bungalows
        this.colN_Bungalow.setCellValueFactory(new PropertyValueFactory("num_bungalow"));
        this.colCaract.setCellValueFactory(new PropertyValueFactory("caracteristiques"));
        this.colPreu.setCellValueFactory(new PropertyValueFactory("preu"));
        this.colEstat.setCellValueFactory(new PropertyValueFactory("estat"));
        this.colTipus.setCellValueFactory(new PropertyValueFactory("tipus_bungalow"));

        Bungalow bung = new Bungalow();
        ObservableList<Bungalow> items = bung.listarBungalows();
        this.gestioBungalows.getItems().setAll(items);

        return items;

    }
    @FXML
    public void usuParam(String usuario, String pwd){
        Usuario usu = new Usuario(usuario, pwd);
        rol = usu.validateRol();
        // System.out.println(rol);

        if (rol.equals("admin")){
            hotel_caixa_1.setVisible(true);
            hotel_img.setVisible(true);
            equipatge_img.setVisible (true);
            ObservableList<Usuario> items = usu.listarUsuarios();
            if(!items.isEmpty()){
                bellTxt2.setText("Tens sol·licituds pendents");
                bellTxt1.setText("Tens sol·licituds pendents");
            }else{
                bellTxt2.setText("");
                bellTxt1.setText("");
            }

        }
        else if(rol.equals("user")){
            hotel_caixa_2.setVisible(true);
            habitacio_img.setVisible(true);
            client_img.setVisible(true);
            img_5.setVisible (true);
        }

    }

    public void nouBungalowClick(ActionEvent actionEvent) {
        estatComboBox.getSelectionModel().select("Disponible");
        tipusComboBox.getSelectionModel().select("Normal");
        numBungalow.setText("");
        preuBungalow.setText("");
        caracteristicasBungalow.setText("");
        numBungalow.setDisable(false);
        updateBungalow.setDisable(true);
        deleteBungalow.setDisable(true);
        insertBungalow.setDisable(false);

        errorBungalow.setText("");
    }

    public void updateBungalowClick(ActionEvent actionEvent) {

        String num_bungalow  = numBungalow.getText().trim();
        String caracteristiques = caracteristicasBungalow.getText().trim();
        String preu = preuBungalow.getText().trim();
        String estat = estatComboBox.getSelectionModel().getSelectedItem().toString();
        String tipus_bungalow = tipusComboBox.getSelectionModel().getSelectedItem().toString();


        if(!num_bungalow.equals("") && !caracteristiques.equals("") && !preu.equals("") && !estat.equals("") && !tipus_bungalow.equals("")){
            if (isInteger(preu) && isInteger(num_bungalow)){

                Bungalow bung = new Bungalow(num_bungalow, caracteristiques, preu, estat, tipus_bungalow);

                bung.updateBungalow();
                updateTableBung();
                errorBungalow.setText("");


            }else{
                errorBungalow.setText("El camp N.Bungalow i Preu han de ser números");
            }


        }else{
            errorBungalow.setText("Si us plau ompli tots els camps");
        }

    }

    public void deleteBungalowClick(ActionEvent actionEvent) {
        String num_bungalow  = numBungalow.getText().trim();
        Bungalow bung = new Bungalow(num_bungalow);

        bung.deleteBungalow();
        updateTableBung();
    }

    public boolean isInteger(String numero){
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public void insertBungalowClick(ActionEvent actionEvent) {

        String num_bungalow  = numBungalow.getText().trim();
        String caracteristiques = caracteristicasBungalow.getText().trim();
        String preu = preuBungalow.getText().trim();
        String estat = estatComboBox.getSelectionModel().getSelectedItem().toString();
        String tipus_bungalow = tipusComboBox.getSelectionModel().getSelectedItem().toString();


        if(!num_bungalow.equals("") && !caracteristiques.equals("") && !preu.equals("") && !estat.equals("") && !tipus_bungalow.equals("")){
            if (isInteger(preu) && isInteger(num_bungalow)){

                Bungalow bung = new Bungalow(num_bungalow, caracteristiques, preu, estat, tipus_bungalow);

                if (bung.validateNumBungalow()){
                    errorBungalow.setText("El número de la habitació ja existeix");
                }else {
                    bung.insertarBungalow();
                    updateTableBung();
                    errorBungalow.setText("");
                }


            }else{
                errorBungalow.setText("El camp N.Bungalow i Preu han de ser números");
            }



        }else{
            errorBungalow.setText("Si us plau ompli tots els camps");
        }

    }

    public void OnMouseClickedBungalow(MouseEvent mouseEvent) {

        Bungalow b = (Bungalow) gestioBungalows.getSelectionModel().getSelectedItem();

        if(b != null){
            numBungalow.setText(b.getNum_bungalow());
            numBungalow.setDisable(true);
            caracteristicasBungalow.setText(b.getCaracteristiques());
            preuBungalow.setText(b.getPreu());
            estatComboBox.getSelectionModel().select(b.getEstat());
            tipusComboBox.getSelectionModel().select(b.getTipus_bungalow());
            updateBungalow.setDisable(false);
            deleteBungalow.setDisable(false);
        }


    }

    public void ReleasedBungalow(KeyEvent keyEvent) {

        String filtroTxt = filtroBungalowTxt.getText();
        ObservableList<Bungalow> items = updateTableBung();
        ObservableList<Bungalow> filtroBungalows = updateTableBung();

        if (filtroTxt.isEmpty()){
            gestioBungalows.setItems(items);
        }else{
            filtroBungalows.clear();

            for(Bungalow b:items){
                if(b.getNum_bungalow().contains(filtroTxt) || b.getCaracteristiques().contains(filtroTxt) ||
                        b.getEstat().contains(filtroTxt) || b.getPreu().contains(filtroTxt) ||
                        b.getTipus_bungalow().contains(filtroTxt)){
                    filtroBungalows.add(b);
                }

            }

            UsuTaula.setItems(filtroBungalows);

        }

    }

    // ----------------------------------------------------------------------------

    // Metodos Validación de Recepcionistas (hotel_caixa_1)---------------------------------

    public void eliminaUsuClick(ActionEvent actionEvent) {
        Usuario usu = (Usuario) UsuTaula.getSelectionModel().getSelectedItem();

        if(usu != null){
            usu.deleteUsuari();
            updateTableValidUsu();
            errorUsu.setText("");
            ObservableList<Usuario> items = usu.listarUsuarios();
            if(!items.isEmpty()){
                bellTxt2.setText("Tens sol·licituds pendents");
                bellTxt1.setText("Tens sol·licituds pendents");
            }else{
                bellTxt2.setText("");
                bellTxt1.setText("");
            }
        }else{
            errorUsu.setText("Has de seleccionar un usuari");
        }


    }

    public void validaUsuClick(ActionEvent actionEvent) {
        Usuario usu = (Usuario) UsuTaula.getSelectionModel().getSelectedItem();

        if(usu != null){
            usu.validateUsuari();
            updateTableValidUsu();
            errorUsu.setText("");
            ObservableList<Usuario> items = usu.listarUsuarios();
            if(!items.isEmpty()){
                bellTxt2.setText("Tens sol·licituds pendents");
                bellTxt1.setText("Tens sol·licituds pendents");
            }else{
                bellTxt2.setText("");
                bellTxt1.setText("");
            }
        }else{
            errorUsu.setText("Has de seleccionar un usuari");
        }

    }

    public ObservableList<Usuario> updateTableValidUsu(){
        // Tabla Validación Usuarios
        this.colDniUsu.setCellValueFactory(new PropertyValueFactory("dni"));
        this.colEmailUsu.setCellValueFactory(new PropertyValueFactory("email"));
        this.colEstatUsu.setCellValueFactory(new PropertyValueFactory("estat"));

        Usuario usu = new Usuario();
        ObservableList<Usuario> items = usu.listarUsuarios();
        UsuTaula.setItems(items);

        return items;

    }

    public void filtroReleased(KeyEvent keyEvent) {

        String filtroTxt = filtreUsuariTxt.getText();
        ObservableList<Usuario> items = updateTableValidUsu();
        ObservableList<Usuario> filtroUsuarios = updateTableValidUsu();

        if (filtroTxt.isEmpty()){
            UsuTaula.setItems(items);
        }else{
            filtroUsuarios.clear();

            for(Usuario usu:items){
                if(usu.getDni().contains(filtroTxt) || usu.getEmail().contains(filtroTxt) || usu.getEstat().contains(filtroTxt)){
                    filtroUsuarios.add(usu);
                }

            }

            UsuTaula.setItems(filtroUsuarios);

        }

    }
    public void OnMouseClickedUsuari(MouseEvent mouseEvent) {
    }

    /*  fin joel */




    @FXML
    void move_effect(MouseEvent event) {
        //Cogemos primero la psoicion del circulo rectangulo
        Integer row_of = gridpane.getRowIndex(rectangle_mov);
        Node source = (Node) event.getSource();
        Integer row_to = gridpane.getRowIndex(source);
        double from_y = rectangle_mov.getLayoutY();
        if(row_of!=row_to){
            gridpane.getChildren().remove(rectangle_mov);
            gridpane.getChildren().remove(circulo_mov);
            rectangle_mov.setVisible(false);
            circulo_mov.setVisible(false);
            gridpane.add(rectangle_mov, 0, row_to);
            gridpane.add(circulo_mov, 0, row_to);
            root_anchor.layout();
            double to_y= rectangle_mov.getLayoutY();
            gridpane.getChildren().remove(rectangle_mov);
            gridpane.getChildren().remove(circulo_mov);
            gridpane.add(rectangle_mov, 0, row_of);
            gridpane.add(circulo_mov, 0, row_of);
            rectangle_mov.setVisible(true);
            circulo_mov.setVisible(true);
            TranslateTransition translate_rect = new TranslateTransition(Duration.seconds(0.45), rectangle_mov);
            TranslateTransition translate_circle = new TranslateTransition(Duration.seconds(0.45), circulo_mov);
            if(from_y<to_y){
                translate_rect.setToY(to_y-from_y);
                translate_circle.setToY(to_y-from_y);
            }else if(from_y>to_y){
                translate_rect.setToY(to_y-from_y);
                translate_circle.setToY(to_y-from_y);
            }
            circulo_mov.toBack();
            translate_circle.play();
            rectangle_mov.toBack();
            translate_rect.play();
            translate_rect.setOnFinished(e->{
                gridpane.getChildren().remove(rectangle_mov);
                rectangle_mov.setTranslateY(0);
                gridpane.add(rectangle_mov, 0, row_to);
                gridpane.setRowIndex(rectangle_mov, row_to);
                rectangle_mov.toBack();
            });
            translate_circle.setOnFinished(e->{
                gridpane.getChildren().remove(circulo_mov);
                circulo_mov.setTranslateY(0);
                gridpane.add(circulo_mov, 0, row_to);
                gridpane.setRowIndex(circulo_mov, row_to);
                circulo_mov.toBack();
            });

            if(rol.equals("admin")){
                if(row_to == 0){
                    hotel_caixa_1.setVisible(true);
                    hotel_caixa_3.setVisible(false);
                }
                else if(row_to==1){
                    hotel_caixa_1.setVisible(false);
                    hotel_caixa_3.setVisible(true);
                }
            } else if(rol.equals("user")){
                if(row_to == 0){
                    hotel_caixa_2.setVisible(true);
                    hotel_caixa_4.setVisible(false);
                    hotel_caixa_5.setVisible(false);
                }
                else if(row_to==1){
                    hotel_caixa_2.setVisible(false);
                    hotel_caixa_4.setVisible(true);
                    hotel_caixa_5.setVisible(false);
                    loadDatosVistaReserva();
                }
                else if(row_to==2){
                    hotel_caixa_2.setVisible(false);
                    hotel_caixa_4.setVisible(false);
                    hotel_caixa_5.setVisible(true);
                    loadDatosVistaComprovant();
                }

            }
        }
    }

    public void handle(MouseEvent mouseEvent) {
        Stage stage = (Stage) (rectangle_mov).getScene().getWindow();
        stage.close();
    }

    public void loadDatosVistaReserva(){
        try{
            reservaData.clear();
            reserva_desde.setValue(null);
            reserva_fins.setValue(null);
            afegirReserva.setText("Afegir");
            afegirReserva.setOnMouseClicked(this::registreReserva);
            afegirReserva.setMinWidth(73);
            combo_estatreserva.setVisible(false);
            label_estatreserva.setVisible(false);
            tabla_reserves.getItems().clear();
            tabla_reserves.setRowFactory(rr -> {
                TableRow<Reserva> row = new TableRow<>();

                    row.setOnMouseClicked(event -> {
                        if(!row.isEmpty()){
                            if(row.getItem().getEstat() != null && !row.getItem().getEstat().contains("Reservada")){
                                Alert a = new Alert(Alert.AlertType.ERROR);
                                a.setTitle("Error al seleccionar reserva");
                                a.setHeaderText("La reserva está: "+row.getItem().getEstat().toUpperCase());
                                a.show();
                            } else{
                                this.reservaId = row.getItem().getNumReserva();
                                afegirReserva.setText("Actualitzar");
                                afegirReserva.setOnMouseClicked(this::updateReserva);
                                afegirReserva.setMinWidth(83);
                                combo_estatreserva.setVisible(true);
                                combo_estatreserva.setValue(row.getItem().getEstat());
                                label_estatreserva.setVisible(true);
                                combo_bungalow.getSelectionModel().select(row.getItem().getNumBungalow());
                                combo_bungalow.setDisable(true);
                                combo_client.getSelectionModel().select(row.getItem().getDniClient());
                                combo_client.setDisable(true);
                                combo_recepcionista.getSelectionModel().select(row.getItem().getDniRecepcionista());
                                combo_recepcionista.setDisable(true);
                                this.oldDate = row.getItem().getDataIngres();
                                txtDataEntrada.setValue(LocalDate.parse(row.getItem().getDataIngres()));
                                txtDataSortida.setValue(LocalDate.parse(row.getItem().getDataSortida()));
                                h_entrada.setValue(LocalTime.parse(row.getItem().getHoraIngres()));
                                Integer preuReal = arrayOfPreus.get(row.getItem().getNumBungalow());
                                Integer preuTotal = row.getItem().getPreuTotal();
                                if (preuTotal != preuReal) {
                                    Integer preuExtres = preuTotal - preuReal;
                                    if (preuExtres - 50 == 0 || (preuExtres - 50 > 0 && (preuExtres - 75 == 0 || preuExtres - 80 == 0 || preuExtres - 105 == 0))) {
                                        check_massatge.setSelected(true);
                                    } else {
                                        check_massatge.setSelected(false);
                                    }
                                    if (preuExtres - 25 == 0 || (preuExtres - 50 > 0 && (preuExtres - 75 == 0 || preuExtres - 55 == 0 || preuExtres - 105 == 0))) {
                                        check_esmorzar.setSelected(true);
                                    } else {
                                        check_esmorzar.setSelected(false);
                                    }
                                    if (preuExtres - 30 == 0 || (preuExtres - 50 > 0 && (preuExtres - 80 == 0 || preuExtres - 55 == 0 || preuExtres - 105 == 0))) {
                                        check_spa.setSelected(true);
                                    } else {
                                        check_spa.setSelected(false);
                                    }
                                }
                            }
                        }
                    });
                return row;
            });
            combo_client.getItems().clear();
            combo_client.setValue(null);
            combo_client.setDisable(false);
            combo_recepcionista.getItems().clear();
            combo_recepcionista.setValue(null);
            combo_recepcionista.setDisable(false);
            combo_bungalow.getItems().clear();
            combo_bungalow.setValue(null);
            combo_bungalow.setDisable(false);
            ResultSet reservas = con.createStatement().executeQuery("SELECT * FROM allotjament");

            ResultSet client = con.createStatement().executeQuery("SELECT dni FROM client");

            ResultSet sql_recep = con.createStatement().executeQuery("SELECT dni FROM usuari WHERE rol = 'user' && estat = 'active'");

            ResultSet sql_bungalow = con.createStatement().executeQuery("SELECT num_bungalow, preu FROM bungalow");

            while (reservas.next()) {
                Reserva reserva = new Reserva(reservas.getInt("id"),reservas.getInt("num_bungalow"), reservas.getString("dni_client"), reservas.getString("dni_recepcionista"), reservas.getString("data_ingres"), reservas.getString("hora_ingres"), reservas.getString("data_sortida"), reservas.getString("hora_sortida"), reservas.getInt("preu_total"), reservas.getString("estat"));
                reservaData.add(reserva);
                tabla_reserves.getItems().add(reserva);
                if(!reservas.getString("estat").contains("Anulada")){
                    String[] daterange = {reservas.getString("data_ingres"), reservas.getString("data_sortida")};
                    if(dateranges.get(reservas.getInt("num_bungalow")) == null){
                        dateranges.put(reservas.getInt("num_bungalow"), new Stack<String[]>());
                    }
                    dateranges.get(reservas.getInt("num_bungalow")).push(daterange);
                }
            }
            while (client.next()) {
                combo_client.getItems().add(client.getString("dni"));
            }
            while (sql_recep.next()) {
                combo_recepcionista.getItems().add(sql_recep.getString("dni"));
            }
            while (sql_bungalow.next()) {
                combo_bungalow.getItems().add(sql_bungalow.getInt("num_bungalow"));
                arrayOfPreus.put(sql_bungalow.getInt("num_bungalow"), sql_bungalow.getInt("preu"));
            }
            txtDataEntrada.setDayCellFactory(picker -> new DateCell() {
                @Override
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    setDisable(empty || date.isBefore(LocalDate.now()));
                }
            });
            txtDataSortida.setDayCellFactory(picker -> new DateCell() {
                @Override
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    setDisable(empty || date.isBefore(LocalDate.now()));
                }
            });
            h_entrada.setValue(null);
            txtDataEntrada.setValue(null);
            txtDataSortida.setValue(null);
            combo_client.getSelectionModel().clearSelection();
            combo_recepcionista.getSelectionModel().clearSelection();
            combo_bungalow.getSelectionModel().clearSelection();
            check_esmorzar.setSelected(false);
            check_massatge.setSelected(false);
            check_spa.setSelected(false);
            preu_total.setText("0 €");
        } catch (SQLException ex){
            Logger.getLogger (hotelController.class.getName ()).log (Level.SEVERE,null,ex);
        }


    }


    public void registreReserva(MouseEvent mouseEvent) {
        pane4_filt.clear();
        for(Node node: pane_hotel4.getChildren()){
            if(node.getId() != null && pane4_filt.size()<6){
                if(node.getClass() == ComboBox.class){
                    if(((ComboBox) node).getValue() == null && ((ComboBox) node).isVisible()){
                        pane4_filt.put("EL "+node.getId().split("_")[1].toString().toUpperCase(),null);
                    } else if(((ComboBox) node).isVisible()){
                        pane4_filt.put("EL "+node.getId().split("_")[1].toString().toUpperCase(),((ComboBox) node).getValue().toString());
                    }
                } else if(node.getClass() == DatePicker.class){
                    if(((DatePicker) node).getValue() == null){
                        pane4_filt.put("LA DATA DE "+node.getId().split("Data")[1].toString().toUpperCase(), null);
                    }
                    else{
                        pane4_filt.put("LA DATA DE "+node.getId().split("Data")[1].toString().toUpperCase(), ((DatePicker) node).getValue().toString());
                    }
                } else if(node.getClass() == JFXTimePicker.class){
                    if(((JFXTimePicker) node).getValue() == null){
                        pane4_filt.put("LA HORA DE "+node.getId().split("_")[1].toString().toUpperCase(), null);
                    }
                    else{
                        pane4_filt.put("LA HORA DE "+node.getId().split("_")[1].toString().toUpperCase(), ((JFXTimePicker) node).getValue().toString());
                    }
                }
            }
        }
        List<String> filter_p4 = Arrays.asList(pane4_filt.entrySet().stream().filter(x->x.getValue()==null).map(x->x.getKey()).collect(Collectors.joining(",")).split(","));
        if(filter_p4.size() > 0 && !"".equals(filter_p4.get(0))){
            Collections.sort(filter_p4);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error al registrar reserva");
            a.setHeaderText("Debes de completar todos los parametros");
            String content = "Faltan por completar los campos:\n"+String.join("\n", filter_p4);
            a.setContentText(content);
            a.show();
        }
        else{
            try{

                con.createStatement().executeUpdate("INSERT INTO `allotjament`(`num_bungalow`, `dni_recepcionista`, `dni_client`, `data_ingres`, `hora_ingres`, " +
                        "`data_sortida`, `hora_sortida`, `preu_total`, `estat`) VALUES ('"+combo_bungalow.getValue()+"','"+combo_recepcionista.getValue()+"'," +
                        "'"+combo_client.getValue()+"','"+txtDataEntrada.getValue().toString()+"','"+h_entrada.getValue().toString()+"','"+txtDataSortida.getValue().toString()+"','Pendent',"
                        +preu_total.getText().split(" ")[0]+",'Reservada');");

            } catch (SQLException ex) {
                Logger.getLogger (hotelController.class.getName ()).log (Level.SEVERE,null,ex);
            }
            loadDatosVistaReserva();
        }
    }

    public void updateReserva(MouseEvent mouseEvent){
        try{
            String h_entrada_upd = "Pendent";
            if(combo_estatreserva.getValue() == "Pagada"){
                h_entrada_upd = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString();
            }
            con.createStatement().executeUpdate("UPDATE `allotjament` SET `data_ingres` = '"+txtDataEntrada.getValue().toString()+"', `hora_ingres`='"+h_entrada.getValue().toString()+"', " +
                    "`data_sortida`='"+txtDataSortida.getValue().toString()+"', `hora_sortida`='"+h_entrada_upd+"', `preu_total`="+preu_total.getText().split(" ")[0]+", `estat`='"+this.combo_estatreserva.getValue()+"' WHERE `id`="+this.reservaId+";");

        } catch (SQLException ex) {
            Logger.getLogger (hotelController.class.getName ()).log (Level.SEVERE,null,ex);
        }
        loadDatosVistaReserva();
    }

    public void loadDatosVistaComprovant(){
        tabla_comprovant.getItems ().clear ();
        try {
            ResultSet comprovants = con.createStatement ().executeQuery ("SELECT * FROM allotjament INNER JOIN client ON dni_client=dni");

            while (comprovants.next ()) {
                tabla_comprovant.getItems ().add (new Comprovant (comprovants.getInt("id"),comprovants.getString ("dni"),comprovants.getString ("nom"),comprovants.getString ("cognoms"),comprovants.getString ("data_sortida"),comprovants.getString ("hora_sortida"),comprovants.getInt ("preu_total"),comprovants.getInt ("num_bungalow")));

            }
        } catch (SQLException ex) {
            Logger.getLogger (hotelController.class.getName ()).log (Level.SEVERE,null,ex);
        }

        t_dni_client_comprovant.setCellValueFactory (new PropertyValueFactory<> ("dniClientComprovant"));
        t_nom.setCellValueFactory (new PropertyValueFactory<> ("nom"));
        t_cognoms.setCellValueFactory (new PropertyValueFactory<> ("cognoms"));
        t_data_sortida_comprovant.setCellValueFactory (new PropertyValueFactory<> ("dataSortidaComprovant"));
        t_hora_sortida_comprovant.setCellValueFactory (new PropertyValueFactory<> ("horaSortidaComprovant"));
        t_preu_comprovant.setCellValueFactory (new PropertyValueFactory<> ("preuTotalComprovant"));
        t_numero_comprovant.setCellValueFactory (new PropertyValueFactory<> ("numBungalowComprovant"));


    }
    @FXML
    public void btnImprimir(ActionEvent actionEvent) throws IOException, DocumentException{
        if(Files.notExists(Paths.get(currentDir+"/src/sample/comprovants/"))){
            File Dcomp = new File (currentDir+"/src/sample/comprovants/");
            Dcomp.mkdir();
        }
        Comprovant fila = this.tabla_comprovant.getSelectionModel().getSelectedItem();
        //Si el valor no es nulo
        if(fila != null) {
            //igualem les variables
            String dni_compro = fila.getDniClientComprovant ();
            String nom_compro = fila.getNom ();
            String cog_compro = fila.getCognoms ();
            String dat_compro = fila.getDataSortidaComprovant ();
            String hor_compro = fila.getHoraSortidaComprovant ();
            Integer pre_compro = fila.getPreuTotalComprovant ();
            Integer bun_compro = fila.getNumBungalowComprovant ();
            Integer n_reserva = fila.getNumReserva();

            //creació de carpeta
            File D = new File (currentDir+"/src/sample/comprovants/" + dni_compro+"_"+n_reserva);
            boolean Directori = D.mkdir ();
            System.out.println (Directori);
            if (Directori) {
                JOptionPane.showMessageDialog (null,"S'ha creat satisfactoriament","Creat Satisfactoriament",JOptionPane.PLAIN_MESSAGE);
                System.out.println ("S'ha creat satisfactoriament");
            } else {
                JOptionPane.showMessageDialog (null,"Error, la carpeta ja existeix!","Ja existeix",JOptionPane.PLAIN_MESSAGE);
                System.out.println ("Error, la carpeta ja existeix!");
            }

            Integer numero_incremental = 0;
            Integer serie = 0;
            serie = numero_incremental + 1;


            OutputStream file = new FileOutputStream(new File (currentDir+"/src/sample/comprovants/" + dni_compro+"_"+n_reserva + "/" + dni_compro + "_" + serie + ".pdf"));

            Document document = new Document ();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


            PdfWriter.getInstance (document,file);


            document.open();

            Image imagen = Image.getInstance(currentDir+"/src/sample/img/logo_hotel.png");

            String avui = dtf.format(LocalDateTime.now());

            Paragraph presentacio = new Paragraph ("Comprovant del client amb dni: " + dni_compro ,FontFactory.getFont ("System",16,Font.BOLD,BaseColor.BLACK));
            Paragraph nom = new Paragraph ("Nom:  " + nom_compro ,FontFactory.getFont ("System",16,Font.BOLD,BaseColor.BLACK));
            Paragraph cognom = new Paragraph ("Cognoms:  " + cog_compro ,FontFactory.getFont ("System",16,Font.BOLD,BaseColor.BLACK));
            Paragraph data = new Paragraph ("Data impresa:  " + avui,FontFactory.getFont ("System",16,Font.BOLD,BaseColor.BLACK));
            Paragraph butlleti = new Paragraph ("Botlletí:  " + serie ,FontFactory.getFont ("System",16,Font.BOLD,BaseColor.BLACK));
            Paragraph precio = new Paragraph ("Comprovant de l'usuari " + nom_compro + " amb dni: " + dni_compro,FontFactory.getFont ("System",16,Font.BOLD,BaseColor.MAGENTA));
            Paragraph blanco1 = new Paragraph (" ");
            Paragraph blanco2 = new Paragraph (" ");

            PdfPTable table = new PdfPTable (3);


            float[] mediaceldas = {33.3f, 33.3f, 33.3f};

            table.setWidths (mediaceldas);
            table.addCell (new Paragraph ("Numero Reserva",FontFactory.getFont ("System",16,Font.BOLD,BaseColor.ORANGE)));
            table.addCell (new Paragraph ("Numero Bungalow",FontFactory.getFont ("System",16,Font.BOLD,BaseColor.ORANGE)));
            table.addCell (new Paragraph ("Preu total",FontFactory.getFont ("System",16,Font.BOLD,BaseColor.ORANGE)));

            table.addCell (new Paragraph (String.valueOf (n_reserva),FontFactory.getFont ("System",16,Font.BOLD,BaseColor.BLUE)));
            table.addCell (new Paragraph (String.valueOf (bun_compro),FontFactory.getFont ("System",16,Font.BOLD,BaseColor.BLUE)));
            table.addCell (new Paragraph (String.valueOf (pre_compro),FontFactory.getFont ("System",16,Font.BOLD,BaseColor.BLUE)));

            imagen.setAlignment(Element.ALIGN_CENTER);
            presentacio.setAlignment (Element.ALIGN_CENTER);
            document.add(imagen);
            document.add (presentacio);
            document.add (nom);
            document.add (cognom);
            document.add (data);
            document.add (butlleti);
            document.add (blanco1);
            document.add (blanco2);
            //document.newPage ();
            document.add (table);

            document.close();
            file.close ();

        }else{
            JOptionPane.showMessageDialog (null,"Has de seleccionar una fila de la taula","Error",JOptionPane.PLAIN_MESSAGE);
        }


    }

    public void selectTipus (ActionEvent actionEvent){
    }

    public void estatSelect (ActionEvent actionEvent){
    }


    public ObservableList<Cliente> updateTableClientes(){
        // Tabla Gestión de Clientes
        this.colDniCliente.setCellValueFactory(new PropertyValueFactory("dni"));
        this.colNomCliente.setCellValueFactory(new PropertyValueFactory("nom"));
        this.colApellCliente.setCellValueFactory(new PropertyValueFactory("cognoms"));
        this.colNacioCliente.setCellValueFactory(new PropertyValueFactory("nacionalitat"));
        this.colEmailCliente.setCellValueFactory(new PropertyValueFactory("email"));
        this.colOcupacioCliente.setCellValueFactory(new PropertyValueFactory("ocupacio"));
        this.colEstCivilCliente.setCellValueFactory(new PropertyValueFactory("estat_civil"));


        Cliente cli = new Cliente();
        ObservableList<Cliente> items = cli.listarClientes();
        this.tablaClientes.setItems(items);

        return items;
    }

    public void nouClienteClick(ActionEvent actionEvent) {

        dniTxtCliente.setText("");
        nomTxtCliente.setText("");
        nacioTxtCliente.setText("");
        emailTxtCliente.setText("");
        ocupacioTxtCliente.setText("");
        cognomsTxtCliente.setText("");
        estatCivilTxtCliente.setText("");
        phoneTxtCliente.setText("");

        dniTxtCliente.setDisable(false);
        updateCliente.setDisable(true);
        deleteCliente.setDisable(true);
        insertCliente.setDisable(false);

        errorCliente.setText("");


    }

    public void updateClienteClick(ActionEvent actionEvent) {
        String dni  = dniTxtCliente.getText().trim();
        String nom = nomTxtCliente.getText().trim();
        String cognoms = cognomsTxtCliente.getText().trim();
        String nacionalitat = nacioTxtCliente.getText().trim();
        String email = emailTxtCliente.getText().trim();
        String ocupacio = ocupacioTxtCliente.getText().trim();
        String estat_civil = estatCivilTxtCliente.getText().trim();
        String telefon = phoneTxtCliente.getText().trim();

        if(!dni.equals("") && !nom.equals("") && !cognoms.equals("") && !nacionalitat.equals("") && !email.equals("") && !ocupacio.equals("") && !estat_civil.equals("") && !telefon.equals("")){
            if (isInteger(telefon)){

                Cliente cli = new Cliente(dni, email, nom, cognoms, nacionalitat, telefon, ocupacio, estat_civil);

                cli.updateCliente();
                updateTableClientes();
                errorCliente.setText("");


            }else{
                errorCliente.setText("El camp Telefon ha d'estar format per números");
            }


        }else{
            errorCliente.setText("Si us plau ompli tots els camps");
        }
    }

    public void deleteClienteClick(ActionEvent actionEvent) {
        String dni  = dniTxtCliente.getText().trim();
        Cliente cli = new Cliente(dni);

        cli.deleteCliente();
        updateTableClientes();

    }

    public void insertClienteClick(ActionEvent actionEvent) {
        String dni  = dniTxtCliente.getText().trim();
        String nom = nomTxtCliente.getText().trim();
        String cognoms = cognomsTxtCliente.getText().trim();
        String nacionalitat = nacioTxtCliente.getText().trim();
        String email = emailTxtCliente.getText().trim();
        String ocupacio = ocupacioTxtCliente.getText().trim();
        String estat_civil = estatCivilTxtCliente.getText().trim();
        String telefon = phoneTxtCliente.getText().trim();


        if(!dni.equals("") && !nom.equals("") && !cognoms.equals("") && !nacionalitat.equals("") && !email.equals("") && !ocupacio.equals("") && !estat_civil.equals("") && !telefon.equals("")){
            if (isInteger(telefon)){

                Cliente cli = new Cliente(dni, email, nom, cognoms, nacionalitat, telefon, ocupacio, estat_civil);

                if (cli.validateDni()){
                    errorCliente.setText("El DNI d'aquest client ja està registrat");
                }else {
                    cli.insertarCliente();
                    updateTableClientes();
                    errorCliente.setText("");
                }


            }else{
                errorCliente.setText("El camp Telefon ha d'estar format per números");
            }


        }else{
            errorCliente.setText("Si us plau ompli tots els camps");
        }



    }

    public void OnMouseClickedClientes(MouseEvent mouseEvent) {

        Cliente c = (Cliente) tablaClientes.getSelectionModel().getSelectedItem();

        if(c != null){
            dniTxtCliente.setText(c.getDni());
            dniTxtCliente.setDisable(true);
            nomTxtCliente.setText(c.getNom());
            cognomsTxtCliente.setText(c.getCognoms());
            nacioTxtCliente.setText(c.getNacionalitat());
            emailTxtCliente.setText(c.getEmail());
            ocupacioTxtCliente.setText(c.getOcupacio());
            estatCivilTxtCliente.setText(c.getEstat_civil());
            phoneTxtCliente.setText(c.getTelefon());

            updateCliente.setDisable(false);
            deleteCliente.setDisable(false);
        }


    }
    public void filtroClienteReleased(KeyEvent keyEvent) {
        String filtroTxt = filtroClienteTxt.getText();
        ObservableList<Cliente> items = updateTableClientes();
        ObservableList<Cliente> clientesFiltrados = updateTableClientes();

        if (filtroTxt.isEmpty()){
            tablaClientes.setItems(items);
        }else{
            clientesFiltrados.clear();

            for(Cliente c:items){
                if(c.getDni().contains(filtroTxt) || c.getNom().contains(filtroTxt) ||
                        c.getCognoms().contains(filtroTxt) || c.getNacionalitat().contains(filtroTxt) ||
                        c.getEmail().contains(filtroTxt) || c.getOcupacio().contains(filtroTxt) ||
                        c.getEstat_civil().contains(filtroTxt)){
                    clientesFiltrados.add(c);
                }
            }
            tablaClientes.setItems(clientesFiltrados);
        }
    }

    public void btn_imprimir_client(ActionEvent actionEvent) {
    }

    public void btn_imprimir_bungalow(ActionEvent actionEvent) {
    }
}
