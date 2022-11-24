﻿create database QUANLYCUAHANG
USE QUANLYCUAHANG
GO
-- ChucVu
CREATE TABLE ChucVu(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL
)
GO
-- Luong
CREATE TABLE Luong(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
ThoiGianVao DATETIME DEFAULT NULL,
ThoiGianRa DATETIME DEFAULT NULL,
ThoiGianLam INT DEFAULT 0,
TongLuong DECIMAL Default 0,
)
GO
-- Kho
CREATE TABLE KhoHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
DiaChi NVARCHAR(50) DEFAULT NULL,
SoDienThoai NVARCHAR(50) DEFAULT NULL,
GhiChu NVARCHAR(50) DEFAULT NULL,
TrangThai INT DEFAULT 0
)
GO
-- Nhà Cung Cấp
CREATE TABLE NhaCungCap(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(50) DEFAULT NULL,
SoDienThoai VARCHAR(50) DEFAULT NULL,
FAX VARCHAR(50) DEFAULT NULL,
Email VARCHAR(50) DEFAULT NULL,
GhiChu NVARCHAR(50) DEFAULT NULL,
TrangThai INT DEFAULT 0
)
GO
-- PhieuNhap
CREATE TABLE PhieuNhap(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKho UNIQUEIDENTIFIER,
IdNCC UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL,
NgayNhap DATETIME DEFAULT NULL,
GhiChu NVARCHAR(50) DEFAULT NULL,
TrangThai INT DEFAULT 0
)
GO
-- CuaHang
CREATE TABLE CuaHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdChiTietSP UNIQUEIDENTIFIER,
IdKho UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
ThanhPho NVARCHAR(50) DEFAULT NULL,
QuocGia NVARCHAR(50) DEFAULT NULL,
GhiChu NVARCHAR(50) DEFAULT NULL,
TrangThai INT DEFAULT 1
)
GO
-- NhanVien
CREATE TABLE NhanVien(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdTK UNIQUEIDENTIFIER,
IdCV UNIQUEIDENTIFIER,
IdCH UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30) DEFAULT NULL,
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
GioiTinh NVARCHAR(10) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
MatKhau VARCHAR(MAX) DEFAULT NULL,
IdGuiBC UNIQUEIDENTIFIER,
TrangThai INT DEFAULT 0
)
GO
-- TaiKhoan
CREATE TABLE TaiKhoan(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma NVARCHAR(50) DEFAULT NULL,
Ten NVARCHAR(50) DEFAULT NULL,
Password NVARCHAR(50) DEFAULT NULL,
NgayTao DATE DEFAULT NULL,
VaiTro NVARCHAR(50)
)
GO
-- KhachHang
CREATE TABLE KhachHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdLoaiKH UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
GioiTinh NVARCHAR(10) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
ThanhPho NVARCHAR(50) DEFAULT NULL,
QuocGia NVARCHAR(50) DEFAULT NULL,
MatKhau VARCHAR(MAX) DEFAULT NULL
)
GO
--ThongKe
CREATE TABLE ThongKe(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdHoaDon UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
IdPhieuNhap UNIQUEIDENTIFIER,
SoLuongBan INT,
DoanhThu INT,
TongTien NVARCHAR(50),
TienKhachHang NVARCHAR(50),
TienThua NVARCHAR(50),
Ngay DATE DEFAULT NULL,
ThoiGian  DATETIME DEFAULT NULL
)
GO
-- LoaiKhachHang
CREATE TABLE LoaiKH(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
)
GO
--HoaDon
CREATE TABLE HoaDon(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
NgayShip DATE DEFAULT NULL,
NgayNhan DATE DEFAULT NULL,
TinhTrang INT DEFAULT 0,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
)
GO
--GioHang
CREATE TABLE GioHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
TinhTrang INT DEFAULT 0
)
GO
-- SanPham
CREATE TABLE SanPham(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdLoaiSP UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- LoaiSanPham
CREATE TABLE LoaiSP(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- NSX
CREATE TABLE NSX(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- MauSac
CREATE TABLE MauSac(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- DongSP
CREATE TABLE DongSP(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- ChiTietSP
CREATE TABLE ChiTietSP(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdSP UNIQUEIDENTIFIER,
IdNsx UNIQUEIDENTIFIER,
IdMauSac UNIQUEIDENTIFIER,
IdDongSP UNIQUEIDENTIFIER,
NamBH INT DEFAULT NULL,
MoTa NVARCHAR(50) DEFAULT NULL,
SoLuongTon INT,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
)

GO
-- HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(
IdHoaDon UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_HoaDonCT PRIMARY KEY (IdHoaDon,IdChiTietSP),
CONSTRAINT FK1_HoaDonChiTiet FOREIGN KEY(IdHoaDon) REFERENCES HoaDon(Id),
CONSTRAINT FK2_HoaDonChiTiet FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id),
)
GO
-- GioHangChiTiet
CREATE TABLE GioHangChiTiet(
IdGioHang UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
DonGiaKhiGiam DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_GioHangCT PRIMARY KEY (IdGioHang,IdChiTietSP),
CONSTRAINT FK1_GioHangChiTiet FOREIGN KEY(IdGioHang) REFERENCES GioHang(Id),
CONSTRAINT FK2_GioHangChiTiet FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id),
)
GO
--ChiTietLuong
CREATE TABLE ChiTietLuong(
IdCV UNIQUEIDENTIFIER,
IdLuong UNIQUEIDENTIFIER,
TongThoiGianLam DECIMAL DEFAULT 0,
ThuNhap DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_ChiTietLuong PRIMARY KEY (IdCV,IdLuong),
CONSTRAINT FK1_ChiTietLuong FOREIGN KEY(IdCV) REFERENCES ChucVu(Id),
CONSTRAINT FK2_ChiTietLuong FOREIGN KEY(IdLuong) REFERENCES Luong(Id),
)
GO
--TẠO QUAN HỆ GIỮA CÁC BẢNG
--NhanVien
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCV) REFERENCES ChucVu(Id)
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCH) REFERENCES CuaHang(Id)
ALTER TABLE NhanVien ADD FOREIGN KEY (IdGuiBC) REFERENCES NhanVien(Id)
ALTER TABLE NhanVien ADD FOREIGN KEY (IdTK) REFERENCES TaiKhoan(Id)
-- HoaDon
ALTER TABLE HoaDon ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
-- GioHang - KhachHang
ALTER TABLE GioHang ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
-- HoaDon
ALTER TABLE HoaDon ADD FOREIGN KEY (IdNV) REFERENCES NhanVien(Id)
-- ChiTietSP
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdSP) REFERENCES SanPham(Id)
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdNsx) REFERENCES Nsx(Id)
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdMauSac) REFERENCES MauSac(Id)
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdDongSP) REFERENCES DongSP(Id)
-- SanPham
ALTER TABLE SanPham ADD FOREIGN KEY(IdLoaiSP) REFERENCES LoaiSP(Id)
-- ThongKe
ALTER TABLE ThongKe ADD FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id)
ALTER TABLE ThongKe ADD FOREIGN KEY(IdHoaDon) REFERENCES HoaDon(Id)
-- KhachHang
ALTER TABLE KhachHang ADD FOREIGN KEY(IdLoaiKH) REFERENCES LoaiKH(Id)
-- CuaHang
ALTER TABLE CuaHang ADD FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id)
ALTER TABLE CuaHang ADD FOREIGN KEY(IdKho) REFERENCES KhoHang(Id)
-- PhieuNhap
ALTER TABLE PhieuNhap ADD FOREIGN KEY(IdNCC) REFERENCES NhaCungCap(Id)
ALTER TABLE PhieuNhap ADD FOREIGN KEY(IdKho) REFERENCES KhoHang(Id)
-- THÊM DỮ LIỆU CHO CÁC BẢNG 
----Chuc Vu
INSERT INTO [dbo].[ChucVu] ([Id],[Ma],[Ten])VALUES('85DB0AD5-DD54-43F1-B3DA-2487750C1030','CV1',N'Nhân Viên')
INSERT INTO [dbo].[ChucVu] ([Id],[Ma],[Ten])VALUES('8490B22F-E6E9-413C-92D7-E0803F15BEB3','CV2',N'Quản Lý')

