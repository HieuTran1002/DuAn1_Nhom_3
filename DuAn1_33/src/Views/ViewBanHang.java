/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.ChiTietSP;
import DomainModels.DongSP;
import DomainModels.HoaDon;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
import Services.HoaDonService;
import Services.SanPhamService;
import Services.ServiceImpl.ChiTietSPServiceImpl;
import Services.ServiceImpl.DongSPServiceImpl;
import Services.ServiceImpl.HoaDonServiceImpl;
import Services.ServiceImpl.MauSacServiceImpl;
import Services.ServiceImpl.NSXServiceImpl;
import Services.ServiceImpl.SanPhamServiceImpl;
import ViewModels.HoaDonViewModel;
import ViewModels.SanPhamUpdateViewModel;
import ViewModels.SanPhamViewModel;
import ViewModels.ViewBanHangModels;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class ViewBanHang extends javax.swing.JFrame {
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtmGH = new DefaultTableModel();
    private DefaultTableModel dtmSP = new DefaultTableModel();
    
    private List<ChiTietSP> listctsp = new ArrayList<>();
    private List<DongSP> listdsp = new ArrayList<>();
    private List<MauSac> listms = new ArrayList<>();
    private List<NSX> listnsx = new ArrayList<>();
    private List<SanPham> listsp = new ArrayList<>();
    private List<HoaDon> listHD = new ArrayList<>();
    private List<ViewBanHangModels> listViewBanHangModels = new ArrayList<>();
    private List<SanPhamUpdateViewModel> listChiTietHoaDonViewModels = new ArrayList<>();
    private List<HoaDonViewModel> listHoaDonViewModels = new ArrayList<>();

    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private ChiTietSPServiceImpl ctspi = new ChiTietSPServiceImpl();
    private DongSPServiceImpl dspi = new DongSPServiceImpl();
    private NSXServiceImpl nsxi = new NSXServiceImpl();
    private MauSacServiceImpl msi = new MauSacServiceImpl();
    private SanPhamServiceImpl spi = new SanPhamServiceImpl();
    
    public ViewBanHang() {
        initComponents();
        String headerAll[] = {"STT", "Mã HĐ", "Ngày Tạo", "Tên NV", "Tình Trạng"};
        String headerGH[] = {"STT", "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"};
        String headerSP[] = {"STT", "Mã SP", "Tên SP", "Năm Bảo Hành", "Mô Tả", "SL SP", "Giá Nhập", "Giá Bán"};
        dtm.setColumnIdentifiers(headerAll);
        dtmGH.setColumnIdentifiers(headerGH);
        dtmSP.setColumnIdentifiers(headerSP);
        tbHoaDon.setModel(dtm);
        tbGioHang.setModel(dtmGH);
        tbCTSanPham.setModel(dtmSP);
        listctsp = ctspi.getAll();
        listdsp = dspi.getAll();
        listms = msi.getAll();
        listnsx = nsxi.getAll();
        listsp = spi.getAll();
        listHD = hoaDonService.getAll();
        listHoaDonViewModels = hoaDonService.getFull();
        rdoChuaThanhToan.setSelected(true);
        rdoDaThanhToan.setSelected(false);

        showDataTableSanPham(listctsp);
        showDataTableAll(listHoaDonViewModels);
    }
  private void showDataTableSanPham(List<ChiTietSP> listSP) {
        int STT = 1;
        dtmSP.setRowCount(0);
        for (ChiTietSP ctsp : listSP) {
            dtmSP.addRow(ctsp.toDataRow());
        }
    }
   
    private void showDataTableGioHang(List<ViewBanHangModels> listGH) {
        int STT = 1;
        dtmGH = (DefaultTableModel) tbGioHang.getModel();
        dtmGH.setRowCount(0);
        for (ViewBanHangModels hoaDonViewModelHD : listGH) {
            dtmGH.addRow(new Object[]{STT++, hoaDonViewModelHD.getMaSP(), hoaDonViewModelHD.getTenSP(), hoaDonViewModelHD.getSoLuong(), hoaDonViewModelHD.getDonGia(), hoaDonViewModelHD.thanhTien()});
        }
    }
    private void showDataTableAll(List<HoaDonViewModel> listHoaDonViewModels) {
        int STT = 1;
        dtm.setRowCount(0);
        for (HoaDonViewModel hoaDonViewModel : listHoaDonViewModels) {
            String tinhTrang;
            if (hoaDonViewModel.getTinhTrang() == 1) {
                tinhTrang = "Đã Thanh Toán";
            } else {
                tinhTrang = "Chưa Thanh Toán";
            }
            dtm.addRow(new Object[]{STT++, hoaDonViewModel.getMaHD(), hoaDonViewModel.getNgayTao(), hoaDonViewModel.getTenNV(), tinhTrang});
        }
    }
    private void fillData(int index) {
        HoaDonViewModel hoaDonViewModel = listHoaDonViewModels.get(index);
        txtMaHD.setText(hoaDonViewModel.getMaHD());
        txtNgayTao.setText(hoaDonViewModel.getNgayTao());
        txtTenNV.setText(hoaDonViewModel.getTenNV());
        System.out.println(hoaDonViewModel.getSoLuong());
        System.out.println(hoaDonViewModel.getDonGia());       
        Double tongTien = hoaDonViewModel.getSoLuong() * hoaDonViewModel.getDonGia();
        txtTongTien.setText(String.valueOf(tongTien));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnTaoHoaDon = new javax.swing.JButton();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        rdoChuaThanhToan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGioHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCTSanPham = new javax.swing.JTable();
        cbbTimKiem = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnBackHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Save.png"))); // NOI18N
        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDaThanhToan);
        rdoDaThanhToan.setText("Đã Thanh Toán");
        rdoDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChuaThanhToan);
        rdoChuaThanhToan.setText("Chưa Thanh Toán");
        rdoChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChuaThanhToanActionPerformed(evt);
            }
        });

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn"));

        jLabel1.setText("Mã HĐ");

        jLabel2.setText("Ngày Tạo");

        jLabel3.setText("Tên NV");

        jLabel4.setText("Tổng Tiền");

        jLabel5.setText("Tiền Khách Đưa");

        jLabel6.setText("Tiền Thừa");

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Pay.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtTienKhachDua.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtTienKhachDuaMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaHD)
                            .addComponent(txtNgayTao)
                            .addComponent(txtTenNV)
                            .addComponent(txtTongTien)
                            .addComponent(txtTienKhachDua)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ Hàng"));

        tbGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbGioHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));

        tbCTSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCTSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbCTSanPham);

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Find.png"))); // NOI18N
        btnAdd.setText("Search");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        btnBackHome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBackHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        btnBackHome.setText("Hệ Thống");
        btnBackHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackHomeMouseClicked(evt);
            }
        });
        btnBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnTaoHoaDon)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDaThanhToan)
                                .addGap(59, 59, 59)
                                .addComponent(rdoChuaThanhToan)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoDaThanhToan)
                            .addComponent(rdoChuaThanhToan)
                            .addComponent(btnBackHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btnTaoHoaDon)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
       int row = tbHoaDon.getSelectedRow();
        fillData(row);
        HoaDonViewModel hoaDonViewModel = new HoaDonViewModel();
        if (hoaDonViewModel.getTinhTrang() == 1) {
            rdoChuaThanhToan.setSelected(false);
            rdoDaThanhToan.setSelected(true);
        } else {
            rdoChuaThanhToan.setSelected(true);
            rdoDaThanhToan.setSelected(false);
        }
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
     ViewHoaDon viewHoaDon = new ViewHoaDon();
        viewHoaDon.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void rdoDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaThanhToanActionPerformed


    }//GEN-LAST:event_rdoDaThanhToanActionPerformed

    private void rdoChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuaThanhToanActionPerformed

    }//GEN-LAST:event_rdoChuaThanhToanActionPerformed

    private void tbCTSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTSanPhamMouseClicked
         SanPhamUpdateViewModel chiTietHoaDonViewModel = new SanPhamUpdateViewModel();
        int soLuongNhap = Integer.valueOf(JOptionPane.showInputDialog("xin mời nhập số lượng"));
        int row = tbCTSanPham.getSelectedRow();
        int soLuong = (int) tbCTSanPham.getValueAt(row, 5);
        ChiTietSP sanPhamViewModel = listctsp.get(row);
        sanPhamViewModel.setSoLuongTon(soLuong - soLuongNhap);
        String sua = sanPhamService.update(sanPhamViewModel.getSanPham().getId(), soLuong - soLuongNhap);
        showDataTableSanPham(listctsp);
        ViewBanHangModels viewBanHangModels = new ViewBanHangModels();
        String headerSP[] = {"STT", "Mã SP", "Tên SP", "Năm Bảo Hành", "Mô Tả", "SL SP", "Giá Nhập", "Giá Bán"};

        viewBanHangModels.setMaSP((String) tbCTSanPham.getValueAt(row, 1));
        viewBanHangModels.setTenSP((String) tbCTSanPham.getValueAt(row, 2));
        viewBanHangModels.setSoLuong(soLuongNhap);
        viewBanHangModels.setDonGia((BigDecimal) tbCTSanPham.getValueAt(row, 7));
        listViewBanHangModels.add(viewBanHangModels);
        showDataTableGioHang(listViewBanHangModels);

    }//GEN-LAST:event_tbCTSanPhamMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackHomeMouseClicked

    }//GEN-LAST:event_btnBackHomeMouseClicked

    private void btnBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackHomeActionPerformed
        // TODO add your handling code here:
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackHomeActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
      int row = tbHoaDon.getSelectedRow();
        HoaDonViewModel hoaDonViewModel = listHoaDonViewModels.get(row);
        String update = hoaDonService.UpdateThanhToan(hoaDonViewModel.getIdHD());
        JOptionPane.showMessageDialog(this, update);
        showDataTableAll(listHoaDonViewModels = hoaDonService.getFull());
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienKhachDuaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachDuaMouseMoved
        // TODO add your handling code here:
        int index = tbHoaDon.getSelectedRow();
        HoaDonViewModel hoaDonViewModel = listHoaDonViewModels.get(index);
        Double tongTien = hoaDonViewModel.getDonGia() * hoaDonViewModel.getSoLuong();
        if (Double.valueOf(txtTienKhachDua.getText()) < tongTien) {
            JOptionPane.showMessageDialog(this, "Tiền Khách Trả Phải Lớn Hơn Tổng Tiền !");
        } else {
            Double tienThua = Float.valueOf(txtTienKhachDua.getText()) - tongTien;
            txtTienThua.setText(String.valueOf(tienThua));
        }
    }//GEN-LAST:event_txtTienKhachDuaMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBackHome;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoChuaThanhToan;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JTable tbCTSanPham;
    private javax.swing.JTable tbGioHang;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}
