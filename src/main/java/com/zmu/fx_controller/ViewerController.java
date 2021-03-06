package com.zmu.fx_controller;

import com.zmu.fx_controller.util.UtilService;
import com.zmu.model.Good;
import com.zmu.service.CarService;
import com.zmu.service.ClothesService;
import com.zmu.service.MachineService;
import com.zmu.service.MaterialService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ViewerController<T extends Good> {
    @Autowired
    private UtilService utilService;
    @Autowired
    private CarService carService;
    @Autowired
    private ClothesService clothesService;
    @Autowired
    private MachineService machineService;
    @Autowired
    private MaterialService materialService;

    public ComboBox<String> category;
    public TableView table;
    public Button back;
    public Button show;

    @FXML
    public void initialize() {
        utilService.changeScene(back, "/views/accounting.fxml");
        TableColumn<T, String> id = new TableColumn<>("ID");
        TableColumn<T, String> name = new TableColumn<>("Име");
        TableColumn<T, String> invoice = new TableColumn<>("Фактура");
        TableColumn<T, String> measurement = new TableColumn<>("Мярка");
        TableColumn<T, String> quantity = new TableColumn<>("Количество");
        TableColumn<T, String> price = new TableColumn<>("Единична Цена");
        TableColumn<T, String> totalPrice = new TableColumn<>("Общо");
        TableColumn<T, String> date = new TableColumn<>("Дата");
        TableColumn<T, String> supplier = new TableColumn<>("Доставчик");


        category.setItems(FXCollections.observableArrayList("Koли", "ЛПС", "Материали", "Машини"));

        table.getColumns().addAll(id, name, invoice, measurement, quantity, price, totalPrice, date, supplier);

        category.setOnAction(e -> {
            id.setCellValueFactory(
                    new PropertyValueFactory<>("id"));
            name.setCellValueFactory(
                    new PropertyValueFactory<>("name"));
            invoice.setCellValueFactory(
                    new PropertyValueFactory<>("numberOfInvoice")
            );
            measurement.setCellValueFactory(
                    new PropertyValueFactory<>("measurement")
            );
            quantity.setCellValueFactory(
                    new PropertyValueFactory<>("quantity")
            );
            price.setCellValueFactory(
                    new PropertyValueFactory<>("price")
            );
            totalPrice.setCellValueFactory(
                    new PropertyValueFactory<>("totalPrice")
            );
            date.setCellValueFactory(
                    new PropertyValueFactory<>("date")
            );
            supplier.setCellValueFactory(
                    new PropertyValueFactory<>("supplier")
            );

            List list = getList(category.getValue());
            final ObservableList data = FXCollections.observableArrayList(list);
            table.setItems(data);
        });
        utilService.changeScene(show, "/views/graphics.fxml");
        utilService.changeScene(back, "/views/accounting.fxml");
    }

    public List getList(String value) {
        switch (value) {
            case "Koли":
                return carService.findAll();
            case "ЛПС":
                return clothesService.findAll();
            case "Материали":
                return materialService.findAll();
            case "Машини":
                return machineService.findAll();
            default:
                return null;
        }
    }

}