--LoaiKH
INSERT INTO [dbo].[LoaiKH]([Id],[Ma],[Ten])VALUES('E80D4A42-E004-4A88-B444-57582AD702AC','LKH1',N'Thân Quen')
INSERT INTO [dbo].[LoaiKH]([Id],[Ma],[Ten])VALUES('7BC17005-A3F4-475D-BF69-2A8F9B7E1458','LKH2',N'Bình Thường')

--Luong 
INSERT INTO Luong VALUES ('9687A600-027A-4224-B48C-27C2CFA24E11','L1',6,18,12,NULL)
INSERT INTO Luong VALUES ('569D6610-619D-4B6A-886D-ABBF78A72731','L3',12,18,6,NULL)
INSERT INTO Luong VALUES ('DBC2E434-5A08-41EE-A702-575790A11E00','L2',18,23,5,NULL)
INSERT INTO Luong VALUES ('40273748-2DEA-4D09-BC60-975E18545F39','L5',6,18,12,NULL)
INSERT INTO Luong VALUES ('6A88B08E-760E-4148-B51E-6CD80399DAD2','L7',10,18,8,NULL)

--LuongChiTiet
INSERT INTO ChiTietLuong VALUES ('85DB0AD5-DD54-43F1-B3DA-2487750C1030','9687A600-027A-4224-B48C-27C2CFA24E11',9,25);
INSERT INTO ChiTietLuong VALUES ('85DB0AD5-DD54-43F1-B3DA-2487750C1030','DBC2E434-5A08-41EE-A702-575790A11E00',5,25);
INSERT INTO ChiTietLuong VALUES ('85DB0AD5-DD54-43F1-B3DA-2487750C1030','6A88B08E-760E-4148-B51E-6CD80399DAD2',4,25);
INSERT INTO ChiTietLuong VALUES ('85DB0AD5-DD54-43F1-B3DA-2487750C1030','40273748-2DEA-4D09-BC60-975E18545F39',10,25);
INSERT INTO ChiTietLuong VALUES ('85DB0AD5-DD54-43F1-B3DA-2487750C1030','569D6610-619D-4B6A-886D-ABBF78A72731',12,25);
INSERT INTO ChiTietLuong VALUES ('8490B22F-E6E9-413C-92D7-E0803F15BEB3','569D6610-619D-4B6A-886D-ABBF78A72731',6,25);
select * from ChiTietLuong

--KhoHang
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('8C138252-1D3B-4CBC-924F-C282B3BC120B','KH01',N'Hà Nội','012223344','Không',0)
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('03EFAF1D-2D29-49D4-854C-AC0FA72DC96B','KH02',N'Kom Tom','018943343','Không',1)
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('B8CD8386-44C9-48FB-B51A-051844CFC515','KH03',N'Đắc Lắc','012223344','Không',0)
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('5695F6CF-53DE-47FB-BE63-570F706B0CFB','KH04',N'Gia Lai','012223344','Không',1)
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('C781D8CE-E992-4C23-A49B-DB8D348124D4','KH05',N'Hà Nội','012223344','Không',0)
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('D8501D9F-9AF7-47FA-912E-83ED7B54470B','KH06',N'Hà Nội','012223344','Không',1)
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('BBDA7A0A-4FC4-4C9A-B32B-C5C7577AF46B','KH07',N'Hải Dương','018943343','Không',1)
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('CA40DF41-0FDE-4731-8178-483F1506DE65','KH08',N'Hà Nội','012223344','Không',1)
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('D6667139-F4CB-44E2-B2CE-EB2B77B22823','KH09',N'Hà Nội','012223344','Không',1)
INSERT INTO [dbo].[KhoHang] ([Id],[Ma],[DiaChi],[SoDienThoai],[GhiChu],[TrangThai])VALUES('AA240334-E026-41EB-B237-6B86ABB4BE27','KH10',N'Hà Nội','012223344','Không',1)

