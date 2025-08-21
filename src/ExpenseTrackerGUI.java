import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExpenseTrackerGUI extends JFrame {
    private JTextField amountField;
    private JTextField categoryField;
    private JTextField dateField;
    private JTable table;
    private DefaultTableModel tableModel;
    private ExpenseDAO expenseDAO;
    private JComboBox<String> categoryDropdown;

    public ExpenseTrackerGUI() {
        expenseDAO = new ExpenseDAO();
        Database.createNewDatabase();

        setTitle("Expense Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        panel.add(amountField);

        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);

        panel.add(new JLabel("Date (DD-MM-YYYY):"));
        dateField = new JTextField();
        panel.add(dateField);

        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(new AddButtonListener());
        panel.add(addButton);

        JButton updateButton = new JButton("Update Expense");
        updateButton.addActionListener(new UpdateButtonListener());
        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete Expense");
        deleteButton.addActionListener(new DeleteButtonListener());
        panel.add(deleteButton);

        JButton viewButton = new JButton("View All Expenses");
        viewButton.addActionListener(new ViewButtonListener());
        panel.add(viewButton);

        JButton totalButton = new JButton("Get Total Expenses");
        totalButton.addActionListener(new totalButtonListener());
        panel.add(totalButton);

        List<String> categories = ExpenseDAO.getCategories();
        categoryDropdown = new JComboBox<>(categories.toArray(new String[0]));
        categoryDropdown.addActionListener(new categoryTotalButton());
        panel.add(categoryDropdown);

        add(panel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Amount", "Category", "Date"});
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String amountText = amountField.getText().trim();
            String category = categoryField.getText().trim();
            String date = dateField.getText().trim();
    
            if (amountText.isEmpty() || category.isEmpty() || date.isEmpty()) {
                JOptionPane.showMessageDialog(ExpenseTrackerGUI.this, 
                                              "Please fill in all fields.", 
                                              "Input Error", 
                                              JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            double amount;
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ExpenseTrackerGUI.this, 
                                              "Please enter a valid number for the amount.", 
                                              "Input Error", 
                                              JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            Expense expense = new Expense(amount, category, date);
            expenseDAO.insert(expense);
    
            amountField.setText("");
            categoryField.setText("");
            dateField.setText("");
            updateCategoryDropdown();
            JOptionPane.showMessageDialog(ExpenseTrackerGUI.this, "Expense Added Successfully");
        }
    }

    private class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String amountText = amountField.getText().trim();
                String category = categoryField.getText().trim();
                String date = dateField.getText().trim();
    
                if (amountText.isEmpty() || category.isEmpty() || date.isEmpty()) {
                    JOptionPane.showMessageDialog(ExpenseTrackerGUI.this, 
                                                  "Please fill in all fields to update the expense.", 
                                                  "Input Error", 
                                                  JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                double amount;
                try {
                    amount = Double.parseDouble(amountText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ExpenseTrackerGUI.this, 
                                                  "Please enter a valid number for the amount.", 
                                                  "Input Error", 
                                                  JOptionPane.ERROR_MESSAGE);
                    return;
                }
    
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                Expense expense = new Expense(id, amount, category, date);
                expenseDAO.update(expense);
    
                amountField.setText("");
                categoryField.setText("");
                dateField.setText("");
                updateCategoryDropdown();
                JOptionPane.showMessageDialog(ExpenseTrackerGUI.this, "Expense Updated Successfully");
                
            } else {
                JOptionPane.showMessageDialog(ExpenseTrackerGUI.this, "Please select an expense to update.");
            }
        }
    }

    private void updateCategoryDropdown() {
        List<String> categories = ExpenseDAO.getCategories();
        categoryDropdown.setModel(new DefaultComboBoxModel<>(categories.toArray(new String[0])));
    }

    private class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                expenseDAO.delete(id);

                tableModel.removeRow(selectedRow);
                updateCategoryDropdown();
                JOptionPane.showMessageDialog(null, "Expense Deleted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Please select an expense to delete");
            }
        }
    }

    private class ViewButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Expense> expenses = expenseDAO.getAllExpenses();
            tableModel.setRowCount(0);
            for (Expense expense : expenses) {
                tableModel.addRow(new Object[]{expense.getId(), expense.getAmount(), expense.getCategory(), expense.getDate()});
            }
        }
    }

    private class totalButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double total = expenseDAO.totalExpenses();
            if(total > 0){
                JOptionPane.showMessageDialog(null, "Total Expenses: $" + total);
            }
            else{
                JOptionPane.showMessageDialog(null, "No Expenses found!");
            }
        }
    }

    public class categoryTotalButton implements ActionListener {
        public void actionPerformed (ActionEvent e) {
    
            String category = (String) categoryDropdown.getSelectedItem();
            double category_total = expenseDAO.categoryTotal(category);
            if(category_total > 0){
                JOptionPane.showMessageDialog(null, "Total Expenses of " + category + ": $" + category_total);
            }
            else{
                JOptionPane.showMessageDialog(null, "No Expenses found!");
            }
        }
    }
}

