package sample;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable //implements interface called Initializable (set default values for the object before its used)
{
    @FXML //In order to access actors, we need a hook or handle to them
    private ListView<Employee> employeeListView; //have to use same name as FXML file to access it
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private CheckBox isActiveCheckBox;
    @FXML
    private Button deleteSelected;
    @FXML
    private Button clearFields;
    @FXML
    private Button addFields;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<Employee> items = employeeListView.getItems(); //named "items" because we need the items from the employeeListView

        //hooking into
        employeeListView.getSelectionModel().selectedItemProperty().addListener
    ((
        ObservableValue < ? extends Worker> ov, Worker old_val, Worker new_val)-> //listeners always have an old value and new value
        {
        Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem(); //get the selected item
         firstNameTextField.setText(((Employee)selectedItem).firstName);
         lastNameTextField.setText(((Employee)selectedItem).lastName);
         isActiveCheckBox.setSelected(((Employee)selectedItem).isActive);

            deleteSelected.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent actionEvent)
                {
                    items.remove(selectedItem);
                }
            });

            isActiveCheckBox.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent actionEvent)
                {
                    if (((Employee)selectedItem).isActive == false)
                    {
                        selectedItem.hire();
                        isActiveCheckBox.setSelected(((Employee) selectedItem).isActive);
                    }
                    else
                    {
                        selectedItem.fire();
                        isActiveCheckBox.setSelected(((Employee) selectedItem).isActive);
                    }
                }
            });
        }
    );
        clearFields.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                firstNameTextField.clear();
                lastNameTextField.clear();
                isActiveCheckBox.setSelected(false);
            }
        });
        addFields.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                Employee newEmp = new Employee();
                newEmp.firstName = firstNameTextField.getText();
                newEmp.lastName = lastNameTextField.getText();
                newEmp.isActive = isActiveCheckBox.isSelected();
                items.add(newEmp);
            }
        });

       Employee employee1 = new Employee ();
       Employee employee2 = new Employee ();
       employee1.firstName = "Robert";
       employee1.lastName = "Smith";
       employee2.firstName = "Lisa";
       employee2.lastName = "Smith";
       items.add(employee1);
       items.add(employee2);

        for (int i = 0; i < 10; i++)
        {
            Employee employee = new Employee();
            employee.firstName = "Generic";
            employee.lastName = "Employee" + " " + i;
            employee.hire();
            items.add(employee);
        }

        Staff staff1 = new Staff();
        staff1.firstName = "StaffPerson";
        staff1.lastName = "GoodWorker";
        Faculty faculty1 = new Faculty();
        faculty1.firstName = "FacultyPerson";
        faculty1.lastName = "TerribleWorker";
        items.add(staff1);
        items.add(faculty1);
    }

}