--LoaiSP
INSERT INTO [dbo].[LoaiSP]([Id],[Ma],[Ten])VALUES('B452B55F-0452-4D03-B1D4-1A0508A16A60','LSP01',N'Bánh Kẹo')
INSERT INTO [dbo].[LoaiSP]([Id],[Ma],[Ten])VALUES('D2B18F71-4191-434F-BE32-E7215E4BC134','LSP02',N'Nước')
INSERT INTO [dbo].[LoaiSP]([Id],[Ma],[Ten])VALUES('796A101D-611E-485B-A2D1-3B854FD744C6','LSP03',N'Đồ Ăn Vặt')
INSERT INTO [dbo].[LoaiSP]([Id],[Ma],[Ten])VALUES('C7509CBF-DAFD-406F-96CC-E95720585451','LSP04',N'Kem')
INSERT INTO [dbo].[LoaiSP]([Id],[Ma],[Ten])VALUES('CF5DB45D-BCD4-49B3-AE62-BBFA61C36638','LSP09',N'Bia')
INSERT INTO [dbo].[LoaiSP]([Id],[Ma],[Ten])VALUES('3A84B766-46E0-4707-8C97-24C6A9C3E4AF','LSP10',N'Rượu')
--DongSP
INSERT INTO [dbo].[DongSP]([Id],[Ma],[Ten])VALUES('C92B55C0-973F-4CD6-8C90-CCE9FDFD8FCC','DSP1',N'a')
INSERT INTO [dbo].[DongSP]([Id],[Ma],[Ten])VALUES('958E8C39-44AC-42BA-994A-9F7E7A9FE8BD','DSP2',N'b')
INSERT INTO [dbo].[DongSP]([Id],[Ma],[Ten])VALUES('BF152635-8D99-45EC-8391-2DE239624E5C','DSP3',N'c')
INSERT INTO [dbo].[DongSP]([Id],[Ma],[Ten])VALUES('74274ED8-4421-47C4-A864-F80B2888EA36','DSP4',N'd')
INSERT INTO [dbo].[DongSP]([Id],[Ma],[Ten])VALUES('DE14B597-3292-43C1-B56A-83DB2015B7BD','DSP5',N'e')
--NSX
INSERT INTO [dbo].[NSX]([Id],[Ma],[Ten])VALUES('986FD848-BD48-4AA8-935D-91A4DBACC321','NSX1',N'a')
INSERT INTO [dbo].[NSX]([Id],[Ma],[Ten])VALUES('1843B36A-B780-498F-AA25-AB892175E71D','NSX2',N'b')
INSERT INTO [dbo].[NSX]([Id],[Ma],[Ten])VALUES('4F5E3520-92D8-4ED6-B9E8-9967FF186B1A','NSX3',N'c')
INSERT INTO [dbo].[NSX]([Id],[Ma],[Ten])VALUES('3DF183E8-2354-498F-AE51-BAF3A2C96849','NSX4',N'd')
INSERT INTO [dbo].[NSX]([Id],[Ma],[Ten])VALUES('617BA791-ACFB-44DC-A38E-57D428525079','NSX5',N'e')
--MauSac
INSERT INTO [dbo].[MauSac]([Id],[Ma],[Ten])VALUES('75B98BA5-AB9F-4F70-9C5C-1D50100A4595','MS1',N'xanh')
INSERT INTO [dbo].[MauSac]([Id],[Ma],[Ten])VALUES('51691FFD-448A-4286-A28E-80790BC432FD','MS2',N'đỏ')
INSERT INTO [dbo].[MauSac]([Id],[Ma],[Ten])VALUES('30BA9FD3-0958-41AC-A6E1-BBF353877970','MS3',N'tím')
INSERT INTO [dbo].[MauSac]([Id],[Ma],[Ten])VALUES('815699C9-A17C-4096-87CA-BA2B449D6AB6','MS4',N'vàng')
INSERT INTO [dbo].[MauSac]([Id],[Ma],[Ten])VALUES('23FFF723-FF56-4639-BDBF-AC22E1B3CFA8','MS5',N'hồng')
INSERT INTO [dbo].[MauSac]([Id],[Ma],[Ten])VALUES('A093D191-72EB-4BBA-B4C6-6036E622D64B','MS6',N'đen')
--TaiKhoan
INSERT INTO TaiKhoan VALUES ('0DBA0083-EDFA-4E1B-AB8D-3831BCFE2D09','TK01','luongpvph27222', '12345', '2022-10-20', 'NHANVIEN')
INSERT INTO TaiKhoan VALUES ('FD944810-0405-460B-A884-C9738890CDDC','TK02','tiepnmph25816', '12345', '2022-11-21', 'QUANTRIVIEN')
INSERT INTO TaiKhoan VALUES ('ED50E2BA-0940-4284-A79C-2BDADE7F14D3', 'TK03','hungltph21667', '12345', '2021-12-20', 'NHANVIEN')
INSERT INTO TaiKhoan VALUES ('43D03BD9-44A8-4C17-86B1-A0046E1627A0', 'TK04','thanhnvph25817', '12345', '2021-10-11', 'NHANVIEN')
INSERT INTO TaiKhoan VALUES ('C1C974D4-6B7A-405B-A60C-21FB2FB72BDB','TK05','hieuttph25785','12345', '2021-01-28', 'QUANTRIVIEN')
INSERT INTO TaiKhoan VALUES ('C788B9D1-5FAB-49C8-A18E-CE7822E65D7D', 'TK06','haiptph25840','12345', '2022-11-21', 'NHANVIEN')

