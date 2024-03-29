import javax.swing.*;
import java.util.Optional;

/**
 * An update controller of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class UpdateController {
    /**
     * The inventory model of this update controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The update view of this update controller.
     */
    private UpdateView updateView;

    /**
     * Constructs a newly allocated {@code UpdateController} object with the specified inventory model and update view.
     *
     * @param inventoryModel the inventory model of this update controller
     * @param updateView the update view of this update controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code updateView} argument is
     * {@code null}
     */
    public UpdateController(InventoryModel inventoryModel, UpdateView updateView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (updateView == null) {
            throw new IllegalArgumentException("updateView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.updateView = updateView;

            this.updateView.getUpdateButton().addActionListener(e -> this.getUpdateButtonSemantics());

            this.updateView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //UpdateController

    /**
     * Gets the semantics of an update view's update button.
     */
    private void getUpdateButtonSemantics() {
        //TODO implement method
        String updateItem = this.updateView.getFieldComboBox().getSelectedItem().toString();
        String updateVal = this.updateView.getNewFieldValueTextField().getText();
        String sku = this.updateView.getSkuTextField().getText();
        if (updateItem.equalsIgnoreCase("name")){
            Optional<Product> product = inventoryModel.searchBySku(sku);
            if (product.isPresent()){
                product.get().setName(updateVal);
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                        "The product's name has been updated",
                        "Product Inventory",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                        "Not exists",
                        "Product Inventory",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            Optional<Product> product = inventoryModel.searchBySku(sku);
            if (product.isPresent()){
                if (updateItem.equalsIgnoreCase("wholesale Price")) {
                    if (isNumeric(updateVal)) {
                        product.get().setWholesalePrice(Double.parseDouble(updateVal));
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame,
                                "The product's wholesale Price has been updated",
                                "Product Inventory",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame,
                                "Invalid number",
                                "Product Inventory",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (updateItem.equalsIgnoreCase("retail Price")) {
                    if (isNumeric(updateVal)) {
                        product.get().setWholesalePrice(Double.parseDouble(updateVal));
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame,
                                "The product's retail Price has been updated",
                                "Product Inventory",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame,
                                "Invalid number",
                                "Product Inventory",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (updateItem.equalsIgnoreCase("quantity")) {
                    if (isInteger(updateVal)) {
                        product.get().setWholesalePrice(Integer.parseInt(updateVal));
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame,
                                "The product's quantity has been updated",
                                "Product Inventory",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame,
                                "Invalid number",
                                "Product Inventory",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
            else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                        "Not exists",
                        "Product Inventory",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        getClearButtonSemantics();
    } //getUpdateButtonSemantics

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
     * Gets the semantics of an update view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
        this.updateView.getFieldComboBox().setSelectedIndex(-1);
        this.updateView.getSkuTextField().setText("");
        this.updateView.getNewFieldValueTextField().setText("");
    } //getClearButtonSemantics

    /**
     * Gets the hash code of this update controller.
     *
     * @return the hash code of this update controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.updateView == null ? 0 : this.updateView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this update controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code UpdateController}, and its field values are equal to
     * this update controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this update controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof UpdateController)
                && (this.inventoryModel == null ? ((UpdateController) anObject).inventoryModel ==  null : this.inventoryModel.equals(((UpdateController) anObject).inventoryModel))
                && (this.updateView == null ? ((UpdateController) anObject).updateView ==  null : this.updateView.equals(((UpdateController) anObject).updateView));
    } //equals

    /**
     * Gets a {@code String} representation of this update controller.
     *
     * @return a {@code String} representation of this update controller
     */
    @Override
    public String toString() {
        return String.format("UpdateController[%s, %s]", this.inventoryModel, this.updateView);
    } //toString
}