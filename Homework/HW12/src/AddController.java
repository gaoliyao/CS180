import javax.swing.*;
import java.util.Optional;

/**
 * An add controller of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class AddController {
    /**
     * The inventory model of this add controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The add view of this add controller.
     */
    private AddView addView;

    /**
     * Constructs a newly allocated {@code AddController} object with the specified inventory model and add view.
     *
     * @param inventoryModel the inventory model of this add controller
     * @param addView the add view of this add controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code addView} argument is
     * {@code null}
     */
    public AddController(InventoryModel inventoryModel, AddView addView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (addView == null) {
            throw new IllegalArgumentException("addView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.addView = addView;

            this.addView.getAddButton().addActionListener(e -> this.getAddButtonSemantics());

            this.addView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //AddController

    /**
     * Gets the semantics of an add view's add button.
     */
    private void getAddButtonSemantics() {
        //TODO implement method
        String sku = this.addView.getSkuTextField().getText();
        String wholesalePrice = this.addView.getWholesalePriceTextField().getText();
        String retailPrice = this.addView.getRetailPriceTextField().getText();
        String quantity = this.addView.getQuantityTextField().getText();
        String name = this.addView.getNameTextField().getText();
        Optional<Product> product = inventoryModel.searchBySku(sku);
        if (!product.isPresent()){

        }
        else{
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame,
                    "Already exists",
                    "Product Inventory",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isNumeric(wholesalePrice) && isNumeric(retailPrice) && isInteger(quantity)){
            this.inventoryModel.add(new Product(sku, name, Double.parseDouble(wholesalePrice), Double.parseDouble(retailPrice),
                    Integer.parseInt(quantity)));
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame,
                    "The product has been added",
                    "Product Inventory",
                    JOptionPane.INFORMATION_MESSAGE);
            getClearButtonSemantics();
        }
        else{
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame,
                    "Invalid number",
                    "Product Inventory",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


    } //getAddButtonSemantics

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
     * Gets the semantics of an add view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
        this.addView.getSkuTextField().setText("");
        this.addView.getNameTextField().setText("");
        this.addView.getWholesalePriceTextField().setText("");
        this.addView.getRetailPriceTextField().setText("");
        this.addView.getQuantityTextField().setText("");
    } //getClearButtonSemantics

    /**
     * Gets the hash code of this add controller.
     *
     * @return the hash code of this add controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.addView == null ? 0 : this.addView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this add controller is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code AddController}, and its field values are equal to this
     * add controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this add controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof AddController)
                && (this.inventoryModel == null ? ((AddController) anObject).inventoryModel ==  null : this.inventoryModel.equals(((AddController) anObject).inventoryModel))
                && (this.addView == null ? ((AddController) anObject).addView ==  null : this.addView.equals(((AddController) anObject).addView));
    } //equals

    /**
     * Gets a {@code String} representation of this add controller.
     *
     * @return a {@code String} representation of this add controller
     */
    @Override
    public String toString() {
        return String.format("AddController[%s, %s]", this.inventoryModel, this.addView);
    } //toString
}