-- NhaCungCap
INSERT INTO [dbo].[NhaCungCap]([Id],[Ma],[Ten],[DiaChi],[SoDienThoai],[FAX],[Email],[GhiChu],[TrangThai])VALUES('1981E6BB-8AB2-4C02-9844-D9A20EA8E3A7','NCC1','a',N'Hà Nội',08378744673,N'FAX-233', 'a@gmail.com',NULL,0)
INSERT INTO [dbo].[NhaCungCap]([Id],[Ma],[Ten],[DiaChi],[SoDienThoai],[FAX],[Email],[GhiChu],[TrangThai])VALUES('48060EB3-B079-4444-8866-D867150FAF43','NCC2','b',N'Thái Bình',08378744673,N'FAX-233', 'b@gmail.com',NULL,0)
INSERT INTO [dbo].[NhaCungCap]([Id],[Ma],[Ten],[DiaChi],[SoDienThoai],[FAX],[Email],[GhiChu],[TrangThai])VALUES('DA4DE803-A274-4ECD-990E-2A42D9F91136','NCC3','c',N'Thanh Hóa',08378744673,N'FAX-233', 'c@gmail.com',NULL,0)
INSERT INTO [dbo].[NhaCungCap]([Id],[Ma],[Ten],[DiaChi],[SoDienThoai],[FAX],[Email],[GhiChu],[TrangThai])VALUES('9B860987-B50A-41FF-9CFC-C17183529A7B','NCC4','d',N'Bình Định',08378744673,N'FAX-233', 'd@gmail.com',NULL,0)
INSERT INTO [dbo].[NhaCungCap]([Id],[Ma],[Ten],[DiaChi],[SoDienThoai],[FAX],[Email],[GhiChu],[TrangThai])VALUES('6869774D-54DA-4A25-892B-C31BE3DFBFE2','NCC5','e',N'Thái Nguyên',08378744673,N'FAX-233', 'e@gmail.com',NULL,0)

--PhieuNhap
INSERT INTO [dbo].[PhieuNhap]([Id],[IdKho],[IdNCC],[Ma],[Ten],[NgayNhap],[GhiChu],[TrangThai])VALUES('A8F3C891-6BD2-42A5-98C1-D51D395E62FF','B8CD8386-44C9-48FB-B51A-051844CFC515','DA4DE803-A274-4ECD-990E-2A42D9F91136','PN1', N'Phiếu nhập kho theo thông tư 107','2022-01-01',NULL,0)
INSERT INTO [dbo].[PhieuNhap]([Id],[IdKho],[IdNCC],[Ma],[Ten],[NgayNhap],[GhiChu],[TrangThai])VALUES('3434FDD5-A306-4AC8-A50E-7B0CF51E7C2F','CA40DF41-0FDE-4731-8178-483F1506DE65','9B860987-B50A-41FF-9CFC-C17183529A7B','PN2', N'Phiếu nhập kho theo thông tư 111','2022-01-05',NULL,0)
INSERT INTO [dbo].[PhieuNhap]([Id],[IdKho],[IdNCC],[Ma],[Ten],[NgayNhap],[GhiChu],[TrangThai])VALUES('B119675F-F8A8-42DA-91F3-D45FF30288EA','5695F6CF-53DE-47FB-BE63-570F706B0CFB','6869774D-54DA-4A25-892B-C31BE3DFBFE2','PN3', N'Phiếu nhập kho theo thông tư 100','2022-01-15',NULL,0)
INSERT INTO [dbo].[PhieuNhap]([Id],[IdKho],[IdNCC],[Ma],[Ten],[NgayNhap],[GhiChu],[TrangThai])VALUES('C25F2E23-E07E-43EC-B809-D186BC4D4212','AA240334-E026-41EB-B237-6B86ABB4BE27','48060EB3-B079-4444-8866-D867150FAF43','PN4', N'Phiếu nhập kho theo thông tư 108','2022-01-20',NULL,0)
INSERT INTO [dbo].[PhieuNhap]([Id],[IdKho],[IdNCC],[Ma],[Ten],[NgayNhap],[GhiChu],[TrangThai])VALUES('899A23FE-BFBE-4149-83D3-205C4D00A9FD','D8501D9F-9AF7-47FA-912E-83ED7B54470B','DA4DE803-A274-4ECD-990E-2A42D9F91136','PN5', N'Phiếu nhập kho theo thông tư 116','2022-01-25',NULL,0)
select * from PhieuNhap
--SanPham
INSERT INTO [dbo].[SanPham]([Id],[IdLoaiSP],[Ma],[Ten]) VALUES('353FAF62-036F-461F-8CCC-24B1426DA220','B452B55F-0452-4D03-B1D4-1A0508A16A60','SP01',N'Bánh Osi')
INSERT INTO [dbo].[SanPham]([Id],[IdLoaiSP],[Ma],[Ten]) VALUES('7B971BAB-00FF-4365-A2E0-CD5A28CC0C43','796A101D-611E-485B-A2D1-3B854FD744C6','SP02',N'Xúc xich')
INSERT INTO [dbo].[SanPham]([Id],[IdLoaiSP],[Ma],[Ten]) VALUES('C05A75ED-E669-410A-8534-B929D7A56421','D2B18F71-4191-434F-BE32-E7215E4BC134','SP03',N'Nước Coca')
INSERT INTO [dbo].[SanPham]([Id],[IdLoaiSP],[Ma],[Ten]) VALUES('C460740A-ECF1-4BA3-8626-74700F667865','C7509CBF-DAFD-406F-96CC-E95720585451','SP04',N'Kem Tràng Tiền')
INSERT INTO [dbo].[SanPham]([Id],[IdLoaiSP],[Ma],[Ten]) VALUES('136C2574-55F1-436B-A588-57B4D66572F8','B452B55F-0452-4D03-B1D4-1A0508A16A60','SP05',N'Kẹo Dẻo')
INSERT INTO [dbo].[SanPham]([Id],[IdLoaiSP],[Ma],[Ten]) VALUES ('9FD42AB2-08F7-4FDE-A302-A8CC1A763094','B452B55F-0452-4D03-B1D4-1A0508A16A60','SP06',N'Bánh chocobai')
INSERT INTO [dbo].[SanPham]([Id],[IdLoaiSP],[Ma],[Ten]) VALUES ('BE95507E-7752-46AF-8A07-9BCE07DBEA8E','796A101D-611E-485B-A2D1-3B854FD744C6','SP07',N'Xúc xich VIệt Đức')
INSERT INTO [dbo].[SanPham]([Id],[IdLoaiSP],[Ma],[Ten]) VALUES ('73ABC66B-44A3-48A8-97B2-C8AD1F2B7CA0','CF5DB45D-BCD4-49B3-AE62-BBFA61C36638','SP08',N'BIa 333')
INSERT INTO [dbo].[SanPham]([Id],[IdLoaiSP],[Ma],[Ten]) VALUES ('4A4C3D95-3E9B-49C9-ADD3-3A5078786AEC','C7509CBF-DAFD-406F-96CC-E95720585451','SP09',N'Kem Ốc Quế')
select * from SanPham

