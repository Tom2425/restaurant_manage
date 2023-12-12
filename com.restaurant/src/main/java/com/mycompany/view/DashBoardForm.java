/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.view.POSForm;
import com.mycompany.model.Admin;
import com.mycompany.model.Dish;
import com.mycompany.service.AdminService;
import com.mycompany.service.DishService;
import com.mycompany.util.HandleImage;
import com.mycompany.util.ImageRenderer;
import com.mycompany.util.TableActionCellEditor;
import com.mycompany.util.TableActionCellRender;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class DashBoardForm extends javax.swing.JFrame {

    /**
     * Creates new form DashBoardForm
     */
    private final Admin admin;

    public DashBoardForm(Admin admin) {
        this.admin = admin;

        initComponents();
        costomComponents();

//        JPanel grid = new JPanel();
//        GridLayout lo = new GridLayout(0, 10);
//        grid.setLayout(lo);
//        for (int i = 0; i < 20; i++) {
//            grid.add(dish);
//        }
//
//    // Assuming menuScroll is a JScrollPane
//        menuScroll.setViewportView(grid);
    }

    public void handleMenuTable() {
        List<Dish> menu = DishService.getAll();
        DefaultTableModel model = (DefaultTableModel) menuTable.getModel();
        model.setRowCount(0);
        menuTable.getColumn("Image").setCellRenderer(new CellRenderer());
        menuTable.getColumn("Action").setCellRenderer(new TableActionCellRender<DishService>(DishService.class));
        menuTable.getColumn("Action").setCellEditor(new TableActionCellEditor<DishService>(DishService.class));
        String imagePath = "/image/image.png";
       
        for (Dish dish : menu) {
              JLabel imageLabel = new JLabel();   
             BufferedImage originalImage = null;
            if(dish.getImage() == null){
                 URL url = getClass().getResource(imagePath);
                File file = new File(url.getPath());
                
                 try {
                     originalImage = ImageIO.read(file);
                 } catch (IOException ex) {
                     Logger.getLogger(DashBoardForm.class.getName()).log(Level.SEVERE, null, ex);
                 }
               
            }
            else{
                   originalImage = dish.getImageAsBufferedImage();
            }
            Image scaledImage = HandleImage.getScaledImage(originalImage, 50, 50);
            ImageIcon icon = new ImageIcon(scaledImage);
            imageLabel.setIcon(icon);
            model.addRow(new Object[]{String.valueOf(menu.indexOf(dish) + 1), dish.getName(), String.valueOf(dish.getPrice()), dish.getCategory(),imageLabel});
        }
       
    }
    class CellRenderer implements TableCellRenderer {
 
        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
 
            TableColumn tb = menuTable.getColumn("Image");
            tb.setMaxWidth(50);
            tb.setMinWidth(50);
 
            menuTable.setRowHeight(60);
 
            return (Component) value;
        }
 
    }
    public void handlStaffTable() {
        List<Admin> admins = AdminService.getAll();
        DefaultTableModel model = (DefaultTableModel) staffTable.getModel();
        model.setRowCount(0);
        staffTable.getColumn("Action").setCellRenderer(new TableActionCellRender<AdminService>(AdminService.class));
        staffTable.getColumn("Action").setCellEditor(new TableActionCellEditor<AdminService>(AdminService.class));
        for (Admin admin : admins) {
            model.addRow(new Object[]{String.valueOf(admins.indexOf(admin) + 1), admin.getName(), admin.getRole(), admin.getPhone()});
        }
    }

    public void costomComponents() {
        adminNameLabel.setText(adminNameLabel.getText() + admin.getName());
        adminRoleLabel.setText(adminRoleLabel.getText() + admin.getRole());
        handlStaffTable();
        handleMenuTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dish = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        mainBoard = new javax.swing.JTabbedPane();
        menuTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        addDishBtn = new javax.swing.JButton();
        removeDishBtn = new javax.swing.JButton();
        stafftab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        addStaffBtn = new javax.swing.JButton();
        removeStaffBtn = new javax.swing.JButton();
        tabletab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        staffTable1 = new javax.swing.JTable();
        addTableBtn = new javax.swing.JButton();
        removeTable = new javax.swing.JButton();
        kitchentab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        staffTable2 = new javax.swing.JTable();
        addStaffBtn2 = new javax.swing.JButton();
        removeStaffBtn2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        menuItem = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        staffItem = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tableItem = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tableItem1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tableItem2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        adminNameLabel = new javax.swing.JLabel();
        adminRoleLabel = new javax.swing.JLabel();

        dish.setBackground(new java.awt.Color(226, 215, 255));
        dish.setVerifyInputWhenFocusTarget(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Chicken");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("100$");

        javax.swing.GroupLayout dishLayout = new javax.swing.GroupLayout(dish);
        dish.setLayout(dishLayout);
        dishLayout.setHorizontalGroup(
            dishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dishLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(dishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        dishLayout.setVerticalGroup(
            dishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dishLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(40, 40, 40))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(233, 233, 235));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 700));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 400));

        title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        title.setText("Menu");
        jPanel12.add(title);

        mainBoard.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        menuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "SR", "Name", "Price", "Category", "Image", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(menuTable);
        if (menuTable.getColumnModel().getColumnCount() > 0) {
            menuTable.getColumnModel().getColumn(0).setResizable(false);
            menuTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            menuTable.getColumnModel().getColumn(1).setResizable(false);
            menuTable.getColumnModel().getColumn(1).setPreferredWidth(130);
            menuTable.getColumnModel().getColumn(2).setResizable(false);
            menuTable.getColumnModel().getColumn(3).setResizable(false);
            menuTable.getColumnModel().getColumn(4).setResizable(false);
            menuTable.getColumnModel().getColumn(5).setResizable(false);
            menuTable.getColumnModel().getColumn(5).setPreferredWidth(62);
        }

        addDishBtn.setText("Add");
        addDishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDishBtnActionPerformed(evt);
            }
        });

        removeDishBtn.setText("Remove");
        removeDishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDishBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuTabLayout = new javax.swing.GroupLayout(menuTab);
        menuTab.setLayout(menuTabLayout);
        menuTabLayout.setHorizontalGroup(
            menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(menuTabLayout.createSequentialGroup()
                .addComponent(addDishBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeDishBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menuTabLayout.setVerticalGroup(
            menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTabLayout.createSequentialGroup()
                .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeDishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
        );

        mainBoard.addTab("tab1", menuTab);

        staffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "SR", "Name", "Status", "Phone", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        staffTable.setRowHeight(40);
        jScrollPane1.setViewportView(staffTable);
        if (staffTable.getColumnModel().getColumnCount() > 0) {
            staffTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            staffTable.getColumnModel().getColumn(4).setPreferredWidth(62);
        }

        addStaffBtn.setText("Add");
        addStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffBtnActionPerformed(evt);
            }
        });

        removeStaffBtn.setText("Remove");
        removeStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStaffBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stafftabLayout = new javax.swing.GroupLayout(stafftab);
        stafftab.setLayout(stafftabLayout);
        stafftabLayout.setHorizontalGroup(
            stafftabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(stafftabLayout.createSequentialGroup()
                .addComponent(addStaffBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeStaffBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        stafftabLayout.setVerticalGroup(
            stafftabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stafftabLayout.createSequentialGroup()
                .addGroup(stafftabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainBoard.addTab("tab2", stafftab);

        staffTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SR", "Name", "Status", "Phone"
            }
        ));
        jScrollPane4.setViewportView(staffTable1);

        addTableBtn.setText("Add");
        addTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTableBtnActionPerformed(evt);
            }
        });

        removeTable.setText("Remove");
        removeTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabletabLayout = new javax.swing.GroupLayout(tabletab);
        tabletab.setLayout(tabletabLayout);
        tabletabLayout.setHorizontalGroup(
            tabletabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(tabletabLayout.createSequentialGroup()
                .addComponent(addTableBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeTable)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tabletabLayout.setVerticalGroup(
            tabletabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabletabLayout.createSequentialGroup()
                .addGroup(tabletabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainBoard.addTab("tab2", tabletab);

        staffTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SR", "Name", "Status", "Phone"
            }
        ));
        jScrollPane3.setViewportView(staffTable2);

        addStaffBtn2.setText("Add");
        addStaffBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffBtn2ActionPerformed(evt);
            }
        });

        removeStaffBtn2.setText("Remove");
        removeStaffBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStaffBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kitchentabLayout = new javax.swing.GroupLayout(kitchentab);
        kitchentab.setLayout(kitchentabLayout);
        kitchentabLayout.setHorizontalGroup(
            kitchentabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(kitchentabLayout.createSequentialGroup()
                .addComponent(addStaffBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeStaffBtn2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        kitchentabLayout.setVerticalGroup(
            kitchentabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kitchentabLayout.createSequentialGroup()
                .addGroup(kitchentabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeStaffBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStaffBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainBoard.addTab("tab2", kitchentab);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainBoard)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 400));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(53, 47, 68));
        jPanel3.setPreferredSize(new java.awt.Dimension(30, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Dashboard");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel1);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(185, 180, 199));
        jPanel4.setPreferredSize(new java.awt.Dimension(520, 440));

        jPanel7.setLayout(new java.awt.GridLayout(0, 1));

        menuItem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Menu");
        menuItem.add(jLabel6);

        jPanel7.add(menuItem);

        staffItem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        staffItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        staffItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffItemMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Staff");
        staffItem.add(jLabel4);

        jPanel7.add(staffItem);

        tableItem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Table");
        tableItem.add(jLabel3);

        jPanel7.add(tableItem);

        tableItem1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItem1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Kitchen");
        tableItem1.add(jLabel5);

        jPanel7.add(tableItem1);

        tableItem2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItem2MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("POS");
        tableItem2.add(jLabel9);

        jPanel7.add(tableItem2);

        jPanel5.setLayout(new java.awt.BorderLayout());

        adminNameLabel.setText("Name:  ");
        adminNameLabel.setPreferredSize(new java.awt.Dimension(35, 25));
        jPanel5.add(adminNameLabel, java.awt.BorderLayout.PAGE_START);

        adminRoleLabel.setText("Role: ");
        adminRoleLabel.setPreferredSize(new java.awt.Dimension(24, 25));
        jPanel5.add(adminRoleLabel, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel9.add(jPanel1, java.awt.BorderLayout.WEST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void staffItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffItemMouseClicked
        mainBoard.setSelectedIndex(1);
        title.setText("Staff");
    }//GEN-LAST:event_staffItemMouseClicked

    private void tableItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemMouseClicked
        mainBoard.setSelectedIndex(2);
        title.setText("Table");
    }//GEN-LAST:event_tableItemMouseClicked

    private void menuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemMouseClicked
        title.setText("Menu");
        mainBoard.setSelectedIndex(0);    }//GEN-LAST:event_menuItemMouseClicked

    private void addStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffBtnActionPerformed
        AddStaffForm addStaffForm = new AddStaffForm(this);
        addStaffForm.setLocationRelativeTo(null);
        addStaffForm.setVisible(true);
    }//GEN-LAST:event_addStaffBtnActionPerformed

    private void addDishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDishBtnActionPerformed
        AddDishForm addDishForm = new AddDishForm(this);
        addDishForm.setLocationRelativeTo(null);
        addDishForm.setVisible(true);
    }//GEN-LAST:event_addDishBtnActionPerformed

    private void removeDishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDishBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeDishBtnActionPerformed

    private void removeStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStaffBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeStaffBtnActionPerformed

    private void tableItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableItem1MouseClicked

    private void tableItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItem2MouseClicked
        new POSForm().setDefaultCloseOperation(POSForm.DISPOSE_ON_CLOSE);
        new POSForm().setLocationRelativeTo(null);
        new POSForm().setVisible(true);
    }//GEN-LAST:event_tableItem2MouseClicked

    private void addTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTableBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTableBtnActionPerformed

    private void removeTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeTableActionPerformed

    private void addStaffBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStaffBtn2ActionPerformed

    private void removeStaffBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStaffBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeStaffBtn2ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDishBtn;
    private javax.swing.JButton addStaffBtn;
    private javax.swing.JButton addStaffBtn2;
    private javax.swing.JButton addTableBtn;
    private javax.swing.JLabel adminNameLabel;
    private javax.swing.JLabel adminRoleLabel;
    private javax.swing.JPanel dish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel kitchentab;
    private javax.swing.JTabbedPane mainBoard;
    private javax.swing.JPanel menuItem;
    private javax.swing.JPanel menuTab;
    private javax.swing.JTable menuTable;
    private javax.swing.JButton removeDishBtn;
    private javax.swing.JButton removeStaffBtn;
    private javax.swing.JButton removeStaffBtn2;
    private javax.swing.JButton removeTable;
    private javax.swing.JPanel staffItem;
    private javax.swing.JTable staffTable;
    private javax.swing.JTable staffTable1;
    private javax.swing.JTable staffTable2;
    private javax.swing.JPanel stafftab;
    private javax.swing.JPanel tableItem;
    private javax.swing.JPanel tableItem1;
    private javax.swing.JPanel tableItem2;
    private javax.swing.JPanel tabletab;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
