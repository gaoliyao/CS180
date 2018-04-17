import javax.swing.*;
import java.util.List;
import java.util.Optional;

/**
 * A search controller of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class SearchController {
    /**
     * The inventory model of this search controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The search view of this search controller.
     */
    private SearchView searchView;

    /**
     * Constructs a newly allocated {@code SearchController} object with the specified inventory model and search view.
     *
     * @param inventoryModel the inventory model of this search controller
     * @param searchView the search view of this search controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code searchView} argument is
     * {@code null}
     */
    public SearchController(InventoryModel inventoryModel, SearchView searchView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (searchView == null) {
            throw new IllegalArgumentException("searchView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.searchView = searchView;

            this.searchView.getSearchButton().addActionListener(e -> this.getSearchButtonSemantics());

            this.searchView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //SearchController

    /**
     * Gets the semantics of a search view's search button.
     */
    private void getSearchButtonSemantics() {
        //TODO implement method
        String selectedField = this.searchView.getFieldComboBox().getSelectedItem().toString();
        if (selectedField.isEmpty()){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame,
                    "Cannot be empty",
                    "Product Inventory",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String selectedValue = this.searchView.getSearchValueTextField().getText();
        List<Product> searchResult = null;
        if (selectedField.equalsIgnoreCase("sku")) {
            Optional<Product> product = this.inventoryModel.searchBySku(selectedValue);
            this.searchView.getResultsTextArea().setText(product.get().toString());
        }
        if (selectedField.equalsIgnoreCase("name")) {
            searchResult = this.inventoryModel.searchByName(selectedValue);
        }
        if (selectedField.equalsIgnoreCase("wholesale price")) {
            if (isNumeric(selectedValue)) {
                searchResult = this.inventoryModel.searchByName(selectedValue);
            }
            else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                        "Invalid number",
                        "Product Inventory",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (selectedField.equalsIgnoreCase("retail price")) {
            if (isNumeric(selectedValue)) {
                searchResult = this.inventoryModel.searchByName(selectedValue);
            }
            else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                        "Invalid number",
                        "Product Inventory",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (selectedField.equalsIgnoreCase("quantity")) {
            if (isInteger(selectedValue)) {
                searchResult = this.inventoryModel.searchByName(selectedValue);
            }
            else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                        "Invalid number",
                        "Product Inventory",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (searchResult != null) {
            String result = "";
            for (Product product : searchResult) {
                result += product.toString() + "\n";
            }
            this.searchView.getResultsTextArea().setText(result);
        }
    } //getSearchButtonSemantics

    /**
     * Gets the semantics of a search view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
        this.searchView.getFieldComboBox().setSelectedIndex(-1);
        this.searchView.getSearchValueTextField().setText("");
        this.searchView.getResultsTextArea().setText("");
    } //getClearButtonSemantics

    boolean isInteger(String str){
        for (char c: str.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    /**
     * Gets the hash code of this search controller.
     *
     * @return the hash code of this search controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.searchView == null ? 0 : this.searchView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this search controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code SearchController}, and its field values are equal to
     * this search controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this search controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof SearchController)
                && (this.inventoryModel == null ? ((SearchController) anObject).inventoryModel ==  null : this.inventoryModel.equals(((SearchController) anObject).inventoryModel))
                && (this.searchView == null ? ((SearchController) anObject).searchView ==  null : this.searchView.equals(((SearchController) anObject).searchView));
    } //equals

    /**
     * Gets a {@code String} representation of this search controller.
     *
     * @return a {@code String} representation of this search controller
     */
    @Override
    public String toString() {
        return String.format("SearchController[%s, %s]", this.inventoryModel, this.searchView);
    } //toString
}