--KhachHang
INSERT INTO KhachHang VALUES('6A8CEEE2-4CA2-4368-8750-2FA46B6E60F2','E80D4A42-E004-4A88-B444-57582AD702AC','KH1','a',N'Văn',N'Nguyễn','1991-01-01',N'Nam',093738737,N'Cao Mỗ 1',N'Hà Nội',N'Việt Nam','12345')
INSERT INTO KhachHang VALUES('5F635033-DB8B-48D3-A162-C90236F9944E','E80D4A42-E004-4A88-B444-57582AD702AC','KH2','b',N'Văn',N'Nguyễn','1992-02-15',N'Nam',093738737,N'Cao Mỗ 2',N'Hà Nội',N'Việt Nam','12345')
INSERT INTO KhachHang VALUES('69C517BB-09AA-44C2-9DD2-BD2C70581A28','7BC17005-A3F4-475D-BF69-2A8F9B7E1458','KH3','x',N'Văn',N'Nguyễn','1999-01-21',N'Nam',093738737,N'Cao Mỗ 3',N'Hà Nội',N'Việt Nam','12345')
INSERT INTO KhachHang VALUES('D6519C2C-1BF4-4F91-BEAC-956043566C94','7BC17005-A3F4-475D-BF69-2A8F9B7E1458','KH4','c',N'Văn',N'Nguyễn','1990-11-01',N'Nam',093738737,N'Cao Mỗ 4',N'Hà Nội',N'Việt Nam','12345')
INSERT INTO KhachHang VALUES('3CD0D3CB-2338-4B25-A16A-06E157FC8514','7BC17005-A3F4-475D-BF69-2A8F9B7E1458','KH5','r',N'Văn',N'Nguyễn','2000-01-03',N'Nam',093738737,N'Cao Mỗ 5',N'Hà Nội',N'Việt Nam','12345')
INSERT INTO KhachHang VALUES('D7585FF4-DE21-437F-AF1E-8A93DD4C206E','7BC17005-A3F4-475D-BF69-2A8F9B7E1458','KH6','g',N'Văn',N'Nguyễn','1995-12-01',N'Nam',093738737,N'Cao Mỗ 6',N'Hà Nội',N'Việt Nam','12345')
select * from KhachHang

--ChiTietSP
INSERT INTO ChiTietSP VALUES('32D873CE-9773-459E-88A0-B2F12ED8968D','BE95507E-7752-46AF-8A07-9BCE07DBEA8E','4F5E3520-92D8-4ED6-B9E8-9967FF186B1A','A093D191-72EB-4BBA-B4C6-6036E622D64B','958E8C39-44AC-42BA-994A-9F7E7A9FE8BD',10,N'Sản Phẩm Tốt',10,10000,15000)
INSERT INTO ChiTietSP VALUES('905894B1-CE52-4C71-ABCA-76E481C28B99','136C2574-55F1-436B-A588-57B4D66572F8','4F5E3520-92D8-4ED6-B9E8-9967FF186B1A','51691FFD-448A-4286-A28E-80790BC432FD','958E8C39-44AC-42BA-994A-9F7E7A9FE8BD',7,N'Sản Phẩm Tốt',30,12000,15000)
INSERT INTO ChiTietSP VALUES('20D914A6-A62F-4E22-BB56-5CF8B7981440','4A4C3D95-3E9B-49C9-ADD3-3A5078786AEC','986FD848-BD48-4AA8-935D-91A4DBACC321','A093D191-72EB-4BBA-B4C6-6036E622D64B','DE14B597-3292-43C1-B56A-83DB2015B7BD',5,N'Sản Phẩm Tốt',10,10000,15000)
INSERT INTO ChiTietSP VALUES('D027EE94-AA39-4543-B7B9-C5A74A9E927E','9FD42AB2-08F7-4FDE-A302-A8CC1A763094','617BA791-ACFB-44DC-A38E-57D428525079','51691FFD-448A-4286-A28E-80790BC432FD','BF152635-8D99-45EC-8391-2DE239624E5C',3,N'Sản Phẩm Tốt',5,15000,20000)
INSERT INTO ChiTietSP VALUES('CA1B1272-02BE-43EC-B105-9D20D6933DB7','C460740A-ECF1-4BA3-8626-74700F667865','986FD848-BD48-4AA8-935D-91A4DBACC321','75B98BA5-AB9F-4F70-9C5C-1D50100A4595','DE14B597-3292-43C1-B56A-83DB2015B7BD',5,N'Sản Phẩm Tốt',20,10000,15000)
INSERT INTO ChiTietSP VALUES('0ADC5C30-D0DF-44E8-A0D7-2D0418FD50A3','353FAF62-036F-461F-8CCC-24B1426DA220','617BA791-ACFB-44DC-A38E-57D428525079','75B98BA5-AB9F-4F70-9C5C-1D50100A4595','BF152635-8D99-45EC-8391-2DE239624E5C',2,N'Sản Phẩm Tốt',10,10000,15000)



--CuaHang
INSERT INTO [dbo].[CuaHang]([Id],[IdChiTietSP],[IdKho],[Ma],[Ten],[DiaChi],[ThanhPho],[QuocGia],[GhiChu],[TrangThai])VALUES('2C477573-8978-4F98-8878-CA20138D5427','0ADC5C30-D0DF-44E8-A0D7-2D0418FD50A3','5695F6CF-53DE-47FB-BE63-570F706B0CFB','CH1', N'Cửa hàng Cơ Sở 1',N'Nguyên Xá 1',N'Hà Nội ',N'Việt Nam',NULL,0)
INSERT INTO [dbo].[CuaHang]([Id],[IdChiTietSP],[IdKho],[Ma],[Ten],[DiaChi],[ThanhPho],[QuocGia],[GhiChu],[TrangThai])VALUES('EC7FB269-F40D-4C83-BD6B-494803EE9E69','0ADC5C30-D0DF-44E8-A0D7-2D0418FD50A3','B8CD8386-44C9-48FB-B51A-051844CFC515','CH2', N'Cửa hàng Cơ Sở 2',N'Nguyên Xá 2',N'Kom Tom',N'Việt Nam',NULL,0)
INSERT INTO [dbo].[CuaHang]([Id],[IdChiTietSP],[IdKho],[Ma],[Ten],[DiaChi],[ThanhPho],[QuocGia],[GhiChu],[TrangThai])VALUES('CEB707D3-EEE3-42E1-A34F-89D5B65B1472','20D914A6-A62F-4E22-BB56-5CF8B7981440','CA40DF41-0FDE-4731-8178-483F1506DE65','CH3', N'Cửa hàng  Cơ Sở 3',N'Nguyên Xá 3',N'Tây Nguyên',N'Việt Nam',NULL,0)
INSERT INTO [dbo].[CuaHang]([Id],[IdChiTietSP],[IdKho],[Ma],[Ten],[DiaChi],[ThanhPho],[QuocGia],[GhiChu],[TrangThai])VALUES('688BF2E1-271A-4F54-A24B-BD153615A479','20D914A6-A62F-4E22-BB56-5CF8B7981440','CA40DF41-0FDE-4731-8178-483F1506DE65','CH4', N'Cửa hàng  Cơ Sở 4',N'Nguyên Xá 4',N'Tuyên Quang',N'Việt Nam',NULL,0)
INSERT INTO [dbo].[CuaHang]([Id],[IdChiTietSP],[IdKho],[Ma],[Ten],[DiaChi],[ThanhPho],[QuocGia],[GhiChu],[TrangThai])VALUES('5D3BADCD-39AF-4CC2-ACAB-AD28884CE08C','905894B1-CE52-4C71-ABCA-76E481C28B99','5695F6CF-53DE-47FB-BE63-570F706B0CFB','CH5', N'Cửa hàng  Cơ Sở 5',N'Nguyên Xá 5',N'Hà Nội',N'Việt Nam',NULL,0)


--NhanVien
INSERT INTO NhanVien VALUES ('C407D88A-284A-49FE-8978-60FD94EBB40D','C1C974D4-6B7A-405B-A60C-21FB2FB72BDB','8490B22F-E6E9-413C-92D7-E0803F15BEB3','EC7FB269-F40D-4C83-BD6B-494803EE9E69','NV01',N'Hiếu',N'Trung',N'Trần','Nam','2003-02-10','Hoai Duc','0918312409','abc',null,1)
INSERT INTO NhanVien VALUES ('5F379545-4AE3-4D44-AFD1-255DA5E9B0FD','FD944810-0405-460B-A884-C9738890CDDC','85DB0AD5-DD54-43F1-B3DA-2487750C1030','EC7FB269-F40D-4C83-BD6B-494803EE9E69','NV02',N'Tiệp',N'Mạnh',N'Nguyễn','Nam','2003-10-20','Ha Noi','0918312409','abc',null,1)
INSERT INTO NhanVien VALUES ('91C2DD91-70C7-49D7-A023-1415918FEE3D','43D03BD9-44A8-4C17-86B1-A0046E1627A0','85DB0AD5-DD54-43F1-B3DA-2487750C1030','EC7FB269-F40D-4C83-BD6B-494803EE9E69','NV03',N'Thành',N'Viết',N'Ninh','Nam','2003-11-01','Thanh Hoa','0918312409','abc',null,1)
INSERT INTO NhanVien VALUES ('E9A54BA5-795C-4232-A87D-8F81E4063EBA','0DBA0083-EDFA-4E1B-AB8D-3831BCFE2D09','85DB0AD5-DD54-43F1-B3DA-2487750C1030','EC7FB269-F40D-4C83-BD6B-494803EE9E69','NV04',N'Lương',N'Văn',N'Phạm','Nam','2003-12-15','Thái Bình','0918312409','abc',null,1)
INSERT INTO NhanVien VALUES ('AC036421-982A-4B64-B66C-8ED0CDFDC1CC','ED50E2BA-0940-4284-A79C-2BDADE7F14D3','85DB0AD5-DD54-43F1-B3DA-2487750C1030','EC7FB269-F40D-4C83-BD6B-494803EE9E69','NV05',N'Hưng',N'Tiến',N'Nguyễn','Nam','2003-06-6','Ninh Bình','0918312409','abc',null,1)
INSERT INTO NhanVien VALUES ('3DD31F40-7104-489F-BC00-BE58E37E2B84','C788B9D1-5FAB-49C8-A18E-CE7822E65D7D','85DB0AD5-DD54-43F1-B3DA-2487750C1030','EC7FB269-F40D-4C83-BD6B-494803EE9E69','NV06',N'Hải',N'Thanh',N'Phạm','Nam','2003-06-25','Thái Bình','0918312409','abc',null,1)
select * from NhanVien

--HoaDon
INSERT INTO HoaDon VALUES('AE89E2F0-9184-4163-8F70-5CA12FD15C0A','3CD0D3CB-2338-4B25-A16A-06E157FC8514','91C2DD91-70C7-49D7-A023-1415918FEE3D','HD01','2022-01-01','2022-01-03','2022-01-05','2022-01-07',0,'a',N'Hà Nội',0437836467)
INSERT INTO HoaDon VALUES('FDB99408-4607-49FC-83D4-7C0F5D97920A','6A8CEEE2-4CA2-4368-8750-2FA46B6E60F2','5F379545-4AE3-4D44-AFD1-255DA5E9B0FD','HD02','2022-02-01','2022-02-03','2022-02-05','2022-02-07',0,'a',N'Hà Nội',0437836467)
INSERT INTO HoaDon VALUES('2F5765E9-6850-42D6-898C-9EC4163E7BD6','3CD0D3CB-2338-4B25-A16A-06E157FC8514','91C2DD91-70C7-49D7-A023-1415918FEE3D','HD04','2022-03-01','2022-03-03','2022-03-05','2022-03-07',0,'a',N'Hà Nội',0437836467)
INSERT INTO HoaDon VALUES('03772FCC-8074-477D-A7D0-F3830FAD775C','D7585FF4-DE21-437F-AF1E-8A93DD4C206E','AC036421-982A-4B64-B66C-8ED0CDFDC1CC','HD05','2022-04-01','2022-04-03','2022-04-05','2022-04-07',0,'a',N'Hà Nội',0437836467)
INSERT INTO HoaDon VALUES('3E9858D4-46CD-4591-A26F-957340008981','3CD0D3CB-2338-4B25-A16A-06E157FC8514','E9A54BA5-795C-4232-A87D-8F81E4063EBA','HD03','2022-05-01','2022-05-03','2022-05-05','2022-05-07',0,'a',N'Hà Nội',0437836467)
INSERT INTO HoaDon VALUES('F79FAF29-560E-4A5B-8689-F2F7185D1D48','6A8CEEE2-4CA2-4368-8750-2FA46B6E60F2','AC036421-982A-4B64-B66C-8ED0CDFDC1CC','HD08','2022-06-01','2022-06-03','2022-06-05','2022-06-07',0,'a',N'Hà Nội',0437836467)
INSERT INTO HoaDon VALUES('829D23DC-6F0B-4906-B12F-FA6025352A08','D7585FF4-DE21-437F-AF1E-8A93DD4C206E','3DD31F40-7104-489F-BC00-BE58E37E2B84','HD09','2022-07-01','2022-07-03','2022-07-05','2022-07-07',0,'a',N'Hà Nội',0437836467)
select * from HoaDon

-- Giỏ Hàng
INSERT INTO GioHang VALUES('7D15A358-6466-4AA6-87DA-E74297DB8B0B','3CD0D3CB-2338-4B25-A16A-06E157FC8514','91C2DD91-70C7-49D7-A023-1415918FEE3D','GH1','2022-01-01','2022-01-03','a',N'Hà Nội',0437836467,0)
INSERT INTO GioHang VALUES('585853F8-0995-4367-B0E2-3232C6F4731F','6A8CEEE2-4CA2-4368-8750-2FA46B6E60F2','91C2DD91-70C7-49D7-A023-1415918FEE3D','GH2','2022-02-02','2022-01-10','b',N'Hà Nội',0437836467,0)
INSERT INTO GioHang VALUES('E05D8EE0-C6BD-4565-A7E6-93219EBB7134','69C517BB-09AA-44C2-9DD2-BD2C70581A28','5F379545-4AE3-4D44-AFD1-255DA5E9B0FD','GH3','2022-03-03','2022-01-05','x',N'Hà Nội',0437836467,0)
INSERT INTO GioHang VALUES('F9EBC61D-5691-4F1D-B527-0011EA51656B','D7585FF4-DE21-437F-AF1E-8A93DD4C206E','3DD31F40-7104-489F-BC00-BE58E37E2B84','GH4','2022-04-01','2022-01-04','d',N'Hà Nội',0437836467,0)
INSERT INTO GioHang VALUES('C9F30C36-3D4B-493A-9BF0-81E80CEF1013','5F635033-DB8B-48D3-A162-C90236F9944E','E9A54BA5-795C-4232-A87D-8F81E4063EBA','GH5','2022-05-11','2022-01-15','b',N'Hà Nội',0437836467,0)
INSERT INTO GioHang VALUES('FAF069EC-0DA0-411F-8588-1C83199CC73E','6A8CEEE2-4CA2-4368-8750-2FA46B6E60F2','3DD31F40-7104-489F-BC00-BE58E37E2B84','GH6','2022-06-10','2022-01-20','h',N'Hà Nội',0437836467,0)
select * from GioHang


--ThongKe
INSERT INTO ThongKe VALUES('BA5CE899-4B26-4609-A2D3-74FF66CE266C', 'AE89E2F0-9184-4163-8F70-5CA12FD15C0A', '0ADC5C30-D0DF-44E8-A0D7-2D0418FD50A3', '899A23FE-BFBE-4149-83D3-205C4D00A9FD', 15, '10000000', '200000000',NULL,NULL,'2022-01-01','2022-01-02 18:01:04')
INSERT INTO ThongKe VALUES('14F7C46D-D85F-4CEA-BCA4-233AF301D327', 'FDB99408-4607-49FC-83D4-7C0F5D97920A', '20D914A6-A62F-4E22-BB56-5CF8B7981440', 'C25F2E23-E07E-43EC-B809-D186BC4D4212', 10, '10000000', '200000000',NULL,NULL,'2022-01-01','2022-01-02 18:01:04')
INSERT INTO ThongKe VALUES('0C36232B-35EE-4288-9149-5ADD55FA8E2B', '3E9858D4-46CD-4591-A26F-957340008981', '0ADC5C30-D0DF-44E8-A0D7-2D0418FD50A3', '899A23FE-BFBE-4149-83D3-205C4D00A9FD', 6, '10000000', '200000000',NULL,NULL,'2022-01-01','2022-01-02 18:01:04')
INSERT INTO ThongKe VALUES('F3488ABC-9463-417B-98E1-82BAC55E9732', 'FDB99408-4607-49FC-83D4-7C0F5D97920A', '20D914A6-A62F-4E22-BB56-5CF8B7981440', 'C25F2E23-E07E-43EC-B809-D186BC4D4212', 15, '10000000', '200000000',NULL,NULL,'2022-01-01','2022-01-02 18:01:04')
INSERT INTO ThongKe VALUES('FCF3723F-32BB-4CAC-893A-53008740E484', '3E9858D4-46CD-4591-A26F-957340008981', '0ADC5C30-D0DF-44E8-A0D7-2D0418FD50A3', 'C25F2E23-E07E-43EC-B809-D186BC4D4212', 9, '10000000', '200000000',NULL,NULL,'2022-01-01','2022-01-02 18:01:04')
INSERT INTO ThongKe VALUES('49B83F59-313B-4CC8-BFC8-5B93D45B0E00', '3E9858D4-46CD-4591-A26F-957340008981', '905894B1-CE52-4C71-ABCA-76E481C28B99', 'B119675F-F8A8-42DA-91F3-D45FF30288EA', 20, '10000000', '200000000',NULL,NULL,'2022-01-01','2022-01-02 18:01:04')
select * from ThongKe



--HOaDonChiTiet
INSERT INTO HoaDonChiTiet VALUES ('AE89E2F0-9184-4163-8F70-5CA12FD15C0A','0ADC5C30-D0DF-44E8-A0D7-2D0418FD50A3',2,1000);
INSERT INTO HoaDonChiTiet VALUES ('FDB99408-4607-49FC-83D4-7C0F5D97920A','20D914A6-A62F-4E22-BB56-5CF8B7981440',22,1000);
INSERT INTO HoaDonChiTiet VALUES ('3E9858D4-46CD-4591-A26F-957340008981','905894B1-CE52-4C71-ABCA-76E481C28B99',5,1000);
INSERT INTO HoaDonChiTiet VALUES ('2F5765E9-6850-42D6-898C-9EC4163E7BD6','CA1B1272-02BE-43EC-B105-9D20D6933DB7',9,1000);
INSERT INTO HoaDonChiTiet VALUES ('F79FAF29-560E-4A5B-8689-F2F7185D1D48','32D873CE-9773-459E-88A0-B2F12ED8968D',4,1000);
INSERT INTO HoaDonChiTiet VALUES ('03772FCC-8074-477D-A7D0-F3830FAD775C','D027EE94-AA39-4543-B7B9-C5A74A9E927E',10,1000);
select * from HoaDonChiTiet

--GioHangChiTiet
INSERT INTO GioHangChiTiet VALUES ('F9EBC61D-5691-4F1D-B527-0011EA51656B','0ADC5C30-D0DF-44E8-A0D7-2D0418FD50A3',2,10000,5000);
INSERT INTO GioHangChiTiet VALUES ('FAF069EC-0DA0-411F-8588-1C83199CC73E','20D914A6-A62F-4E22-BB56-5CF8B7981440',22,20000,1000);
INSERT INTO GioHangChiTiet VALUES ('585853F8-0995-4367-B0E2-3232C6F4731F','905894B1-CE52-4C71-ABCA-76E481C28B99',4,10000,9000);
INSERT INTO GioHangChiTiet VALUES ('C9F30C36-3D4B-493A-9BF0-81E80CEF1013','CA1B1272-02BE-43EC-B105-9D20D6933DB7',10,9000,2000);
INSERT INTO GioHangChiTiet VALUES ('E05D8EE0-C6BD-4565-A7E6-93219EBB7134','32D873CE-9773-459E-88A0-B2F12ED8968D',3,2000,1500);
INSERT INTO GioHangChiTiet VALUES ('7D15A358-6466-4AA6-87DA-E74297DB8B0B','D027EE94-AA39-4543-B7B9-C5A74A9E927E',3,2000,1500);


